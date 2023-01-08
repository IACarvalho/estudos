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

## Enum
* "Classe" com campos que consistem em um conjunto fixo de constantes (static final). Ou seja valores pré definidos.

## Notation (Anotações)
* São "configurações" adicionais para o código. Por exemplo ao criar uma model para uma tabela de um banco de dados posso passar anotações para o java, por baixo dos panos, gerar a configuração necessária para funcionar corretamente.
```java
@Entity
@Table(name="Pessoa")
public class Pesso {
	@id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Basic
	@Column(name = "name", length = 100)
	private string name;
}
```
* Existem também anotações para o compilado. Por exemplo **@Override** que fala opara o compilador que é uma sobrecrista e que tem que seguir a mesma assinatura.
* É possível criar anotações próprias, para isso é criado uma interface especial(**@interface**) que implementa diuas anotações específicas para isso.