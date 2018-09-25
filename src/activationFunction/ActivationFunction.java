package activationFunction;

public class ActivationFunction {

	public static double sigmoid (double z) {
		// Sigmoid Activation Function
		return 1 / (1 + (Math.pow(Math.E, -z)));
	}
	
	public static double relu (double z) {
		// ReLU Activation Function
		return Math.max(0, z);
	}
	
}
