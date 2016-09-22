package com.p4square.ccbapi.serializer;

import com.p4square.ccbapi.model.Address;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Encode an Address object as form data for CCB.
 */
public class AddressFormSerializer implements Serializer<Address> {

    @Override
    public String encode(final Address address) {
        final StringBuilder sb = new StringBuilder();
        encode(address, sb);
        return sb.toString();
    }

    @Override
    public void encode(final Address address, final StringBuilder builder) {
        // Sanity check.
        if (address.getType() == null) {
            throw new IllegalArgumentException("Address type cannot be null");
        }

        // Every form field will be prefixed with the type.
        final String type = address.getType().toString().toLowerCase();

        if (address.getStreetAddress() != null) {
            appendField(builder, type, "street_address", address.getStreetAddress());
        }

        if (address.getCity() != null) {
            appendField(builder, type, "city", address.getCity());
        }

        if (address.getState() != null) {
            appendField(builder, type, "state", address.getState());
        }

        if (address.getZip() != null) {
            appendField(builder, type, "zip", address.getZip());
        }

        if (address.getCountry() != null) {
            appendField(builder, type, "country", address.getCountry().getCountryCode());
        }
    }

    private void appendField(final StringBuilder builder, final String type, final String key, final String value) {
        if (builder.length() > 0) {
            builder.append("&");
        }
        try {
            builder.append(type).append("_").append(key).append("=").append(URLEncoder.encode(value, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("UTF-8 encoding should always be available.");
        }
    }
}
