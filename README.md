# Qber

Qber is a Java Machine Library that is modelled after the Keras Framework
(FYI: There may be a lot of mistakes as this was in fact developed by a high school student)

## Getting Started

Qber is aimed for machine learning starters who would want to start with Java and it has similar syntax and structure to the Keras framework

For example, in Keras, one may may create a new neural network by using the Sequential model class and add neuron layers to it like this:
```
  model = Sequential()
  model.add(Dense(1, activation = 'relu', input_shape = (1)))
  model.add(Dense(1, activation = 'relu'))
```
In Qber, this would be accomplished thourgh this similar block of code:
```
  Sequential model = new Sequential();
  model.add(new Dense(1, "relu", inputVector))
  model.add(new Dense(1, "relu"))
```

## Objects

Qber mostly involves the manipulation of Vectors and Neurons. Qber Vectors are essentially a more functional double array, and Qber Neurons are modelled after neurons in machine learning. A Neuron object would take in an input Vector and will calculate a single a term. The layer object (Dense) involves an array of Neurons, and a model (Sequential) is an array of layers.

#### Qbers

Qbers are at the core of Qber. Qbers are essentially Java representations of any mathematical representation of arrays (i.e., Scalars, Vectors, Matrices and Tensors). All Qbers are subclasses to the Tensor superclass.

#### Neurons

Neurons are Java representations of machine learning (and real life!) neurons. They involve an input Vetor (Dendrites) and some sort of function to tranform the input Vector into an output

#### Layer (Dense)

A Qber Layer is basically an array of Neurons. All Layer objects will belong to the Layer superclass. Custom Layer objects could be created by extending the Layer superclass, allowing for custom implementation.

#### Model (Sequential)

The Sequential Model is a Java implementation of neural networks. It contains an array of Dense Layer objects that it will train with.

## Making a Model with Qber

Inside of the repo, there is a bunch of sample programs under the samples package. Here is some sample to implement a linear regression network in Qber using the Sequential model.

```

  // Creates a new Sequential Model object
  Sequential model = new Sequential();
  // Creates the layers that will be added to the model (this code could be embedded into the add method call)
  Dense input = new Dense(2, "sigmoid");
  Dense hidden = new Dense(2, "sigmoid");
  Dense output = new Dense(2, "sigmoid");
  
  // Creates an input Vector for the input layer
  double[] inputArray = {0.5, 0.3};
	Vector inputV = new Vector(inputArray);
		
  // Creates a truth Vector to calculate the loss
	double[] truthArray = {0.25, 0.1};
	Vector truthV = new Vector(truthArray);
	
  // Add the previsouly created layers to the model
	model.add(input);
	model.add(hidden);
	model.add(output);
		
  // Train the model and enjoy!
	model.train(inputV, truthV, "MSE", 10, 0.1);

```
