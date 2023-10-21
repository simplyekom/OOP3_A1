package application;

public class SquarePrism extends Shape {
	
	public SquarePrism(double height, double edgeOrRad) {
		super(height, edgeOrRad);
	}
	
	public double getBaseArea() {
        return Math.pow(getEdgeOrRad(), 2);
    }
	
	public double getVolume() {
        return getBaseArea() * getHeight();
    }
}