package sortingShapes;

public class Cylinder extends GeometricShape {
	
	private double height;
	private double radius;

	public Cylinder(double height, double radiusCylinder) {
		this.height = height;
		this.radius = radiusCylinder;
	}

	@Override
	public double getHeight() {
		return height;
	}

    @Override
    public double getBaseArea() {
        // Area of the base of the cylinder: π * radius^2
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getVolume() {
        // Volume of the cylinder: π * radius^2 * height
        return Math.PI * Math.pow(radius, 2) * height;
    }

}
