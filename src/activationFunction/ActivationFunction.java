package activationFunction;

import qsor.Vector;

public class ActivationFunction {

	public static double sigmoid (double z) {
		// Sigmoid Activation Function
		return 1 / (1 + (Math.pow(Math.E, -z)));
	}
	
	public static double relu (double z) {
		// ReLU Activation Function
		return Math.max(0, z);
	}
	
	public static double softmax (Vector v, double z) {
		// Softmax Activation Function (used for output)
		double[] vals = v.getValue();
		
		double sum = 0;
		for (int i=0; i<v.size(); i++) {
			sum += Math.pow(Math.E, vals[i]);
		}
		
		return Math.pow(Math.E, z) /(sum);
	}
	
	public static double tanh (double z) {
		// TanH Activation Function
		return (Math.pow(Math.E, z) - Math.pow(Math.E, z)) / (Math.pow(Math.E, z) + Math.pow(Math.E, z));
	}
	
}
