package com.p4square.ccbapi;

import com.p4square.ccbapi.exception.CCBException;
import com.p4square.ccbapi.exception.CCBRetryableErrorException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ApacheHttpClientImpl is an implementation of HTTPInterface which uses the Apache HTTP Client library.
 */
public class ApacheHttpClientImpl implements HTTPInterface {

    private final DefaultHttpClient httpClient;

    public ApacheHttpClientImpl(final URI apiBaseUri, final String username, final String password) {
        // Create the HTTP client.
        this.httpClient = new DefaultHttpClient();

        // Prepare the CredentialsProvider for the HTTP Client.
        int port = apiBaseUri.getPort();
        if (port == -1) {
            if ("http".equalsIgnoreCase(apiBaseUri.getScheme())) {
                port = 80;
            } else if ("https".equalsIgnoreCase(apiBaseUri.getScheme())) {
                port = 443;
            } else {
                throw new IllegalArgumentException("Cannot determine port for unknown scheme.");
            }
        }
        this.httpClient.getCredentialsProvider().setCredentials(new AuthScope(apiBaseUri.getHost(), port),
                                                                new UsernamePasswordCredentials(username, password));
    }

    @Override
    public void close() throws IOException {
        httpClient.getConnectionManager().shutdown();
    }

    @Override
    public InputStream sendPostRequest(final URI uri, final byte[] form) throws IOException {
        // Build the request.
        final HttpPost httpPost = new HttpPost(uri);

        if (form != null) {
            httpPost.setEntity(new ByteArrayEntity(form));
        }

        // Make the request.
        final HttpResponse response = httpClient.execute(httpPost);

        // Process the response.
        final int statusCode = response.getStatusLine().getStatusCode();
        if (statusCode != 200) {
            // Consume the entity and close the connection.
            EntityUtils.consume(response.getEntity());

            // Determine the type of failure and throw an exception.
            if (statusCode >= 400 && statusCode < 500) {
                throw new CCBException("Unexpected non-retryable error: " + response.getStatusLine().toString());
            } else if (statusCode >= 500 && statusCode < 600) {
                throw new CCBRetryableErrorException("Retryable error: " + response.getStatusLine().toString());
            } else {
                throw new CCBException("Unexpected status code: " + response.getStatusLine().toString());
            }
        }

        final HttpEntity entity = response.getEntity();
        if (entity != null) {
            return entity.getContent();
        } else {
            return null;
        }
    }
}
