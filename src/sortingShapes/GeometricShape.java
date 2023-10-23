package sortingShapes;

import java.util.Comparator;

public abstract class GeometricShape implements Comparable<GeometricShape>, Comparator<GeometricShape> {
    // Common properties for all shapes
    protected double height;

    // Constructors
    public GeometricShape(double height) {
        this.height = height;
    }

    // Getter and setter for height
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Abstract methods for calculating area and volume
    public abstract double calculateBaseArea();
    public abstract double calculateVolume();

    @Override
    public int compareTo(GeometricShape other) {
        // Compare shapes by height
        return Double.compare(this.height, other.height);
    }

    @Override
    public int compare(GeometricShape shape1, GeometricShape shape2) {
        // Compare shapes by base area and volume
        double shape1Area = shape1.calculateBaseArea();
        double shape2Area = shape2.calculateBaseArea();
        double shape1Volume = shape1.calculateVolume();
        double shape2Volume = shape2.calculateVolume();

        // Compare by base area first
        int areaComparison = Double.compare(shape1Area, shape2Area);

        // If base area is equal, compare by volume
        if (areaComparison == 0) {
            return Double.compare(shape1Volume, shape2Volume);
        }

        return areaComparison;
    }
}


