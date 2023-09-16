package Structural.Adapter;

public class PDFDocument implements UploadableDocument{

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private String filePath;

    public PDFDocument(String filePath){
        this.filePath = filePath;
    }

    @Override
    public String getPDFFilePath() {
        return this.filePath;
    }
}
