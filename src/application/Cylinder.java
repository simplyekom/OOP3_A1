package application;

public class Cylinder extends Shape {
	
	public Cylinder(double height, double edgeOrRad) {
		super(height, edgeOrRad);
	}

	public double getBaseArea() {
		return Math.PI * Math.pow(getEdgeOrRad(), 2); // Math.pow(a,b) = a^b
	}
	
	public double getVolume() {
		return Math.PI * Math.pow(getEdgeOrRad(), 2) * getHeight();
	}
}