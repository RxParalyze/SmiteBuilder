import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;

public class api {

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