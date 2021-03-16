package ObjectModules;

import java.util.List;

// Wrapper for the string to be shown to the user
public class Response {

    private String response;

    public Response() {
        this.response = "";
    }

    public Response(String message) {
        this.response = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void makeResponse(List<LibraryElement> media) {
        if (media == null) {
            setResponse("Artist have not been implemented due to lack of data");
        } else if (media.size() == 0) {
            setResponse("No media in the library");
            return;
        }
        StringBuilder response = new StringBuilder("Result...\n");
        assert media != null;
        for (LibraryElement e: media) {
            response.append(e.toString()).append("\n");
        }
        setResponse(response.toString());
    }
}
