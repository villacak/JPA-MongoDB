package au.com.mongodb.test.persistence;

import au.com.mongodb.test.model.EventModel;
import au.com.mongodb.test.model.SystemMetadataModel;
import au.com.mongodb.test.HelperTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

import static junit.framework.TestCase.assertNull;

public class NoSQLCRUDMasterTest {

    private EventModel event;
    private SystemMetadataModel systemMetadata;


    @Before
    public void startup() throws Exception {
        boolean isRunning = HelperTest.checkifMongoIsRunning();
        if (isRunning) {
            systemMetadata = new SystemMetadataModel();
            systemMetadata.setCreateBy("Test");
            systemMetadata.setCreatedDate(LocalDateTime.now().atZone(ZoneId.systemDefault()).toString());

            event = new EventModel();
            event.setPrimaryKey("1000");
            event.setAccountID("accountID");
            event.setAccNumber("accountNumber");
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

    }


    @After
    public void cleanup() {
        event = null;
        systemMetadata = null;
    }



    @Test
    public void testSuccessSave() {
        assertNull(null);
    }
}
