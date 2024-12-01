class FilaDinamica(var tamanho: Int = 5) : Enfileiravel {
    private var ponteiroInicio: NoDuplo? = null
    private var ponteiroFim: NoDuplo? = null
    private var quantidade = 0

    override fun estaCheia(): Boolean {
        return quantidade == tamanho
    }


    override fun estaVazia(): Boolean {
        return quantidade == 0

    }

    override fun enfileirar(dado: Any?) {
        if(!estaCheia()){
            val novoNo = NoDuplo(dado)
           if(ponteiroFim != null){
            ponteiroFim?.proximo = novoNo}
            else{
                ponteiroInicio = novoNo
           }
            novoNo.anterior = ponteiroFim
            ponteiroFim = novoNo
            quantidade++
        }
        else{
            throw NoSuchElementException("Fila Vazia!")
        }
    }






    override fun desenfileirar(): Any? {
       var aux: Any? = null
        if(!estaVazia()){
            aux = ponteiroInicio?.dado
            ponteiroInicio = ponteiroInicio?.proximo
           if(ponteiroInicio != null){
            ponteiroInicio?.anterior = null
            quantidade--}
            else{
                ponteiroFim = null
           }
        } else{
            throw NoSuchElementException("Fila Vazia")
        }
        return aux
    }




    override fun frente(): Any? {
        var aux: Any? = null
        if (!estaVazia()) {
            aux = ponteiroInicio?.dado
        } else {
            throw NoSuchElementException("Fila Vazia")
        }
        return aux
    }


    override fun atualizar(dado: Any?) {
        if (!estaVazia()) {
            ponteiroInicio?.dado = dado
        } else {
            throw NoSuchElementException("Lista Vazia")
        }
    }


    override fun imprimir(): String {
        var retorno = "["
        var aux = ponteiroInicio
        for (i in 0 until quantidade) {
            retorno += "${aux?.dado}, "
            aux = aux?.proximo
        }

        return "$retorno]"
    }


}
