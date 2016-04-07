package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A GetLookupTableResponse contains a list of lookup table values.
 */
@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.NONE)
public class GetLookupTableResponse extends CCBAPIResponse {

    @XmlElementWrapper(name = "items")
    @XmlElement(name="item")
    private List<LookupTableItem> items;

    public GetLookupTableResponse() {
        items = new ArrayList<>();
    }

    /**
     * @return The list of items in the lookup table.
     */
    public List<LookupTableItem> getItems() {
        return items;
    }

    /**
     * Set the list of lookup table items.
     *
     * @param items  The list of items in the lookup table.
     */
    public void setItems(final List<LookupTableItem> items) {
        this.items = items;
    }
}