package com.p4square.ccbapi;

import com.p4square.ccbapi.exception.CCBParseException;
import com.p4square.ccbapi.model.*;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

/**
 * Tests for the CCBXmlBinder.
 */
public class CCBXmlBinderTest {

    private CCBXmlBinder binder;

    @Before
    public void setUp() {
        binder = new CCBXmlBinder();
    }

    /**
     * Expect CCBXmlBinder to throw an exception if there is no response element.
     */
    @Test(expected = CCBParseException.class)
    public void testMalformedNoResponseEntity() throws Exception {
        runTest("ccb_malformed_response_no_entity.xml", GetCustomFieldLabelsResponse.class);
    }

    /**
     * Expect CCBXmlBinder to throw an exception if the XML is malformed.
     */
    @Test(expected = CCBParseException.class)
    public void testMalformedXML() throws Exception {
        runTest("ccb_malformed_xml.xml", GetCustomFieldLabelsResponse.class);
    }

    /**
     * Assert CCBXmlBinder correctly parses an error response.
     */
    @Test
    public void testErrorResponse() throws Exception {
        CCBAPIResponse response = runTest("model/ccb_error_response.xml", GetCustomFieldLabelsResponse.class);

        assertNotNull(response.getErrors());
        assertEquals(1, response.getErrors().size());

        CCBErrorResponse error = response.getErrors().get(0);
        assertEquals(2, error.getNumber());
        assertEquals("Service Permission", error.getType());
        assertEquals("Invalid username or password.", error.getDescription());
    }

    /**
     * Assert CCBXmlBinder correctly parses a more elaborate response.
     */
    @Test
    public void testGetCustomFieldLabelsResponse() throws Exception {
        GetCustomFieldLabelsResponse response = runTest("model/ccb_custom_field_labels_response.xml",
                                                        GetCustomFieldLabelsResponse.class);

        assertNull("Response should not have errors", response.getErrors());

        assertNotNull(response.getCustomFields());
        assertEquals(27, response.getCustomFields().size());

        CustomField field = response.getCustomFields().get(0);
        assertEquals("udf_ind_text_1", field.getName());
        assertEquals("Favorite Movie", field.getLabel());
        assertEquals(false, field.isAdminOnly());

        field = response.getCustomFields().get(1);
        assertEquals("udf_ind_text_2", field.getName());
        assertEquals("Another Field", field.getLabel());
        assertEquals(true, field.isAdminOnly());
    }

    /**
     * Helper to test the response stored in a file.
     *
     * @param filename The name of the xml file containing the response.
     * @param clazz The class to bind to.
     * @param <T> The type of the return value.
     * @return The parsed response.
     * @throws Exception If something fails.
     */
    private <T extends CCBAPIResponse> T runTest(final String filename, final Class<T> clazz) throws Exception {
        InputStream in = getClass().getResourceAsStream(filename);
        if (in == null) {
            throw new AssertionError("Could not find file " + filename);
        }
        try {
            return binder.bindResponseXML(in, clazz);
        } finally {
            in.close();
        }
    }
}