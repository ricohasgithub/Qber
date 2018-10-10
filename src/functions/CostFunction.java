package functions;

/* Created By Rico Zhu
 * 		The following class is used in the Qber library to perform cost/loss function calculations (e.g., MSE)
 * 		In order to call the methods, use CostFunction.method(Parameter p);
 */

import qsor.Vector;

public class CostFunction {
	
	public static double MSE (double[] p, double[] t) {
		// Mean Squared Error cost function
		if (p.length != t.length) {
			throw new IllegalArgumentException("The predictions and truth vectors must be the same size " 
												+ p.length + " != " + t.length);
		}
		
		double[] predictions = p;
		double[] truth = t;
		
		if (p.length == 1 && t.length == 1) {
			return (truth[0] - predictions[0]);
		}
		
		int m = t.length;
		double error = 0;
		
		for (int i=0; i<m; i++) {
			error += Math.pow(truth[i] - predictions[i], 2);
		}
		
		return error/m;
	}
	
	public static double diff (double p, double t) {
		return Math.pow(t - p, 2);
	}
	
}
