/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package converter;

import dao.YoneticiDAO;
import entity.Yonetici;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.FacesConverter;


@FacesConverter("yoneticiConverter")
public class YoneticiConverter implements Converter {

    private YoneticiDAO yoneticiDao;

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        int id = Integer.valueOf(string);
        Yonetici c = this.getYoneticiDao().findByID(id);
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        Yonetici c = (Yonetici) t;
        return String.valueOf(c.getId());
    }

    public YoneticiDAO getYoneticiDao() {
        if (yoneticiDao == null) {
            this.yoneticiDao = new YoneticiDAO();
        }
        return yoneticiDao;
    }

    public void setYoneticiDao(YoneticiDAO yoneticiDao) {
        this.yoneticiDao = yoneticiDao;
    }
}
