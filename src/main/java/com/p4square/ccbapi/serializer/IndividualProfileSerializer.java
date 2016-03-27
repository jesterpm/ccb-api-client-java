package com.p4square.ccbapi.serializer;

import com.p4square.ccbapi.model.Address;
import com.p4square.ccbapi.model.Phone;
import com.p4square.ccbapi.model.UpdateIndividualProfileRequest;

import java.time.LocalDate;
import java.util.Map;

/**
 * Serializes an {@link UpdateIndividualProfileRequest} into a form suitable for the update_individual API.
 */
public class IndividualProfileSerializer extends AbstractFormSerializer<UpdateIndividualProfileRequest> {

    private static final AddressFormSerializer ADDRESS_FORM_SERIALIZER = new AddressFormSerializer();
    private static final PhoneFormSerializer PHONE_FORM_SERIALIZER = new PhoneFormSerializer();

    @Override
    public void encode(final UpdateIndividualProfileRequest request, final StringBuilder builder) {
        // Encode any fields which are present.
        if (request.getSyncId() != null) {
            appendField(builder, "sync_id", request.getSyncId());
        }
        if (request.getOtherId() != null) {
            appendField(builder, "other_id", request.getOtherId());
        }
        if (request.getGivingNumber() != null) {
            appendField(builder, "giving_number", request.getGivingNumber());
        }
        if (request.getFirstName() != null) {
            appendField(builder, "first_name", request.getFirstName());
        }
        if (request.getLastName() != null) {
            appendField(builder, "last_name", request.getLastName());
        }
        if (request.getMiddleName() != null) {
            appendField(builder, "middle_name", request.getMiddleName());
        }
        if (request.getLegalFirstName() != null) {
            appendField(builder, "legal_first_name", request.getLegalFirstName());
        }
        if (request.getSalutation() != null) {
            appendField(builder, "salutation", request.getSalutation());
        }
        if (request.getSuffix() != null) {
            appendField(builder, "suffix", request.getSuffix());
        }
        if (request.getFamilyId() != null) {
            appendField(builder, "family_id", request.getFamilyId());
        }
        if (request.getFamilyPosition() != null) {
            appendField(builder, "family_position", request.getFamilyPosition().getCode());
        }
        if (request.getMaritalStatus() != null) {
            appendField(builder, "marital_status", request.getMaritalStatus().getCode());
        }
        if (request.getGender() != null) {
            appendField(builder, "gender", request.getGender().getCode());
        }
        if (request.getBirthday() != null) {
            appendField(builder, "birthday", request.getBirthday());
        }
        if (request.getAnniversary() != null) {
            appendField(builder, "anniversary", request.getAnniversary());
        }
        if (request.getDeceased() != null) {
            appendField(builder, "deceased", request.getDeceased());
        }
        if (request.getMembershipDate() != null) {
            appendField(builder, "membership_date", request.getMembershipDate());
        }
        if (request.getMembershipEnd() != null) {
            appendField(builder, "membership_end", request.getMembershipEnd());
        }
        if (request.getEmail() != null) {
            appendField(builder, "email", request.getEmail());
        }
        if (request.getEmergencyContactName() != null) {
            appendField(builder, "emergency_contact_name", request.getEmergencyContactName());
        }
        if (request.getAllergies() != null) {
            appendField(builder, "allergies", request.getAllergies());
        }
        if (request.getConfirmedNoAllergies() != null) {
            appendField(builder, "confirmed_no_allergies", request.getConfirmedNoAllergies());
        }
        if (request.getBaptized() != null) {
            appendField(builder, "baptized", request.getBaptized());
        }
        if (request.getModifiedById() != null) {
            appendField(builder, "modifier_id", request.getModifiedById());
        }

        // Encode all the addresses.
        if (request.getAddresses() != null) {
            for (Address address : request.getAddresses()) {
                ADDRESS_FORM_SERIALIZER.encode(address, builder);
            }
        }

        // and the phone numbers.
        if (request.getPhones() != null) {
            for (Phone phone : request.getPhones()) {
                PHONE_FORM_SERIALIZER.encode(phone, builder);
            }
        }

        // Add the User-defined fields.
        for (Map.Entry<String, String> entry : request.getCustomTextFields().entrySet()) {
            if (entry.getValue() != null) {
                appendField(builder, entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, LocalDate> entry : request.getCustomDateFields().entrySet()) {
            if (entry.getValue() != null) {
                appendField(builder, entry.getKey(), entry.getValue());
            }
        }
        for (Map.Entry<String, Integer> entry : request.getCustomPulldownFields().entrySet()) {
            if (entry.getValue() != null) {
                appendField(builder, entry.getKey(), entry.getValue());
            }
        }
    }
}
