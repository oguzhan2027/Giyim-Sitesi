/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.UrunlerDAO;
import entity.Urunler;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter("urunlerConverter")
public class UrunlerConverter implements Converter{

    private UrunlerDAO urunlerDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Urunler u = this.getUrunlerDao().findByID(id);
        return u;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Urunler u = (Urunler) t;
        return String.valueOf(u.getId());
    }

    public UrunlerDAO getUrunlerDao() {
        if (urunlerDao == null) {
            this.urunlerDao = new UrunlerDAO();
        }
        return urunlerDao;
    }

    public void setUrunlerDao(UrunlerDAO urunlerDao) {
        this.urunlerDao = urunlerDao;
    }

}
