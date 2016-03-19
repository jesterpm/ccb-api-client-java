package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Enumeration of the supported values for the family_position field of an IndividualProfile.
 */
public enum FamilyPosition {
    @XmlEnumValue("Primary Contact") PRIMARY_CONTACT("h"),
    @XmlEnumValue("Spouse") SPOUSE("s"),
    @XmlEnumValue("Child") CHILD("c"),
    @XmlEnumValue("Other") OTHER("o");

    private final String code;

    FamilyPosition(String code) {
        this.code = code;
    }

    /**
     * @return A one character string representing the enum value.
     */
    public String getCode() {
        return this.code;
    }
}
