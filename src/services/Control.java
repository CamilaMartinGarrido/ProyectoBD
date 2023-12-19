package services;

import dto.User;

public class Control {

    private User session = null;
    private static Control instance;


    private Control() {}

    public static Control getInstance() {
        if (instance == null) {
            instance = new Control();
        }
        return instance;
    }

    public User getSessionUser() {
        return session;
    }

    public void setSessionUser(User sessionUser) {
        this.session = sessionUser;
    }
}
