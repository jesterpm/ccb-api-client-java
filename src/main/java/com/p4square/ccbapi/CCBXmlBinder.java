package com.p4square.ccbapi;

import com.p4square.ccbapi.exception.CCBParseException;
import com.p4square.ccbapi.model.CCBAPIResponse;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;

/**
 * CCBXmlBinder is used to bind XML responses to CCBAPIResponse implementations.
 *
 * This class is thread-safe.
 */
public class CCBXmlBinder {
    private final XMLInputFactory xmlInputFactory;
    private final ConcurrentHashMap<Class<? extends CCBAPIResponse>, JAXBContext> jaxbContextCache;

    public CCBXmlBinder() {
        xmlInputFactory = XMLInputFactory.newFactory();
        jaxbContextCache = new ConcurrentHashMap<>();
    }

    public <T extends CCBAPIResponse> T bindResponseXML(InputStream response, Class<T> responseClass)
            throws CCBParseException {
        try {
            final XMLStreamReader xmlReader = xmlInputFactory.createXMLStreamReader(response);
            final JAXBContext jaxbContext = getJAXBContext(responseClass);
            final Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            // Skip ahead to the response entity.
            while (xmlReader.hasNext()) {
                xmlReader.next();
                if (xmlReader.isStartElement() && "response".equalsIgnoreCase(xmlReader.getLocalName())) {
                    // Parse and return the response.
                    // If the response cannot be parsed a JAXBException will be thrown.
                    return (T) unmarshaller.unmarshal(xmlReader);
                }
            }

            // If we reach this point then the response did not contain a response element.
            throw new CCBParseException("Response did not contain a response element.");

        } catch (XMLStreamException | JAXBException e) {
            throw new CCBParseException("Failed to parse response.", e);
        }
    }

    /**
     * Find or create the JAXBContext for a CCBAPIResponse implementation.
     *
     * @param responseClass The response implementation class.
     * @return a JAXBContext which can be used to unmarshell the responseClass.
     */
    private JAXBContext getJAXBContext(Class<? extends CCBAPIResponse> responseClass) {
        if (!jaxbContextCache.containsKey(responseClass)) {
            synchronized (jaxbContextCache) {
                // Check again to be sure.
                if (!jaxbContextCache.containsKey(responseClass)) {
                    try {
                        final JAXBContext jaxbContext = JAXBContext.newInstance(responseClass);
                        jaxbContextCache.put(responseClass, jaxbContext);
                    } catch (JAXBException e) {
                        throw new AssertionError("Could not construct JAXBContext for " + responseClass.getName(), e);
                    }
                }
            }
        }
        return jaxbContextCache.get(responseClass);
    }
}
