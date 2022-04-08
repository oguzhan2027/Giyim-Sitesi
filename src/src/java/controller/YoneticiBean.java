/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.YoneticiDAO;
import entity.Yonetici;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "yoneticiBean")
@SessionScoped
public class YoneticiBean implements Serializable {

    private Yonetici entity;
    private YoneticiDAO dao;
    private List<Yonetici> list;

    public YoneticiBean() {
    }

    public String getTitle(int id) {
        Yonetici c = this.getDao().findByID(id);
        return c.getAdSoyad();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Yonetici();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Yonetici();
    }

    public void delete(Yonetici c) {
        this.getDao().delete(c);
        entity = new Yonetici();
    }

    public void clear() {
        entity = new Yonetici();
    }

    public Yonetici getEntity() {
        if (this.entity == null) {
            this.entity = new Yonetici();
        }
        return entity;
    }

    public void setEntity(Yonetici entity) {
        this.entity = entity;
    }

    public YoneticiDAO getDao() {
       if (this.dao == null) {
            this.dao = new YoneticiDAO();
        }
        return dao;
    }

    public void setDao(YoneticiDAO dao) {
        this.dao = dao;
    }

    public List<Yonetici> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Yonetici> list) {
        this.list = list;
    }
}
