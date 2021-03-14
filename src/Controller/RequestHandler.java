package Controller;

import Model.*;
import ObjectModules.Response;
import ObjectModules.mediaCollection;

public class RequestHandler {

    public Response handleRequest(String commandRequest,  mediaCollection collection ) {

        String commandCode = commandRequest.substring(0, commandRequest.indexOf(";"));
        String query = commandRequest.substring(commandRequest.indexOf(";") + 1);
        Request request = null;

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
        }
        return request.performRequest();
    }
}
