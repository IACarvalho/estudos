# Anotações

## Classes abstratas
* Classes abstratas não são obrigadas a implementar métodos abstratos

## Interfaces
* É como se fosse uma classe abstrata com todos os métodos abstratos
* Ou pode pensar como um contrato, ao "assinar" esse contrato terei que implementar todos os métodos dessa interface.
* Eu posso extender uma classe (herença) e posso implementar quantos interface eu quiser
```java
public class Desenvolvedor extends PessoaFisica implements Funcionario, Terceirizado {
	// lógica
}
```
* Posso usar uma interface para instanciar um objeto
* Interfaces não é bem herença, herança é quando há reutilização de código e polimorfismo, quando há apenas polimorfismo é interface

## Composição
* Ao invez de implementar ou extender eu delego a lógica para um objeto que instancio na classe.
* É usado para reutilização de códico