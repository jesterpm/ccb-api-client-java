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
    public void encode(final UpdateIndividualProfileRequest request, final FormBuilder builder) {
        // Encode any fields which are present.
        if (request.getSyncId() != null) {
            builder.appendField("sync_id", request.getSyncId());
        }
        if (request.getOtherId() != null) {
            builder.appendField("other_id", request.getOtherId());
        }
        if (request.getGivingNumber() != null) {
            builder.appendField("giving_number", request.getGivingNumber());
        }
        if (request.getFirstName() != null) {
            builder.appendField("first_name", request.getFirstName());
        }
        if (request.getLastName() != null) {
            builder.appendField("last_name", request.getLastName());
        }
        if (request.getMiddleName() != null) {
            builder.appendField("middle_name", request.getMiddleName());
        }
        if (request.getLegalFirstName() != null) {
            builder.appendField("legal_first_name", request.getLegalFirstName());
        }
        if (request.getSalutation() != null) {
            builder.appendField("salutation", request.getSalutation());
        }
        if (request.getSuffix() != null) {
            builder.appendField("suffix", request.getSuffix());
        }
        if (request.getFamilyId() != null) {
            builder.appendField("family_id", request.getFamilyId());
        }
        if (request.getFamilyPosition() != null) {
            builder.appendField("family_position", request.getFamilyPosition().getCode());
        }
        if (request.getMaritalStatus() != null) {
            builder.appendField("marital_status", request.getMaritalStatus().getCode());
        }
        if (request.getGender() != null) {
            builder.appendField("gender", request.getGender().getCode());
        }
        if (request.getBirthday() != null) {
            builder.appendField("birthday", request.getBirthday());
        }
        if (request.getAnniversary() != null) {
            builder.appendField("anniversary", request.getAnniversary());
        }
        if (request.getDeceased() != null) {
            builder.appendField("deceased", request.getDeceased());
        }
        if (request.getMembershipDate() != null) {
            builder.appendField("membership_date", request.getMembershipDate());
        }
        if (request.getMembershipEnd() != null) {
            builder.appendField("membership_end", request.getMembershipEnd());
        }
        if (request.getEmail() != null) {
            builder.appendField("email", request.getEmail());
        }
        if (request.getEmergencyContactName() != null) {
            builder.appendField("emergency_contact_name", request.getEmergencyContactName());
        }
        if (request.getAllergies() != null) {
            builder.appendField("allergies", request.getAllergies());
        }
        if (request.getConfirmedNoAllergies() != null) {
            builder.appendField("confirmed_no_allergies", request.getConfirmedNoAllergies());
        }
        if (request.getBaptized() != null) {
            builder.appendField("baptized", request.getBaptized());
        }
        if (request.getModifiedById() != null) {
            builder.appendField("modifier_id", request.getModifiedById());
        }

        // Encode all the addresses.
        if (request.getAddresses() != null) {
            for (Address address : request.getAddresses()) {
                ADDRESS_FORM_SERIALIZER.encode(address, builder.getStringBuilder());
            }
        }

        // and the phone numbers.
        if (request.getPhones() != null) {
            for (Phone phone : request.getPhones()) {
                PHONE_FORM_SERIALIZER.encode(phone, builder);
            }
        }

        // Add the User-defined fields.
        request.getCustomTextFields().entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .forEach(entry -> builder.appendField(entry.getKey(), entry.getValue()));
        request.getCustomDateFields().entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .forEach(entry -> builder.appendField(entry.getKey(), entry.getValue()));
        request.getCustomPulldownFields().entrySet().stream()
                .filter(entry -> entry.getValue() != null)
                .forEach(entry -> builder.appendField(entry.getKey(), entry.getValue()));
    }
}
