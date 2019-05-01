package au.com.mongodb.test;

import au.com.mongodb.test.model.EventModel;
import au.com.mongodb.test.model.SystemMetadataModel;
import au.com.mongodb.test.persistence.entities.Event;
import au.com.mongodb.test.persistence.entities.SystemMetadata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.UUID;

public class HelperTest {

    public static boolean checkifMongoIsRunning() {
        boolean toReturn = false;
        BufferedReader input = null;
        try {
            String line;
            final ProcessBuilder pb = new ProcessBuilder("/bin/bash", "-c", "pgrep mongod");
            pb.redirectErrorStream(true);
            final Process p = pb.start();
            final InputStreamReader isr = new InputStreamReader(p.getInputStream());
            input = new BufferedReader(isr);
            while ((line = input.readLine()) != null) {
                if (line != null)
                    toReturn = true;
                    break;
            }
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return toReturn;
    }


    public Event getEventEntityForTest() {
        SystemMetadata systemMetadata = new SystemMetadata();
        systemMetadata.setCreateBy("Test");
        systemMetadata.setCreatedDate(LocalDateTime.now().atZone(ZoneId.systemDefault()).toString());

        Event event = new Event();
        event.set_id("1000");
        event.setAccountId("accountID");
        event.setAccountNumber("accountNumber");
        event.setBenefitReason("benefitReason");
        event.setContribuitionType("contribuitionType");
        event.setScheme("scheme");
        event.setSchemeMembershipNumber("schemeMembershipNumber");
        event.setDescription("Testing " + UUID.randomUUID());
        event.setTotalAmount(100200.00D);
        event.setMedatadata(systemMetadata);
        return event;
    }


    public EventModel getEventModelForTest() {
        SystemMetadataModel systemMetadata = new SystemMetadataModel();
        systemMetadata.setCreateBy("Test");
        systemMetadata.setCreatedDate(LocalDateTime.now().atZone(ZoneId.systemDefault()).toString());

        EventModel event = new EventModel();
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
        return event;
    }
}
