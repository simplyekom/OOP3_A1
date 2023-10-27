package sortingShapes;

import java.util.Comparator;

public abstract class GeometricShape implements Comparable<GeometricShape> {

		// Create abstract methods for subclasses 
		public abstract double getHeight();
		public abstract double getBaseArea();
		public abstract double getVolume();
		
		// Initialize height 
		protected double height;
	
		// Constructor
		public GeometricShape(double height){
			this.height = height;
		}
		
		// Method to compare two shapes by their height
		@Override
		public int compareTo(GeometricShape other) {
			if (this.height > other.height) {
				return 1;
			} else if (this.height < other.height) {
				return -1;
			} else { // this.height == other.height
				return 0;
			}
		}

		public static class shapeComparator implements Comparator<GeometricShape>{
			
			private final char compareType;
			
			// Set compareType from user input
			public shapeComparator(char compareType) {
				this.compareType = compareType;
			}
			
			//Method to compare two shapes by their base area and volume
			//Take user's input from command line to execute the correct method
			@Override
			public int compare(GeometricShape shape1, GeometricShape shape2) {
				
				if (compareType == 'h') {
					return shape1.compareTo(shape2);
				} else if (compareType == 'v') {
					if (shape1.getVolume() > shape2.getVolume()) {
						return 1;
					} else if (shape1.getVolume() < shape2.getVolume()) {
						return -1;
					} else {
						return 0; 
					}
				} else if (compareType == 'a') {
					if (shape1.getBaseArea() > shape2.getBaseArea()) {
						return 1;
					} else if (shape1.getBaseArea() < shape2.getBaseArea()) {
						return -1;
					} else {
						return 0;
					}
				} else {
					throw new IllegalArgumentException(compareType + " is an invalid entry");
				}
			}
		}
}
