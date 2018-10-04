package samples;

import layer.Dense;
import model.Sequential;
import qsor.Vector;

public class SampleDriverClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sequential model = new Sequential();
		
		Dense input = new Dense(3, "sigmoid");
		Dense hidden = new Dense(4, "sigmoid");
		Dense hidden2 = new Dense(4, "sigmoid");
		Dense output = new Dense(1, "sigmoid");
		
		double[] inputArray = {0.45, 0.12, 0.67};
		Vector inputV = new Vector(inputArray);
		
		double[] truthArray = {0.25};
		Vector truthV = new Vector(truthArray);
		
		model.add(input);
		model.add(hidden);
		model.add(hidden2);
		model.add(output);
		
		model.train(inputV, truthV, "MSE", 100, 0.5);
	}

}
