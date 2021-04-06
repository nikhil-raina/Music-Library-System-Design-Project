package ObjectModules;

import Model.Grouping;
import Model.WebService;
import Model.db;

public class MediaCollection {

    private Library library;
    private db db;

    public MediaCollection(Library library, Grouping db) {
        this.library = library;
        this.db = db;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void setDb(Grouping db) {
        this.db = db;
    }

    public db getDb() {
        return db;
    }

    public Library getLibrary() {
        return library;
    }
    public void setOnline(){
        this.db =  WebService.getInstance();
    }

}
