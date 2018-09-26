package model;

import java.util.ArrayList;

import layer.Layer;

import qsor.Vector;

public class Sequential {
	
	ArrayList<Layer> layers;
	String layerType;
	
	public Sequential () {
		layers = new ArrayList<Layer>();
	}
	
	public void add (Layer layer, String type) {
		layers.add(layer);
		layerType = type;
	}
	
	public boolean isEmpty () {
		return layers.isEmpty();
	}
	
	public void train (Vector input, int epochs) {
		
		double[] inputVal = input.getValue();
		
		for (int e=0; e<epochs; e++) {
			Layer curr = layers.get(e);
			
			if (type.equals("Dense")) {
				
			}
			
		}
		
	}
	
}
