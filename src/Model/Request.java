package Model;

// Command Pattern: Command
public interface Request {
    public void performRequest();
    public Response performRequest(String mediaType, String media);
    public Response performRequest(String media);
}
