package samples;

import qsor.*;
import model.*;
import functions.*;
import layer.*;

public class SampleModelDriver {

	public static void main(String[] args) {
		
		Sequential model = new Sequential();
		
		/*
		// Input layer size: 5, Activation Function: sigmoid,  Input Shape / Vector size: 5
		Dense input = new Dense(5, "sigmoid", 5);
		// Hidden layer size: 4, Activation Function: reLu
		Dense hidden1 = new Dense(4, "relu");
		// Hidden layer size: 4, Activation Function: reLu
		Dense hidden2 = new Dense(4, "relu");
		// Output layer size: 1, Activation Function: softmax
		Dense output = new Dense(1, "softmax");
		
		// Add the layers to the Sequential model (in order)
		model.add(input);
		model.add(hidden1);
		model.add(hidden2);
		model.add(output);
		*/
		
		Dense input = new Dense(2, "sigmoid");
		Dense output = new Dense(2, "sigmoid");
		
		// w1, w2; w3, w4
		double[][] weights1 = {{0.15, 0.45},
							  {0.25, 0.55}};
		
		double[][] weights2 = {{0.50, 0.60},
				  			  {0.40, 0.35}};
		
		double bias1 = 0.45;
		double bias2 = 0.25;
		
		double[] inputArray = {0.25, 0.05};
		Vector inputV = new Vector(inputArray);
		
//		input.testSetNeurons(weights1);
//		output.testSetNeurons(weights2);
//		
//		input.testSetBias(bias1);
//		output.testSetBias(bias2);
		
		model.add(input);
		model.add(output);
		
		model.train(inputV);
	}

}
