package com.p4square.ccbapi.serializer;

import com.p4square.ccbapi.model.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

/**
 * Tests for the IndividualProfileSerializer.
 *
 * Serializer output is compared to the expected output in the update_individual API example.
 */
public class IndividualProfileSerializerTest {

    private IndividualProfileSerializer serializer;

    @Before
    public void setUp() {
        serializer = new IndividualProfileSerializer();
    }

    /**
     * This test sets all of the fields on an
     * {@link UpdateIndividualProfileRequest} and tries to serialize them.
     */
    @Test
    public void testEncodeAllFields() {
        final Address mailing_address = new Address();
        mailing_address.setType(Address.Type.MAILING);
        mailing_address.setStreetAddress("12265 Oracle Blvd, Suite 105");
        mailing_address.setCity("Colorado Springs");
        mailing_address.setState("CO");
        mailing_address.setZip("80921");
        mailing_address.setCountry(Countries.UNITED_STATES);

        final Phone phone = new Phone();
        phone.setType(Phone.Type.CONTACT);
        phone.setNumber("719-555-2888");

        final UpdateIndividualProfileRequest request = new UpdateIndividualProfileRequest()
                .withSyncId(1001)
                .withOtherId("A1001")
                .withGivingNumber("ABC123")
                .withFirstName("Larry")
                .withLastName("Bob")
                .withMiddleName("P")
                .withLegalFirstName("Larabar")
                .withSalutation("Mr.")
                .withSuffix("Jr.")
                .withFamilyId(48)
                .withFamilyPosition(FamilyPosition.PRIMARY_CONTACT)
                .withMaritalStatus(MaritalStatus.MARRIED)
                .withGender(Gender.MALE)
                .withBirthday(LocalDate.of(1966, 2, 12))
                .withAnniversary(LocalDate.of(1989, 5, 6))
                .withDeceased(LocalDate.of(2016, 12, 31))
                .withMembershipDate(LocalDate.of(2010, 1, 1))
                .withMembershipEnd(LocalDate.of(2016, 12, 1))
                .withEmail("ken@example.com")
                .withAddresses(Collections.singletonList(mailing_address))
                .withPhones(Collections.singletonList(phone))
                .withEmergencyContactName("Marry Bob")
                .withAllergies("Pine Nuts")
                .withConfirmedNoAllergies(true)
                .withBaptized(true)
                .withModifiedById(12);

        final String actual = serializer.encode(request);

        final String expected = "sync_id=1001&other_id=A1001&giving_number=ABC123"
                        + "&first_name=Larry&last_name=Bob&middle_name=P&legal_first_name=Larabar&salutation=Mr."
                        + "&suffix=Jr.&family_id=48&family_position=h&marital_status=m&gender=m"
                        + "&birthday=1966-02-12&anniversary=1989-05-06&deceased=2016-12-31"
                        + "&membership_date=2010-01-01&membership_end=2016-12-01"
                        + "&email=ken%40example.com&emergency_contact_name=Marry+Bob"
                        + "&allergies=Pine+Nuts&confirmed_no_allergies=true&baptized=true&modifier_id=12"
                        + "&mailing_street_address=12265+Oracle+Blvd%2C+Suite+105"
                        + "&mailing_city=Colorado+Springs&mailing_state=CO&mailing_zip=80921&mailing_country=US"
                        + "&contact_phone=719-555-2888";

        assertEquals(expected, actual);
    }

    @Test
    public void testEncodeSomeFields() {
        final UpdateIndividualProfileRequest request = new UpdateIndividualProfileRequest()
                .withSyncId(1001)
                .withMiddleName("P")
                .withMaritalStatus(MaritalStatus.DIVORCED)
                .withGender(Gender.FEMALE)
                .withBirthday(LocalDate.of(1966, 2, 12));

        final String actual = serializer.encode(request);

        assertEquals("sync_id=1001&middle_name=P&marital_status=d&gender=f&birthday=1966-02-12", actual);
    }

    @Test
    public void testEncodeMultipleAddresses() {
        final Address address1 = new Address();
        address1.setType(Address.Type.HOME);
        address1.setStreetAddress("123 Happy Lane");

        final Address address2 = new Address();
        address2.setType(Address.Type.WORK);
        address2.setStreetAddress("12265 Oracle Blvd, Suite 105");

        final UpdateIndividualProfileRequest request = new UpdateIndividualProfileRequest()
                .withAddresses(Arrays.asList(address1, address2));

        final String actual = serializer.encode(request);

        assertEquals("home_street_address=123+Happy+Lane&work_street_address=12265+Oracle+Blvd%2C+Suite+105", actual);
    }

    @Test
    public void testEncodeMultiplePhones() {
        final Phone phone1 = new Phone();
        phone1.setType(Phone.Type.MOBILE);
        phone1.setNumber("719-555-2888");

        final Phone phone2 = new Phone();
        phone2.setType(Phone.Type.EMERGENCY);
        phone2.setNumber("719-555-3999");

        final UpdateIndividualProfileRequest request = new UpdateIndividualProfileRequest()
                .withPhones(Arrays.asList(phone1, phone2));

        final String actual = serializer.encode(request);

        assertEquals("mobile_phone=719-555-2888&phone_emergency=719-555-3999", actual);
    }

    @Test
    public void testEncodeCustomFieldsByName() {
        final UpdateIndividualProfileRequest request = new UpdateIndividualProfileRequest()
                .withCustomTextField("udf_text_1", "Hello")
                .withCustomDateField("udf_date_1", LocalDate.of(1966, 2, 12))
                .withCustomPulldownField("udf_pulldown_1", 12);

        final String actual = serializer.encode(request);

        assertEquals("udf_text_1=Hello&udf_date_1=1966-02-12&udf_pulldown_1=12", actual);
    }

    @Test
    public void testEncodeCustomFieldsByNumber() {
        final UpdateIndividualProfileRequest request = new UpdateIndividualProfileRequest()
                .withCustomTextField(2, "Hello")
                .withCustomDateField(2, LocalDate.of(1966, 2, 12))
                .withCustomPulldownField(2, 12);

        final String actual = serializer.encode(request);

        assertEquals("udf_text_2=Hello&udf_date_2=1966-02-12&udf_pulldown_2=12", actual);
    }

    @Test
    public void testNullCustomField() {
        final UpdateIndividualProfileRequest request = new UpdateIndividualProfileRequest()
                .withCustomTextField(1, null)
                .withCustomDateField(1, null)
                .withCustomPulldownField(1, null);

        final String actual = serializer.encode(request);
        assertEquals("", actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCustomTextFieldName() {
        new UpdateIndividualProfileRequest().withCustomTextField("udf_text_13", "foo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCustomTextFieldNumber() {
        new UpdateIndividualProfileRequest().withCustomTextField(0, "foo");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCustomDateFieldName() {
        new UpdateIndividualProfileRequest().withCustomDateField("udf_date_7", LocalDate.of(1966, 2, 12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCustomDateFieldNumber() {
        new UpdateIndividualProfileRequest().withCustomDateField(0, LocalDate.of(1966, 2, 12));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCustomPulldownFieldName() {
        new UpdateIndividualProfileRequest().withCustomPulldownField("udf_pulldown_7", 12);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCustomPulldownFieldNumber() {
        new UpdateIndividualProfileRequest().withCustomPulldownField(0, 12);
    }
}