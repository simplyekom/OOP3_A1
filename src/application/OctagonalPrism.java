package application;

public class OctagonalPrism extends Shape {
	
	public OctagonalPrism(double height, double edgeOrRad) {
		super(height, edgeOrRad);
	}
	
	public double getBaseArea() {
        return 2 * (1 + Math.sqrt(2)) * Math.pow(getEdgeOrRad(), 2);
    }

    public double getVolume() {
        return getBaseArea() * getHeight();
    }
}