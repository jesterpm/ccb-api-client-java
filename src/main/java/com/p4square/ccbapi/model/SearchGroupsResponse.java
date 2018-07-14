package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * SearchGroupsResponse models the response from the group_search API.
 */
@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.NONE)
public class SearchGroupsResponse extends CCBAPIResponse {

    @XmlElementWrapper(name = "items")
    @XmlElement(name="item")
    private List<GroupSearchResult> results;

    /**
     * @return The list of individuals retrieved from CCB.
     */
    public List<GroupSearchResult> getResults() {
        return results;
    }

    public void setResults(List<GroupSearchResult> results) {
        this.results = results;
    }
}
