/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.UrunlerDAO;
import entity.Urunler;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "urunlerBean")
@SessionScoped
public class UrunlerBean implements Serializable {

    private Urunler entity;
    private UrunlerDAO dao;
    private List<Urunler> list;

    public UrunlerBean() {
    }
  public String getTitle(int id) {
        Urunler c = this.getDao().findByID(id);
        return c.getAd();
    }


    public void create() {
        this.getDao().create(entity);
        entity = new Urunler();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Urunler();
    }

    public void delete(Urunler p) {
        this.getDao().delete(p);
        entity = new Urunler();
    }

    public void clear() {
        entity = new Urunler();
    }

    public Urunler getEntity() {
        if (this.entity == null) {
            this.entity = new Urunler();
        }
        return entity;
    }

    public void setEntity(Urunler entity) {
        this.entity = entity;
    }

    public UrunlerDAO getDao() {
        if (this.dao == null) {
            this.dao = new UrunlerDAO();
        }
        return dao;
    }

    public void setDao(UrunlerDAO dao) {
        this.dao = dao;
    }

    public List<Urunler> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Urunler> list) {
        this.list = list;
    }
}
