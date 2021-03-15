package Controller;

import Model.*;
import ObjectModules.Library;
import ObjectModules.Response;

import java.text.ParseException;

public class RequestHandler {
    public Library library;
    public Database db;

    public RequestHandler(Library library, Database db) {
        this.library = library;
        this.db = db;
    }

    public Response handleRequest(String commandRequest) throws ParseException {
        String commandCode = commandRequest.substring(0, commandRequest.indexOf(";"));
        String query = commandRequest.substring(commandRequest.indexOf(";") + 1);
        Request request = null;

        switch (commandCode){
            case "add":
                request = new ActionAddMedia(query, library, db);
                break;
            case "remove":
                request = new ActionRemoveMedia(query, library, db);
                break;
            case "rate":
                request = new ActionRateMedia(query, library, db);
                break;
            case "create":
                request = new ActionCreateCollection(query, library, db);
                break;
            case "search":
                request = new ActionSearchMedia(query, library, db);
                break;
            case "show" :
                request = new ActionShowCollection(query, library, db);
        }

        assert request != null;
        return request.performRequest();
    }
}
