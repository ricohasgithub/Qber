package layer;

/* 	Created By Rico Zhu
 * 	The Dense object is used to represent a single layer of neurons (similar to Keras)
 * 		There are 2 constructors, one with an inputShape parameter (for input layers) and one without
 * 		There are also methods that manipulate weights (used in forward and back propagation)
 */

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

	public double[] feedAndGetA (Vector v, boolean first) {
		
		double[] a = new double[neurons.length];

		if (first) {
			// First iteration, initialize the random weights
			for (int i=0; i<neurons.length; i++) {
				Neuron curr = neurons[i];
				curr.addVector(v);
				curr.propagate(bias);
				a[i] = curr.getA();
			}
		} else {
			// Add the input vector without initializing the random weights
			for (int i=0; i<neurons.length; i++) {
				Neuron curr = neurons[i];
				curr.addVectorNoWeights(v);
				curr.propagate(bias);
				a[i] = curr.getA();
			}
		}

		return a;
	}

	public void updateWeights (double[] lastLA, double learningRate, double error) {

		// lastLA is the a values for the last layer (input to the current layer)
		for (int i=0; i<neurons.length; i++) {

			Neuron currNeuron = neurons[i];
			
			double[] currWeights = currNeuron.getWeights();

			for (int k=0; k<lastLA.length; k++) {
				// For each output / neuron in the last layer
				
				double lastOutput = lastLA[k];
				
				for (int j=0; j<currWeights.length; j++) {
					// For each of the current neurons weights, adjust it according to the error and the output
					double currNeuronOutput = currNeuron.getA();

					double oldW = currWeights[j];

					oldW += (error * learningRate * error * lastOutput * currNeuronOutput * (1 - currNeuronOutput));

					// currWeights[j] += learningRate * error * currNeuronOutput * lastLA[j] * (1 - lastLA[j]);
					currWeights[j] = oldW;
				}
				
			}

		}

	}
	
	public void updateWeightsRan (double[] lastLA, double learningRate, double error) {

		// lastLA is the a values for the last layer (input to the current layer)
		for (int i=0; i<neurons.length; i++) {
			System.out.println("\tCurr Neuron: " + i);
			Neuron currNeuron = neurons[i];
			
			if (error < 0) {
				// Negative error, decrease weights
				currNeuron.adjustWeights(new double[]{-0.001, 1});
			} else {
				currNeuron.adjustWeights(new double[]{0.001, 1});
			}

		}

	}
	
	public void printNeurons () {
		for (int i=0; i<neurons.length; i++) {
			System.out.println("\t" + neurons[i]);
		}
	}

	private void initRanBias() {
		// bias = Math.random();
		bias = 0;
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
