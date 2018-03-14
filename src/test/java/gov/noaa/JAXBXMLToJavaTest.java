package gov.noaa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JAXBXMLToJavaTest {

    private final Logger logger = LogManager.getLogger(this.getClass());


    @Test
    void main() {
        JAXBXMLToJava jaxbxmlToJava = new JAXBXMLToJava();

        String testLatLon = "??";

        String returnedLatLon = jaxbxmlToJava.getLatLon();

        assertEquals(testLatLon, returnedLatLon);
    }
}