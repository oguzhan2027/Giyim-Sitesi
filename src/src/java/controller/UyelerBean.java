/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.UyelerDAO;
import entity.Uyeler;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "uyelerBean")
@SessionScoped
public class UyelerBean implements Serializable {

    private Uyeler entity;
    private UyelerDAO dao;
    private List<Uyeler> list;

    public UyelerBean() {
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Uyeler();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Uyeler();
    }

    public void delete(Uyeler p) {
        this.getDao().delete(p);
        entity = new Uyeler();
    }

    public void clear() {
        entity = new Uyeler();
    }

    public Uyeler getEntity() {
        if (this.entity == null) {
            this.entity = new Uyeler();
        }
        return entity;
    }

    public void setEntity(Uyeler entity) {
        this.entity = entity;
    }

    public UyelerDAO getDao() {
        if (this.dao == null) {
            this.dao = new UyelerDAO();
        }
        return dao;
    }

    public void setDao(UyelerDAO dao) {
        this.dao = dao;
    }

    public List<Uyeler> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Uyeler> list) {
        this.list = list;
    }
}
