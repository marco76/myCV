package ch.javaee.mycv.model;

import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.io.Serializable;

import static ch.javaee.mycv.model.ApplicationConstants.DB_APP_DATA;
import static ch.javaee.mycv.model.ApplicationConstants.DB_CV;

/**
 * Created by marco on 15/03/16.
 */
@ApplicationScoped
public class ApplicationData implements Serializable{

    @Inject
    MongoClientProvider mongoClientProvider;


    private String serverInstance;
    private String serverUrl;



    @PostConstruct
    public void initializeData() {

        serverInstance = getAppReferenceFromDB("server_instance");
        if (serverInstance == null) {
            serverInstance = "dev";
        }

        serverUrl = getAppReferenceFromDB("server_url");
        if (serverUrl == null) {
            serverUrl = "http://localhost:8080";
        }
    }

    public String getServerInstance() {
        return serverInstance;
    }

    public String getServerUrl() {
        return serverUrl;
    }

    private String getAppReferenceFromDB(String type){
        MongoDatabase database = mongoClientProvider.getMongoClient().getDatabase(DB_CV);
        Document result = database.getCollection(DB_APP_DATA).find(new Document("type",type)).first();
        String value =result.get("value").toString();
        return value;
    }
}
