package ObjectModules;

import Model.Database;

public class mediaCollection {

    private Database database;
    private Library library;

    public mediaCollection (Database database, Library library) {
        this.database = database;
        this.library = library;
    }

    public Database getDatabase() {
        return database;
    }

    public Library getLibrary() {
        return library;
    }
}
