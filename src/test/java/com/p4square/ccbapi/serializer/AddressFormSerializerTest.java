package com.p4square.ccbapi.serializer;

import com.p4square.ccbapi.model.Address;
import com.p4square.ccbapi.model.Countries;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the AddressFormSerializer.
 *
 * Serializer output is compared to the expected output in the update_individual API example.
 */
public class AddressFormSerializerTest {

    private AddressFormSerializer serializer;

    @Before
    public void setUp() {
        serializer = new AddressFormSerializer();
    }

    @Test
    public void testEncodeAllFields() {
        final Address address = new Address();
        address.setType(Address.Type.MAILING);
        address.setStreetAddress("12265 Oracle Blvd, Suite 105");
        address.setCity("Colorado Springs");
        address.setState("CO");
        address.setZip("80921");
        address.setCountry(Countries.UNITED_STATES);

        final String actual = serializer.encode(address);

        assertEquals("mailing_street_address=12265+Oracle+Blvd%2C+Suite+105"
                     + "&mailing_city=Colorado+Springs&mailing_state=CO&mailing_zip=80921&mailing_country=US",
                     actual);
    }

    @Test
    public void testEncodeSomeFields() {
        final Address address = new Address();
        address.setType(Address.Type.MAILING);
        address.setStreetAddress("12265 Oracle Blvd, Suite 105");

        final String actual = serializer.encode(address);

        assertEquals("mailing_street_address=12265+Oracle+Blvd%2C+Suite+105", actual);
    }

    @Test
    public void testEncodeSomeFieldsWithExistingData() {
        final StringBuilder sb = new StringBuilder("foo=bar");

        final Address address = new Address();
        address.setType(Address.Type.MAILING);
        address.setStreetAddress("12265 Oracle Blvd, Suite 105");
        address.setCity("Colorado Springs");

        serializer.encode(address, sb);
        final String actual = sb.toString();

        assertEquals("foo=bar&mailing_street_address=12265+Oracle+Blvd%2C+Suite+105&mailing_city=Colorado+Springs",
                     actual);
    }

    @Test
    public void testEncodeHomeAddress() {
        final Address address = new Address();
        address.setType(Address.Type.HOME);
        address.setStreetAddress("12265 Oracle Blvd, Suite 105");

        final String actual = serializer.encode(address);

        assertEquals("home_street_address=12265+Oracle+Blvd%2C+Suite+105", actual);
    }

    @Test
    public void testEncodeWorkAddress() {
        final Address address = new Address();
        address.setType(Address.Type.WORK);
        address.setStreetAddress("12265 Oracle Blvd, Suite 105");

        final String actual = serializer.encode(address);

        assertEquals("work_street_address=12265+Oracle+Blvd%2C+Suite+105", actual);
    }

    @Test
    public void testEncodeOtherAddress() {
        final Address address = new Address();
        address.setType(Address.Type.OTHER);
        address.setStreetAddress("12265 Oracle Blvd, Suite 105");

        final String actual = serializer.encode(address);

        assertEquals("other_street_address=12265+Oracle+Blvd%2C+Suite+105", actual);
    }

}