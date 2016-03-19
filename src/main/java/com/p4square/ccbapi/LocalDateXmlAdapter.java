package com.p4square.ccbapi;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;

/**
 * XmlAdapter implementation for LocalDate.
 */
public class LocalDateXmlAdapter extends XmlAdapter<String, LocalDate> {

    @Override
    public LocalDate unmarshal(final String value) throws Exception {
        return LocalDate.parse(value);
    }

    @Override
    public String marshal(final LocalDate value) throws Exception {
        return value.toString();
    }

}