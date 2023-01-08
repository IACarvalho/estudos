# Anotações
## List - Coleções com iterações ordenadas
* List fica no pacote **java.util.List**
* Aceita elementos duplicados e garente ordem de inserção
* Vector implementa List, List extende Collection
* Vector é usado para trabalhar com theads

### ArrayList
* ArrayList implementa List, portanto aje como uma List
* Deve ser usado quando pesquisas forem mais necessárias do que inserções
* Usa um array dinâmico para armazenar os lementos
* Manipular uma ArrayList demora mais para implementações internas. Sempre que removemos um elemento, internamente, o array é totalmente percorrido e os bits de memória são trocados 
* Essa classe trabalha melhor quando a aplicação demanda armazenar a informação e acessar ela.

## LinkedList
* LinkedList implementa tanto List quanto Queue
* Deve ser usado quando inserções forem mais frequentes do que pesquisas
* Usa uma lista duplamente lincada para armazenar os elemetnos
* É menos custoso do que ArrayList pois não misturas os bits, afinal é uma lista duplamente lincada
* Essa classe trabalha melhor quando há a necessidade de manipular dados

## Set
* Set fica no pacote **java.util.Set**
* Não permite elementos duplicados
* Não possui índice

### HashSet
* Usa HashMap para armazenar os elementos
* Não mantém nenhuma ordem dos elementos
* É mais performática do que LinkedHashSet e TreeSet
* permite no máximo um elemento **null**

### LinkedHashSet
* Usa LinkedHashMap para armazenar os elementos
* Mantém a ordem de inserção
* A performance é inferior à HashSet e superior à TreeSet
* Permite no máximo um elemento **null**

### TreeSet
* Armazena os elementos usando TreeMap
* Mantém por padrão a ordem natural dos elementos (Se os elemetnos forem núemros será ordem numérica, se forem stirngs será ordem alfabética etc.)
* Apresenta menos performance do que HashSet e LinkedHashSet
* Não permite nenhum elemento de valor **null**

## Map
* Map fica no pacote **java.util.Map**
* Elementos únicos (key) para cada valor (value)
* Nenhum dos três abaixo tem sincronização, mas pode fazer uso da Collections.synchronizedMap() para sincronizar.
* Map.put(key, value) -> adiciona um elemento
* É possível ordenar um Map pelo valor

### HashMap
* Itera os alementos aleatoriamente
* Permite null key
* Implementa Map
* Utilizada a estrutura de dados List of Buckets

### LinkedHashMap
* Itera pela ordem de inserção
* Permite null key
* IMplementa Map
* Utilizada a estrutura de dados Doubly Linked List of Buckets

### TreeMap
* De acordo com a ordem natura das chaves
* Não permite null key
* Implementa Map, SortedMap e NavigableMap
* Utilizada a estrutura de dados Red-Black Tree


__________________________________________________

## Tratamento de exceções Java

**try**, **catch** e **finally** -> O tratamento de erro em Java é feiro usando essas palavras chave, cada uma dessas palavras chaves define um bloco para tratamento da exceção.
**throws** -> declara que o método pode lançar uma ou amis exceções.
**throw** -> Lança explicitamente uma exceção

### Unchecked (Runtime)
Exceptions que PODEM ser evitadas se forem tratadas e analisadas pelo desenvolvedor

### Checked
Exceptions que DEVEM ser evitados e tratados pelo desenvolvedor para o programa funcionar corretamente


