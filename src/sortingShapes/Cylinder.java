package sortingShapes;

public class Cylinder extends GeometricShape {
    private double radius;

    // Constructors
    public Cylinder(double height, double radius) {
        super(height);
        this.radius = radius;
    }

    // Getter and setter for radius
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateBaseArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculateVolume() {
        return calculateBaseArea() * height;
    }

    @Override
    public String toString() {
        return "Cylinder - Height: " + height + ", Radius: " + radius + ", Base Area: " + calculateBaseArea() + ", Volume: " + calculateVolume();
    }
}

