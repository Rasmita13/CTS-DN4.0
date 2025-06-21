
class OldMachine {
    void oldPrint() {
        System.out.println("Printing in old style");
    }
}


interface NewPrinter {
    void print();
}


class PrinterAdapter implements NewPrinter {
    private OldMachine oldMachine;

    public PrinterAdapter(OldMachine oldMachine) {
        this.oldMachine = oldMachine;
    }

    @Override
    public void print() {
        oldMachine.oldPrint();
    }
}


public class Adapter {
    public static void main(String[] args) {
        OldMachine oldMachine = new OldMachine();
        NewPrinter printer = new PrinterAdapter(oldMachine);
        printer.print(); 
    }
}
