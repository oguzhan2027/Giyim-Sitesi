/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Kategori;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class KategoriDAO extends DBConnection {

    public Kategori findByID(int id) {
        Kategori k = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kategori where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                k = new Kategori(rs.getInt("id"), rs.getString("ad"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return k;
    }

    public void create(Kategori k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into kategori (ad) values ('"+ k.getKategoriAd() + "')";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(Kategori k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update kategori set ad='" + k.getKategoriAd() + "'where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(Kategori k) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from kategori where id=" + k.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public List<Kategori> getList() {
        List<Kategori> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kategori";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Kategori(rs.getInt("id"), rs.getString("ad")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

}
