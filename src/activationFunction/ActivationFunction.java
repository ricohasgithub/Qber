package activationFunction;

public class ActivationFunction {

	public static double sigmoid (double z) {
		// Sigmoid Activation Function
		return 1 / (1 + (Math.pow(Math.E, -z)));
	}
	
}
