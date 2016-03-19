package com.p4square.ccbapi;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * XmlAdapter implementation to convert CCB dates to LocalDateTime.
 *
 * Note that the datetime format used by CCB is not ISO-8601 formatted.
 */
public class LocalDateTimeXmlAdapter extends XmlAdapter<String, LocalDateTime> {

    private static final DateTimeFormatter FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public LocalDateTime unmarshal(final String value) throws Exception {
        return LocalDateTime.parse(value, FORMAT);
    }

    @Override
    public String marshal(final LocalDateTime value) throws Exception {
        return value.format(FORMAT);
    }

}