package ObjectModules;

import Model.Database;

public class MediaCollection {

    private Library library;
    private Database db;

    public MediaCollection(Library library, Database db) {
        this.library = library;
        this.db = db;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public Database getDb() {
        return db;
    }

    public Library getLibrary() {
        return library;
    }

}
