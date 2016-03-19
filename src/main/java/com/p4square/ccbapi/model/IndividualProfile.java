package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Representation of a Individual Profile.
 */
@XmlRootElement(name="individual")
@XmlAccessorType(XmlAccessType.NONE)
public class IndividualProfile {

    @XmlAttribute(name="id")
    private int id;

    @XmlElement(name="other_id")
    private int otherId;

    @XmlElement(name="sync_id")
    private int syncId;

    @XmlElement(name="giving_number")
    private String givingNumber;

    @XmlElement(name="active")
    private boolean active;

    @XmlElement(name="first_name")
    private String firstName;

    @XmlElement(name="last_name")
    private String lastName;

    @XmlElement(name="middle_name")
    private String middleName;

    @XmlElement(name="legal_first_name")
    private String legalFirstName;

    @XmlElement(name="full_name")
    private String fullName;

    @XmlElement(name="salutation")
    private String salutation;

    @XmlElement(name="suffix")
    private String suffix;

    @XmlElement(name="image")
    private String imageUrl;

    @XmlElement(name="family_position", defaultValue = "Primary Contact")
    private FamilyPosition familyPosition;

    @XmlElement(name="family")
    private FamilyReference family;

    @XmlElement(name="family_image")
    private String familyImageUrl;

    @XmlElementWrapper(name="family_members")
    @XmlElement(name="family_member")
    private List<FamilyMemberReference> familyMembers;

    @XmlElement(name="email")
    private String email;

    @XmlElement(name="login")
    private String login;

    @XmlElement(name="allergies")
    private String allergies;

    @XmlElement(name="confirmed_no_allergies")
    private boolean confirmedNoAllergies;

    @XmlElement(name="gender")
    private Gender gender;

    @XmlElement(name="marital_status", defaultValue="")
    private MaritalStatus maritalStatus;

    @XmlElement(name="birthday")
    private LocalDate birthday;

    @XmlElement(name="anniversary")
    private LocalDate anniversary;

    @XmlElement(name="deceased")
    private LocalDate deceased;

    @XmlElement(name="membership_date")
    private LocalDate membershipStartDate;

    @XmlElement(name="membership_end")
    private LocalDate membershipEndDate;

    @XmlElement(name="baptized")
    private boolean baptized;

    @XmlElement(name="creator")
    private IndividualReference createdBy;

    @XmlElement(name="created")
    private LocalDateTime createdTime;

    @XmlElement(name="modifier")
    private IndividualReference modifiedBy;

    @XmlElement(name="modified")
    private LocalDateTime modifiedTime;

    @XmlElementWrapper(name="addresses")
    @XmlElement(name="address")
    private List<Address> addresses;

    @XmlElementWrapper(name="phones")
    @XmlElement(name="phone")
    private List<Phone> phones;

    @XmlElementWrapper(name="user_defined_text_fields")
    @XmlElement(name="user_defined_text_field")
    private CustomFieldCollection<CustomTextFieldValue> customTextFields;

    @XmlElementWrapper(name="user_defined_date_fields")
    @XmlElement(name="user_defined_date_field")
    private CustomFieldCollection<CustomDateFieldValue> customDateFields;

    @XmlElementWrapper(name="user_defined_pulldown_fields")
    @XmlElement(name="user_defined_pulldown_field")
    private CustomFieldCollection<CustomPulldownFieldValue> customPulldownFields;

    public IndividualProfile() {
        familyMembers = new ArrayList<>();
        addresses = new ArrayList<>();
        phones = new ArrayList<>();
        customTextFields = new CustomFieldCollection<>();
        customDateFields = new CustomFieldCollection<>();
        customPulldownFields = new CustomFieldCollection<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOtherId() {
        return otherId;
    }

    public IndividualProfile setOtherId(int otherId) {
        this.otherId = otherId;
        return this;
    }

    public int getSyncId() {
        return syncId;
    }

    public void setSyncId(int syncId) {
        this.syncId = syncId;
    }

    public String getGivingNumber() {
        return givingNumber;
    }

    public void setGivingNumber(String givingNumber) {
        this.givingNumber = givingNumber;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLegalFirstName() {
        return legalFirstName;
    }

    public void setLegalFirstName(String legalFirstName) {
        this.legalFirstName = legalFirstName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public FamilyPosition getFamilyPosition() {
        return familyPosition;
    }

    public void setFamilyPosition(FamilyPosition familyPosition) {
        this.familyPosition = familyPosition;
    }

    public FamilyReference getFamily() {
        return family;
    }

    public void setFamily(FamilyReference family) {
        this.family = family;
    }

    public String getFamilyImageUrl() {
        return familyImageUrl;
    }

    public void setFamilyImageUrl(String familyImageUrl) {
        this.familyImageUrl = familyImageUrl;
    }

    public List<FamilyMemberReference> getFamilyMembers() {
        return familyMembers;
    }

    public void setFamilyMembers(List<FamilyMemberReference> familyMembers) {
        this.familyMembers = familyMembers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public boolean isConfirmedNoAllergies() {
        return confirmedNoAllergies;
    }

    public void setConfirmedNoAllergies(boolean confirmedNoAllergies) {
        this.confirmedNoAllergies = confirmedNoAllergies;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(MaritalStatus maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDate getAnniversary() {
        return anniversary;
    }

    public void setAnniversary(LocalDate anniversary) {
        this.anniversary = anniversary;
    }

    public LocalDate getDeceased() {
        return deceased;
    }

    public void setDeceased(LocalDate deceased) {
        this.deceased = deceased;
    }

    public LocalDate getMembershipStartDate() {
        return membershipStartDate;
    }

    public void setMembershipStartDate(LocalDate membershipStartDate) {
        this.membershipStartDate = membershipStartDate;
    }

    public LocalDate getMembershipEndDate() {
        return membershipEndDate;
    }

    public void setMembershipEndDate(LocalDate membershipEndDate) {
        this.membershipEndDate = membershipEndDate;
    }

    public boolean isBaptized() {
        return baptized;
    }

    public void setBaptized(boolean baptized) {
        this.baptized = baptized;
    }

    public IndividualReference getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(IndividualReference createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public IndividualReference getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(IndividualReference modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(LocalDateTime modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public CustomFieldCollection<CustomTextFieldValue> getCustomTextFields() {
        return customTextFields;
    }

    public void setCustomTextFields(CustomFieldCollection<CustomTextFieldValue> customTextFields) {
        this.customTextFields = customTextFields;
    }

    public CustomFieldCollection<CustomDateFieldValue> getCustomDateFields() {
        return customDateFields;
    }

    public void setCustomDateFields(CustomFieldCollection<CustomDateFieldValue> customDateFields) {
        this.customDateFields = customDateFields;
    }

    public CustomFieldCollection<CustomPulldownFieldValue> getCustomPulldownFields() {
        return customPulldownFields;
    }

    public void setCustomPulldownFields(CustomFieldCollection<CustomPulldownFieldValue> customPulldownFields) {
        this.customPulldownFields = customPulldownFields;
    }
}
