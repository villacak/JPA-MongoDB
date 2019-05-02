package au.com.mongodb.test.mapper;

import au.com.mongodb.test.HelperTest;
import au.com.mongodb.test.model.EventModel;
import au.com.mongodb.test.model.SystemMetadataModel;
import au.com.mongodb.test.persistence.entities.Event;
import au.com.mongodb.test.persistence.entities.SystemMetadata;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import static org.junit.Assert.*;

public class EventMapperTest {


    private Event event;
    private SystemMetadataModel systemMetadataModel;
    private EventModel model;
    private SystemMetadata systemMetadata;
    private HelperTest helperTest;


    @Before
    public void startup() {
        helperTest = new HelperTest();
    }


    @After
    public void cleanup() {
        event = null;
        systemMetadata = null;
        model = null;
        systemMetadataModel = null;
        helperTest = null;
    }


    @Test
    public void mapFromEntityToModelTest() {
        event = helperTest.getEventEntityForTest();
        assertNotNull(event);
        assertNull(model);

        model = EventMapper.MAPPER.mapEventEntityToEventModel(event);
        assertEquals(model.getPrimaryKey(), event.get_id());
        assertEquals(model.getAccNumber(), event.getAccountNumber());
        assertEquals(model.getAccountID(), event.getAccountId());
        assertTrue(model.getTotalAmount() == event.getTotalAmount());
    }

    @Test
    public void mapFromModelToEntityTest() {
        model = helperTest.getEventModelForTest();
        assertNotNull(model);
        assertNull(event);

        event = EventMapper.MAPPER.mapEventModelToEventEntity(model);
        assertEquals(event.get_id(), model.getPrimaryKey());
        assertEquals(event.getAccountNumber(), model.getAccNumber());
        assertEquals(event.getAccountId(), model.getAccountID());
        assertTrue(event.getTotalAmount() == model.getTotalAmount());
    }
}
