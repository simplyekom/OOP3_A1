package sortingShapes;

import java.util.Comparator;

public class ShapeComparator implements Comparator<GeometricShape> {
    private char compareType;

    public ShapeComparator(char compareType) {
        this.compareType = compareType;
    }

    @Override
    public int compare(GeometricShape shape1, GeometricShape shape2) {
        switch (compareType) {
            case 'h':
                // Compare by height
                return shape1.compareTo(shape2);
            case 'v':
                // Compare by volume
                return Double.compare(shape1.calculateVolume(), shape2.calculateVolume());
            case 'a':
                // Compare by base area
                return Double.compare(shape1.calculateBaseArea(), shape2.calculateBaseArea());
            default:
                throw new IllegalArgumentException("Invalid comparison type");
        }
    }
}
