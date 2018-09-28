package model;

import java.util.ArrayList;

import layer.Dense;
import layer.Layer;

import qsor.Vector;

public class Sequential {
	
	ArrayList<Dense> layers;
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
		
		// double[] inputVal = input.getValue();
		double[] prevA = new double[input.size()];
		
		double output = 0;
		
		// Forward Propagation
		for (Dense d : layers) {
			prevA = d.feedAndGetA(input);
			
		}
		
	}
	
}
