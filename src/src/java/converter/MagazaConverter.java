/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;


import dao.MagazaDAO;
import entity.Magaza;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter("magazaConverter")
public class MagazaConverter implements Converter {

    private MagazaDAO magazaDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Magaza c = this.getMagazaDao().findByID(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Magaza c = (Magaza) t;
        return String.valueOf(c.getId());
    }

    public MagazaDAO getMagazaDao() {
        if (magazaDao == null) {
            this.magazaDao = new MagazaDAO();
        }
        return magazaDao;
    }

    public void setmagazaDao(MagazaDAO magazaDao) {
        this.magazaDao = magazaDao;
    }

   
}
