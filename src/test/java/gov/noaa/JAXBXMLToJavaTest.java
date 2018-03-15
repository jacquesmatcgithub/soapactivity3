package gov.noaa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class JAXBXMLToJavaTest {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Test
    void getLatLonTest() {
        logger.debug("getLatLonTest");

        String testLatLon = "43.0798,-89.3875";

        JAXBXMLToJava jaxbxmlToJava = new JAXBXMLToJava();

        String returnedLatLon = jaxbxmlToJava.getLatLon("src/test/resources/response.xml");

        assertEquals(testLatLon, returnedLatLon);
    }


    @Test
    void getVersionTest() {
        logger.debug("getVersionTest");

        String testVersion = "1.0";

        JAXBXMLToJava jaxbxmlToJava = new JAXBXMLToJava();

        String returnedVersion = jaxbxmlToJava.getVersion("src/test/resources/response.xml");

        assertEquals(testVersion, returnedVersion);
    }
}