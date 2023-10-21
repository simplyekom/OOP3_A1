package application;

public class Cone extends Shape {
	
	public Cone(double height, double edgeOrRad) {
		super(height, edgeOrRad);
	}
	
	public double getBaseArea() {
            return Math.PI * Math.pow(getEdgeOrRad(), 2);
	}

    public double getVolume() {
        return (1.0 / 3.0) * Math.PI * Math.pow(getEdgeOrRad(), 2) * getHeight();
    }
}
