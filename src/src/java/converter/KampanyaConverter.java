/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.KampanyaDAO;
import entity.Kampanya;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author user
 */
@FacesConverter("kampanyaConverter")
public class KampanyaConverter implements Converter {

    private KampanyaDAO kampanyaDao;

    public KampanyaDAO getKampanyaDao() {
        if (kampanyaDao == null) {
            this.kampanyaDao = new KampanyaDAO();
        }
        return kampanyaDao;
    }

    public void setKampanyaDao(KampanyaDAO kampanyaDao) {
        this.kampanyaDao = kampanyaDao;
    }

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Kampanya k = this.getKampanyaDao().findByID(id);
        return k;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Kampanya k = (Kampanya) t;
        return String.valueOf(k.getId());
    }

}
