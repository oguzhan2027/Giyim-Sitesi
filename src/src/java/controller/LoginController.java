package controller;

import entity.UserManager;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import util.DBConnection;

@Named(value = "lc")
@SessionScoped
public class LoginController extends DBConnection implements Serializable {

    private UserManager user;

    public LoginController() {
    }

    public void login() {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from yetkili";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                if (user.getUsername().equals(rs.getString("ad")) && user.getPassword().equals(rs.getString("sifre"))) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("validUser", user);

                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Kullanıcı adı ve şifre hatalı girilmiştir!!!"));

                }
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

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
