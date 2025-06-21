class CPU {
    void run() {
        System.out.println("CPU is running");
    }
}

class Memory {
    void load() {
        System.out.println("Memory is loading data");
    }
}

class HardDrive {
    void read() {
        System.out.println("Reading from Hard Drive");
    }
}

class ComputerFacade {
    private CPU cpu = new CPU();
    private Memory memory = new Memory();
    private HardDrive hardDrive = new HardDrive();

    void start() {
        cpu.run();
        memory.load();
        hardDrive.read();
        System.out.println("Computer started successfully");
    }
}

public class Facade {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade();
        computer.start();
    }
}
