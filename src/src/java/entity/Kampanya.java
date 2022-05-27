
package entity;


public class Kampanya {

    private int id;
    private String isim;
    private String basSure;
    private String bitSure;

    public Kampanya() {
    }

    public Kampanya(int id, String isim) {
        this.id = id;
        this.isim = isim;
    }

    public Kampanya(int id, String isim, String basSure, String bitSure) {
        this.id = id;
        this.isim = isim;
        this.basSure = basSure;
        this.bitSure = bitSure;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getBasSure() {
        return basSure;
    }

    public void setBasSure(String basSure) {
        this.basSure = basSure;
    }

    public String getBitSure() {
        return bitSure;
    }

    public void setBitSure(String bitSure) {
        this.bitSure = bitSure;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Kampanya other = (Kampanya) obj;
        return this.id == other.id;
    }

}
