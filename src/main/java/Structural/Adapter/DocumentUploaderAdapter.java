package Structural.Adapter;

public class DocumentUploaderAdapter {

    private DocumentUploader documentUploader;
    private Document document;

    public DocumentUploaderAdapter(DocumentUploader documentUploader, Document document){
        this.documentUploader = documentUploader;
        this.document = document;
    }

    public boolean uploadDocument(){
        String fileType = document.getType();
        String filePath = document.getPath();
        String pdfFile;
        if(fileType != "PDF") {
            //analize the file tayp e
            // if it cannot be converted to pdf file then return false
            // logic to convert the file to a new file of pdf format
            // and assign its name to pdf file
            pdfFile = null;
        }else {
            pdfFile = filePath;
        }

        PDFDocument pdfDocument = new PDFDocument(pdfFile);
        return documentUploader.uploadDocument(pdfDocument);
    }
}
