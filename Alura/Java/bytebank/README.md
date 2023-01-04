## Herança
Caso a classe mãe tenha um construtor é necessário passar os valores requeridos
pelo construtor da classe mãe usando **super()**.

## Classes abstratas
Uma classe abstrata (**abstract**) é uma classe que não pode ser instanciada, é uma classe de hierarquia mais alta usada para servir de de modelo mais genérico para as classes filhas.

## Método abstrato
É um método sem corpo e definido com a palavra reservada **abstract**, tem uma funcionalidade semelhante a uma classe abstrata. Se um método tem funcionamento diferente em todas as classes filhas é interessante criar um método abstrato para o polimorfismo funcionar corretamente. E claro, ao declarar um método abstrato OBRIGA todos as classes filhas a implementar esse método, a não ser que seja uma classe abstrata.