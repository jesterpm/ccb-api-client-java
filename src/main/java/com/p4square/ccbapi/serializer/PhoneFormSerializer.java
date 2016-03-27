package com.p4square.ccbapi.serializer;

import com.p4square.ccbapi.model.Phone;

/**
 * Encode a Phone object as form data for CCB.
 */
public class PhoneFormSerializer extends AbstractFormSerializer<Phone> {
    @Override
    public void encode(final Phone phone, final StringBuilder builder) {
        // Sanity check.
        if (phone.getType() == null) {
            throw new IllegalArgumentException("Phone type cannot be null");
        }

        final String key;
        if (phone.getType() == Phone.Type.EMERGENCY) {
            key = "phone_emergency";
        } else {
            key = phone.getType().toString().toLowerCase() + "_phone";
        }
        appendField(builder, key, phone.getNumber());
    }
}
