package com.p4square.ccbapi.serializer;

import com.p4square.ccbapi.model.Phone;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the PhoneFormSerializer.
 *
 * Serializer output is compared to the expected output in the update_individual API example.
 */
public class PhoneFormSerializerTest {

    private PhoneFormSerializer serializer;

    @Before
    public void setUp() {
        serializer = new PhoneFormSerializer();
    }

    @Test
    public void testEncodeContactPhone() {
        final Phone phone = new Phone();
        phone.setType(Phone.Type.CONTACT);
        phone.setNumber("719-555-2888");

        final String actual = serializer.encode(phone);

        assertEquals("contact_phone=719-555-2888", actual);
    }

    @Test
    public void testEncodeHomePhone() {
        final Phone phone = new Phone();
        phone.setType(Phone.Type.HOME);
        phone.setNumber("719-555-2888");

        final String actual = serializer.encode(phone);

        assertEquals("home_phone=719-555-2888", actual);
    }

    @Test
    public void testEncodeWorkPhone() {
        final Phone phone = new Phone();
        phone.setType(Phone.Type.WORK);
        phone.setNumber("719-555-2888");

        final String actual = serializer.encode(phone);

        assertEquals("work_phone=719-555-2888", actual);
    }

    @Test
    public void testEncodeMobilePhone() {
        final Phone phone = new Phone();
        phone.setType(Phone.Type.MOBILE);
        phone.setNumber("719-555-2888");

        final String actual = serializer.encode(phone);

        assertEquals("mobile_phone=719-555-2888", actual);
    }

    @Test
    public void testEncodeEmergencyPhone() {
        final Phone phone = new Phone();
        phone.setType(Phone.Type.EMERGENCY);
        phone.setNumber("719-555-2888");

        final String actual = serializer.encode(phone);

        assertEquals("phone_emergency=719-555-2888", actual);
    }

    @Test
    public void testEncodeWithExistingData() {
        final StringBuilder sb = new StringBuilder();

        final Phone phone1 = new Phone();
        phone1.setType(Phone.Type.MOBILE);
        phone1.setNumber("719-555-2888");

        final Phone phone2 = new Phone();
        phone2.setType(Phone.Type.EMERGENCY);
        phone2.setNumber("719-555-3999");

        serializer.encode(phone1, sb);
        serializer.encode(phone2, sb);
        final String actual = sb.toString();

        assertEquals("mobile_phone=719-555-2888&phone_emergency=719-555-3999", actual);
    }

}