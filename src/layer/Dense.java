package layer;

import qsor.Vector;

public class Dense {
	
	private double bias;
	
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
	
	public int getSize () {
		return neurons.length;
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
	
	public void updateWeights (double[] lastLA, double learningRate, double error) {
		
		// lastLA is the a values for the last layer (input to the current layer)
		
		for (int i=0; i<neurons.length; i++) {
			
			Neuron currNeuron = neurons[i];
			double[] currWeights = neurons[i].getWeights();
			
			for (int j=0; j<currWeights.length; j++) {
				// For each of the current neurons weights, adjust it according to the error and the output
				double currNeuronOutput = currNeuron.getA();
				
				currWeights[j] -= learningRate * error * currNeuronOutput * lastLA[j] * (1 - lastLA[j]);
			}
			
		}
		
	}
	
	private void initRanBias() {
		bias = Math.random();
	}
	
	// The following methods are only used in testing (now hidden)
	
	private void testSetNeurons (double[][] weights) {
		
		if (weights.length == 1) {
			neurons[0].setWeights(weights[0]);
			return;
		}
		
		for (int r=0; r<neurons.length; r++) {
			double[] weightsForCurrNeuron = weights[r];
			neurons[r].setWeights(weightsForCurrNeuron);
		}
	}
	
	private void testSetBias (double inputBias) {
		bias = inputBias;
	}
	
}
