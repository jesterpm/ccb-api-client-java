package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.time.LocalDate;

/**
 * A user-defined date field and the associated value.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class CustomDateFieldValue extends CustomField {

    @XmlElement(name="date")
    private LocalDate date;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }
}
