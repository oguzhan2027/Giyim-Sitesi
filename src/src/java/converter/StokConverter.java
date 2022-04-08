/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;


import dao.StokDAO;
import entity.Stok;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author tr
 */
@FacesConverter("stokConverter")
public class StokConverter implements Converter {

    private StokDAO stokDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Stok s= this.getStokDao().findByID(id);
        return s;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Stok s = (Stok) t;
        return String.valueOf(s.getId());
    }

    public StokDAO getStokDao() {
        if (stokDao == null) {
            this.stokDao = new StokDAO();
        }
        return stokDao;
    }

    public void setstokDao(StokDAO stokDao) {
        this.stokDao = stokDao;
    }

}
