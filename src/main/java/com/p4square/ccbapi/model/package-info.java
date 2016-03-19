/**
 * This package contains models for CCB API requests and responses.
 */
@XmlJavaTypeAdapters({
        @XmlJavaTypeAdapter(type=LocalDate.class, value=LocalDateXmlAdapter.class),
        @XmlJavaTypeAdapter(type=LocalDateTime.class, value=LocalDateTimeXmlAdapter.class),
})
package com.p4square.ccbapi.model;

import com.p4square.ccbapi.LocalDateTimeXmlAdapter;
import com.p4square.ccbapi.LocalDateXmlAdapter;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapters;
import java.time.LocalDate;
import java.time.LocalDateTime;
