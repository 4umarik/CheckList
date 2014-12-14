package com.checklist.example;

//import com.sun.jersey.api.client.ClientRequest;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.representation.Form;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Markiyan on 07.12.14.
 */
// The Java class will be hosted at the URI path "/helloworld"
@Path("/helloworld")
public class HelloWorld {
    // The Java method will process HTTP GET requests
    @GET
    // The Java method will produce content identified by the MIME Media type "text/plain"
    @Produces(MediaType.TEXT_PLAIN)
    public String getQ() {
        return "Hello World:";
    }

    public static void main(String[] args) throws Exception {
        Client client = Client.create();

        WebResource webResource = client
                .resource("https://android.googleapis.com/gcm/send");

        Form form = new Form();
        form.add("registration_id", "20");

        ClientResponse response = webResource.accept("text/plain").header("Content-Type", "application/json")
                .header("Authorization", "key=AIzaSyDlo8O89rmTLgbhuxjHPC_HXByqoZZLYJ8")
                .type(MediaType.APPLICATION_JSON).post(ClientResponse.class, form);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);

        System.out.println("Output from Server .... \n");
        System.out.println(output);
    }
}
