package Model;

// Command Pattern: Concrete Command
public class ActionSearchMedia implements Request{
    @Override
    public void performRequest() {

    }

    @Override
    public Response performRequest(String mediaType, String media) {
        return null;
    }

    @Override
    public Response performRequest(String media) {
        return null;
    }


}
