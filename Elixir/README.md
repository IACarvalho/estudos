# Introdução ao Elixir

## Tipos de dados
Elixir tem tiopagem dinâmica
* ### Integer
Basucamente são números inteiros, não se difere tantos de outras linguagens
* ### Float
Número com ponto flutuante, também bem semelhantes a outras linguagens no geral
* ### Booleans
Valores verdadeiros e falso.
Todos os valores são considerados **verdadeiros** exceto **false** e **nil**
* ### Atoms
Um tipo que é uma das diferenças do Elixir, funciona semelhante aos Symbols do ruby. É uma constante que o valor dele é ele mesmo. (Meio estranho, mas conforme vejo os usos estou começando a compreender)

* ### Strings
São textos entre aspas duplas. A feature interessante é que as strings aceitam quebra de linha no Elixir.
```elixir
text = "Ola, eu aceito quebra
de linha"
```

## Operadores básicos
* ### Aritiméticos
    * '+' -> adição
    * '-' -> subtração
    * '*' -> multiplicação
    * '/' -> divisão
O operador de módulo é um pouco diferente e tem, também, um operador que retorna um inteiro de uma divisão
    * **div** -> Função que retorna um valor inteiro da divisão de dois valores
    * **rem** -> basicamente o opperador de módulo, mas é uma função
* ### Booleanos
    * '||' -> operar de or
    * '&&' -> Operador de and
    * '!' -> Operador de negação
Tem além desse mais três operadores, esses operadores devem receber o priemiro argumento um booleano (true, false). Esses operadores são **and**, **or** e **not**
```elixir
    true and 42 # retorna 42
    false or true # retorna true
    not false # retorna true
    42 and true # retorna um erro de ArgumentError
```
* ### Comparativos
Os comparativos sãoÇ **==, !=, ===, !==, <=, >=, < e >**. A principal diferença das linguagens mais comuns são os comparadores estritos
```elixir
2 == 2.0 # retorna true
2 === 2.0 # retorna false
```
No elixir é possível comparar tipos diferentes, isso é útil para ordenação principalmente.
```elixir
# ordem de menor para maior
number < atom < reference < function < port < pid < tuple < map < list < bitstring
```

Por exemplo posso comparar um atom com uma string ou uma tupla com uma lista
```elixir
:hello > 999 # retorna true
{:hello, :world} > [:hello, :world] # retorna false
```
* ### Interpolação de strings
A interpolação de strings no Elixir é bem simples, basta usar o #{}
```elixir
name = "Israel"
"Hello, #{name}" # Retorna Hello, Israel
```
* ### Concatenação de strings
Já a concatenação é um pouco diferente das maioria das linguagens que tive contato, ao invés de um "+" usa <>
```elixir
name = "Israel"
"Hello, " <> name # retonar Hello, Israel
```

## Coleções
* ### Listas
Pelo que vi as listas de elixir são bem semelhantes as listas de python, aceitam multiplos tipos e aceitam valores repetidos.
```elixir
lista = [3.14, :pir, "Apple"]
```

