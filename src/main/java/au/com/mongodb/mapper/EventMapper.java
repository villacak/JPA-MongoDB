package au.com.mongodb.mapper;

import au.com.mongodb.model.EventModel;
import au.com.mongodb.persistence.entities.Event;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EventMapper {

    final EventMapper MAPPER = Mappers.getMapper(EventMapper.class);

    @Mappings({
            @Mapping(source = "primaryKey", target = "_id"),
            @Mapping(source = "accountID", target = "accountId"),
            @Mapping(source = "refNumber", target = "referenceNumber"),
            @Mapping(source = "accNumber", target = "accountNumber")
    })
    public Event mapEventModelToEventEntity(final EventModel model);


    @InheritInverseConfiguration
    public EventModel mapEventEntityToEventModel(final Event entity);
}
