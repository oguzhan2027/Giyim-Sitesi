/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import entity.Kampanya;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;


public class KampanyaDAO extends DBConnection{
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

    public List<Kampanya> getList() {
        List<Kampanya> list = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from kampanya";
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
