package test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class LuisGetRequest {

    public static void main(String[] args) {

        HttpClient httpClient = HttpClients.createDefault();
        try {
            String region = "westus";
            String apiId = "df67dcdb-c37d-46af-88e1-8b97951ca1c2";
            String endpointKey = "74ec184f0a4c42c6a9b3936ca1537e64";
            String userUtterance = "turn on the bedroom light";
            URIBuilder endpointURIBuilder = new URIBuilder("https://" + region + ".api.cognitive.microsoft.com/luis/v2.0/apps/" + apiId);
            endpointURIBuilder.setParameter("q", userUtterance);
            URI endpointURL = endpointURIBuilder.build();
            HttpGet request = new HttpGet(endpointURL);
            request.setHeader("Ocp-Apim-Subscription-Key", endpointKey);
            HttpResponse response = httpClient.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity == null) {
                System.out.println("ENTITY == NULL");
            } else {
                System.out.printf("ENTITY ---> \n%s", EntityUtils.toString(entity));
            }
        } catch (URISyntaxException | IOException ex) {
            ex.printStackTrace();
        }

    }

}
