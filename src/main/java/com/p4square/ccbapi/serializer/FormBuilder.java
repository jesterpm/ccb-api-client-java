package com.p4square.ccbapi.serializer;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility for building URL encoded form payloads.
 */
public class FormBuilder {

    /**
     * This is the datetime format specified by the CCB API Doc.
     */
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final StringBuilder builder;

    /**
     * Construct a new FormBuilder.
     */
    public FormBuilder() {
        this(new StringBuilder());
    }

    /**
     * Construct a new FormBuilder which will append fields to the given StringBuilder.
     *
     * @param builder The StringBuilder to append to.
     */
    public FormBuilder(StringBuilder builder) {
        this.builder = builder;
    }

    /**
     * This methods provides access to the StringBuilder.
     *
     * @return The StringBuilder passed in at construct time.
     */
    public StringBuilder getStringBuilder() {
        return builder;
    }

    /**
     * Build the entire URL encoded form.
     *
     * @return All form fields as a URL encoded string.
     */
    public String build() {
        return builder.toString();
    }

    /**
     * Append a field to the form.
     *
     * @param key The form key, which must be URLEncoded before calling this method.
     * @param value The value associated with the key. The value will be URLEncoded by this method.
     */
    public void appendField(final String key, final String value) {
        if (builder.length() > 0) {
            builder.append("&");
        }

        try {
            builder.append(key).append("=").append(URLEncoder.encode(value, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("UTF-8 encoding should always be available.");
        }
    }

    /**
     * Append an integer field to the form.
     *
     * @param key The form key, which must be URLEncoded before calling this method.
     * @param value The value associated with the key.
     */
    public void appendField(final String key, final int value) {
        if (builder.length() > 0) {
            builder.append("&");
        }
        builder.append(key).append("=").append(value);
    }

    /**
     * Append a boolean field to the form.
     *
     * @param key The form key, which must be URLEncoded before calling this method.
     * @param value The value associated with the key.
     */
    public void appendField(final String key, final boolean value) {
        if (builder.length() > 0) {
            builder.append("&");
        }
        builder.append(key).append("=").append(value ? "true" : "false");
    }

    /**
     * Append a LocalDate field to the form.
     *
     * @param key The form key, which must be URLEncoded before calling this method.
     * @param value The value associated with the key.
     */
    public void appendField(final String key, final LocalDate value) {
        appendField(key, value.toString());

    }

    /**
     * Append a LocalDateTime field to the form.
     *
     * @param key The form key, which must be URLEncoded before calling this method.
     * @param value The value associated with the key.
     */
    public void appendField(final String key, final LocalDateTime value) {
        appendField(key, DATE_TIME_FORMAT.format(value));
    }
}
