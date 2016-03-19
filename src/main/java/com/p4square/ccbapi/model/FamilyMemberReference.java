package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * Reference to a family member.
 */
@XmlAccessorType(XmlAccessType.NONE)
public class FamilyMemberReference {

    @XmlElement(name="individual")
    private IndividualReference individualReference;

    @XmlElement(name="family_position")
    private FamilyPosition familyPosition;

    public IndividualReference getIndividualReference() {
        return individualReference;
    }

    public void setIndividualReference(IndividualReference individualReference) {
        this.individualReference = individualReference;
    }

    public FamilyPosition getFamilyPosition() {
        return familyPosition;
    }

    public void setFamilyPosition(FamilyPosition familyPosition) {
        this.familyPosition = familyPosition;
    }
}
