package au.com.mongodb.test.services.v1.crud;

import au.com.mongodb.test.business.EventBusiness;
import au.com.mongodb.test.model.ErrorMessage;
import au.com.mongodb.test.model.EventModel;
import au.com.mongodb.test.services.v1.validations.CrudMongoDbValidations;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/v1/crudMongoDB")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
public class CrudMongoDB {

    @PUT
    @Path("insertRecord")
    public Response insertRecord(final EventModel event) {
        Response response = simpleCRUDEventValidations(event);
        if (response == null) {
            final EventBusiness business = new EventBusiness();
            response = business.mapAndPersistSingleEvent(event, true);
        }
        return response;
    }


    @PATCH
    @Path("updateRecord")
    public Response updateRecord(final EventModel event) {
        Response response = simpleCRUDEventValidations(event);
        if (response == null) {
            final EventBusiness business = new EventBusiness();
            response = business.mapAndPersistSingleEvent(event, false);
        }
        return response;
    }


    private Response simpleCRUDEventValidations(final EventModel model) {
        final CrudMongoDbValidations validations = new CrudMongoDbValidations();
        final boolean isValid = validations.validateEventModelInsert(model);
        final Response response;
        if (isValid) {
            response = null;
        } else {
            final ErrorMessage errorMessage = new ErrorMessage(Response.Status.BAD_REQUEST.getStatusCode(),
                                                        "Basic Validation Failed. Please check your payload.");
            response = Response.status(Response.Status.BAD_REQUEST).entity(errorMessage.toJSON()).build();
        }
        return response;
    }

}
