package dao;

import entity.Kategori;
import entity.MusteriHizmet;
import entity.Stok;
import entity.Urunler;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;

public class UrunlerDAO extends DBConnection {

    private KategoriDAO kategoriDao;
    private StokDAO stokDao;
    private MusteriHizmetDAO musteriHizmetDao;

    public Urunler findByID(int id) {
        Urunler u = null;

        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from urunler where id=" + id;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                u = new Urunler(rs.getInt("id"), rs.getString("ad"));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return u;
    }

    public void create(Urunler u) {
        try {
            Statement st = this.getConnection().createStatement();

            String query = "insert into urunler (kategori_id,ad,fiyat,stok_id,musteri_hizmet_id) values (" + u.getKategori().getId() + ",'" + u.getAd() + "','" + u.getFiyat() + "','" + u.getStok().getId() + "','" + u.getMusteriHizmet().getId() + "')";
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void update(Urunler u) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "update urunler set kategori_id=" + u.getKategori().getId() + ",ad='" + u.getAd() + "',fiyat='" + u.getFiyat() + "',stok_id='" + u.getStok().getId() + "',musteri_hizmet_id='" + u.getMusteriHizmet().getId() + "'where id=" + u.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public void delete(Urunler u) {
        try {
            Statement st = this.getConnection().createStatement();
            String query = "delete from urunler where id=" + u.getId();
            st.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
    }

    public int count() {
        int count = 0;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select count(id) as urunler_count from urunler";
            ResultSet rs = st.executeQuery(query);
            rs.next();
            count = rs.getInt("urunler_count");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return count;
    }

    public List<Urunler> getList(int page, int pageSize) {
        List<Urunler> list = new ArrayList<>();
        int start = (page - 1) * pageSize;
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from urunler order by id asc limit " + pageSize + " offset " + start;
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                Kategori k = this.getKategoriDao().findByID(rs.getInt("kategori_id"));
                Stok s = this.getStokDao().findByID(rs.getInt("stok_id"));
                MusteriHizmet m = this.getMusteriHizmetDao().findByID(rs.getInt("musteri_hizmet_id"));
                list.add(new Urunler(rs.getInt("id"), k, rs.getString("ad"), rs.getInt("fiyat"), s, m));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return list;
    }

    public KategoriDAO getKategoriDao() {
        if (kategoriDao == null) {
            this.kategoriDao = new KategoriDAO();
        }
        return kategoriDao;
    }

    public void setKategoriDao(KategoriDAO kategoriDao) {
        this.kategoriDao = kategoriDao;
    }

    public StokDAO getStokDao() {
        if (stokDao == null) {
            this.stokDao = new StokDAO();
        }
        return stokDao;
    }

    public void setStokDao(StokDAO stokDao) {
        this.stokDao = stokDao;
    }

    public MusteriHizmetDAO getMusteriHizmetDao() {
        if (musteriHizmetDao == null) {
            this.musteriHizmetDao = new MusteriHizmetDAO();
        }
        return musteriHizmetDao;
    }

    public void setMusteriHizmetDao(MusteriHizmetDAO musteriHizmetDao) {
        this.musteriHizmetDao = musteriHizmetDao;
    }

}
