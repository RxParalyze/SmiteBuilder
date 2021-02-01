import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class API {
    public int devId;
    public String authKey;

    @SuppressWarnings("unchecked")
    public API () {
        JSONParser parser = new JSONParser();

        try {
            Object obj = parser.parse(new FileReader("../resources/smite_dev_key.json"));

            JSONObject jsonObject = (JSONObject) obj;

            this.devId = (int) jsonObject.get("devId");
            this.authKey = (String) jsonObject.get("authKey");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public JsonNode apiPost()
    {
        HttpResponse <JsonNode> httpResponse = Unirest.post("")
            .header("name", "value")
            .queryString("name", "value")
            .field("name", "value")
            .field("name", "value")
            .asJson();

        return httpResponse.getBody();
    }

    public JsonNode apiGet()
    {
        HttpResponse <JsonNode> httpResponse = Unirest.get("")
            .header("name", "value")
            .queryString("name", "value")
            .asJson();

        return httpResponse.getBody();
    }

}