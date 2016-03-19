package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.*;

/**
 * Representation of an error response returned by CCB.
 */
@XmlRootElement(name="error")
@XmlAccessorType(XmlAccessType.NONE)
public class CCBErrorResponse {
    @XmlAttribute
    private int number;

    @XmlAttribute
    private String type;

    @XmlValue
    private String description;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%03d %s Error: %s", getNumber(), getType(), getDescription());
    }
}
