package functions;

/* Created By Rico Zhu
 * 		The following class is used in the Qber library to perform activation function calculations (e.g., sigmoid, tanh .etc)
 * 		In order to call the methods, use ActivationFunction.method(Parameter p);
 */

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
	
	public static double softmax (double[] vals, double z) {
		// Softmax Activation Function (used for output)
		
		double sum = 0;
		for (int i=0; i<vals.length; i++) {
			sum += Math.pow(Math.E, vals[i]);
		}
		
		return Math.pow(Math.E, z) /(sum);
	}
	
	public static double tanh (double z) {
		// TanH Activation Function
		return (Math.pow(Math.E, z) - Math.pow(Math.E, z)) / (Math.pow(Math.E, z) + Math.pow(Math.E, z));
	}
	
}
