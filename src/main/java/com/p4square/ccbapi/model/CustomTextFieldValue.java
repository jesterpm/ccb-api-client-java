package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * A user-defined text field and the associated value.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class CustomTextFieldValue extends CustomField {

    @XmlElement(name="text")
    private String text;

    public String getText() {
        return text;
    }

    public void setText(final String text) {
        this.text = text;
    }
}
