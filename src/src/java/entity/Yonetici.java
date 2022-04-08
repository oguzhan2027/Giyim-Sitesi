package entity;


public class Yonetici {

    private int id;
    private String adSoyad;

    public Yonetici() {
    }

    public Yonetici(int id, String adSoyad) {
        this.id = id;
        this.adSoyad = adSoyad;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
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
        final Yonetici other = (Yonetici) obj;
        return this.id == other.id;
    }

}
