package au.com.mongodb.test.persistence;

import au.com.mongodb.test.enums.EvenSearchField;
import au.com.mongodb.test.model.EventModel;
import au.com.mongodb.test.model.SystemMetadataModel;
import au.com.mongodb.test.HelperTest;
import au.com.mongodb.test.persistence.entities.Event;
import au.com.mongodb.test.persistence.entities.SystemMetadata;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

import static junit.framework.TestCase.assertNull;
import static org.junit.Assert.*;

public class NoSQLCRUDMasterTest {

    private Event event;
    private SystemMetadata systemMetadata;
    private NoSQLCRUDMaster crud;


    @Before
    public void startup() throws Exception {
        boolean isRunning = HelperTest.checkifMongoIsRunning();
        if (isRunning) {
            systemMetadata = new SystemMetadata();
            systemMetadata.setCreateBy("Test");
            systemMetadata.setCreatedDate(LocalDateTime.now().atZone(ZoneId.systemDefault()).toString());

            event = new Event();
            event.setAccountId("accountID");
            event.setAccountNumber("accountNumber");
            event.setBenefitReason("benefitReason");
            event.setContribuitionType("contribuitionType");
            event.setScheme("scheme");
            event.setSchemeMembershipNumber("schemeMembershipNumber");
            event.setDescription("Testing " + UUID.randomUUID());
            event.setTotalAmount(100200.00D);
            event.setMedatadata(systemMetadata);
        } else {
            throw new Exception("Local MongoDB not Running");
        }

        crud = new NoSQLCRUDMaster();
    }


    @After
    public void cleanup() {
        event = null;
        systemMetadata = null;
        crud = null;
    }



    @Test
    public void testSuccessSaveThenDelete() {
        Event saved = crud.saveData(event);
        assertNotNull(saved);

        List<Event> search = crud.search(EvenSearchField.ACCOUNT_ID, "accountID");
        assertNotNull(search);
        assertTrue(search.size() > 0);

        Event fromSearch = search.get(0);
        assertEquals(fromSearch, saved);

        crud.delete(saved);
    }


    @Test
    public void testSuccessSaveUpdateThenDelete() {
        Event saved = crud.saveData(event);
        assertNotNull(saved);

        List<Event> search = crud.search(EvenSearchField.ACCOUNT_ID, "accountID");
        assertNotNull(search);
        assertTrue(search.size() > 0);

        Event fromSearch = search.get(0);
        assertEquals(fromSearch, saved);

        fromSearch.setAccountId("UpdatedAccountId");
        Event update = crud.mergeData(fromSearch);

        search = crud.search(EvenSearchField.ACCOUNT_ID, "UpdatedAccountId");
        assertNotNull(search);
        assertTrue(search.size() > 0);

        fromSearch = search.get(0);
        assertEquals(fromSearch, update);

        crud.delete(update);
    }


}
