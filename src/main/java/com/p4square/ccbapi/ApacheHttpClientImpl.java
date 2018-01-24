package com.p4square.ccbapi;

import com.p4square.ccbapi.exception.CCBException;
import com.p4square.ccbapi.exception.CCBRetryableErrorException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.*;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;

/**
 * ApacheHttpClientImpl is an implementation of HTTPInterface which uses the Apache HTTP Client library.
 */
public class ApacheHttpClientImpl implements HTTPInterface {

    private final CloseableHttpClient httpClient;

    public ApacheHttpClientImpl(final URI apiBaseUri, final String username, final String password) {
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

        CredentialsProvider credsProvider = new BasicCredentialsProvider();
        credsProvider.setCredentials(
                new AuthScope(apiBaseUri.getHost(), port),
                new UsernamePasswordCredentials(username, password));

        this.httpClient = HttpClients.custom()
                .setDefaultCredentialsProvider(credsProvider)
                .build();
    }

    @Override
    public void close() throws IOException {
        httpClient.close();
    }

    @Override
    public InputStream sendPostRequest(final URI uri, final byte[] form) throws IOException {
        // Build the request.
        final HttpPost httpPost = new HttpPost(uri);

        if (form != null) {
            final ByteArrayEntity entity = new ByteArrayEntity(form);
            entity.setContentType("application/x-www-form-urlencoded");
            httpPost.setEntity(entity);
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
