package com.checklist.google.api;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.datastore.client.DatastoreOptions;

import java.io.File;
import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Created by Markiyan on 14.12.14.
 */
public class Authorization {

    public static GoogleCredential getCredentials() throws GeneralSecurityException, IOException {
        HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
        JsonFactory JSON_FACTORY = new JacksonFactory();
        GoogleCredential credentials = new GoogleCredential.Builder()
                .setTransport(HTTP_TRANSPORT)
                .setJsonFactory(JSON_FACTORY)
//                .setServiceAccountId("4Umarik@gmail.com")
                .setServiceAccountId("1075234860567-f84mtohshvi4o1qmjceqfdj5st15htgt@developer.gserviceaccount.com")
//                .setServiceAccountId("1075234860567-compute@developer.gserviceaccount.com")
                .setServiceAccountPrivateKeyFromP12File(new File("C:\\Users\\Markiyan\\IdeaProjects\\CheckList\\src\\main\\resources\\certificates\\Checklist-20dffa3d12f6.p12"))
                .setServiceAccountScopes(DatastoreOptions.SCOPES)
//                .setServiceAccountUser("4umarik@gmail.com")
                .build();
        credentials.refreshToken();
        return credentials;
    }
}
