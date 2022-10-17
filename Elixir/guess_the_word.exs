# "worsd: bread"
hints = "flour, water, yeast, bakery"
IO.puts "Hints: #{hints}"

guess = IO.gets "Guess the world: "
# IO.inspect guess # Normalmente usado apenas para inspecionar a variavel, nunca deve ser usado em producao
guess = String.strip(guess)

# estrutura de controle case
case guess do
    "bread" ->
        IO.puts "Wond!"
    _ -> # passando o undescore significa qualquer outra coisa, poderia colocar um nome para ficar mais legivel caso quisesse
        IO.puts "Lost!"
end