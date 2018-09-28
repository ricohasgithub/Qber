package samples;

import qsor.*;
import model.*;
import layer.*;

public class SampleModelDriver {

	public static void main(String[] args) {
		
		Sequential model = new Sequential();
		
		// Input layer size: 5 Activation Function: Sigmoid  Input Shape / Vector size: 5
		Dense input = new Dense(5, "sigmoid", 5);
		// Hidden layer size: 4 Activation Function: reLu
		Dense hidden1 = new Dense(4, "relu");
		// Hidden layer size: 4 Activation Function: reLu
		Dense hidden2 = new Dense(4, "relu");
		// Output layer size: 1 Activation Function: softmax
		Dense output = new Dense(1, "softmax");
		
		// Add the layers to the Sequential model (in order)
		model.add(input);
		model.add(hidden1);
		model.add(hidden2);
		model.add(output);
			
	}

}
