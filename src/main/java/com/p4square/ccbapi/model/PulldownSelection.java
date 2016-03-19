package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * A pull down field option.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class PulldownSelection {
    @XmlAttribute(name="id")
    private int id;

    @XmlValue
    private String label;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(final String label) {
        this.label = label;
    }
}
