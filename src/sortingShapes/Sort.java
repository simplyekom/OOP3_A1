package sortingShapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;

import Shape.Cone;
import Shape.Cylinder;
import Shape.OctagonalPrism;
import Shape.PentagonalPrism;
import Shape.Pyramid;
import Shape.SquarePrism;
import Shape.TriangularPrism;

public class Sort {

	public static void main(String[] args) {
		
		String fileName = args[1];
		char comparisonType = 'h'; //Default comparison type (height)
		char sortingAlgo = 'b'; //Default sorting algorithm (bubble)
		
		for (int i = 0; i < args.length; i++) {
			String arg = args[i].toLowerCase(); //Convert to lower case in case user enters capitals
			
            if (arg.startsWith("-f")) {
                // Extract the filename without a space after -f
                fileName = arg.substring(2); // Extract characters after -f
            } else if (arg.startsWith("-t")) {
                // Extract comparison type without a space after -t
                if (arg.length() > 2) {
                    comparisonType = arg.charAt(2);
                } else {
                    displayError("Missing comparison type after -t option.");
                    return;
                }
            } else if (arg.startsWith("-s")) {
                // Extract sorting algorithm without a space after -s
                if (arg.length() > 2) {
                    sortingAlgo = arg.charAt(2);
                } else {
                    displayError("Missing sorting algorithm after -s option.");
                    return;
                }
            } else {
                displayError("Invalid option: " + args[i]);
                return;
            }
		}
		
        // Check for null or empty filename
        if (fileName == null || fileName.isEmpty()) {
            displayError("Missing or invalid filename after -f option.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            
        	int numberOfShapes = 0;
        	
        	// Read the first line from the file
            String line = br.readLine();

            String[] parts = line.trim().split("\\s+");
            if (parts.length > 0) {
            	try {
            		numberOfShapes = Integer.parseInt(parts[0]);
                    // Print the number of shapes
                    System.out.println("Number of shapes: " + numberOfShapes);
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format in the input file: " + parts[0]);
                }
            } else {
                System.err.println("Invalid format for the first line in the input file.");
            }
            	
            // Initialize the array to hold the shapes
            GeometricShape[] shapes = new GeometricShape[numberOfShapes];
        	int counter = 1;
        	
            // Process shape data for each line
            for (int i = 0; i < numberOfShapes; i++) {
                String[] shapeData = line.split(" ");
                String shapeType = shapeData[counter];
                counter++;
                double height = Double.parseDouble(shapeData[counter]);
                counter++;
	            switch (shapeType) {
	                case "Cylinder":
	                    double radiusCylinder = Double.parseDouble(shapeData[counter]);
	                    shapes[i] = new Cylinder(height, radiusCylinder);
	                    counter++;
	                    break;
	                case "Cone":
	                    double radiusCone = Double.parseDouble(shapeData[counter]);
	                    shapes[i] = new Cone(height, radiusCone);
	                    counter++;
	                    break;
	                case "Pyramid":
	                    double edgeLengthPyramid = Double.parseDouble(shapeData[counter]);
	                    shapes[i] = new Pyramid(height, edgeLengthPyramid);
	                    counter++;
	                    break;
	                case "SquarePrism":
	                    double squareEdgeLength = Double.parseDouble(shapeData[counter]);
	                    shapes[i] = new SquarePrism(height, squareEdgeLength);
	                    counter++;
	                    break;
	                case "TriangularPrism":
	                    double triangularEdgeLength = Double.parseDouble(shapeData[counter]);
	                    shapes[i] = new TriangularPrism(height, triangularEdgeLength);
	                    counter++;
	                    break;
	                case "PentagonalPrism":
	                    double pentagonalEdgeLength = Double.parseDouble(shapeData[counter]);
	                    shapes[i] = new PentagonalPrism(height, pentagonalEdgeLength);
	                    counter++;
	                    break;
	                case "OctagonalPrism":
	                    double octagonalEdgeLength = Double.parseDouble(shapeData[counter]);
	                    shapes[i] = new OctagonalPrism(height, octagonalEdgeLength);
	                    counter++;
	                    break;
	                default:
	                    System.out.println("Invalid shape type: " + shapeType);
	                    break;
	            } 
            }

            // Sort the shapes array based on the comparison type in descending order
            Comparator<GeometricShape> comparator = new GeometricShape.shapeComparator(comparisonType);
            
            int firstIndex = 0;
            int lastIndex = shapes.length - 1;
            long startTime = 0, endTime = 0, elapsedTime = 0;
            
            switch (sortingAlgo) {
            case 'b':
                startTime = System.currentTimeMillis();
                Utility.bubbleSort(shapes, comparator.reversed());
                endTime = System.currentTimeMillis();
                break;
            case 's':
                startTime = System.currentTimeMillis();
                Utility.selectionSort(shapes, comparator.reversed());
                endTime = System.currentTimeMillis();
                break;
            case 'i':
                startTime = System.currentTimeMillis();
                Utility.insertionSort(shapes, comparator.reversed());
                endTime = System.currentTimeMillis();
                break;
            case 'm':
                startTime = System.currentTimeMillis();
                Utility.mergeSort(shapes, comparator.reversed());
                endTime = System.currentTimeMillis();
                break;
            case 'q':
                startTime = System.currentTimeMillis();
                Utility.quickSort(shapes, comparator.reversed());
                endTime = System.currentTimeMillis();
                break;
            case 'z':
                startTime = System.currentTimeMillis();
                Utility.shellSort(shapes, comparator.reversed());
                endTime = System.currentTimeMillis();
                break;
                
            default:
                displayError("Invalid sorting algorithm.");
                return;
            }
            
            // Calculate elapsed time and print it
            elapsedTime = endTime - startTime;
            System.out.println("Time taken to sort using " + getSortingAlgorithmName(sortingAlgo) + ": " + elapsedTime + " milliseconds");
            
            if (firstIndex >= 0 && firstIndex < shapes.length && lastIndex >= 0 && lastIndex < shapes.length) {
                GeometricShape firstShape = shapes[firstIndex];
                GeometricShape lastShape = shapes[lastIndex];

                System.out.println("First Shape - Height: " + firstShape.getHeight() + ", Volume: " + firstShape.getVolume() + ", Base Area: " + firstShape.getBaseArea());
                System.out.println("Last Shape - Height: " + lastShape.getHeight() + ", Volume: " + lastShape.getVolume() + ", Base Area: " + lastShape.getBaseArea());
            } else {
                System.out.println("Invalid indices for first and last shapes.");
            }
            
            // Print the sorted shapes
            for (int i = 0; i < shapes.length; i++) {
                GeometricShape shape = shapes[i];
                if (i % 1000 == 0) {
                    System.out.println("Index: " + i + " - Height: " + shape.getHeight() + ", Volume: " + shape.getVolume() + ", Base Area: " + shape.getBaseArea());
                }
            }
            
        } catch (IOException e) {
        	System.out.println("Error reading the file: " + e.getMessage());
        }
	}
	
	//Method to display helpful messages for user when entering incorrect command line.
	private static void displayError(String message) {
		System.out.println("Error: " + message);
		System.out.println("Usage: java -jar sort.jar -f<filename> -t<v/h/s> -s<b/s/i/m/q/z>");
	}
	

    private static String getSortingAlgorithmName(char sortingAlgo) {
        switch (sortingAlgo) {
            case 'b':
                return "Bubble Sort";
            case 's':
                return "Selection Sort";
            case 'i':
                return "Insertion Sort";
            case 'm':
                return "Merge Sort";
            case 'q':
                return "Quick Sort";
            case 'z':
            	return "Shell Sort";
            default:
                return "Unknown Sorting Algorithm";
        }
    }
}
