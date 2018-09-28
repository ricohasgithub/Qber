package layer;

import activationFunction.ActivationFunction;
import qsor.Vector;

public class Neuron {

	private Vector input;
	
	private double[] inputs;
	private double[] weights;
	private String activationFunction;
	
	private double z;
	private double a;
	
	public Neuron (Vector v, String activationFunction) {
		// Initializes all of the instance variables and initializes the weights and bias to random valus between 0 and 1
		
		if (activationFunction.isEmpty()) {
			throw new IllegalArgumentException("Activation Function must not be empty");
		}
		
		input = v;
		inputs = v.getValue();
		
		initRanWeights();
		
		this.activationFunction = activationFunction;
	}
	
	public Neuron (String activationFunction) {
		
		// initRanWeights();
		
		this.activationFunction = activationFunction;
	}
	
	public void add (Vector v) {
		
		if (v == null) {
			throw new IllegalArgumentException("Input vector cannot be null");
		}
		
		input = v;
		inputs = v.getValue();
	}
	
	public void propagate (double bias) {
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
		return a;
	}
	
	public void setWeights (double[] input) {
		
		if (input.length != weights.length) {
			throw new IllegalArgumentException("Input size doesn't match the size of the current layer");
		}
		
		for (int i=0; i<weights.length; i++) {
			weights[i] = input[i];
		}
		
	}
	
	public void adjustWeights (Vector changes) {
		/* TODO */
	}
	
	private void initRanWeights () {
		
		weights = new double[input.size()];
		
		for (int i=0; i<weights.length; i++) {
			weights[i] = Math.random();
		}
		
	}
	
}