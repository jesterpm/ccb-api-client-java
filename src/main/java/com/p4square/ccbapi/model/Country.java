package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.*;

/**
 * Country code and name pair.
 */
@XmlRootElement(name="country")
@XmlAccessorType(XmlAccessType.NONE)
public class Country {

    @XmlAttribute(name="code")
    private String code;

    @XmlValue
    private String name;

    /**
     * Default Country constructor.
     */
    public Country() {

    }

    /**
     * This package-private Country constructor is used to create the
     * constants in the {@link Countries} class.
     *
     * Usually the country name cannot be set except when binding to
     * responses from CCB. This constructor is an exception so that the
     * constants in {@link Countries} can be provide with
     * <strong>known</strong> values used by CCB.
     *
     * @param code The two letter country code.
     * @param name The country name as typically presented by CCB.
     */
    Country(final String code, final String name) {
        setCountryCode(code);
        this.name = name;
    }

    /**
     * @return The two letter country code.
     */
    public String getCountryCode() {
        return code;
    }

    /**
     * Set the two letter country code.
     *
     * This class does not attempt to resolve the country name from the country code.
     * When the country code is set the name will become null.

     * @param code A two letter countey code.
     * @throws IllegalArgumentException if the country code is not valid.
     */
    public void setCountryCode(final String code) {
        if (code.length() != 2) {
            throw new IllegalArgumentException("Argument must be a two letter country code.");
        }
        this.code = code.toUpperCase();
        this.name = null;
    }

    /**
     * @return The country name or null if the country name is unknown.
     */
    public String getName() {
        return name;
    }
}
