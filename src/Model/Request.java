package Model;

import ObjectModules.Response;

// Command Pattern: Command
public interface Request {

    // The action that will be performed by the concrete Classes
    public Response performRequest();
}
