/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class MusteriHizmet {

    private int id;
    private Magaza magaza;
    private String adSoyad;
    private String telefon;

    public MusteriHizmet() {
    }

    public MusteriHizmet(int id, String telefon) {
        this.id = id;
        this.telefon = telefon;
    }

    public MusteriHizmet(int id, Magaza magaza, String adSoyad, String telefon) {
        this.id = id;
        this.magaza = magaza;
        this.adSoyad = adSoyad;
        this.telefon = telefon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Magaza getMagaza() {
        return magaza;
    }

    public void setMagaza(Magaza magaza) {
        this.magaza = magaza;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
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
        final MusteriHizmet other = (MusteriHizmet) obj;
        return this.id == other.id;
    }

}
