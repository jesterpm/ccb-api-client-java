package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * GetCustomFieldLabelsResponse models the response of a variety of APIs which return one or more Individual Profiles.
 */
@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.NONE)
public class GetIndividualProfilesResponse extends CCBAPIResponse {

    @XmlElementWrapper(name = "individuals")
    @XmlElement(name="individual")
    private List<IndividualProfile> individuals;

    /**
     * @return The list of individuals retrieved from CCB.
     */
    public List<IndividualProfile> getIndividuals() {
        return individuals;
    }

    public void setIndividuals(List<IndividualProfile> individuals) {
        this.individuals = individuals;
    }
}
