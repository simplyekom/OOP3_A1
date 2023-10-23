package sortingShapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

public class ShapeSortingApplication {
    public static void main(String[] args) {
        String fileName = "C:\\Users\\lyaar\\Downloads\\Assignment Complexity and Sorting\\polyfor1.txt";
        char compareType = 'h'; // Default comparison type (height)
        char sortingAlgorithm = 'b'; // Default sorting algorithm (bubble)

        // Parse command line arguments
        for (int i = 0; i < args.length; i++) {
            String arg = args[i].toLowerCase(); // Make the argument case insensitive
            switch (arg) {
                case "-f":
                case "-file":
                    fileName = args[i + 1];
                    i++; // Skip next argument
                    break;
                case "-t":
                case "-type":
                    compareType = args[i + 1].toLowerCase().charAt(0);
                    i++; // Skip next argument
                    break;
                case "-s":
                case "-sort":
                    sortingAlgorithm = args[i + 1].toLowerCase().charAt(0);
                    i++; // Skip next argument
                    break;
            }
        }

        // Read shapes from the file and perform sorting
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Read shapes from the file and store them in an array
            int numShapes = Integer.parseInt(reader.readLine());
            GeometricShape[] shapes = new GeometricShape[numShapes];

            for (int i = 0; i < numShapes; i++) {
                String[] shapeInfo = reader.readLine().split(" ");
                String shapeType = shapeInfo[0];
                double height = Double.parseDouble(shapeInfo[1]);
                double parameter = Double.parseDouble(shapeInfo[2]);

                GeometricShape shape = null;
                
                switch (shapeType) {
                case "Cylinder":
                    double radius = parameter;
                    shape = new Cylinder(height, radius);
                    break;
                default:
                    // Handle unknown shape type
                    throw new IllegalArgumentException("Unknown shape type: " + shapeType);
            }

                shapes[i] = shape;
            }

            // Sort shapes using Bubble Sort based on the specified comparison type
            bubbleSort(shapes, new ShapeComparator(compareType));

            // Print sorted shapes
            for (GeometricShape shape : shapes) {
                System.out.println(shape.getClass().getSimpleName() + ": " + shape);
            }

        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    }

    // Bubble Sort implementation
    public static void bubbleSort(GeometricShape[] shapes, Comparator<GeometricShape> comparator) {
        int n = shapes.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (comparator.compare(shapes[i - 1], shapes[i]) > 0) {
                    // Swap shapes[i - 1] and shapes[i]
                    GeometricShape temp = shapes[i - 1];
                    shapes[i - 1] = shapes[i];
                    shapes[i] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}
