package dao;

import entity.Kampanya;
import entity.Magaza;
import entity.Urunler;
import entity.Uyeler;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class UyelerDAO extends DBConnection {

    private MagazaDAO magazaDao;
    private UrunlerDAO urunlerDao;
    private KampanyaDAO kampanyaDao;

    public void create(Uyeler c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "insert into uyeler (magaza_id,ad_soyad,adres,e_posta,telefon) values (" + c.getMagaza().getId() + ",'" + c.getAdSoyad() + "','" + c.getAdres() + "','" + c.getPosta() + "','" + c.getTelefon() + "')";
            st.executeUpdate(query);
            ResultSet rs = st.executeQuery("select max(id) as mid from uyeler");
            rs.next();
            int uye_id = rs.getInt("mid");
            for (Urunler ur : c.getUrun()) {
                query = "insert into sepete_ekle (urunler_id,uyeler_id) values (" + ur.getId() + "," + uye_id + ")";
                st.executeUpdate(query);
            }
            for (Urunler ur : c.getUrun1()) {
                query = "insert into siparis_verme (urunler_id,uyeler_id) values (" + ur.getId() + "," + uye_id + ")";
                st.executeUpdate(query);
            }
            for (Urunler ur : c.getUrun2()) {
                query = "insert into yorum_yapma (urunler_id,uyeler_id) values (" + ur.getId() + "," + uye_id + ")";
                st.executeUpdate(query);
            }
            for (Kampanya k : c.getKam()) {
                query = "insert into faydalanma (uyeler_id,kampanya_id) values (" + uye_id + "," + k.getId() + ")";
                st.executeUpdate(query);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(Uyeler c) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update uyeler set magaza_id=" + c.getMagaza().getId() + ",ad_soyad='" + c.getAdSoyad() + "',adres='" + c.getAdres() + "',e_posta='" + c.getPosta() + "',telefon='" + c.getTelefon() + "'where id=" + c.getId();
            st.executeUpdate(query);
            for (Urunler ur : c.getUrun()) {
                query = "insert into sepete_ekle (urunler_id,uyeler_id) values (" + ur.getId() + "," + c.getId() + ")";
                st.executeUpdate(query);
            }
            for (Urunler ur : c.getUrun1()) {
                query = "insert into siparis_verme (urunler_id,uyeler_id) values (" + ur.getId() + "," + c.getId() + ")";
                st.executeUpdate(query);
            }
            for (Urunler ur : c.getUrun2()) {
                query = "insert into yorum_yapma (urunler_id,uyeler_id) values (" + ur.getId() + "," + c.getId() + ")";
                st.executeUpdate(query);
            }
            for (Kampanya k : c.getKam()) {
                query = "insert into faydalanma (uyeler_id,kampanya_id) values (" + c.getId() + "," + k.getId() + ")";
                st.executeUpdate(query);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(Uyeler c) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("delete from siparis_verme where uyeler_id=" + c.getId());
            st.executeUpdate("delete from sepete_ekle where uyeler_id=" + c.getId());
            st.executeUpdate("delete from yorum_yapma where uyeler_id=" + c.getId());
            st.executeUpdate("delete from faydalanma where uyeler_id=" + c.getId());
            String query = "delete from uyeler where id=" + c.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as uyeler_count from uyeler";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("uyeler_count");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return count;
    }

    public List<Uyeler> getList(int page, int pageSize) {
        List<Uyeler> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from uyeler order by id asc limit " + pageSize + " offset " + start;

            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Magaza c = this.getMagazaDao().findByID(rs.getInt("magaza_id"));
                list.add(new Uyeler(rs.getInt("id"), c, rs.getString("ad_Soyad"), rs.getString("adres"), rs.getString("e_posta"), rs.getString("telefon"), this.getUyeUrunSep(rs.getInt("id")), this.getUyeUrunsiparis(rs.getInt("id")), this.getUyeUrunYorum(rs.getInt("id")), this.getUyeKampanyaFay(rs.getInt("id"))));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public List<Urunler> getUyeUrunSep(int uyeler_id) {
        List<Urunler> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from Urunler where id in (select urunler_id from sepete_ekle where uyeler_id=" + uyeler_id + ")";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Urunler(rs.getInt("id"), rs.getString("ad")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public List<Urunler> getUyeUrunsiparis(int uyeler_id) {
        List<Urunler> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from Urunler where id in (select urunler_id from siparis_verme where uyeler_id=" + uyeler_id + ")";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Urunler(rs.getInt("id"), rs.getString("ad")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public List<Urunler> getUyeUrunYorum(int uyeler_id) {
        List<Urunler> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from Urunler where id in (select urunler_id from yorum_yapma where uyeler_id=" + uyeler_id + ")";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Urunler(rs.getInt("id"), rs.getString("ad")));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public List<Kampanya> getUyeKampanyaFay(int uyeler_id) {
        List<Kampanya> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from Kampanya where id in (select kampanya_id from faydalanma where uyeler_id=" + uyeler_id + ")";
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                list.add(new Kampanya(rs.getInt("id"), rs.getString("isim")));
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

    public UrunlerDAO getUrunlerDao() {
        if (urunlerDao == null) {
            this.urunlerDao = new UrunlerDAO();
        }
        return urunlerDao;
    }

    public void setUrunlerDao(UrunlerDAO urunlerDao) {
        this.urunlerDao = urunlerDao;
    }

    public KampanyaDAO getKampanyaDao() {
        return kampanyaDao;
    }

    public void setKampanyaDao(KampanyaDAO kampanyaDao) {
        this.kampanyaDao = kampanyaDao;
    }

}
