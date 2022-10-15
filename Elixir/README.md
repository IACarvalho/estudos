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
Um tipo que é uma das diferenças do Elixir, funciona semelhante aos Symb0ls do ruby
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
    * '/' -> divisão<br />
    O operador de módulo é um pouco diferente e tem, também, um operador que retorna um inteiro de uma divisão
    * **div** -> Função que retorna um valor inteiro da divisão de dois valores
    * **rem** -> basicamente o opperador de módulo, mas é uma função
* ### Booleanos
    * '||' -> operar de or
    * '&&' -> Operador de and
    * '!' -> Operador de negação<br/>
    Tem além desse mais três operadores, esses operadores devem receber o priemiro argumento um booleano (true, false). Esses operadores são **and**, **or** e **not**
    ```elixir
        true and 42 # retorna 42
        false or true # retorna true
        not false # retorna true
        42 and true # retorna um erro de ArgumentError
    ```
* ### Comparativos
Nessa parte tem alguma features interessantes e diferentes

* ### Interpolação de strings
* ### Concatenação de strings