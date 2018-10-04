package model;

import java.util.ArrayList;

import layer.Dense;
import layer.Layer;
import layer.Neuron;
import functions.CostFunction;

import qsor.Vector;

public class Sequential {

	ArrayList<Dense> layers;
	Dense[] propLayers;

	String optimizer;
	String costFunction;

	double error;
	double learningRate;

	double[] predictions;
	double[] truth;

	public Sequential () {
		layers = new ArrayList<Dense>();
	}
	
	public Sequential (double learningRate) {
		layers = new ArrayList<Dense>();
		this.learningRate = learningRate;
	}

	public void add (Dense layer) {
		layers.add(layer);
	}

	public void add (Dense layer, String type) {
		layers.add(layer);
	}

	public boolean isEmpty () {
		return layers.isEmpty();
	}

	public void compile (String opt, String costF) {
		optimizer = opt;
		costFunction = costF;
	}

	public void train (Vector input, Vector truth, String costFunction, double learningRate) {

		if (input.isEmpty() || truth.isEmpty()) {
			throw new IllegalArgumentException("Input vector cannot be empty");
		}

		this.learningRate = learningRate;
		this.costFunction = costFunction;
		
		forwardProp(input);
		
		updateCurrError(costFunction);

		backProp(100);
		
	}
	
	public void train (Vector input, Vector truth, String costFunctions, int epochs, double learningRate) {

		if (input.isEmpty() || truth.isEmpty()) {
			throw new IllegalArgumentException("Input vector cannot be empty");
		}

		this.learningRate = learningRate;
		
		forwardProp(input);
		
		updateCurrError(costFunction);

		backProp(epochs);
		
	}

	private void forwardProp (Vector input) {
		
		initPropLayers();

		// Initial Layer
		double[] prevA = propLayers[0].feedAndGetA(input);

		System.out.println();

		for (int i=1; i<propLayers.length; i++) {
			// Repeatedly feed forward a new Vector created from the a values of the previous layer
			prevA = propLayers[i].feedAndGetA(new Vector(prevA));
		}

		Vector output = new Vector(propLayers[propLayers.length-1].getAArray());
		predictions = output.getValue();

		System.out.println(output);
	}
	
	private void backProp (int epochs) {
		
		if (propLayers.length == 0) {
			// Forward Propagation hasn't been called yet
			throw new IllegalArgumentException("Must call forward propagation first");
		}
		
		/* 
		 * During each epoch, iterate backwards through the network and update values
		 * then calculate the new error term and repeat
		 */
		
		for (int e=0; e<epochs; e++) {
			
			for (int i=propLayers.length-1; i>=1; i--) {
				
				Dense currL = propLayers[i];
				Dense lastL = propLayers[i-1];
				
				// Output of the current layer
				double[] currLOutput = currL.getAArray();
				
				// For each of the current layer's output, adjust its corresponding weights
				for (int j=0; j<currLOutput.length; j++) {
					// Update every output / neuron of the previous layer with respect to the current neuron's value
					lastL.updateWeights(learningRate, error, currLOutput[j]);
				}
				
			}
			
			updateCurrError(costFunction);
			
			System.out.println("Epoch: " + e + "\t Error: " + error);
			
		}
		
	}
	
	private void updateCurrError (String costFunction) {
		
		if (predictions.length == 0 || truth.length == 0) {
			throw new IllegalArgumentException("Model has not been trained yet");
		}
		
		switch (costFunction) {
			case ("MSE"):
				error = CostFunction.MSE(new Vector(predictions), new Vector(truth));
				break;
			case ("Cross Entrophy"):
				break;
		}
		
	}

	private void initPropLayers() {
		// Initialize the Dense Layer array where propagation will happen
		propLayers = new Dense[layers.size()];

		for (int i=0; i<layers.size(); i++) {
			propLayers[i] = layers.get(i);
		}

	}
}
