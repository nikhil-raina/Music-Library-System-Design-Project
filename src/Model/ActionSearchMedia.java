package Model;

import ObjectModules.Response;

// Command Pattern: Concrete Command
public class ActionSearchMedia implements Request{
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
