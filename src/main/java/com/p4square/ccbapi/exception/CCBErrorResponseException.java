package com.p4square.ccbapi.exception;

import com.p4square.ccbapi.model.CCBErrorResponse;

import java.util.List;

/**
 * CCBErrorResponseException is thrown when the CCB API returns one or more error responses.
 */
public class CCBErrorResponseException extends CCBException {
    private final List<CCBErrorResponse> errors;

    public CCBErrorResponseException(List<CCBErrorResponse> errors) {
        super("CCB API service responded with errors: " + errors);
        this.errors = errors;
    }

    /**
     * @return The error response returned by the service.
     */
    public List<CCBErrorResponse> getErrors() {
        return errors;
    }
}
