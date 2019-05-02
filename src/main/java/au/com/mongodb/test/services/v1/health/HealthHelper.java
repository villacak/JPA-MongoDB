package au.com.mongodb.test.services.v1.health;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class HealthHelper {

    /**
     * Check if the MongoDB is up and running, when running local.
     * IF MongoDB is running in a separate server/ Instance/ VM then this
     * service will not work and the application will fail to start.
     *
     * @return
     */
    public boolean checkifMongoIsRunning() {
        MongoClient client = null;
        boolean toReturn = false;
        try {
            client = new MongoClient("localhost", 27017);
            final MongoDatabase mongoDB = client.getDatabase("jpaNoSQLTestDB");
            final Document ping = new Document("ping", "1");
            final Document serverStatus = mongoDB.runCommand(ping);
            System.out.println(serverStatus.toJson());
            toReturn = true;
        } catch (Exception err) {
            err.printStackTrace();
        } finally {
            client.close();
            client = null;
        }
        return toReturn;
    }
}
