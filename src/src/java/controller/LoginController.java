package controller;

import entity.UserManager;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;

@Named(value = "lc")
@SessionScoped
public class LoginController implements Serializable {

    private UserManager user;

    public LoginController() {
    }

    public void login() {

        if (user.getUsername().equals("test") && user.getPassword().equals("123")) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", user);
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanıcı adı veya şifre hatalı girilmiştir!!!"));
        }
    }

    public UserManager getUser() {
        if (user == null) {
            user = new UserManager();
        }
        return user;
    }

    public void setUser(UserManager user) {
        this.user = user;
    }

}
