public class BP {
    public static void main(String[] args) {
        Computer gamingRig = new Computer.Builder()
            .setCpu("Intel i9")
            .setRam("32GB")
            .setStorage("2TB SSD")
            .build();

        Computer officePc = new Computer.Builder()
            .setCpu("Intel i5")
            .setRam("8GB")
            .setStorage("256GB SSD")
            .build();

      
        System.out.println("Gaming Rig -> CPU: " + gamingRig.getCpu() + ", RAM: " + gamingRig.getRam() + ", Storage: " + gamingRig.getStorage());
        System.out.println("Office PC -> CPU: " + officePc.getCpu() + ", RAM: " + officePc.getRam() + ", Storage: " + officePc.getStorage());
    }
}

