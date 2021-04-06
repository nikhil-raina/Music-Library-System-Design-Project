package Model;

import ObjectModules.*;

import java.text.ParseException;

// Command Pattern: Concrete Command
public class ActionRateMedia implements Request {

    private String query;
    private MediaCollection collection;
    private float previousRating;

    public ActionRateMedia(String query, MediaCollection collection) {
        this.query = query;
        this.collection = collection;
    }

    @Override
    public Response performRequest() throws ParseException {
        Library library = this.collection.getLibrary();
        String req = query.substring((query.indexOf(";") + 1));
        String name = req.substring(0, (req.indexOf(";")));
        float rating = Float.parseFloat(req.substring(req.indexOf(";") + 1));
        boolean didRate = false;

        for (LibraryElement s : library.getElements()) {
            if (s.getTitle().equals(name)) {
                didRate = true;
                this.previousRating = s.getRating();
                s.setRating(rating);
            }
        }
        if (didRate)
            return new Response("Media rated!");
        else
            return new Response("Sorry, media not in the Grouping...");
    }

    @Override
    public Response undo() throws ParseException {

        String[] arr=query.split(";");
        arr[arr.length-1] = Float.toString(previousRating);
        String result="";
        for (int i =0;i<arr.length;i++){
            result=result+arr[i]+";";
        }
        if(result.endsWith(";")){
            result=result.substring(0,result.length()-1);
        }

        query = result;
        return this.performRequest();
    }

    @Override
    public Response redo() throws ParseException {
        return this.undo();
    }
}