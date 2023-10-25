package sortingShapes;

public class Pyramid extends GeometricShape {

	private double height;
	private double edgeLength;
	
	public Pyramid(double height, double edgeLengthPyramid) {
		this.height = height;
		this.edgeLength = edgeLengthPyramid;
	} 

	@Override
	public double getHeight() {
		return height;
	}

    @Override
    public double getBaseArea() {
        // Area of the base of the pyramid: edgeLength^2
        return Math.pow(edgeLength, 2);
    }

    @Override
    public double getVolume() {
        // Volume of the pyramid: (1/3) * base area * height
        return (1.0 / 3.0) * getBaseArea() * height;
    }

}
