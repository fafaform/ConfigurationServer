package updateDatabase;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("updateDatabase")
public class UpdateDatabase {

//    @Context
//    private UriInfo context;
//    private GetCurrentAcc database;
    
    public UpdateDatabase() {
    }
    
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String updateDatabase() throws Exception{
        

        new SendGet().sendGet();
        
        return "200 OK";
    }
    
    

}
