package Controller;

import Model.*;
import ObjectModules.Library;
import ObjectModules.MediaCollection;
import ObjectModules.Response;

import java.text.ParseException;

public class RequestHandler {
    private MediaCollection collection;

    public RequestHandler(Library library, Grouping db) {
        collection = new MediaCollection(library, db);
    }

    UndoRedoManager x = new UndoRedoManager();

    public Response handleRequest(String commandRequest) throws ParseException {
        String commandCode = commandRequest.substring(0, commandRequest.indexOf(";"));
        String query = commandRequest.substring(commandRequest.indexOf(";") + 1);
        Request request;

        switch (commandCode){
            case "add":
                request = new ActionAddMedia(query, collection);
                break;
            case "remove":
                request = new ActionRemoveMedia(query, collection);
                break;
            case "rate":
                request = new ActionRateMedia(query, collection);
                break;
            case "create":
                request = new ActionCreateCollection(query, collection);
                break;
            case "search":
                request = new ActionSearchMedia(query, collection);
                break;
            case "show" :
                request = new ActionShowCollection(query, collection);
                break;
            case "help":
                request = new ActionHelp();
                break;

            //undo/redo
            case "undo" :
                return x.Undo();
            case "redo" :
                return x.Redo();
            default:
                return new Response("Command Error! Type 'help;' for more details.");
        }

        Response res = request.performRequest();
        if(res.getResponse().equals("Media added!") || res.getResponse().equals("Media removed!") || res.getResponse().equals("Media rated!")){
            x.pushToUndo(request);
        }
        return res;
    }
}
