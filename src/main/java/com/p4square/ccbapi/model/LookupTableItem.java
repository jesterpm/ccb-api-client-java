package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * LookupTableItem is the definition of an item in a pulldown list.
 */
@XmlRootElement(name="item")
@XmlAccessorType(XmlAccessType.NONE)
public class LookupTableItem {

    @XmlElement
    private int id;

    @XmlElement
    private int order;

    @XmlElement
    private String name;

    public int getId() {
        return id;
    }

    public LookupTableItem setId(final int id) {
        this.id = id;
        return this;
    }

    public int getOrder() {
        return order;
    }

    public LookupTableItem setOrder(final int order) {
        this.order = order;
        return this;
    }

    public String getName() {
        return name;
    }

    public LookupTableItem setName(final String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "LookupTableItem::{" +
                "id=" + id +
                ", order=" + order +
                ", name='" + name + '\'' +
                '}';
    }
}
