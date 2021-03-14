package ObjectModules;

import java.util.ArrayList;

public class Response {

    private final String response;

    public Response(String message) {
        this.response = message;
    }

    public String getResponse() {
        return response;
    }

    public String getResponse(ArrayList<Media> media) {
        return "";
    }
}
