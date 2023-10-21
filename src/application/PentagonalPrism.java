package application;

public class PentagonalPrism extends Shape {
	
	public PentagonalPrism(double height, double edgeOrRad) {
		super(height, edgeOrRad);
	}
	
	public double getBaseArea() {
            return (Math.sqrt(25 + 10 * Math.sqrt(5)) / 4) * Math.pow(getEdgeOrRad(), 2);
	}

    public double getVolume() {
        return getBaseArea() * getHeight();
    }
}