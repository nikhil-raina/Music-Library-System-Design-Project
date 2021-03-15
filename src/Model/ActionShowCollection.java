package Model;

import ObjectModules.Library;
import ObjectModules.Response;

// Command Pattern: Concrete Command
public class ActionShowCollection implements Request{

    private String query;
    private Library library;
    private Database db;

    public ActionShowCollection(String query, Library library, Database db) {
        this.query = query;
        this.library = library;
        this.db = db;
    }

    @Override
    public Response performRequest() {
        return this.library.display();
    }
}
