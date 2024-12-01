class PilhaDinamica(var tamanho: Int = 10) : Empilhavel {
    var ponteiroTopo: NoDuplo? = null
    var quantidade: Int = 0


    override fun empilhar(dado: Any?) {
        if (!estaCheia()) {
            val novoNo = NoDuplo(dado)
            ponteiroTopo = novoNo
            novoNo.anterior = ponteiroTopo
            ponteiroTopo = novoNo
            quantidade++
        }
    }


    override fun atualizar(dado: Any?) {
        if (!estaVazia()) {
            ponteiroTopo?.dado = dado
        } else {
            println("Esta Vazia")
        }
    }


    override fun desempilhar(): Any? {
        var dadoAux: Any? = null
        if (!estaVazia()) {
            dadoAux = ponteiroTopo?.dado
            ponteiroTopo = ponteiroTopo?.anterior
            if(ponteiroTopo != null)
            ponteiroTopo?.proximo = null
            quantidade--

        } else {
            println("Esta Vazia")
        }
        return dadoAux
    }


    override fun espiar(): Any? {
        var dadoAux: Any? = null
        if (!estaVazia()) {
            dadoAux = ponteiroTopo?.dado
        } else {
            println("Esta Vazia")
        }
        return dadoAux
    }


    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }


    override fun estaVazia(): Boolean {
        return quantidade == 0

    }


    override fun imprimir(): String {
        var aux = ponteiroTopo
        var retorno = "["
        while (aux?.anterior != null) {
            retorno += aux.dado
            aux = aux.anterior

        }
        return "$retorno]"
    }


}







