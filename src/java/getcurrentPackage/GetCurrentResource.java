package getcurrentPackage;

import java.io.StringWriter;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@Path("getcurrent")
public class GetCurrentResource {

    @Context
    private UriInfo context;
    private GetCurrentAcc database;

    public GetCurrentResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getCurrent(@QueryParam("Patient_ID") String Patient_ID, @QueryParam("Device_ID") String Device_ID) {
        database = new GetCurrentAcc();
        database.setConfiguration(Patient_ID, Device_ID);
        return database.stringXML();

//        return tempCurrent(Patient_ID, Device_ID);
    }

    private String tempCurrent(String Patient_ID, String Device_ID) {
        Current getcurrent = new Current();
        
//        getcurrent.setPatient_ID(Patient_ID);
//        getcurrent.setDevice_ID(Device_ID);
//        getcurrent.setWeek_NO(1);
//        getcurrent.setDay_NO(1);
//        getcurrent.setSet_NO(1);
//        getcurrent.setTime_NO(1);
//        getcurrent.setNoDayinWeek(4);
//        getcurrent.setNoSetinDay(3);
//        getcurrent.setNoTimeinSet(10);
//        getcurrent.setEnd_DateTime(Instant.now().getEpochSecond() + "");

        StringWriter xml = new StringWriter();
        try {

//                JAXBContext jaxbContext = JAXBContext.newInstance(getConfig.getClass());
            JAXBContext jaxbContext = JAXBContext.newInstance(Current.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(getcurrent, xml);
            jaxbMarshaller.marshal(getcurrent, System.out);

        } catch (JAXBException e) {
            System.err.println("JAXBEXception");
            e.printStackTrace();
        }
        return xml.toString();
    }
}
