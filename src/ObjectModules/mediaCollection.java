package ObjectModules;

public class mediaCollection {

    private Library library;
    private User user;

    public mediaCollection (User user) {
        this.user = user;
        this.library = new Library();
    }

    public Library getLibrary() {
        return library;
    }

    public User getUser() {
        return user;
    }
}
