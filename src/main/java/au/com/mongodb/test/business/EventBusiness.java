package au.com.mongodb.test.business;

import au.com.mongodb.test.mapper.EventMapper;
import au.com.mongodb.test.model.ErrorMessage;
import au.com.mongodb.test.model.EventModel;
import au.com.mongodb.test.persistence.NoSQLCRUDMaster;
import au.com.mongodb.test.persistence.entities.Event;

import javax.ws.rs.core.Response;

public class EventBusiness {


    public Response mapAndPersistSingleEvent(final EventModel model, final boolean isSave) {
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
            final ErrorMessage errorMessage = new ErrorMessage(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                    Response.Status.INTERNAL_SERVER_ERROR.getReasonPhrase());
            response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage.toJSON()).build();
        }
        return response;
    }


}
