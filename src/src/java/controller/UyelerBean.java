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
    private int page = 1;
    private int pageSize = 2;
    private int pageCount;

    public UyelerBean() {
    }

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
        this.list = this.getDao().getList(page, pageSize);
        return list;
    }

    public void setList(List<Uyeler> list) {
        this.list = list;
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
}
