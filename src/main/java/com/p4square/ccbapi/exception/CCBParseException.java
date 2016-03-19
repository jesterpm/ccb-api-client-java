package com.p4square.ccbapi.exception;

/**
 * CCBParseException is thrown when a response from CCB cannot be parsed.
 */
public class CCBParseException extends CCBException {
    public CCBParseException(String message) {
        super(message);
    }

    public CCBParseException(String message, Throwable cause) {
        super(message, cause);
    }
}
