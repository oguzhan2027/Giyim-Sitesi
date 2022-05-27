
package dao;


import entity.Kampanya;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;


public class KampanyaDAO extends DBConnection{
    
     public Kampanya findByID(int id) {
        Kampanya k = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kampanya where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                k = new Kampanya(rs.getInt("id"), rs.getString("isim"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return k;
    }
    
    public void create(Kampanya c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into kampanya (isim,bas_sure,bit_sure) values ('" + c.getIsim() +"','" + c.getBasSure() + "','"  + c.getBitSure() +  "')";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(Kampanya c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update kampanya set isim='" + c.getIsim()  + "',bas_sure='" + c.getBasSure()  + "',bit_sure='" + c.getBitSure() + "'where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(Kampanya c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from kampanya where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }
      public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as kampanya_count from kampanya";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("kampanya_count");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return count;
    }

    public List<Kampanya> getList(int page, int pageSize) {
        List<Kampanya> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kampanya order by id asc limit "+pageSize+" offset "+start;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Kampanya(rs.getInt("id"), rs.getString("isim"), rs.getString("bas_sure"), rs.getString("bit_sure")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }
}
