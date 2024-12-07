//questao 3:  Implemente um método “boolean isPalindrome(String data)” para verificação de
// palíndromos utilizando Pilha Dinâmica. //

class Pilha {
    private var topo: No? = null

    private class No(var dado: Char, var proximo: No? = null)

    fun empurrar(dado: Char) {
        val novoNo = No(dado)
        novoNo.proximo = topo
        topo = novoNo
    }

    fun remover(): Char? {
        val noRemovido = topo ?: return null
        topo = topo?.proximo
        return noRemovido.dado
    }

    fun estaVazia(): Boolean {
        return topo == null
    }
}

fun ehPalindromo(dado: String): Boolean {
    val pilha = Pilha()
    val dadoLimpo = dado.replace("\\s".toRegex(), "").toLowerCase()

    for (caractere in dadoLimpo) {
        pilha.empurrar(caractere)
    }

    for (caractere in dadoLimpo) {
        if (caractere != pilha.remover()) {
            return false
        }
    }

    return true
}

// Exemplo de uso
fun main() {
    val stringTeste = "A man a plan a canal Panama"
    println("É palíndromo: ${ehPalindromo(stringTeste)}") // Saída: É palíndromo: true


    val lista = ListaDuplamenteEncadeada()
    lista.inserirNoInicio(1)
    lista.inserirNoInicio(2)
    lista.inserirNoInicio(3)
    lista.exibir()

    val fila = FilaDuplamenteEncadeada()
    fila.enfileirar(3)
    fila.enfileirar(2)
    fila.enfileirar(1)
    fila.exibir()
    fila.sort()
    fila.exibir()



}
