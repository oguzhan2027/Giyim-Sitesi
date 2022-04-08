/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Yonetici;
import entity.Magaza;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class MagazaDAO extends DBConnection {

    private YoneticiDAO yoneticiDao;

    public Magaza findByID(int id) {
        Magaza c = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from magaza where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = new Magaza(rs.getInt("id"), rs.getString("ad"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return c;
    }

    public void create(Magaza c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into magaza (yonetici_id,ad,adres) values (" + c.getYonetici().getId() + ",'" + c.getAd() + "','" + c.getAdres() + "')";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(Magaza c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update magaza set yonetici_id=" + c.getYonetici().getId() + ",ad='" + c.getAd() + "',adres='" + c.getAdres() + "'where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(Magaza c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from magaza where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public List<Magaza> getList() {
        List<Magaza> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from magaza";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Yonetici c = this.getYoneticiDao().findByID(rs.getInt("yonetici_id"));
                list.add(new Magaza(rs.getInt("id"), c, rs.getString("ad"), rs.getString("adres")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public YoneticiDAO getYoneticiDao() {
        if (yoneticiDao == null) {
            this.yoneticiDao = new YoneticiDAO();
        }
        return yoneticiDao;
    }

    public void setYoneticiDao(YoneticiDAO yoneticiDao) {
        this.yoneticiDao = yoneticiDao;
    }

}
