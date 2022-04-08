/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;


import dao.MusteriHizmetDAO;
import entity.MusteriHizmet;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author tr
 */
@FacesConverter("musteriHizmetConverter")
public class MusteriHizmetConverter implements Converter {

    private MusteriHizmetDAO musteriHizmetDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        MusteriHizmet m = this.getMusteriHizmetDao().findByID(id);
        return m;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        MusteriHizmet m = (MusteriHizmet) t;
        return String.valueOf(m.getId());
    }

    public MusteriHizmetDAO getMusteriHizmetDao() {
        if (musteriHizmetDao == null) {
            this.musteriHizmetDao = new MusteriHizmetDAO();
        }
        return musteriHizmetDao;
    }

    public void setmusteriHizmetDao(MusteriHizmetDAO musteriHizmetDao) {
        this.musteriHizmetDao = musteriHizmetDao;
    }

}
