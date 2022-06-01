package dao;

import entity.Document;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import java.sql.ResultSet;


public class DocumentDAO extends DBConnection {

    public List<Document> findAll() {
        List<Document> dList = new ArrayList<>();
      
            try {
            Statement st = this.getConnection().createStatement();
            String query = "select * from document";

           
            ResultSet rs = st.executeQuery(query);

            while (rs.next()) {

                
                Document doc = new Document();
                doc.setId(rs.getLong("id"));
                doc.setFileName(rs.getString("fileName"));
                doc.setFilePath(rs.getString("filePath"));
                doc.setFileType(rs.getString("fileType"));
                System.out.println(doc.getId() + doc.getFileName());
                dList.add(doc);
            }
            } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        return dList;
    }

    public void insert(Document d) {
        String query="insert into document(filepath,filename,filetype) values(?,?,?)";
        try {
            PreparedStatement pst = this.getConnection().prepareStatement(query);
            pst.setString(1, d.getFilePath());
            pst.setString(2, d.getFilePath());
            pst.setString(3, d.getFilePath());
            pst.executeUpdate();
           
        } catch (Exception e) {
            
            System.out.print(e.getMessage());

        }
    }

}


