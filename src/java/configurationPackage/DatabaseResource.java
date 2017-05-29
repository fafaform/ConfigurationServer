package configurationPackage;

import java.io.StringWriter;
import java.time.Instant;
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

@Path("getthreshold")
public class DatabaseResource {

    @Context
    private UriInfo context;
    private DatabaseAcc database;

    public DatabaseResource() {
    }

    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getConfiguration2(@QueryParam("Patient_ID") String Patient_ID, @QueryParam("Device_ID") String Device_ID, @QueryParam("Week_NO") String Week_NO) {
        database = new DatabaseAcc();
        if (Week_NO == null) {
            database.setConfiguration(Patient_ID, Device_ID);
        } else {
            database.setConfiguration2(Patient_ID, Device_ID, Week_NO);
        }
        return database.stringXML();

//        return tempConfigure(Patient_ID, Device_ID);
    }

    private String tempConfigure(String Patient_ID, String Device_ID) {
        long unixTimestamp = Instant.now().getEpochSecond();
        Configurations getConfig = new Configurations();
        Configuration getconfig = new Configuration();

        getconfig.setThreshold_ID(1);
        getconfig.setPatient_ID(Patient_ID);
        getconfig.setStaff_ID(1 + "");
        getconfig.setDevice_ID(Device_ID);
        getconfig.setWeek_NO(1);
        getconfig.setThreshold_DateTime((int) unixTimestamp + "");
        switch (Device_ID) {
            case "4":
                getconfig.setThreshold_1(100 + "");
                getconfig.setThreshold_2(150 + "");
//                getconfig.setThreshold_3(3 + "");
        getconfig.setThreshold_3("null");
//                getconfig.setThreshold_4(1 + "");
        getconfig.setThreshold_4("null");
//                getconfig.setThreshold_5(2 + "");
        getconfig.setThreshold_5("null");
//                getconfig.setThreshold_6(3 + "");
        getconfig.setThreshold_6("null");
//                getconfig.setThreshold_7(1 + "");
        getconfig.setThreshold_7("null");
//                getconfig.setThreshold_8(2 + "");
        getconfig.setThreshold_8("null");
//                getconfig.setThreshold_9(3 + "");
        getconfig.setThreshold_9("null");
//                getconfig.setThreshold_10(1 + "");
        getconfig.setThreshold_10("null");
                getconfig.setNoDayinWeek(5);
                getconfig.setNoSetinDay(2);
                getconfig.setNoTimeinSet(3);
                break;
            case "5":
                getconfig.setThreshold_1(50 + "");
                getconfig.setThreshold_2(1 + "");
                getconfig.setThreshold_3(2 + "");
//        getconfig.setThreshold_3("null");
//                getconfig.setThreshold_4(1 + "");
        getconfig.setThreshold_4("null");
//                getconfig.setThreshold_5(2 + "");
        getconfig.setThreshold_5("null");
//                getconfig.setThreshold_6(3 + "");
        getconfig.setThreshold_6("null");
//                getconfig.setThreshold_7(1 + "");
        getconfig.setThreshold_7("null");
//                getconfig.setThreshold_8(2 + "");
        getconfig.setThreshold_8("null");
//                getconfig.setThreshold_9(3 + "");
        getconfig.setThreshold_9("null");
//                getconfig.setThreshold_10(1 + "");
        getconfig.setThreshold_10("null");
                getconfig.setNoDayinWeek(5);
                getconfig.setNoSetinDay(5);
                getconfig.setNoTimeinSet(5);
                break;
            case "10":
                getconfig.setThreshold_1(6 + "");
                getconfig.setThreshold_2(2 + "");
//                getconfig.setThreshold_3(3 + "");
        getconfig.setThreshold_3("null");
//                getconfig.setThreshold_4(1 + "");
        getconfig.setThreshold_4("null");
//                getconfig.setThreshold_5(2 + "");
        getconfig.setThreshold_5("null");
//                getconfig.setThreshold_6(3 + "");
        getconfig.setThreshold_6("null");
//                getconfig.setThreshold_7(1 + "");
        getconfig.setThreshold_7("null");
//                getconfig.setThreshold_8(2 + "");
        getconfig.setThreshold_8("null");
//                getconfig.setThreshold_9(3 + "");
        getconfig.setThreshold_9("null");
//                getconfig.setThreshold_10(1 + "");
        getconfig.setThreshold_10("null");
                getconfig.setNoDayinWeek(4);
                getconfig.setNoSetinDay(3);
                getconfig.setNoTimeinSet(10);
                break;
            case "13":
                getconfig.setThreshold_1(50 + "");
                getconfig.setThreshold_2(50 + "");
                getconfig.setThreshold_3(70 + "");
//        getconfig.setThreshold_3("null");
//                getconfig.setThreshold_4(1 + "");
        getconfig.setThreshold_4("null");
//                getconfig.setThreshold_5(2 + "");
        getconfig.setThreshold_5("null");
//                getconfig.setThreshold_6(3 + "");
        getconfig.setThreshold_6("null");
//                getconfig.setThreshold_7(1 + "");
        getconfig.setThreshold_7("null");
//                getconfig.setThreshold_8(2 + "");
        getconfig.setThreshold_8("null");
//                getconfig.setThreshold_9(3 + "");
        getconfig.setThreshold_9("null");
//                getconfig.setThreshold_10(1 + "");
        getconfig.setThreshold_10("null");
                getconfig.setNoDayinWeek(5);
                getconfig.setNoSetinDay(3);
                getconfig.setNoTimeinSet(5);
                break;
            case "14":
                getconfig.setThreshold_1(1 + "");
                getconfig.setThreshold_2(2 + "");
                getconfig.setThreshold_3(3 + "");
//        getconfig.setThreshold_3("null");
                getconfig.setThreshold_4(1 + "");
//        getconfig.setThreshold_4("null");
                getconfig.setThreshold_5(2 + "");
//        getconfig.setThreshold_5("null");
                getconfig.setThreshold_6(3 + "");
//        getconfig.setThreshold_6("null");
                getconfig.setThreshold_7(1 + "");
//        getconfig.setThreshold_7("null");
                getconfig.setThreshold_8(2 + "");
//        getconfig.setThreshold_8("null");
                getconfig.setThreshold_9(3 + "");
//        getconfig.setThreshold_9("null");
                getconfig.setThreshold_10(1 + "");
//        getconfig.setThreshold_10("null");
                getconfig.setNoDayinWeek(1);
                getconfig.setNoSetinDay(2);
                getconfig.setNoTimeinSet(3);
                break;
            default:
                getconfig.setThreshold_1(1 + "");
                getconfig.setThreshold_2(2 + "");
                getconfig.setThreshold_3(3 + "");
//        getconfig.setThreshold_3("null");
                getconfig.setThreshold_4(1 + "");
//        getconfig.setThreshold_4("null");
                getconfig.setThreshold_5(2 + "");
//        getconfig.setThreshold_5("null");
                getconfig.setThreshold_6(3 + "");
//        getconfig.setThreshold_6("null");
                getconfig.setThreshold_7(1 + "");
//        getconfig.setThreshold_7("null");
                getconfig.setThreshold_8(2 + "");
//        getconfig.setThreshold_8("null");
                getconfig.setThreshold_9(3 + "");
//        getconfig.setThreshold_9("null");
                getconfig.setThreshold_10(1 + "");
//        getconfig.setThreshold_10("null");
                getconfig.setNoDayinWeek(1);
                getconfig.setNoSetinDay(2);
                getconfig.setNoTimeinSet(3);
                break;
        }
        getConfig.getConfiguration().add(getconfig);

        StringWriter xml = new StringWriter();
        try {

//		JAXBContext jaxbContext = JAXBContext.newInstance(Configurations.class);
            JAXBContext jaxbContext = JAXBContext.newInstance(getConfig.getClass());
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(getConfig, xml);
            jaxbMarshaller.marshal(getConfig, System.out);

        } catch (JAXBException e) {
            System.err.println("JAXBEXception");
            e.printStackTrace();
        }
        return xml.toString();
    }

//    @PUT
//    @Consumes("text/html")
//    public void putHtml(String content) {
//    }
    /**
     * PUT method for updating or creating an instance of DatabaseResource
     *
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_XML)
//    public void putXml(String content) {
//    }
}
