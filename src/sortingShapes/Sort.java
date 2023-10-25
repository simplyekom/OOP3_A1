package sortingShapes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Sort {

	public static void main(String[] args) {
		
        if (args.length < 2 || !args[0].equals("-f")) {
            System.out.println("Usage: java -jar Sort.jar -f <filename> -t <v/h/s> -s <b/s/i/m/q/z>");
            return;
        }
		
		String fileName = args[1];
		char comparisonType = 'h'; //Default comparison type (height)
		char sortingAlgo = 'b'; //Default sorting algorithm (bubble)
		
		for (int i = 0; i < args.length; i++) {
			String arg = args[i].toLowerCase(); //Convert to lower case in case user enters capitals
			
			switch (arg) {
				case "-f":
					if (i + 1 < args.length) {
						fileName = args[i+1];
						i++; //Skips the filename
					} else {
						displayError("Missing file name after -f option.");
						return;
					}
					break;
				case "-t":
					if (i + 1 < args.length) {
						char type = args[i + 1].toLowerCase().charAt(0);
						if (type == 'v' || type == 'h' || type == 'a') {
							comparisonType = type;
							i++; //Skips the comparison type
						} else {
							displayError("Invalid comparison type. Use v (volume), h (height), a (base area).");
							return;
						}
					} else {
						displayError("Missing comparison type after -t option.");
						return;
					}
					break;
				case "-s":
					if (i + 1 < args.length) {
						char algo = args[i + 1].toLowerCase().charAt(0);
						if ("bsimqz".contains(String.valueOf(algo))) {
							sortingAlgo = algo;
							i++; //Skips the sorting algorithm
						} else {
							displayError("Invalid sorting algorithm. Use b (bubble), s (selection), i (insertion), m (merge), q (quick), or z (your choice).");
							return;
						}
					} else {
						displayError("Missing comparison type after -s option.");
						return;
					}
					break;
				default:
					displayError("Invalid option: " + args[i]);
					return;
			}	
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
            
            // Iterate through the shapes array and print specific shapes
            for (GeometricShape shape : shapes) {
                // Check the type of the shape
                if (shape instanceof Cylinder) {
                    Cylinder cylinder = (Cylinder) shape;
                    System.out.println("Cylinder - Height: " + cylinder.getHeight() + ", Base Area: " + cylinder.getBaseArea());
                } else if (shape instanceof Cone) {
                    Cone cone = (Cone) shape;
                    System.out.println("Cone - Height: " + cone.getHeight() + ", Base Area: " + cone.getBaseArea());
                }
            }
            
            //Part A - 3
            // Sort the shapes array based on the comparison type in descending order
            Comparator<GeometricShape> comparator = new GeometricShape.shapeComparator(comparisonType);
            Arrays.sort(shapes, Collections.reverseOrder(comparator));

            // Print the sorted shapes
            for (GeometricShape shape : shapes) {
                System.out.println("Height: " + shape.getHeight() + ", Volume: " + shape.getVolume() + ", Base Area: " + shape.getBaseArea());
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
}
