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

    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as stok_count from stok";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("stok_count");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return count;
    }

    public List<Stok> getList(int page, int pageSize) {
        List<Stok> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from stok order by id asc limit " + pageSize + " offset " + start;
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