As lista no elixir são encadeadas. Por isso é normalmente mais rápido inserir um novo elemento no inicio (prepending) do que no final (appending)
```elixir
lista = [3.14, :pir, "Apple"]
["π" | lista] # prepending ["π", 3.14, :pir, "Apple"]
lista  ++ ["Cherry"] # appending ["π", 3.14, :pir, "Apple", "Cherry"]
```
* ### Concatenação de listas
A concatenação de listas usa o operador **++/2**.
```elixir
[1, 2] ++ [3, 4] # [1, 2, 3, 4]
```
Uma pequena nota sobre o formato de nome (++/2) usado acima. Em Elixir (e Erlang, sobre o qual Elixir é construído), o nome de uma função ou operador tem dois componentes: o nome em si (neste caso ++) e sua aridade. Aridade é uma parte central quando se fala sobre código Elixir (e Erlang). Indica o número de argumentos que uma dada função aceita (dois, nesse nosso exemplo). Aridade e o nome são combinados com uma barra. fonte: [Elixir school](https://elixirschool.com/pt/lessons/basics/collections)

* ### Subtração de listas
A subtra;'ao [e feita usando o operardor **--/2**. é importante frisar que mão é possível subtrair itens que não existe,
```elixir
["foo", :bar, 42] -- [42, "bar"] # ["foo", :bar]
```
Para cada elemento na direita será removido o primerio elemento da esquerda que for igual. Além disso é bom estar atento que a compração dos elementos é uma comparação restrita.
```elixir
[1, 2, 2, 3, 2, 3] -- [1, 2, 3, 2] # [2, 3]
[2] -- [2.0] # [2]
[2.0] -- [2.0] # []
```

* ### Conceito de Topo/calda(head/tail)
Quando se trabalha com listas em linguagens funcionais esse conceito aparece, onde o topo(head) é o primeiro elemento e a calda(tail) são o restante dos elemetnos. No Elixir tem duas funções para trabalhar com listas que seguem esse conceito **hd** e **tl**.
```elixir
hd [3.14, :pie, "Apple"] # retorna 3.14
tl [3.14, :pie, "Apple"] # retorna [:pie, "Apple"]
```
Além das duas funçõe posso trabalhar com o conceito usando o **pattern matching** e o operador cons (**|**), irá dividir a lista em topo e calda.
```elixir
[head | tail] = [3.14, :pie, "Apple"]
head # 3.14
tail # [:pie, "Apple"]
```

* ### Tuplas
As tuplas são similares às listas porém são armazenadas de maneira contígua em memória. Isto permite acessar seu tamanho de forma rápida porém sua modificação é custosa; a nova tupla deve ser armazenada inteira na memória. As tuplas são definidas com chaves. [Elixir school](https://elixirschool.com/pt/lessons/basics/collections)

```elixir
{3.14, :pie, "Apple"}
```

Retornos de funções nromalmente são feitos com tuplas, onde o primeiro elemento é um atom com :ok (caso de sucesso) ou :error (caso de erro) e o segundo o resultado da execução
[Exemplo exlixir school](https://elixirschool.com/pt/lessons/basics/collections)
```elixir
File.read("path/to/existing/file")
{:ok, "... contents ..."}
File.read("path/to/unknown/file")
{:error, :enoent}
```

* ### Listas de palavras chave
As listas de palavras-chave e os mapas são coleções associativas no Elixir. No Elixir, uma lista de palavras-chave é uma lista especial de tuplas de dois elementos cujo o primeiro elemento é um átomo; eles compartilham o desempenho das listas:
```elixir
[chave: "valor", idade: 30]
[{:cahve, "valor"}, {:idade, 30 }]
```
Basicamente é uma lista de tuplas com 2 valores, um atom como chave.
* As chaves são atoms
* As chaves estão ordenadas
* As chaves não são únicas

Por essas razões as listas de palavra-chave são frequentemente usadas para passar opções a funções.

* ### Mapas
Em Elixir, mapas normalmente são a escolha para armazenamento chave-valor. A diferença entre os mapas e as listas de palavras-chave está no fato de que os mapas permitem chaves de qualquer tipo e não seguem uma ordem. Você pode definir um mapa com a sintaxe **%{}**:
```elixir
map = %{:foo => "bar", "hello" => :world}
map[:foo] # "bar"
map["hello"] # :world
```

Variáveis também são permitidas como chave
Se um elemento duplicaod for inserido o anterior será substituido
Existe uma sintase especial para maps que todas as chaves são atoms
```elixir
%{foo: "bar", hello: "world"} == %{:foo => "bar", :hello => "world"} # true
```
Além disso existe uma sintaxe especial para acessar esses maps com atoms
```elixir
map = %{foo: "bar", hello: "world"}
map.hello # "world"
```
Mapas também tem uma sintaxe para atualizar valores]
```elixir
map = %{foo: "bar", hello: "world"}
%{map| foo: "baz"}
```
Nota: esta sintaxe funciona apenas para atualizar uma chave que já existe no mapa! Se a chave não existir, um KeyError será gerado.
Para criar uma nova chave, use **Map.put/3**
```elixir
map = %{foo: "bar", hello: "world"}
map = Map.put(map, :key, "value")
```

## Enum
Existe mais de 70 funções para trabalhar com enumeráveis, a única coleção não enumerável no elixir é a tupla. Ou seja essas funções podem ser usadas em todas as coleções ocm exceção da tupla.

* ### all?
A função **all?/2** recebe como parâmetro uma coleção e uma função anônima, irá verificar cada elemento com a função e caso passe retorna true, caso contrário retorna false.
```elixir
colecao = ["foo", "bar", "hello"]
Enum.all?(colecao, fn(s) -> String.length(s) == 3 end) # false
Enum.all?(colecao, fn(s) -> String.length(s) > 1 end) # true
```

* ###any?
Diferente do anterior o **any?/2** apenas um elemento precisa atender ao requisito
```elixir
colecao = ["foo", "bar", "hello"]
Enum.any?(colecao, fn(s) -> String.length(s) == 5 end) # true
```

* ### chunk_every
Função para quebrar uma coleção eu várias coleções menores, usando o **chunk_every/2** no primeiro argumetno é passado uma coleção e no segundo o tamanho das novas coleções

```elixir
colecao = [1, 2, 3, 4, 5, 6]
Enum.chunk_every(colecao, 2) # [[1, 2], [3, 4], [5, 6]]
```

* ### chunk_by
Se necessita agrupar uma coleção baseado em algo diferente do tamanho, podemos usar a função **chunk_by/2**. Ela recebe um enumerável e uma função, e quando o retorno desta função muda, um novo grupo é iniciado e começa a criação do próximo:
Pessoalmente achei o conseito meio estranho, por isso copiei o conseito do site elixir school
```elixir
Enum.chunk_by(["one", "two", "three", "four", "five"], fn(x) -> String.length(x) end)
[["one", "two"], ["three"], ["four", "five"]]
Enum.chunk_by(["one", "two", "three", "four", "five", "six"], fn(x) -> String.length(x) end)
[["one", "two"], ["three"], ["four", "five"], ["six"]]
```