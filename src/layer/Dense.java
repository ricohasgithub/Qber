package layer;

import qsor.Vector;

public class Dense {
	
	private double[] previous;
	private Neuron[] neurons;
	
	public Dense (int size, String activationFunction, int inputShape) {
		/* Input Layer
			The size parameter is the size of the layer (how many neurons there are)
			The activationFunction parameter specifies what function to use for propagation
			The inputShape parameter is used to determine the size of the vectors
		*/
		neurons = new Neuron[size];
		
		for (int i=0; i<neurons.length; i++) {
			neurons[i] = new Neuron(new Vector(inputShape), activationFunction);
		}
	}
	
	public Dense (int size, String activationFunction) {
		// Hidden / Output Layer
		neurons = new Neuron[size];
		
		for (int i=0; i<neurons.length; i++) {
			neurons[i] = new Neuron(activationFunction);
		}
	}
	
	public double[] getAVal () {
		
		double[] a = new double[neurons.length];
		
		for (int i=0; i<a.length; i++) {
			a[i] = neurons[i].getA();
		}
		
		return a;
	}
	
}
