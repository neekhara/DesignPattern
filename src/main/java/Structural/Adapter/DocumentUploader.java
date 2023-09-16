package Structural.Adapter;

public class DocumentUploader {

    public boolean uploadDocument(UploadableDocument uploadableDocument){
        String file = uploadableDocument.getPDFFilePath();
        //Code to establish network connection
        //code to send file
        // code to close soket
        return true;
    }
}
