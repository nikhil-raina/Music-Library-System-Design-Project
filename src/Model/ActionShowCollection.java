package Model;

import ObjectModules.Library;
import ObjectModules.Response;

// Command Pattern: Concrete Command
public class ActionShowCollection implements Request{

    private String query;
    private Library library;

    public ActionShowCollection(String query, Library library, Database db) {
        this.query = query;
        this.library = library;
    }

    @Override
    public Response performRequest() {
        this.library.display();
        return null;
    }
}
