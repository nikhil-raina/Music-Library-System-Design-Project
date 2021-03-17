package ObjectModules;

public class User {
    public int ID;
    public String userName;
    public Library library;

    // new user
    public User(int ID, String userName) {
        this.ID = ID;
        this.userName = userName;
        this.library = new Library();
    }

    // old user
    public User(double ID, String userName, Library library) {
        this.ID = (int) ID;
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
        return this.library;
    }
}
