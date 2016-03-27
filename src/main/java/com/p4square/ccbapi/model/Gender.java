package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * Enum representing the gender of an individual in CCB.
 */
public enum Gender {
    /**
     * The documentation currently provides conflicting examples for the gender code.
     * The documentation says it must be 'M' or 'F', but the example given uses 'm'.
     * According to an API Village posting, it should actually be lower case.
     *
     * https://village.ccbchurch.com/message_comment_list.php?message_id=3308
     */
    @XmlEnumValue("M") MALE("m"),
    @XmlEnumValue("F") FEMALE("f");

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
