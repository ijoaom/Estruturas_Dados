public final class PilhaEstatica(length: Int) : Empilhavel {
    private val tamanho = 5
    private val pilha = CharArray(tamanho)
    private var topo = -1



     fun empilhar(valor: Char) {
        if (topo < tamanho - 1) {
            pilha[++topo] = valor
        } else {
            println("Pilha cheia!")
        }
    }


    override fun desempilhar(): Char? {
        return if (topo >= 0) {
            pilha[topo--]
        } else {
            println("Pilha vazia!")
            null
        }
    }


          override fun estaVazia(): Boolean {
              return topo == -1
          }



}



