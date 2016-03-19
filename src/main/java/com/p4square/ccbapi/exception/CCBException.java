package com.p4square.ccbapi.exception;

import java.io.IOException;

/**
 * Common exception class for all CCB API library exceptions.
 */
public class CCBException extends IOException {
    public CCBException(String message) {
        super(message);
    }

    public CCBException(String message, Throwable cause) {
        super(message, cause);
    }
}
