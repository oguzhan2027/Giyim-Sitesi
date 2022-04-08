/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Stok;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class StokDAO extends DBConnection {

    public Stok findByID(int id) {
        Stok s = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from stok where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                s = new Stok(rs.getInt("id"), rs.getInt("stok_adet"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return s;
    }

    public void create(Stok s) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into stok (stok_adet) values ('" + s.getAdet() + "')";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(Stok s) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update stok set stok_adet='" + s.getAdet() + "'where id=" + s.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(Stok s) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from stok where id=" + s.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public List<Stok> getList() {
        List<Stok> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from stok";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Stok(rs.getInt("id"), rs.getInt("stok_adet")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

}
