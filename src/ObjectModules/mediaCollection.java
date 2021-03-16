package ObjectModules;

import Model.Database;

public class mediaCollection {

    private Library library;
    private Database db;

    public void setLibrary(Library library) {
        this.library = library;
    }

    public void setDb(Database db) {
        this.db = db;
    }

    public mediaCollection(Library library, Database db) {
        this.library = library;
        this.db = db;
    }

    public Database getDb() {
        return db;
    }

    public Library getLibrary() {
        return library;
    }

}
