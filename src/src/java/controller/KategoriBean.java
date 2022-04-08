/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.KategoriDAO;
import entity.Kategori;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;


@Named(value = "kategoriBean")
@SessionScoped
public class KategoriBean implements Serializable {

    private Kategori entity;
    private KategoriDAO dao;
    private List<Kategori> list;

    public KategoriBean() {
    }

    public String getTitle(int id) {
        Kategori k = this.getDao().findByID(id);
        return k.getKategoriAd();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Kategori();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Kategori();
    }

    public void delete(Kategori k) {
        this.getDao().delete(k);
        entity = new Kategori();
    }

    public void clear() {
        entity = new Kategori();
    }

    public Kategori getEntity() {
        if (this.entity == null) {
            this.entity = new Kategori();
        }
        return entity;
    }

    public void setEntity(Kategori entity) {
        this.entity = entity;
    }

    public KategoriDAO getDao() {
        if (this.dao == null) {
            this.dao = new KategoriDAO();
        }
        return dao;
    }

    public void setDao(KategoriDAO dao) {
        this.dao = dao;
    }

    public List<Kategori> getList() {
        this.list = this.getDao().getList();
        return list;
    }

    public void setList(List<Kategori> list) {
        this.list = list;
    }
}
