package ObjectModules;

import Model.Database;
import Model.Request;

public class User {
    public int ID;
    public String userName;
    public Request request;
    private Library library;
    private Database db;


    public User(int ID, String userName) {
        this.ID = ID;
        this.userName = userName;
        this.library = new Library();
        this.db = new Database();
    }

    public User(int ID, String userName, Library library) {
        this.ID = ID;
        this.userName = userName;
        this.library = library;
    }

    public String getUserName(){
        return userName;
    }

    public int getUserID(){
        return ID;
    }

    public Library getLibrary() {
        return library;
    }

    public Database getDb() {
        return db;
    }
}
