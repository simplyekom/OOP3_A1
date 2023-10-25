package sortingShapes;

public class OctagonalPrism extends GeometricShape {

	private double height;
	private double edgeLength;
	
	public OctagonalPrism(double height, double octagonalEdgeLength) {
		this.height = height;
		this.edgeLength = octagonalEdgeLength;
	}

	@Override
	public double getHeight() {
		return height;
	}


    @Override
    public double getBaseArea() {
        // Area of the base of the   prism: 2 * (1 + √2) * edgeLength^2
        return 2 * (1 + Math.sqrt(2)) * Math.pow(edgeLength, 2);
    }

    @Override
    public double getVolume() {
        // Volume of the octagonal prism: base area * height
        return getBaseArea() * height;
    }

}
