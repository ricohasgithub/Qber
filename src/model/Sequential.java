package model;

import java.util.ArrayList;

import layer.Dense;
import layer.Layer;

import functions.CostFunction;

import qsor.Vector;

public class Sequential {

	ArrayList<Dense> layers;
	Dense[] propLayers;

	String optimizer;
	String costFunction;

	double error;

	double[] predictions;
	double[] truth;

	public Sequential () {
		layers = new ArrayList<Dense>();
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

	public void train (Vector input, Vector truth) {

		if (input.isEmpty() || truth.isEmpty()) {
			throw new IllegalArgumentException("Input vector cannot be empty");
		}

		forwardProp(input);
		
		updateCurrError();

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
	
	private void backProp () {
		
		if (propLayers.length == 0) {
			// Forward Propagation hasn't been called yet
			throw new IllegalArgumentException("Must call forward propagation first");
		}
		
	}
	
	private void updateCurrError () {

		if (predictions.length == 0 || truth.length == 0) {
			throw new IllegalArgumentException("Model has not been trained yet");
		}

		error = CostFunction.MSE(new Vector(predictions), new Vector(truth));
	}

	private void initPropLayers() {
		// Initialize the Dense Layer array where propagation will happen
		propLayers = new Dense[layers.size()];

		for (int i=0; i<layers.size(); i++) {
			propLayers[i] = layers.get(i);
		}

	}
}
