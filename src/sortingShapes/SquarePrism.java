package sortingShapes;

public class SquarePrism extends GeometricShape {

	private double height;
	private double edgeLength;
	
	public SquarePrism(double height, double squareEdgeLength) {
		this.height = height;
		this.edgeLength = squareEdgeLength;
	}

	@Override
	public double getHeight() {
		return height; 
	}

    @Override
    public double getBaseArea() {
        // Area of the base of the square prism: edgeLength^2
        return Math.pow(edgeLength, 2);
    }

    @Override
    public double getVolume() {
        // Volume of the square prism: base area * height
        return getBaseArea() * height;
    }

}
