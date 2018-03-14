package gov.noaa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JAXBXMLToJavaTest {

    private final Logger logger = LogManager.getLogger(this.getClass());


    @Test
    void main() {
        logger.info("Hello");

        JAXBXMLToJava jaxbxmlToJava = new JAXBXMLToJava();

        String testLatLon = "43.0798,-89.3875";

        String returnedLatLon = jaxbxmlToJava.getLatLon();

        assertEquals(testLatLon, returnedLatLon);
    }
}