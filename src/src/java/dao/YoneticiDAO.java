package dao;

import entity.Yonetici;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class YoneticiDAO extends DBConnection {

    public Yonetici findByID(int id) {
        Yonetici c = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from yonetici where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                c = new Yonetici(rs.getInt("id"), rs.getString("ad_soyad"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return c;
    }

    public void create(Yonetici c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into yonetici (ad_soyad) values ('" + c.getAdSoyad() + "')";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(Yonetici c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update yonetici set ad_soyad='" + c.getAdSoyad() + "'where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(Yonetici c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from yonetici where id=" + c.getId();
            st.executeUpdate(query);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as yonetici_count from yonetici";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("yonetici_count");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return count;
    }

    public List<Yonetici> getList(int page, int pageSize) {
        List<Yonetici> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from yonetici order by id asc limit "+pageSize+" offset "+start;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Yonetici(rs.getInt("id"), rs.getString("ad_soyad")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

}
