package com.p4square.ccbapi.model;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * UpdateIndividualProfileRequest encapsulates a change to an IndividualProfile.
 *
 * The only property which must be set is {@link #withIndividualId(int)},
 * to indicate the profile to update.
 *
 * A property can be unset by setting it to null.
 */
public class UpdateIndividualProfileRequest {

    /**
     * The set of all valid custom text field names.
     */
    public static final Set<String> CUSTOM_TEXT_FIELD_NAMES =
            IntStream.rangeClosed(1, 12).mapToObj(x -> "udf_text_" + x).collect(Collectors.toSet());

    /**
     * The set of all valid custom date field names.
     */
    public static final Set<String> CUSTOM_DATE_FIELD_NAMES =
            IntStream.rangeClosed(1, 6).mapToObj(x -> "udf_date_" + x).collect(Collectors.toSet());

    /**
     * The set of all valid custom pulldown field names.
     */
    public static final Set<String> CUSTOM_PULLDOWN_FIELD_NAMES =
            IntStream.rangeClosed(1, 6).mapToObj(x -> "udf_pulldown_" + x).collect(Collectors.toSet());

    private int individualId;

    private Integer syncId;
    private String otherId;
    private String givingNumber;

    private String firstName;
    private String lastName;
    private String middleName;
    private String legalFirstName;
    private String salutation;
    private String suffix;

    private Integer familyId;

    private FamilyPosition familyPosition;

    private MaritalStatus maritalStatus;

    private Gender gender;
    private LocalDate birthday;
    private LocalDate anniversary;
    private LocalDate deceased;
    private LocalDate membershipDate;
    private LocalDate membershipEnd;

    private String email;

    private List<Address> addresses;
    private List<Phone> phones;

    private String emergencyContactName;
    private String allergies;
    private Boolean confirmedNoAllergies;
    private Boolean baptized;

    private Map<String, String> customTextFields = new HashMap<>();
    private Map<String, LocalDate> customDateFields = new HashMap<>();
    private Map<String, Integer> customPulldownFields = new HashMap<>();

    private Integer modifiedById;

    public int getIndividualId() {
        return individualId;
    }

    public UpdateIndividualProfileRequest withIndividualId(int individualId) {
        this.individualId = individualId;
        return this;
    }

    public Integer getSyncId() {
        return syncId;
    }

    public UpdateIndividualProfileRequest withSyncId(Integer syncId) {
        this.syncId = syncId;
        return this;
    }

    public String getOtherId() {
        return otherId;
    }

    public UpdateIndividualProfileRequest withOtherId(String otherId) {
        this.otherId = otherId;
        return this;
    }

    public String getGivingNumber() {
        return givingNumber;
    }

    public UpdateIndividualProfileRequest withGivingNumber(String givingNumber) {
        this.givingNumber = givingNumber;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UpdateIndividualProfileRequest withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UpdateIndividualProfileRequest withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getMiddleName() {
        return middleName;
    }

    public UpdateIndividualProfileRequest withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public String getLegalFirstName() {
        return legalFirstName;
    }

    public UpdateIndividualProfileRequest withLegalFirstName(String legalFirstName) {
        this.legalFirstName = legalFirstName;
        return this;
    }

    public String getSalutation() {
        return salutation;
    }

    public UpdateIndividualProfileRequest withSalutation(String salutation) {
        this.salutation = salutation;
        return this;
    }

    public String getSuffix() {
        return suffix;
    }

    public UpdateIndividualProfileRequest withSuffix(String suffix) {
        this.suffix = suffix;
        return this;
    }

    public Integer getFamilyId() {
        return familyId;
    }

    public UpdateIndividualProfileRequest withFamilyId(Integer familyId) {
        this.familyId = familyId;
        return this;
    }

    public FamilyPosition getFamilyPosition() {
        return familyPosition;
    }

    public UpdateIndividualProfileRequest withFamilyPosition(FamilyPosition familyPosition) {
        this.familyPosition = familyPosition;
        return this;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public UpdateIndividualProfileRequest withMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
        return this;
    }

    public Gender getGender() {
        return gender;
    }

    public UpdateIndividualProfileRequest withGender(Gender gender) {
        this.gender = gender;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public UpdateIndividualProfileRequest withBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public LocalDate getAnniversary() {
        return anniversary;
    }

    public UpdateIndividualProfileRequest withAnniversary(LocalDate anniversary) {
        this.anniversary = anniversary;
        return this;
    }

    public LocalDate getDeceased() {
        return deceased;
    }

    public UpdateIndividualProfileRequest withDeceased(LocalDate deceased) {
        this.deceased = deceased;
        return this;
    }

    public LocalDate getMembershipDate() {
        return membershipDate;
    }

    public UpdateIndividualProfileRequest withMembershipDate(LocalDate membershipDate) {
        this.membershipDate = membershipDate;
        return this;
    }

    public LocalDate getMembershipEnd() {
        return membershipEnd;
    }

    public UpdateIndividualProfileRequest withMembershipEnd(LocalDate membershipEnd) {
        this.membershipEnd = membershipEnd;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UpdateIndividualProfileRequest withEmail(String email) {
        this.email = email;
        return this;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public UpdateIndividualProfileRequest withAddresses(List<Address> addresses) {
        this.addresses = addresses;
        return this;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public UpdateIndividualProfileRequest withPhones(List<Phone> phones) {
        this.phones = phones;
        return this;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public UpdateIndividualProfileRequest withEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
        return this;
    }

    public String getAllergies() {
        return allergies;
    }

    public UpdateIndividualProfileRequest withAllergies(String allergies) {
        this.allergies = allergies;
        return this;
    }

    public Boolean getConfirmedNoAllergies() {
        return confirmedNoAllergies;
    }

    public UpdateIndividualProfileRequest withConfirmedNoAllergies(Boolean confirmedNoAllergies) {
        this.confirmedNoAllergies = confirmedNoAllergies;
        return this;
    }

    public Boolean getBaptized() {
        return baptized;
    }

    public UpdateIndividualProfileRequest withBaptized(Boolean baptized) {
        this.baptized = baptized;
        return this;
    }

    /**
     * @return A map of custom field identifiers to text field values.
     */
    public Map<String, String> getCustomTextFields() {
        return customTextFields;
    }

    public UpdateIndividualProfileRequest withCustomTextField(final String name, final String value) {
        final String transformedName = transformUDFName(name);

        if (!CUSTOM_TEXT_FIELD_NAMES.contains(transformedName)) {
            throw new IllegalArgumentException(transformedName + " is not a valid a valid text field name.");
        }
        customTextFields.put(transformedName, value);
        return this;
    }

    public UpdateIndividualProfileRequest withCustomTextField(final int number, final String value) {
        return withCustomTextField("udf_text_" + number, value);
    }

    /**
     * @return A map of custom field identifiers to date field values.
     */
    public Map<String, LocalDate> getCustomDateFields() {
        return customDateFields;
    }

    public UpdateIndividualProfileRequest withCustomDateField(final String name, final LocalDate value) {
        final String transformedName = transformUDFName(name);

        if (!CUSTOM_DATE_FIELD_NAMES.contains(transformedName)) {
            throw new IllegalArgumentException(transformedName + " is not a valid a valid date field name.");
        }
        customDateFields.put(transformedName, value);
        return this;
    }

    public UpdateIndividualProfileRequest withCustomDateField(final int number, final LocalDate value) {
        return withCustomDateField("udf_date_" + number, value);
    }

    /**
     * @return A map of custom field identifiers to pulldown field values.
     */
    public Map<String, Integer> getCustomPulldownFields() {
        return customPulldownFields;
    }

    public UpdateIndividualProfileRequest withCustomPulldownField(final String name, final Integer value) {
        final String transformedName = transformUDFName(name);

        if (!CUSTOM_PULLDOWN_FIELD_NAMES.contains(transformedName)) {
            throw new IllegalArgumentException(transformedName + " is not a valid a valid pulldown field name.");
        }
        customPulldownFields.put(transformedName, value);
        return this;
    }

    public UpdateIndividualProfileRequest withCustomPulldownField(final int number, final Integer value) {
        return withCustomPulldownField("udf_pulldown_" + number, value);
    }

    public Integer getModifiedById() {
        return modifiedById;
    }

    public UpdateIndividualProfileRequest withModifiedById(Integer modifiedById) {
        this.modifiedById = modifiedById;
        return this;
    }

    /**
     * Normalize a variety forms of custom field names.
     *
     * The CCB API isn't particularly consistent about how user-defined fields are identified.
     * In most cases the fields associated with an individual are prefixed with "udf_ind_",
     * but when it comes to updating the profile the fields are prefixed with just "udf_".
     *
     * This function attempts to transform various forms into the udf_TYPE_ID form.
     *
     * @param name A custom field name.
     * @return A custom field name suitable for the update_individual_profile API.
     */
    private String transformUDFName(final String name) {
        return name.replace("_ind_", "_");
    }
}
