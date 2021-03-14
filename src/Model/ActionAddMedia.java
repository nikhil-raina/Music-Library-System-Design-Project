package Model;

// Command Pattern: Concrete Command
public class ActionAddMedia implements Request{
    @Override
    public void performRequest() {

    }

    @Override
    public Response performRequest(String mediaType, String mediaName, String collectionName) {
        return null;
    }

    @Override
    public Response performRequest(String mediaType, String mediaName) {
        return null;
    }

    @Override
    public Response performRequest(String media) {
        return null;
    }

}
