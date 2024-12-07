//   QUESTAO 2: 2. Implemente o método “void insertBegin(Object data)” de uma Lista Dinâmica
//Duplamente Encadeada que sempre insere um novo dado no início da Estrutura de Dados/

class ListaDuplamenteEncadeada {
    private var cabeca: No? = null

    private class No(var dado: Any, var proximo: No? = null, var anterior: No? = null)

    fun inserirNoInicio(dado: Any) {
        val novoNo = No(dado)
        if (cabeca == null) {
            cabeca = novoNo
        } else {
            novoNo.proximo = cabeca
            cabeca?.anterior = novoNo
            cabeca = novoNo
        }
    }

    // Método para exibir a lista (opcional, para fins de teste)
    fun exibir() {
        var atual = cabeca
        while (atual != null) {
            print("${atual.dado} ")
            atual = atual.proximo
        }
        println()
    }



}
