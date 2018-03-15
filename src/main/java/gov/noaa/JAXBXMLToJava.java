package gov.noaa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 * The JAXBXMLToJava class contains methods that will:
 * <ul>
 * <li>Return the latitude & longitude from the xml file</li>
 * <li>Return the version from the xml file</li>
 * </ul>
 */
public class JAXBXMLToJava {

    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Gets latitude & longitude from the xml file
     *
     * @param xmlFile The file containing the xml
     * @return the latitude & longitude from the xml file
     */
    public String getLatLon(String xmlFile) {

        String latLonList = "";

        try {
            DwmlType dwmlType = getDwmlType(xmlFile);
            latLonList = dwmlType.getLatLonList();
        } catch (JAXBException e) {
            logger.error("JAXBException:", e);
        }

        return latLonList;
    }


    /**
     * Gets the version from the xml file
     *
     * @param xmlFile The file containing the xml
     * @return the version from the xml file
     */
    public String getVersion(String xmlFile) {

        String version = "";

        try {
            DwmlType dwmlType = getDwmlType(xmlFile);
            version = dwmlType.getVersion();
        } catch (JAXBException e) {
            logger.error("JAXBException:", e);
        }

        return version;
    }


    /**
     * Return an unmarchalled xmls file as a DwmlType method.
     *
     * @return DwmlType
     */
    private DwmlType getDwmlType(String xmlFile) throws JAXBException {

        // create JAXB context and initializing Marshaller
        JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        // return unmarshalled xml file
        return (DwmlType) jaxbUnmarshaller.unmarshal(new File(xmlFile));
    }

}