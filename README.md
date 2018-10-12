# Qber
Qber is a Java Machine Library that is modelled after the Keras Framework
(FYI: There may be a lot of mistakes as this was in fact developed by a high school student)

## Getting Started
Qber has similar syntax and structure to the Keras framework

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
Qber is aimed for machine learning starters who would want to start with Java
