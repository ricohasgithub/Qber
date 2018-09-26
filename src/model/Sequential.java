package model;

import layer.Dense;

public class Sequential {

	public static class LayerCollection {
		
		LayerCollection previous;
		LayerCollection next;
		
		Dense layer;
		
		public LayerCollection (Dense layer) {
			// Default Constructor
			this.layer = layer;
			
			previous = null;
			next = null;
		}
		
		public boolean isEmpty () {
			return layer == null;
		}
		
	}
	
}
