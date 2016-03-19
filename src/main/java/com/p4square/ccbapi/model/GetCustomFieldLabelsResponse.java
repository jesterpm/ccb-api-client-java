package com.p4square.ccbapi.model;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

/**
 * GetCustomFieldLabelsResponse models the response returned by the custom_field_labels API.
 */
@XmlRootElement(name="response")
@XmlAccessorType(XmlAccessType.NONE)
public class GetCustomFieldLabelsResponse extends CCBAPIResponse {

    @XmlElementWrapper(name = "custom_fields")
    @XmlElement(name="custom_field")
    private List<CustomField> customFields;

    public GetCustomFieldLabelsResponse() {
        customFields = new ArrayList<>();
    }

    /**
     * @return The list of custom field names and labels.
     */
    public List<CustomField> getCustomFields() {
        return customFields;
    }

    /**
     * Set the list of custom fields.
     *
     * @param fields The list to include in the response.
     */
    public void setCustomFields(final List<CustomField> fields) {
        this.customFields = fields;
    }
}
