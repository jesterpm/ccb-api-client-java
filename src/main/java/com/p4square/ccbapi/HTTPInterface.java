package com.p4square.ccbapi;

import com.p4square.ccbapi.exception.CCBException;
import com.p4square.ccbapi.exception.CCBRetryableErrorException;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;

/**
 * HTTPInterface exists to separate the HTTP client implementation from the CCB client.
 *
 * The concern here is that it may not be possible or desirable to take a dependency on the
 * Apache HTTP Client library. If that case arises the CCBAPIClient and the HTTPInterface
 * implementation can be split into separate packages. For simplicity's sake I'm not doing
 * that now. But if it needs to be done at a later time the code will already be isolated.
 */
public interface HTTPInterface extends Closeable {
    /**
     * Send an HTTP POST request to the given URI.
     *
     * The form data for the request is specified in the form Map.
     *
     * @param uri The URI to request.
     * @param form Map of key/value pairs to send as form data.
     * @return The response received.
     * @throws com.p4square.ccbapi.exception.CCBRetryableErrorException
     * @throws CCBRetryableErrorException if a retryable error occurs.
     * @throws IOException If a non-retryable error occurs.
     */
    InputStream sendPostRequest(URI uri, Map<String, String> form) throws IOException;
}
