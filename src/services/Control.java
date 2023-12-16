package services;

import dto.User;

public class Control {

    private User session = null;

    public Control() {
        super();
        //
    }

    public User getSessionUser() {
        return session;
    }

    public void setSessionUser(User sessionUser) {
        this.session = sessionUser;
    }
}
