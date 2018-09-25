package layer;

import activationFunction.ActivationFunction;
import qsor.Vector;

public class Dense {

	double[] inputs;
	double[] weights;
	String activationFunction;
	
	public Dense (Vector v, String activationFunction) {
		inputs = v.getValue();
		this.activationFunction = activationFunction;
	}
	
}
