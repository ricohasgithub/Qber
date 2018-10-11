package layer;

/* 	Created By Rico Zhu
 * 	The Neuron object is used to represent a single neurons (similar to Keras)
 * 		There are 2 constructors, one with an input Vector v (used in input layers) and one without (used in hidden and output)
 * 		There are also methods that manipulate weights and add Vectors
 * 		The propagate method is used to transform the z vector into a values to be passed onto the next layer
 */

import functions.*;
import qsor.Vector;

public class Neuron {
	
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

		inputs = v.getValue();
		
		weights = new double[inputs.length];

		initRanWeights();
		
		this.activationFunction = activationFunction;
	}
	
	public Neuron (String activationFunction) {
		this.activationFunction = activationFunction;
	}
	
	public void addVector (Vector v) {
		
		if (v == null) {
			throw new IllegalArgumentException("Input vector cannot be null");
		}
		
		weights = new double[v.size()];
		initRanWeights();
		
		inputs = v.getValue();
	}
	
	public void addVectorNoWeights (Vector v) {
		
		if (v == null) {
			throw new IllegalArgumentException("Input vector cannot be null");
		}
		
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
		
		switch (activationFunction) {
			case "relu":
				a = ActivationFunction.relu(z);
				break;
			case "sigmoid":
				a = ActivationFunction.sigmoid(z);
				break;
			case "tanh":
				a = ActivationFunction.tanh(z);
				break;
			case "softmax":
				a = ActivationFunction.softmax(inputs, z);
				break;
			case "test":
				a = z;
				break;
		}
			
	}
	
	public double getA () {
		return a;
	}
	
	public void setWeights (double[] input) {
		
		weights = new double[input.length];
		
		if (input.length != weights.length) {
			throw new IllegalArgumentException("Input size doesn't match the size of the current layer");
		}
		
		for (int i=0; i<weights.length; i++) {
			weights[i] = input[i];
		}
		
	}
	
	public void adjustWeights (double[] changes) {
		
//		if (changes.length != weights.length) {
//			throw new IllegalArgumentException("The size of the changes array must be equal to the weight array");
//		}
		
		for (int i=0; i<weights.length; i++) {
			System.out.print("\tWeights Before: " + weights[i] + "\t");
			weights[i] += changes[0];
			System.out.print("Weights After: " + weights[i] + "\n");
 		}
		
	}
	
	public double[] getWeights () {
		return weights;
	}
	
	public String toString () {
		
		Vector currNeuron = new Vector(weights);
		
		return "Weights: " + currNeuron;
	}
	
	private void initRanWeights () {
		for (int i=0; i<weights.length; i++) {
			weights[i] = Math.random();
		}
		
	}
	
}