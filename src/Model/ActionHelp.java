package Model;

public class ActionHelp implements Request{
    @Override
    public void performRequest() {
        System.out.println("Reached");
    }

    @Override
    public void performRequest(String mediaType, String media) {

    }


}
