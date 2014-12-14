package com.checklist.test;

import com.checklist.google.api.Utils;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.core.MediaType;
import java.util.Arrays;

/**
 * Created by Markiyan on 14.12.14.
 */
public class GoogleAPITest {

    @Test
    public void connectionTest() throws JSONException {
        ClientConfig clientConfig = new DefaultClientConfig();
        clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
        Client client = Client.create(clientConfig);

        WebResource webResource = client
                .resource(Utils.API_ENDPOINT);

        JSONObject object = new JSONObject();
        object.put("registration_ids", Arrays.asList(new String[] {"20s"}));

        ClientResponse response = webResource.accept(MediaType.APPLICATION_JSON)
                .header("Content-Type", MediaType.APPLICATION_JSON)
                .header("Authorization", Utils.API_AUTHORIZATION_KEY)
                .type(MediaType.APPLICATION_JSON).post(ClientResponse.class, object.toString());

        Assert.assertEquals(response.getStatus(), 200);
    }
}
