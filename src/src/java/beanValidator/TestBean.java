package beanValidator;

import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import java.io.Serializable;

@Named(value = "testBean")
@SessionScoped
public class TestBean implements Serializable {

   

    public TestBean() {
    }

    public boolean validatePassword(FacesContext context, UIComponent cmp, Object value) throws ValidatorException {
        String v = (String) value;
        if (v.isEmpty()) {
            throw new ValidatorException(new FacesMessage("şifre alanı boş olamaz!"));

        } else if (v.length() < 3) {
            throw new ValidatorException(new FacesMessage("şifre alanı 3 karakterden kısa olamaz!"));
        }
        return true;
    }

  

}

