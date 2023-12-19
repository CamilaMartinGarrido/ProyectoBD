package services;
import dto.User;

public class Control {
    //Attributes
    private User session = null;
    private static Control instance;

    //Empty Constructor
    private Control() {}

    //Singleton
    public static Control getInstance() {
        if (instance == null) {
            instance = new Control();
        }
        return instance;
    }

    //Get and Set og Singleton
    public User getSessionUser() {
        return session;
    }
    public void setSessionUser(User sessionUser) {
        this.session = sessionUser;
    }
}
