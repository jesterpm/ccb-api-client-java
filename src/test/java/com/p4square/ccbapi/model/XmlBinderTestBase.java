package com.p4square.ccbapi.model;

import java.io.InputStream;
import com.p4square.ccbapi.CCBXmlBinder;
import org.junit.Before;

/**
 * Created by jesterpm on 3/14/16.
 */
public class XmlBinderTestBase {

    private CCBXmlBinder binder;

    @Before
    public void setUp() {
        binder = new CCBXmlBinder();
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
    protected <T extends CCBAPIResponse> T parseFile(final String filename, final Class<T> clazz) throws Exception {
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
