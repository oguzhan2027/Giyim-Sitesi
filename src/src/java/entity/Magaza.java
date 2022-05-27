/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class Magaza {
    private int id;
    private Yonetici yonetici;
    private String ad;
    private String adres;

    public Magaza() {
    }

    public Magaza(int id, String ad) {
        this.id = id;
        this.ad = ad;
    }

    public Magaza(int id, Yonetici yonetici, String ad, String adres) {
        this.id = id;
        this.yonetici = yonetici;
        this.ad = ad;
        this.adres = adres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Yonetici getYonetici() {
        return yonetici;
    }

    public void setYonetici(Yonetici yonetici) {
        this.yonetici = yonetici;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
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
        final Magaza other = (Magaza) obj;
        return this.id == other.id;
    }

}
