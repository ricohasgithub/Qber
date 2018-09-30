package functions;

import qsor.Vector;

public class CostFunction {
	
	public static double MSE (Vector p, Vector t) {
		// Mean Squared Error cost function
		
		if (p.size() != t.size()) {
			throw new IllegalArgumentException("The predictions and truth vectors must be the same size " 
												+ p.size() + " != " + t.size());
		}
		
		double[] predictions = p.getValue();
		double[] truth = t.getValue();
		
		int m = t.size();
		double error = 0;
		
		for (int i=0; i<m; i++) {
			error += Math.sqrt(truth[i] - predictions[i]);
		}
		
		return error/m;
	}
	
}
