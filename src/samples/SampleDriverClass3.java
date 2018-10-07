package samples;

import layer.Dense;
import model.Sequential;
import qsor.Vector;

public class SampleDriverClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sequential model = new Sequential();
		
		Dense input = new Dense(1, "test");
//		Dense hidden = new Dense(1, "test");
		Dense output = new Dense(1, "test");
		
		double[] inputArray = {0.5};
		Vector inputV = new Vector(inputArray);
		
		double[] truthArray = {0.7};
		Vector truthV = new Vector(truthArray);
		
		model.add(input);
//		model.add(hidden);
		model.add(output);
		
		model.train(inputV, truthV, "MSE", 10, 0.1);
	}
	
}
