package configurationPackage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("getthreshold")
public class DatabaseResource {

    @Context
    private UriInfo context;
    private DatabaseAcc database;
    
    public DatabaseResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getConfiguration2(@QueryParam("Patient_ID")String Patient_ID, @QueryParam("Device_ID")String Device_ID, @QueryParam("Week_NO")String Week_NO){
        database = new DatabaseAcc();
        if(Week_NO == null){
            database.setConfiguration(Patient_ID,Device_ID);
        }else{
            database.setConfiguration2(Patient_ID,Device_ID,Week_NO);
        }
        return database.stringXML();
    }

//    @PUT
//    @Consumes("text/html")
//    public void putHtml(String content) {
//    }

    /**
     * PUT method for updating or creating an instance of DatabaseResource
     * @param content representation for the resource
     */
//    @PUT
//    @Consumes(MediaType.APPLICATION_XML)
//    public void putXml(String content) {
//    }
}
