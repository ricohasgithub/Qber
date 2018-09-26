package model;

import java.util.ArrayList;

import layer.Dense;
import layer.Layer;

public class Sequential {
	
	ArrayList<Layer> layers;
	
	public Sequential () {
		layers = new ArrayList<Layer>();
	}
	
	public void add (Layer layer) {
		
	}
	
	public boolean isEmpty () {
		return layers.isEmpty();
	}
	
}
