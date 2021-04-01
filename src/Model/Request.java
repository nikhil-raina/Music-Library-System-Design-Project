package Model;

import ObjectModules.Response;

import java.text.ParseException;

// Command Pattern: Command
public interface Request {

    // The action that will be performed by the concrete Classes
    public Response performRequest() throws ParseException;

    public Response undo() throws ParseException;
}
