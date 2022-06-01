
package dao;


import entity.Magaza;
import entity.MusteriHizmet;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class MusteriHizmetDAO extends DBConnection {

    private MagazaDAO magazaDao;

    public MusteriHizmet findByID(int id) {
        MusteriHizmet m = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from musteri_hizmet where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                m = new MusteriHizmet(rs.getInt("id"), rs.getString("telefon"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return m;
    }

    public void create(MusteriHizmet m) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into musteri_hizmet (magaza_id,ad_soyad,telefon) values (" + m.getMagaza().getId() + ",'" + m.getAdSoyad() + "','" + m.getTelefon() + "')";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(MusteriHizmet m) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update musteri_hizmet set magaza_id=" + m.getMagaza().getId() + ",ad_soyad='" + m.getAdSoyad() + "',telefon='" + m.getTelefon() + "'where id=" + m.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(MusteriHizmet m) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from musteri_hizmet where id=" + m.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }
  public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as muhHiz_count from musteri_hizmet";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("muhHiz_count");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return count;
    }
    public List<MusteriHizmet> getList(int page, int pageSize) {
        List<MusteriHizmet> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from musteri_hizmet order by id asc limit "+pageSize+" offset "+start;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Magaza m = this.getMagazaDao().findByID(rs.getInt("magaza_id"));
                list.add(new MusteriHizmet(rs.getInt("id"), m, rs.getString("ad_Soyad"), rs.getString("telefon")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public MagazaDAO getMagazaDao() {
        if (magazaDao == null) {
            this.magazaDao = new MagazaDAO();
        }
        return magazaDao;
    }

    public void setMagazaDao(MagazaDAO magazaDao) {
        this.magazaDao = magazaDao;
    }

}


