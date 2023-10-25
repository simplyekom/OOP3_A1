package sortingShapes;

import java.util.Comparator;

public abstract class GeometricShape implements Comparable<GeometricShape> {

		public abstract double getHeight();
		public abstract double getBaseArea();
		public abstract double getVolume();
		
		//Method to compare two shapes by their height
		@Override
		public int compareTo(GeometricShape other) {
			return Double.compare(getHeight(), other.getHeight());
		}
		
		public static class shapeComparator implements Comparator<GeometricShape>{
			
			private final char compareType;
			
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
					return Double.compare(shape1.getVolume(), shape2.getVolume());
				} else if (compareType == 'a') {
					return Double.compare(shape1.getBaseArea(), shape2.getBaseArea());
				} else {
					throw new IllegalArgumentException(compareType + " is an invalid entry");
				}
			}
		}
}
