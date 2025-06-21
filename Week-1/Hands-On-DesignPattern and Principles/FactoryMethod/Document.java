public interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Opening a Word Document...");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("Opening a PDF Document...");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening an Excel Document...");
    }
}

