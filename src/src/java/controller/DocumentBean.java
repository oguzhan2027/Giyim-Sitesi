package controller;

import dao.DocumentDAO;
import entity.Document;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;

@Named(value = "documentBean")
@SessionScoped
public class DocumentBean implements Serializable {

    private Document document;
    private List<Document> documentList;
    private DocumentDAO documentDao;

    private Part doc;
    private final String uploadTo = "/Users/user/Desktop/resim/kopindir.jpg/";

    public void upload() {
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo + doc.getSubmittedFileName());
            
            Files.copy(input, f.toPath());

            document = this.getDocument();
            document.setFilePath(f.getParent());
            document.setFileName(f.getName());
            document.setFileType(doc.getContentType());

            this.getDocumentDao().insert(document);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Document getDocument() {
        if (this.document == null) {
            this.document = new Document();
        }
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Document> getDocumentList() {
        this.documentList = this.getDocumentDao().findAll();
        return documentList;
    }

    public void setDocumentList(List<Document> documentList) {
        this.documentList = documentList;
    }

    public DocumentDAO getDocumentDao() {
        if (this.documentDao == null) {
            this.documentDao = new DocumentDAO();
        }
        return documentDao;
    }

    public void setDocumentDao(DocumentDAO documentsDao) {
        this.documentDao = documentsDao;
    }

}
