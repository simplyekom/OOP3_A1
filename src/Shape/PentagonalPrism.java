package Shape;

import sortingShapes.GeometricShape;

public class PentagonalPrism extends GeometricShape {
	
	private double edgeLength;

	public PentagonalPrism(double height, double pentagonalEdgeLength) {
		super(height);
		this.edgeLength	= pentagonalEdgeLength;
	}
 
	@Override
	public double getHeight() {
		return height;
	}

    @Override
    public double getBaseArea() {
        // Area of the base of the pentagonal prism: (5/4) * (edgeLength^2) * (1 / tan(π/5))
        return (5.0 / 4.0) * Math.pow(edgeLength, 2) * (1.0 / Math.tan(Math.PI / 5.0));
    }

    @Override
    public double getVolume() {
        // Volume of the pentagonal prism: base area * height
        return getBaseArea() * height;
    }

}
