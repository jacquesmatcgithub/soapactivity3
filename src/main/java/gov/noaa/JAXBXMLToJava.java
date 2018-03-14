package gov.noaa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class JAXBXMLToJava {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public String getLatLon() {

        String latLonList = "";
        logger.info("Hello");
        try {

            // create JAXB context and initializing Marshaller
            JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);

            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();


            // specify the location and name of xml file to be read
//            File XMLfile = new File("/Users/JacquesFourie/MATCProjects/enterprisejava/week8/soapactivity3/src/test/resources/response.xml");
            File XMLfile = new File("src/test/resources/response.xml");

            // this will create Java object - dwmlType from the XML file
            DwmlType dwmlType = (DwmlType) jaxbUnmarshaller.unmarshal(XMLfile);


            logger.info("DwmlType Version: " , dwmlType.getVersion());

            latLonList = dwmlType.getLatLonList();

            logger.info("Latlon:" , latLonList);


        } catch (JAXBException e) {
            // some exception occured
            e.printStackTrace();
        }

        return latLonList;
    }


}