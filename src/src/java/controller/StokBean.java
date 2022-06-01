/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controller;

import dao.StokDAO;
import entity.Stok;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;

@Named(value = "stokBean")
@SessionScoped
public class StokBean implements Serializable {

    private Stok entity;
    private StokDAO dao;
    private List<Stok> list;

    public StokBean() {
    }
    private int page = 1;
    private int pageSize = 2;
    private int pageCount;

    public void next() {
        if (this.page == this.getPageCount()) {
            this.page = 1;
        } else {
            this.page++;
        }
    }

    public void previous() {
        if (this.page == 1) {
            this.page = this.getPageCount();
        } else {
            this.page--;
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageCount() {
        this.pageCount = (int) Math.ceil(this.getDao().count() / (double) pageSize);
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTitle(int id) {
        Stok s = this.getDao().findByID(id);
        return s.getAdet();
    }

    public void create() {
        this.getDao().create(entity);
        entity = new Stok();
    }

    public void update() {
        this.getDao().update(entity);
        entity = new Stok();
    }

    public void delete(Stok c) {
        this.getDao().delete(c);
        entity = new Stok();
    }

    public void clear() {
        entity = new Stok();
    }

    public Stok getEntity() {
        if (this.entity == null) {
            this.entity = new Stok();
        }
        return entity;
    }

    public void setEntity(Stok entity) {
        this.entity = entity;
    }

    public StokDAO getDao() {
        if (this.dao == null) {
            this.dao = new StokDAO();
        }
        return dao;
    }

    public void setDao(StokDAO dao) {
        this.dao = dao;
    }

    public List<Stok> getList() {
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    public void setList(List<Stok> list) {
        this.list = list;
    }
}

