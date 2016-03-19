package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.*;

/**
 * Phone Number and Type pair.
 */
@XmlRootElement(name="phone")
@XmlAccessorType(XmlAccessType.NONE)
public class Phone {
    @XmlType(namespace="Phone")
    public enum Type {
        @XmlEnumValue("contact") CONTACT,
        @XmlEnumValue("home") HOME,
        @XmlEnumValue("work") WORK,
        @XmlEnumValue("mobile") MOBILE,
        @XmlEnumValue("emergency") EMERGENCY;
    }

    @XmlAttribute(name="type")
    private Type type;

    @XmlValue
    private String number;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
