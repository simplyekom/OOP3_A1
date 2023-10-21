package application;

public class Main {

	public static void main(String[] args) {
	}
	
	// MUST DOUBLE CHECK FORMULAS
	
	public class Cylinder extends Shape {
		
		public Cylinder(double height, double edgeOrRad) {
			super(height, edgeOrRad);
		}

		public double getBaseArea() {
			return Math.PI * Math.pow(getEdgeOrRad(), 2); // Math.pow(a,b) = a^b
		}
		
		public double getVolume() {
			return Math.PI * Math.pow(getEdgeOrRad(), 2) * getHeight();
		}
	}
	
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
	
	public class SquarePrism extends Shape {
		
		public SquarePrism(double height, double edgeOrRad) {
			super(height, edgeOrRad);
		}
		
		public double getBaseArea() {
            return Math.pow(getEdgeOrRad(), 2);
        }
		
		public double getVolume() {
            return getBaseArea() * getHeight();
        }
	}
	
	public class TriangularPrism extends Shape {
		
		public TriangularPrism(double height, double edgeOrRad) {
			super(height, edgeOrRad);
		}
		
		public double getBaseArea() {
            return (Math.sqrt(3) / 4) * Math.pow(getEdgeOrRad(), 2);
        }

        public double getVolume() {
            return getBaseArea() * getHeight();
        }
	}
	
	public class PentagonalPrism extends Shape {
		
		public PentagonalPrism(double height, double edgeOrRad) {
			super(height, edgeOrRad);
		}
		
		public double getBaseArea() {
	            return (Math.sqrt(25 + 10 * Math.sqrt(5)) / 4) * Math.pow(getEdgeOrRad(), 2);
		}
	
        public double getVolume() {
            return getBaseArea() * getHeight();
        }
	}
	
	public class OctagonalPrism extends Shape {
		
		public OctagonalPrism(double height, double edgeOrRad) {
			super(height, edgeOrRad);
		}
		
		public double getBaseArea() {
            return 2 * (1 + Math.sqrt(2)) * Math.pow(getEdgeOrRad(), 2);
        }

        public double getVolume() {
            return getBaseArea() * getHeight();
        }
	}
	
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
}
