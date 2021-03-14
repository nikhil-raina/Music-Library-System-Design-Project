package Model;

// Command Pattern: Command
public interface Request {
    public void performRequest();
    public void performRequest(String mediaType, String media);
}
