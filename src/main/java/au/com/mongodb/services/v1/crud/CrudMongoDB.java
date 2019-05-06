package au.com.mongodb.services.v1.crud;

import au.com.mongodb.business.EventBusiness;
import au.com.mongodb.enums.EventSearchField;
import au.com.mongodb.model.EventModel;
import au.com.mongodb.services.v1.validations.CrudMongoDbValidations;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/crudMongoDB")
@Consumes(MediaType.APPLICATION_JSON)
@Produces({MediaType.TEXT_HTML, MediaType.APPLICATION_JSON})
public class CrudMongoDB {

    @PUT
    @Path("insert")
    public Response insertRecord(final EventModel event) {
        Response response = simpleCRUDEventValidations(event);
        if (response == null) {
            final EventBusiness business = new EventBusiness();
            response = business.persistSingleEvent(event, true);
        }
        return response;
    }


    @PATCH
    @Path("update")
    public Response updateRecord(final EventModel event) {
        Response response = simpleCRUDEventValidations(event);
        if (response == null) {
            final EventBusiness business = new EventBusiness();
            response = business.persistSingleEvent(event, false);
        }
        return response;
    }


    @DELETE
    @Path("delete/{id}")
    public Response deleteRecord(@PathParam("id") final String id) {
        final CrudMongoDbValidations validations = new CrudMongoDbValidations();
        final Response response;
        if (validations.validateMandatoryString(id)) {
            final EventBusiness business = new EventBusiness();
            response = business.deleteSingleEvent(id);
        } else {
            response = EventBusiness.badRequest();
        }
        return response;
    }


    @GET
    @Path("search")
    public Response searchRecord(@QueryParam("value") final String value, @QueryParam("byField") final String byField) {
        final CrudMongoDbValidations validations = new CrudMongoDbValidations();
        final Response response;
        final EventSearchField searchField = validations.getSearchFieldEnum(byField);
        if (validations.validateMandatoryString(value) &&  searchField != null) {
            final EventBusiness business = new EventBusiness();
            response = business.searchForEvents(value, searchField);
        } else {
            response = EventBusiness.badRequest();
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
            response = EventBusiness.badRequest();
        }
        return response;
    }
}
