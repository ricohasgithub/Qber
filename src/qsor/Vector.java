package qsor;

public class Vector extends Tensor {

	private static double[] values;
	
	public Vector (double[] values) {
		this.values = values;
	}
	
	public Tensor dot(Tensor that) {
		// Iterate through
		return null;
	}

	public void norm() {
		
		double min = getMinFromVal();
		double max = getMaxFromVal();
		
		for (int i=0; i<values.length; i++) {
			double z = values[i];
			z = (z - min) / (max - min);
			values[i] = z;
		}
		
	}

	private static double getMaxFromVal () {
		
		double max = Integer.MIN_VALUE;
		
		for (int i=0; i<values.length; i++) {
			if (values[i] > max) {
				max = values[i];
			}
		}
		
		return max;
	}
	
	private static double getMinFromVal () {
		
		double min = Integer.MAX_VALUE;
		
		for (int i=0; i<values.length; i++) {
			if (values[i] < min) {
				min = values[i];
			}
		}
		
		return min;
	}

}
