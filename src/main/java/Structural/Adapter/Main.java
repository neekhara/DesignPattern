package Structural.Adapter;

public class Main {

    public static void main(String[] args) {
        DocumentUploader documentUploader = new DocumentUploader();
        ImageFile imageFile= new ImageFile();

        // We are creating adapter here
        DocumentUploaderAdapter adapter = new DocumentUploaderAdapter(documentUploader, imageFile);
        adapter.uploadDocument();
    }

}
