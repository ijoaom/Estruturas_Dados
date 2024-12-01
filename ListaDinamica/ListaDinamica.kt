class ListaDinamica(val tamanho: Int) : Listavel {

    private var quantidade = 0
    private var fim: NoDuplo? = null
    private var inicio: NoDuplo? = null


    // principais//

    override fun limpar() {
        quantidade = 0
        fim = null
        inicio = null
    }

    override fun inserir(posicao: Int, dado: Any?) {
        var dadoAux: Any? = null
        var ponteiroaux = inicio
        if (!estaCheia()) {
            if (posicao >= 0 && posicao <= quantidade)
                for (i in 0 until posicao) {
                    ponteiroaux = ponteiroaux?.proximo
                }

            var pro = ponteiroaux
            var ant = ponteiroaux?.anterior
            var novoNo = NoDuplo(dado)

            if (ant != null) {
                ant.proximo = novoNo
            } else {
                inicio = novoNo
            }
            if (pro != null) {
                pro.anterior = novoNo
            } else {
                fim = novoNo
            }

            novoNo.anterior = ant
            novoNo.proximo = pro
            quantidade++


        } else {
            throw NoSuchElementException("Lista Cheia")
        }
    }


    override fun apagar(posicao: Int): Any? {
        var dadoAux: Any? = null
        var ponteiroaux = inicio

        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                for (i in 0 until quantidade) {
                    ponteiroaux = ponteiroaux?.proximo
                }
                dadoAux = ponteiroaux?.dado
                val ponteiroAnterior = ponteiroaux?.anterior
                val ponteiroProximo = ponteiroaux?.proximo

                if (ponteiroAnterior != null) {
                    ponteiroProximo?.anterior = ponteiroAnterior
                }
                if (ponteiroProximo != null) {
                    ponteiroProximo.anterior = ponteiroAnterior
                } else
                    fim = fim?.anterior
                quantidade--

            } else {
                println("Indice Inválido!")
            }
        } else {
            println("Lista Vazia!")
        }
        return dadoAux
    }


    override fun selecionarTodos(): Array<Any?> {
        var dadoaux: Array<Any?> = arrayOfNulls(quantidade)
        if (!estaVazia()) {
            var ponteiroauxiliar = inicio
            for (i in 0 until quantidade) {
                dadoaux[i] = ponteiroauxiliar?.dado
                ponteiroauxiliar = ponteiroauxiliar?.proximo

            }

        } else {
            throw NoSuchElementException("Lista Vazia")
        }
        return dadoaux
    }


    override fun anexar(dado: Any?) {
        if (!estaCheia()) {
            val NovoNo = NoDuplo(dado)
            NovoNo.anterior = fim
            if (!estaVazia()) fim?.proximo = NovoNo
            else {
                inicio = NovoNo
            }
            fim = NovoNo
            quantidade++
        } else {
            throw NoSuchElementException("Lista Cheia")
        }
    }


    override fun atualizar(posicao: Int, dado: Any?) {

        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var aux = inicio
                //laço para ir ate o no que tem o dado a ser retornado//
                for (i in 0 until posicao) {
                    aux = aux?.proximo

                }

            } else {
                throw IndexOutOfBoundsException("Indice Invalido")
            }
        } else {
            throw NoSuchElementException("Lista Vazia")
        }

    }


    override fun selecionar(posicao: Int): Any? {
        var dadoTemp: Any? = null

        if (!estaVazia()) {
            if (posicao >= 0 && posicao < quantidade) {
                var aux = inicio
                //laço para ir ate o no que tem o dado a ser retornado//
                for (i in 0 until posicao) {
                    aux = aux?.proximo
                    dadoTemp = aux?.dado
                }

            } else {
                throw IndexOutOfBoundsException("Indice Invalido")
            }
        } else {
            throw NoSuchElementException("Lista Vazia")
        }

        return dadoTemp
    }


    // auxiliares //
    override fun estaCheia(): Boolean {
        return tamanho == quantidade
    }

    override fun estaVazia(): Boolean {
        return tamanho == 0
    }


    override fun imprimir(): String {
        var result = "["
        var aux = inicio
        //laço que roda quantidade vezes//

        for (i in 0 until quantidade) {
            result += aux?.dado
            if (i != +quantidade - 1) result += ","
            aux = aux?.proximo
        }
        return "$result]"
    }

}
