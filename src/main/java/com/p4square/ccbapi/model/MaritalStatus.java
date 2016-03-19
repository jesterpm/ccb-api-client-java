package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Enumeration of the possible values for the marital status field of an individual in CCB.
 */
public enum MaritalStatus {
    @XmlEnumValue("Single") SINGLE("s"),
    @XmlEnumValue("Married") MARRIED("m"),
    @XmlEnumValue("Widowed") WIDOWED("w"),
    @XmlEnumValue("Divorced") DIVORCED("d"),
    @XmlEnumValue("Separated") SEPARATED("p"),
    @XmlEnumValue("") NOT_SELECTED(" ");

    private final String code;

    MaritalStatus(String code) {
        this.code = code;
    }

    /**
     * @return A one character string representing the enum value.
     */
    public String getCode() {
        return this.code;
    }
}
