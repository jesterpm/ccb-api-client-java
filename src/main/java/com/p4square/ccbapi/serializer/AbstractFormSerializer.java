package com.p4square.ccbapi.serializer;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * AbstractFormSerializer provides default implementations for some methods defined in Serializer
 * and methods to support encoding form data for CCB.
 */
public abstract class AbstractFormSerializer<T> implements Serializer<T> {

    /**
     * This is the datetime format specified by the CCB API Doc.
     */
    private static final DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String encode(final T obj) {
        final StringBuilder sb = new StringBuilder();
        encode(obj, sb);
        return sb.toString();
    }

    /**
     * Append a field to the form.
     *
     * @param builder The StringBuilder to use.
     * @param key The form key, which must be URLEncoded before calling this method.
     * @param value The value associated with the key. The value will be URLEncoded by this method.
     */
    protected void appendField(final StringBuilder builder, final String key, final String value) {
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
     * @param builder The StringBuilder to use.
     * @param key The form key, which must be URLEncoded before calling this method.
     * @param value The value associated with the key.
     */
    protected void appendField(final StringBuilder builder, final String key, final int value) {
        if (builder.length() > 0) {
            builder.append("&");
        }
        builder.append(key).append("=").append(value);
    }

    /**
     * Append a boolean field to the form.
     *
     * @param builder The StringBuilder to use.
     * @param key The form key, which must be URLEncoded before calling this method.
     * @param value The value associated with the key.
     */
    protected void appendField(final StringBuilder builder, final String key, final boolean value) {
        if (builder.length() > 0) {
            builder.append("&");
        }
        builder.append(key).append("=").append(value ? "true" : "false");
    }

    /**
     * Append a LocalDate field to the form.
     *
     * @param builder The StringBuilder to use.
     * @param key The form key, which must be URLEncoded before calling this method.
     * @param value The value associated with the key.
     */
    protected void appendField(final StringBuilder builder, final String key, final LocalDate value) {
        appendField(builder, key, value.toString());

    }

    /**
     * Append a LocalDateTime field to the form.
     *
     * @param builder The StringBuilder to use.
     * @param key The form key, which must be URLEncoded before calling this method.
     * @param value The value associated with the key.
     */
    protected void appendField(final StringBuilder builder, final String key, final LocalDateTime value) {
        appendField(builder, key, DATE_TIME_FORMAT.format(value));
    }
}
