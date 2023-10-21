package application;
import java.io.*;
import java.util.*;

public class SortManager {
	Shape[] shapes;
	
	String fileName;
	char sortType;
	char compareType;
	
	public SortManager(String[] args)
	{
		fileName = "";
	    sortType = '\0';
	    compareType = '\0';
	    sortShapes();

	    for (String arg : args) {
	        if (arg.toLowerCase().startsWith("-f")) {
	            fileName = arg.substring(2);} 
	        else if (arg.toLowerCase().startsWith("-t")) {
	            compareType = arg.toLowerCase().charAt(2);}
	        else if (arg.toLowerCase().startsWith("-s")) {
	            sortType = arg.toLowerCase().charAt(2);}
	    	}
	}
	
	private void sortShapes() {
		fillShapes();
		
		if (sortType == 'b' || sortType == 'B') { // Bubble sort
	        if (compareType == 'h') {
	            Utilities.bubbleSort(shapes);}
	        else if (compareType == 'v') {
	            Utilities.bubbleSort(shapes, new CompareByVolume());}
	        else if (compareType == 'a') {
	            Utilities.bubbleSort(shapes, new CompareByBaseArea());}
	        }
		
		else if (sortType == 's' || sortType == 'S') { // Selection sort
	        if (compareType == 'h') {
	            Utilities.selectionSort(shapes);}
	        else if (compareType == 'v') {
	            Utilities.selectionSort(shapes, new CompareByVolume());}
	        else if (compareType == 'a') {
	            Utilities.selectionSort(shapes, new CompareByBaseArea());}
	        }
		
		else if (sortType == 'i' || sortType == 'I') { // Insertion sort
	        if (compareType == 'h') {
	            Utilities.insertionSort(shapes);}
	        else if (compareType == 'v') {
	            Utilities.insertionSort(shapes, new CompareByVolume());}
	        else if (compareType == 'a') {
	            Utilities.insertionSort(shapes, new CompareByBaseArea());}
	        }
		
		else if (sortType == 'm' || sortType == 'M') { // Merge sort
	        if (compareType == 'h') {
	            Utilities.mergeSort(shapes);}
	        else if (compareType == 'v') {
	            Utilities.mergeSort(shapes, new CompareByVolume());}
	        else if (compareType == 'a') {
	            Utilities.mergeSort(shapes, new CompareByBaseArea());}
	        }
		
		else if (sortType == 'q' || sortType == 'Q') { // Quick sort
	        if (compareType == 'h') {
	            Utilities.quickSort(shapes);}
	        else if (compareType == 'v') {
	            Utilities.quickSort(shapes, new CompareByVolume());}
	        else if (compareType == 'a') {
	            Utilities.quickSort(shapes, new CompareByBaseArea());}
	        }
		
		else if (sortType == 'z' || sortType == 'Z') { // Shell sort
			if (compareType == 'h') {
	            Utilities.shellSort(shapes);}
	        else if (compareType == 'v') {
	            Utilities.shellSort(shapes, new CompareByVolume());}
	        else if (compareType == 'a') {
	            Utilities.shellSort(shapes, new CompareByBaseArea());}
	    	}
	}
	
	public class CompareByVolume implements Comparator<Shape> {
	    @Override
	    public int compare(Shape shape1, Shape shape2) {
	        if (shape1.getVolume() > shape2.getVolume())
	            return 1;
	        else if (shape1.getVolume() < shape2.getVolume())
	            return -1;
	        else
	            return 0;
	    }
	}
	
	public class CompareByBaseArea implements Comparator<Shape> {
	    @Override
	    public int compare(Shape shape1, Shape shape2) {
	        if (shape1.getBaseArea() > shape2.getBaseArea())
	            return 1;
	        else if (shape1.getBaseArea() < shape2.getBaseArea())
	            return -1;
	        else
	            return 0;
	    	}
	}

	private void fillShapes() {
		List<Shape> shapeList = new ArrayList<>();

	    try {
	        File file = new File(fileName);
	        Scanner scanner = new Scanner(file);

	        while (scanner.hasNextLine()) {
	            String line = scanner.nextLine();
	            String[] shapeData = line.split(","); // Assuming the shape data is comma-separated

	            // Assuming the shape data format is: shapeType,x,y,z
	            String shapeType = shapeData[0];
	            double x = Double.parseDouble(shapeData[1]);
	            double y = Double.parseDouble(shapeData[2]);

	            Shape shape;

	            if (shapeType.equals("Cylinder")) {
	                shape = new Cylinder(x, y);
	            } else if (shapeType.equals("Cone")) {
	                shape = new Cone(x, y);
	            } else if (shapeType.equals("OctagonalPrism")) {
	                shape = new OctagonalPrism(x, y);
	            } else if (shapeType.equals("PentagonalPrism")) {
	                shape = new PentagonalPrism(x, y);
	            } else if (shapeType.equals("TriangularPrism")) {
	                shape = new TriangularPrism(x, y);
	            } else if (shapeType.equals("SquarePrism")) {
	                shape = new SquarePrism(x, y);
	            } else if (shapeType.equals("Pyramid")) {
	                shape = new Pyramid(x, y);
	            } else {
	                // Handle unrecognized shape type
	                continue;
	            }

	            shapeList.add(shape);
	        }

	        scanner.close();
	    } catch (FileNotFoundException e) {
	        System.out.println("File not found: " + fileName);
	        e.printStackTrace();
	    }

	    shapes = shapeList.toArray(new Shape[0]);
	}
}
