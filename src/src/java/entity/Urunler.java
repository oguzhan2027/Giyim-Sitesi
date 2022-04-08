/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class Urunler {

    private int id;
    private Kategori kategori;
    private String ad;
    private int fiyat;
    private Stok stok;
    private MusteriHizmet musteriHizmet;

    public Urunler() {
    }

    public Urunler(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public Urunler(int id, Kategori kategori, String ad, int fiyat, Stok stok, MusteriHizmet musteriHizmet) {
        this.id = id;
        this.kategori = kategori;
        this.ad = ad;
        this.fiyat = fiyat;
        this.stok = stok;
        this.musteriHizmet = musteriHizmet;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public void setKategori(Kategori kategori) {
        this.kategori = kategori;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    public Stok getStok() {
        return stok;
    }

    public void setStok(Stok stok) {
        this.stok = stok;
    }

    public MusteriHizmet getMusteriHizmet() {
        return musteriHizmet;
    }

    public void setMusteriHizmet(MusteriHizmet musteriHizmet) {
        this.musteriHizmet = musteriHizmet;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Urunler other = (Urunler) obj;
        return this.id == other.id;
    }

}
