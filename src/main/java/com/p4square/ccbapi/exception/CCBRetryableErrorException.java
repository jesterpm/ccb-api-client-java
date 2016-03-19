package com.p4square.ccbapi.exception;

/**
 * CCBRetryableErrorException is thrown when a retryable error is received.
 *
 * The caller may retry the request with an appropriate back-off.
 */
public class CCBRetryableErrorException extends CCBException {
    public CCBRetryableErrorException(final String message) {
        super(message);
    }
}
