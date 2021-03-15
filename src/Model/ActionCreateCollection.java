package Model;

import ObjectModules.Library;
import ObjectModules.Response;

// Command Pattern: Concrete Command
public class ActionCreateCollection implements Request {

    private String query;
    private Library library;

    public ActionCreateCollection(String query, Library library, Database db) {
        this.query = query;
        this.library = library;
    }

    @Override
    public Response performRequest() {

        return null;
    }

}
