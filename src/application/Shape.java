package application;

public abstract class Shape implements Comparable<Shape> {
    public abstract double getBaseArea();
    public abstract double getVolume();
    
    public double height;
    public double edgeOrRad; // Represents the second number being edge length or radius
    
    public Shape(double height, double edgeOrRad) {
    	this.height = height;
    	this.edgeOrRad = edgeOrRad;
    }
    
    public double getHeight() {
    	return this.height;
    }
    
    public double getEdgeOrRad() {
    	return this.edgeOrRad;
    }
    
    @Override
    public int compareTo(Shape secondShape) {
    	if (this.height > secondShape.height)
    		return 1; //Current shape is greater
    	else if (this.height < secondShape.height)
            return -1; //Current shape is smaller
        else
            return 0; //Both shapes are equal
    }
    
    @Override
    public boolean[] compare(Shape secondShape) {
    	boolean[] toReturn = new boolean[2];
    		/*A boolean array named `toReturn` is created with a size of 2.
    		This array will store the comparison results for base area and volume.*/
    	
    	if (this.getBaseArea() > secondShape.getBaseArea())
    		toReturn[0] = true;
    	else
    		toReturn[0] = false;
    		/*If the base area of `this` is greater than the base area of `secondShape`,
    		`true` is assigned to the first element of the `toReturn` array.
    		Otherwise, `false` is assigned.*/
    	
    	if (this.getVolume() > secondShape.getVolume())
    		toReturn[1] = true;
    	else
    		toReturn[1] = false;
    		/*If the volume of `this` is greater than the volume of `secondShape`,
    		`true` is assigned to the second element (`toReturn[1]`) of the `toReturn` array.
    		Otherwise, `false` is assigned.*/
    	
    	return toReturn;
    }
}