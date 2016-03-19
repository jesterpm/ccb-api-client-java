package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Enum representing the gender of an individual in CCB.
 */
public enum Gender {
    @XmlEnumValue("M") MALE("M"),
    @XmlEnumValue("F") FEMALE("F");

    private final String code;

    Gender(String code) {
        this.code = code;
    }

    /**
     * @return A one character string representing the enum value.
     */
    public String getCode() {
        return this.code;
    }
}
