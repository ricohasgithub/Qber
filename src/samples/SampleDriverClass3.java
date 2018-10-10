package samples;

import layer.Dense;
import model.Sequential;
import qsor.Vector;

public class SampleDriverClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sequential model = new Sequential();
		
		Dense input = new Dense(2, "sigmoid");
		Dense hidden = new Dense(2, "sigmoid");
		Dense output = new Dense(2, "sigmoid");
		
		double[] inputArray = {0.5, 0.3};
		Vector inputV = new Vector(inputArray);
		
		double[] truthArray = {0.25, 0.1};
		Vector truthV = new Vector(truthArray);
		
		model.add(input);
		model.add(hidden);
		model.add(output);
		
		model.train(inputV, truthV, "MSE", 10, 0.1);
	}
	
}
