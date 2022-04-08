/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class Kampanya {
     private int id;
   
    private String isim;
    private String basSure;
    private String bitSure;

    public Kampanya() {
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

  
    

}
