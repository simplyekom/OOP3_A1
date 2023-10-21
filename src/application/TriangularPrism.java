package application;

public class TriangularPrism extends Shape {
	
	public TriangularPrism(double height, double edgeOrRad) {
		super(height, edgeOrRad);
	}
	
	public double getBaseArea() {
        return (Math.sqrt(3) / 4) * Math.pow(getEdgeOrRad(), 2);
    }

    public double getVolume() {
        return getBaseArea() * getHeight();
    }
}