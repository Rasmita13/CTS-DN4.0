interface Glider {
    void glide();
}

class Eagle implements Glider {
    public void glide() {
        System.out.println("Eagle soars through the skies.");
    }
}

class Penguin {
    
    public void swim() {
        System.out.println("Penguin swims in water.");
    }
}

public class LSP {
    public static void main(String[] args) {
        Glider eagle = new Eagle();
        eagle.glide();

        Penguin penguin = new Penguin();
        penguin.swim();
    }
}
