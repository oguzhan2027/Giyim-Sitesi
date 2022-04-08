/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;


import dao.KategoriDAO;
import entity.Kategori;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author tr
 */
@FacesConverter("kategoriConverter")
public class KategoriConverter implements Converter {

    private KategoriDAO kategoriDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Kategori k = this.getKategoriDao().findByID(id);
        return k;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Kategori k = (Kategori) t;
        return String.valueOf(k.getId());
    }

    public KategoriDAO getKategoriDao() {
        if (kategoriDao == null) {
            this.kategoriDao = new KategoriDAO();
        }
        return kategoriDao;
    }

    public void sekategoriDao(KategoriDAO kategoriDao) {
        this.kategoriDao = kategoriDao;
    }

}
