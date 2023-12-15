package services;

import dto.User;

public class Control {

    private User sesion = null;

    public Control() {
        super();
        //
    }

    public User getSessionUser() {
        return sesion;
    }

    public void setSessionUser(User sessionUser) {
        this.sesion = sessionUser;
    }
}
