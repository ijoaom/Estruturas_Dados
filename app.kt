fun main() {
    val heap: Heap = MinHeap(10)

    // Inserir elementos no Min Heap
    heap.inserir(10)
    heap.inserir(20)
    heap.inserir(15)
    heap.inserir(30)
    heap.inserir(50)
    heap.inserir(40)

    // Exibir o heap
    println("Heap após inserção:")
    heap.mostrarHeap()

    // Extrair o menor elemento (raiz) do heap
    println("Menor valor extraído: ${heap.extrairMin()}")

    // Exibir o heap após a extração
    println("Heap após a extração:")
    heap.mostrarHeap()
}
