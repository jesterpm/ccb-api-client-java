package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Representation of a Custom/User Defined Field.
 */
@XmlRootElement(name="custom_field")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class CustomField {
    private String name;
    private String label;
    private boolean adminOnly;

    /**
     * Create an empty CustomField object.
     */
    public CustomField() {
        // Default constructor
    }

    /**
     * Create a CustomField object with the name and label set.
     *
     * adminOnly will be false by default.
     *
     * @param name The CustomField name.
     * @param label The CustomField label.
     */
    public CustomField(final String name, final String label) {
        this(name, label, false);
    }

    /**
     * Create a CustomField object with the name, label, and adminOnly fields set.
     *
     * @param name The CustomField name.
     * @param label The CustomField label.
     * @param adminOnly The value of the adminOnly field.
     */
    public CustomField(final String name, final String label, final boolean adminOnly) {
        this.name = name;
        this.label = label;
        this.adminOnly = adminOnly;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isAdminOnly() {
        return adminOnly;
    }

    @XmlElement(name="admin_only")
    public void setAdminOnly(boolean adminOnly) {
        this.adminOnly = adminOnly;
    }
}
