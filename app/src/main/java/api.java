import java.io.FileReader;

import org.apache.http.cookie.SM;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class API {
    public int devId;
    public String authKey;
    public String sessionId;
    public static final String SMITE_URL = "http://api.smitegame.com/smiteapi.svc";

    @SuppressWarnings("unchecked")
    public API () {
        JSONParser parser = new JSONParser();

        /*
        Reads in the developer information to connect to the SMITE API
        To mimick this, create a file called "smite_dev_key.json" under the src/main/resources folder
        in the file, insert the following:
        {
            "devId": xxxx,
            "authKey": "xxxxxxxx..."
        }
        */
        try {
            Object obj = parser.parse(new FileReader("../resources/smite_dev_key.json"));

            JSONObject jsonObject = (JSONObject) obj;

            this.devId = (int) jsonObject.get("devId");
            this.authKey = (String) jsonObject.get("authKey");

        } catch (Exception e) {
            e.printStackTrace();
        }

        //Creates a Session with your Dev Info
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JsonNode apiPost()
    {
        HttpResponse <JsonNode> httpResponse = Unirest.post(SMITE_URL)
            .header("name", "value")
            .queryString("name", "value")
            .field("name", "value")
            .field("name", "value")
            .asJson();

        return httpResponse.getBody();
    }

    public JsonNode apiGet()
    {
        HttpResponse <JsonNode> httpResponse = Unirest.get(SMITE_URL)
            .header("name", "value")
            .queryString("name", "value")
            .asJson();

        return httpResponse.getBody();
    }

}