public class PP {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.png");
        Image image2 = new ProxyImage("photo2.png");

        // First display (image will be loaded from the remote server)
        image1.display();
        image2.display();

        System.out.println("\nDisplaying again:");
        // Second display (image will be retrieved from cache/local reference)
        image1.display();
        image2.display();
    }
}

// Subject interface
interface Image {
    void display();
}

// Real Subject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromRemoteServer();
    }

    private void loadFromRemoteServer() {
        System.out.println("Loading image: " + filename + " from remote server...");
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy
class ProxyImage implements Image {
    private String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

