package ObjectModules;

import Model.Grouping;

public class MediaCollection {

    private Library library;
    private Grouping db;

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

    public Grouping getDb() {
        return db;
    }

    public Library getLibrary() {
        return library;
    }

}
