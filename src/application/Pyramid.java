package application;

public class Pyramid extends Shape {

	public Pyramid(double height, double edgeOrRad) {
		super(height, edgeOrRad);
	}
	
	public double getBaseArea() {
        return Math.pow(getEdgeOrRad(), 2);
    }

    public double getVolume() {
        return (1.0 / 3.0) * getBaseArea() * getHeight();
    }
}