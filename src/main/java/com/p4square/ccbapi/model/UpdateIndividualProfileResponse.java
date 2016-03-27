package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * The response from an update_individual request.
 */
@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.NONE)
public class UpdateIndividualProfileResponse extends CCBAPIResponse {

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
