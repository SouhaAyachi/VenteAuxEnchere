/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fst.jee.mybeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author souha
 */
@Named(value = "PrimefacesFileUpload")
@RequestScoped
public class PrimefacesFileUpload {

    private UploadedFile uploadedFile;
    //private UploadedFile event;

     public void upload() {
          System.out.println("uploaaaaaaad");
        if(uploadedFile != null) {
            System.out.println("uploaaaaaaad");
            FacesMessage message = new FacesMessage("Succesful", uploadedFile.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
             try {
        
        InputStream in = uploadedFile.getInputstream();
        String fileName = uploadedFile.getFileName();
        System.out.println("filename: "+fileName);

        // write the inputStream to a FileOutputStream            
        OutputStream out = new FileOutputStream(new File("/home/souha/GestionProduit/src/main/webapp/resources/img"+ "/" + fileName));
        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = in.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        in.close();
        out.flush();
        out.close();
        System.err.println("New file created!");
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
        
   }
    }
    
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);
        try {
        
        InputStream in = (event.getFile()).getInputstream();
        String fileName = event.getFile().getFileName();
        System.out.println("filename: "+fileName);

        // write the inputStream to a FileOutputStream            
        OutputStream out = new FileOutputStream(new File("/home/souha/GestionProduit/src/main/webapp/resources/img"+ "/" + fileName));
        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = in.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        in.close();
        out.flush();
        out.close();
        System.err.println("New file created!");
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
    }
    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

    public UploadedFile getUploadedFile() {
        return uploadedFile;
    }
    
    public void uploadFile(FileUploadEvent eventUpload) throws IOException, Exception {
    try {
        
        InputStream in = (eventUpload.getFile()).getInputstream();
        String fileName = eventUpload.getFile().getFileName();
        System.out.println("filename: "+fileName);

        // write the inputStream to a FileOutputStream            
        OutputStream out = new FileOutputStream(new File("/home/souha/GestionProduit/src/main/webapp/resources/img"+ "/" + fileName));
        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = in.read(bytes)) != -1) {
            out.write(bytes, 0, read);
        }
        in.close();
        out.flush();
        out.close();
        System.err.println("New file created!");
    } catch (IOException e) {
        System.out.println(e.getMessage());
    }
}

   /* public void upload(ActionEvent event) {        
        String fileName = uploadedFile.getFileName();
        byte[] content = uploadedFile.getContents();
        String contentType = uploadedFile.getContentType();
        // Keep upload file 
        FacesContext.getCurrentInstance().addMessage("messages", new FacesMessage("Successful! " + uploadedFile.getFileName() + " is uploaded."));
    }  */ 
}
