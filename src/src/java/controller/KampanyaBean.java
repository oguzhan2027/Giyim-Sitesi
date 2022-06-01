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

    public String getTitle(int id) {
        Kampanya k = this.getDao().findByID(id);
        return k.getIsim();
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
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    public void setList(List<Kampanya> list) {
        this.list = list;
    }
}

