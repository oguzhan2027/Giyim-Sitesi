package controller;

import dao.MusteriHizmetDAO;
import entity.MusteriHizmet;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "musteriHizmetBean")
@SessionScoped
public class MusteriHizmetBean implements Serializable {

    private MusteriHizmet entity;
    private MusteriHizmetDAO dao;
    private List<MusteriHizmet> list;

    public MusteriHizmetBean() {
    }

    public String getTitle(int id) {
        MusteriHizmet m = this.getDao().findByID(id);
        return m.getTelefon();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new MusteriHizmet();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new MusteriHizmet();
    }

    public void delete(MusteriHizmet p) {
        this.getDao().delete(p);
        entity = new MusteriHizmet();
    }

    public void clear() {
        entity = new MusteriHizmet();
    }

    public MusteriHizmet getEntity() {
        if (this.entity == null) {
            this.entity = new MusteriHizmet();
        }
        return entity;
    }

    public void setEntity(MusteriHizmet entity) {
        this.entity = entity;
    }

    public MusteriHizmetDAO getDao() {
        if (this.dao == null) {
            this.dao = new MusteriHizmetDAO();
        }
        return dao;
    }

    public void setDao(MusteriHizmetDAO dao) {
        this.dao = dao;
    }

    public List<MusteriHizmet> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<MusteriHizmet> list) {
        this.list = list;
    }
}
