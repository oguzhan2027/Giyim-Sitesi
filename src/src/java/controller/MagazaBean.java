/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.MagazaDAO;
import entity.Magaza;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "magazaBean")
@SessionScoped
public class MagazaBean implements Serializable {

    private Magaza entity;
    private MagazaDAO dao;
    private List<Magaza> list;

    public MagazaBean() {
    }

    public String getTitle(int id) {
        Magaza c = this.getDao().findByID(id);
        return c.getAd();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Magaza();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Magaza();
    }

    public void delete(Magaza p) {
        this.getDao().delete(p);
        entity = new Magaza();
    }

    public void clear() {
        entity = new Magaza();
    }

    public Magaza getEntity() {
        if (this.entity == null) {
            this.entity = new Magaza();
        }
        return entity;
    }

    public void setEntity(Magaza entity) {
        this.entity = entity;
    }

    public MagazaDAO getDao() {
        if (this.dao == null) {
            this.dao = new MagazaDAO();
        }
        return dao;
    }

    public void setDao(MagazaDAO dao) {
        this.dao = dao;
    }

    public List<Magaza> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Magaza> list) {
        this.list = list;
    }

}
