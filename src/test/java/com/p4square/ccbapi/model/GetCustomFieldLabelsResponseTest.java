package com.p4square.ccbapi.model;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for parsing GetCustomFieldLabelsResponse.
 */
public class GetCustomFieldLabelsResponseTest extends XmlBinderTestBase {

    /**
     * Assert that all of the fields bind appropriately in a GetCustomFieldLabelsResponse.
     */
    @Test
    public void testGetCustomFieldLabelsResponse() throws Exception {
        final GetCustomFieldLabelsResponse response = parseFile("ccb_custom_field_labels_response.xml",
                GetCustomFieldLabelsResponse.class);

        assertNull("Response should not have errors", response.getErrors());

        assertNotNull(response.getCustomFields());
        assertEquals(27, response.getCustomFields().size());

        // Check the first field.
        CustomField field = response.getCustomFields().get(0);
        assertEquals("udf_ind_text_1", field.getName());
        assertEquals("Favorite Movie", field.getLabel());
        assertEquals(false, field.isAdminOnly());

        // And the second.
        field = response.getCustomFields().get(1);
        assertEquals("udf_ind_text_2", field.getName());
        assertEquals("Another Field", field.getLabel());
        assertEquals(true, field.isAdminOnly());

        // And that's probably enough for now...
    }
}