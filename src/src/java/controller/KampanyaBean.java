/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KampanyaDAO;
import entity.Kampanya;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "kampanyaBean")
@SessionScoped
public class KampanyaBean implements Serializable {

    private Kampanya entity;
    private KampanyaDAO dao;
    private List<Kampanya> list;

    public KampanyaBean() {
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Kampanya();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Kampanya();
    }

    public void delete(Kampanya c) {
        this.getDao().delete(c);
        entity = new Kampanya();
    }

    public void clear() {
        entity = new Kampanya();
    }

    public Kampanya getEntity() {
        if (this.entity == null) {
            this.entity = new Kampanya();
        }
        return entity;
    }

    public void setEntity(Kampanya entity) {
        this.entity = entity;
    }

    public KampanyaDAO getDao() {
        if (this.dao == null) {
            this.dao = new KampanyaDAO();
        }
        return dao;
    }

    public void setDao(KampanyaDAO dao) {
        this.dao = dao;
    }

    public List<Kampanya> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Kampanya> list) {
        this.list = list;
    }
}
