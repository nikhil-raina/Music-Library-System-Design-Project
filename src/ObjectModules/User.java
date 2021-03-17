package ObjectModules;

import Model.Grouping;
import Model.Request;

public class User {
    public int ID;
    public String userName;
    public Request request;
    private MediaCollection collection;

    // new user
    public User(int ID, String userName) {
        this.ID = ID;
        this.userName = userName;
        this.collection = new MediaCollection(new Library(), new Grouping());
    }

    // old user
    public User(int ID, String userName, Library library) {
        this.ID = ID;
        this.userName = userName;
    }

    public MediaCollection getCollection() {
        return collection;
    }

    public String getUserName(){
        return userName;
    }

    public int getUserID(){
        return ID;
    }

    public Library getLibrary() {
        return getCollection().getLibrary();
    }

    public Grouping getDb() {
        return getCollection().getDb();
    }
}
