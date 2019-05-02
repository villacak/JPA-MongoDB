package au.com.mongodb.test.business;

import au.com.mongodb.test.enums.EventSearchField;
import au.com.mongodb.test.mapper.EventMapper;
import au.com.mongodb.test.model.ResponseMessage;
import au.com.mongodb.test.model.EventModel;
import au.com.mongodb.test.persistence.NoSQLCRUDMaster;
import au.com.mongodb.test.persistence.entities.Event;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.ws.rs.core.Response;
import java.util.List;

public class EventBusiness {


    public Response persistSingleEvent(final EventModel model, final boolean isSave) {
        Response response = null;
        try {
            final Event eventEntity = EventMapper.MAPPER.mapEventModelToEventEntity(model);

            final NoSQLCRUDMaster crud = new NoSQLCRUDMaster();
            final Event savedEventEntity;
            if (isSave) {
                savedEventEntity = crud.saveData(eventEntity);
            } else {
                savedEventEntity = crud.mergeData(eventEntity);
            }
            final EventModel modelToReturn = EventMapper.MAPPER.mapEventEntityToEventModel(savedEventEntity);
            response = Response.ok().entity(modelToReturn.toJSON()).build();
        } catch (Exception e) {
            response = serverError();
        }
        return response;
    }



    public Response deleteSingleEvent(final String id) {
        Response response = null;
        try {
            final ResponseMessage responseMessage;
            final NoSQLCRUDMaster crud = new NoSQLCRUDMaster();
            final List<Event> events = crud.search(EventSearchField.ID, id);
            if (events == null || events.size() == 0) {
                response = successWithMessage("Record not found for delete.");
            } else if (events.size() > 1) {
                response = successWithMessage("Duplicated ids.");
            } else {
                crud.delete(events.get(0));
                response = successWithMessage("Record deleted.");
            }
        } catch (Exception e) {
            response = serverError();
        }
        return response;
    }



    public Response searchForEvents(final String id, final EventSearchField field) {
        Response response = null;
        try {
            final NoSQLCRUDMaster crud = new NoSQLCRUDMaster();
            final List<Event> events = crud.search(field, id);
            if (events == null || events.size() == 0) {
                response = successWithMessage("Nothing found.");
            } else {
                final ObjectMapper mapper = new ObjectMapper();
                final String json = mapper.writeValueAsString(events);
                response = Response.ok().entity(json).build();
            }
        } catch (Exception e) {
            response = serverError();
        }
        return response;

    }



    public static Response badRequest() {
        final ResponseMessage responseMessage = new ResponseMessage(Response.Status.BAD_REQUEST.getStatusCode(),
                "Basic Validation Failed. Please check your payload.");
        final Response response = Response.status(Response.Status.BAD_REQUEST).entity(responseMessage.toJSON()).build();
        return response;
    }



    public static Response serverError() {
        final ResponseMessage responseMessage = new ResponseMessage(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
        final Response response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(responseMessage.toJSON()).build();
        return response;
    }



    public static Response successWithMessage(final String message) {
        final ResponseMessage responseMessage = new ResponseMessage(Response.Status.OK.getStatusCode(), message);
        final Response response = Response.ok().entity(responseMessage.toJSON()).build();
        return response;
    }

}
