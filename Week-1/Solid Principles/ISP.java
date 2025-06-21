interface DocumentPrinter {
    void printDocument();
}

interface DocumentScanner {
    void scanDocument();
}

interface DocumentCopier {
    void copyDocument();
}

class BasicPrinter implements DocumentPrinter {
    public void printDocument() {
        System.out.println("Document printed.");
    }
}

class MultiFunctionMachine implements DocumentPrinter, DocumentScanner, DocumentCopier {
    public void printDocument() {
        System.out.println("Document printed");
    }
    public void scanDocument() {
        System.out.println("Document scanned");
    }
    public void copyDocument() {
        System.out.println("Document copied");
    }
}

public class ISP {
    public static void main(String[] args) {
        BasicPrinter printer = new BasicPrinter();
        printer.printDocument();

        MultiFunctionMachine mfm = new MultiFunctionMachine();
        mfm.printDocument();
        mfm.scanDocument();
        mfm.copyDocument();
    }
}
