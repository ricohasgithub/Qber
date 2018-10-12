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
