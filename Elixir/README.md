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