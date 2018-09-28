package layer;

import qsor.Vector;

public class Dense {
	
	private double bias;
	
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
		
		initRanBias();
	}
	
	public Dense (int size, String activationFunction) {
		// Hidden / Output Layer
		neurons = new Neuron[size];
		
		for (int i=0; i<neurons.length; i++) {
			neurons[i] = new Neuron(activationFunction);
		}
		
		initRanBias();
	}
	
	public double[] getAArray () {
		
		double[] a = new double[neurons.length];
		
		for (int i=0; i<a.length; i++) {
			a[i] = neurons[i].getA();
		}
		
		return a;
	}
	
	public double[] feedAndGetA (Vector v) {
		
		double[] a = new double[neurons.length];
		
		for (int i=0; i<neurons.length; i++) {
			Neuron curr = neurons[i];
			curr.addVector(v);
			curr.propagate(bias);
			a[i] = curr.getA();
		}
		
		return a;
	}
	
	private void initRanBias() {
		bias = Math.random();
	}
	
	// The following methods are only used in testing (now hidden)
	
	public void testSetNeurons (double[][] weights) {
		for (int r=0; r<neurons.length; r++) {
			double[] weightsForCurrNeuron = weights[r];
			neurons[r].setWeights(weightsForCurrNeuron);
		}
	}
	
	public void testSetBias (double inputBias) {
		bias = inputBias;
	}
	
}
