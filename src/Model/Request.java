package Model;

// Command Pattern: Command
public interface Request {
    public void performRequest();
    public Response performRequest(String mediaType, String mediaName, String collectionName);
    public Response performRequest(String mediaType, String mediaName);
    public Response performRequest(String media);
}
