package com.p4square.ccbapi.model;

import com.p4square.ccbapi.model.CCBErrorResponse;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

/**
 * Base class for all responses from the CCB API.
 */
public abstract class CCBAPIResponse {

    @XmlElementWrapper(name="errors", nillable=true)
    @XmlElement(name="error")
    private List<CCBErrorResponse> errorResponses;

    /**
     * Return the error message if present.
     *
     * @return A {@link CCBErrorResponse} if an error occurred. Null if the request was successful.
     */
    public List<CCBErrorResponse> getErrors() {
        return errorResponses;
    }

    /**
     * Set the error response.
     *
     * @param errors The list of {@link CCBErrorResponse}s to set.
     */
    public void setErrors(final List<CCBErrorResponse> errors) {
        this.errorResponses = errors;
    }
}
