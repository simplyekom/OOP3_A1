package shape;

import sortingShapes.GeometricShape;

public class Cone extends GeometricShape {

	private double radius;
	
	public Cone(double height, double radiusCone) {
		super(height);
		this.radius = radiusCone; 
	}

	@Override
	public double getHeight() {
		return height;
	}

    @Override
    public double getBaseArea() {
        // Area of the base of the cone: π * radius^2
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
        // Volume of the cone: (1/3) * π * radius^2 * height
        return (1.0 / 3.0) * Math.PI * Math.pow(radius, 2) * height;
    }

}
