package Shape;

import sortingShapes.GeometricShape;

public class TriangularPrism extends GeometricShape {

	private double edgeLength;
	
	public TriangularPrism(double height, double triangularEdgeLength) {
		super(height);
		this.edgeLength = triangularEdgeLength;
	}

	@Override
	public double getHeight() {
		return height;
	}


    @Override
    public double getBaseArea() { 
        // Area of the base of the triangular prism: (sqrt(3) / 4) * edgeLength^2
        return (Math.sqrt(3) / 4) * Math.pow(edgeLength, 2);
    }

    @Override
    public double getVolume() {
        // Volume of the triangular prism: base area * height
        return getBaseArea() * height;
    }

}
