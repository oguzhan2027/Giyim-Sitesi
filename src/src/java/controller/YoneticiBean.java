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

    public List<Yonetici> getList() {
        this.list = this.getDao().getList(page, pageSize);
        return list;
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

    public void setList(List<Yonetici> list) {
        this.list = list;
    }
}
