package model;

import java.util.ArrayList;

import layer.Dense;
import layer.Layer;

import qsor.Vector;

public class Sequential {
	
	ArrayList<Dense> layers;
	Dense[] propLayers;
	
	String layerType;
	
	public Sequential () {
		layers = new ArrayList<Dense>();
	}
	
	public void add (Dense layer) {
		layers.add(layer);
	}
	
	public void add (Dense layer, String type) {
		layers.add(layer);
		layerType = type;
	}
	
	public boolean isEmpty () {
		return layers.isEmpty();
	}
	
	public void train (Vector input) {
		
		if (input.isEmpty()) {
			throw new IllegalArgumentException("Input vector cannot be empty");
		}
		
		initPropLayers();
		
		// Initial Layer
		double[] prevA = propLayers[0].feedAndGetA(input);
		
		for (int i=0; i<propLayers.length; i++) {
			
		}
		
		Vector output = new Vector(propLayers[propLayers.length-1].getAArray());
		System.out.println(output);
		
	}
	
	private void initPropLayers() {
		// Initialize the Dense Layer array where propagation will happen
		propLayers = new Dense[layers.size()];
		
		for (int i=0; i<layers.size(); i++) {
			propLayers[i] = layers.get(i);
		}
		
	}
}
