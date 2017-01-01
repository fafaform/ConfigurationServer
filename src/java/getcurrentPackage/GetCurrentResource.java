package getcurrentPackage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("getcurrent")
public class GetCurrentResource {

    @Context
    private UriInfo context;
    private GetCurrentAcc database;
    
    public GetCurrentResource() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getCurrent(@QueryParam("Patient_ID")String Patient_ID, @QueryParam("Device_ID")String Device_ID){
        database = new GetCurrentAcc();
        database.setConfiguration(Patient_ID,Device_ID);

        return database.stringXML();
    }

}
