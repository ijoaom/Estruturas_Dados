// questao 1  : 1. Implemente o método “void sort()” para ordenar de forma crescente os elementos de uma
// Fila Dinâmica Duplamente Encadeada que armazena números inteiros não negativos.//



class FilaDuplamenteEncadeada {
    private var cabeca: No? = null
    private var cauda: No? = null

    private class No(var dado: Int, var proximo: No? = null, var anterior: No? = null)

    fun enfileirar(dado: Int) {
        val novoNo = No(dado)
        if (cauda == null) {
            cabeca = novoNo
            cauda = novoNo
        } else {
            cauda?.proximo = novoNo
            novoNo.anterior = cauda
            cauda = novoNo
        }
    }

    fun desenfileirar(): Int? {
        val noRemovido = cabeca ?: return null
        cabeca = cabeca?.proximo
        if (cabeca == null) {
            cauda = null
        } else {
            cabeca?.anterior = null
        }
        return noRemovido.dado
    }

    fun sort() {
        if (cabeca == null) return

        var trocado: Boolean
        do {
            trocado = false
            var atual = cabeca

            while (atual?.proximo != null) {
                if (atual.dado > atual.proximo!!.dado) {
                    val temp = atual.dado
                    atual.dado = atual.proximo!!.dado
                    atual.proximo!!.dado = temp
                    trocado = true
                }
                atual = atual.proximo
            }
        } while (trocado)
    }

    // Método para exibir a fila (opcional, para fins de teste)
    fun exibir() {
        var atual = cabeca
        while (atual != null) {
            print("${atual.dado} ")
            atual = atual.proximo
        }
        println()

    }


    fun main(){
        val fila = FilaDuplamenteEncadeada()
        fila.enfileirar(3)
        fila.enfileirar(2)
        fila.enfileirar(1)
        fila.exibir()
        fila.sort()
        fila.exibir()
    }
}
