package layer;

import activationFunction.ActivationFunction;
import qsor.Vector;

public class Neuron {

	private static Vector input;
	
	private static double bias;
	private static double[] inputs;
	private static double[] weights;
	private static String activationFunction;
	
	private static double z;
	private static double a;
	
	public Neuron (Vector v, String activationFunction) {
		// Initializes all of the instance variables and initializes the weights and bias to random valus between 0 and 1
		input = v;
		inputs = v.getValue();
		
		initRanWeights();
		initRanBias();
		
		this.activationFunction = activationFunction;
	}
	
	public Neuron (String activationFunction) {
		
		initRanWeights();
		initRanBias();
		
		this.activationFunction = activationFunction;
	}
	
	public void add (Vector v) {
		input = v;
		inputs = v.getValue();
	}
	
	public void propagate () {
		// Applies the activation function to the current neuron (used in propagation)
		
		for (int i=0; i<inputs.length; i++) {
			/* Dot Product:
					x = input
					w = weight
					z = (x * w) + b
			*/
			z += inputs[i] * weights[i];
		}
		
		z += bias;
		
		switch (activationFunction){
			case "relu":
				a = ActivationFunction.relu(z);
			case "sigmoid":
				a = ActivationFunction.sigmoid(z);
			case "tanh":
				a = ActivationFunction.tanh(z);
			case "softmax":
				a = ActivationFunction.softmax(input, z);
		}
		
		a += bias;
			
	}
	
	public double getA () {
		if (a == 0) {
			propagate();
		}
		return a;
	}
	
	private void initRanWeights () {
		for (int i=0; i<weights.length; i++) {
			weights[i] = Math.random();
		}
	}

	private void initRanBias() {
		bias = Math.random();
	}
	
}