abstract class Geometry {
    public abstract double calculateArea();
}

class Square extends Geometry {
    private double side;
    public Square(double side) {
        this.side = side;
    }
    public double calculateArea() {
        return side * side;
    }
}

class Triangle extends Geometry {
    private double base, height;
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

public class OCP {
    public static void main(String[] args) {
        Geometry square = new Square(4);
        Geometry triangle = new Triangle(3, 6);

        System.out.println("Square area: " + square.calculateArea());
        System.out.println("Triangle area: " + triangle.calculateArea());
    }
}
