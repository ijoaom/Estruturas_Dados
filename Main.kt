fun main() {

    fun ehPalindromo(palavra: String): Boolean {
        val pilha = PilhaEstatica(palavra.length)

        // Empilha todos os caracteres da palavra
        for (char in palavra) {
            pilha.empilhar(char)
        }

        // Compara os caracteres empilhados com a palavra original
        for (char in palavra) {
            if (char != pilha.desempilhar()) {
                return false
            }
        }

        return true
    }


    val palavra = "arara"
    if (ehPalindromo(palavra)) {
        println("$palavra é um palíndromo.")
    } else {
        println("$palavra não é um palíndromo.")
    }







}



