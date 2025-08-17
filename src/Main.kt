//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
class Produto(
    val id: Int,
    val nome: String,
    val preco: Double,
    var estoque: Int
) {
    fun exibirDetalhes() {
        println("ID: $id, Nome: $nome, Preço: $preco, Estoque: $estoque")
    }
}

class Cliente(
    val id: Int,
    val nome: String,
    var saldo: Double

) {
    fun AdicionarSaldo(valor : Double) {
        saldo += valor
        println("Saldo Atualizado: R$$saldo")
    }
}

class CarrinhoDeCompras {
    val produtos: MutableList<Pair<Produto, Int>> = mutableListOf()

    fun adicionarProduto(produto: Produto, quantidade: Int) {
        if (produto.estoque >= quantidade) {
            produtos.add(Pair(produto, quantidade))
            println("Adicionado ao carrinho: ${produto.nome} (Quantidade: $quantidade)")
        } else {
            println("Estoque insuficiente para ${produto.nome}.")
        }
    }

    fun removerProduto(produto: Produto) {
        produtos.removeIf { it.first.id == produto.id }
        println("Produto ${produto.nome} removido com sucesso!!")
    }

    fun exibirCarrinho() {
        println("Itens no Carrinho")
        for ((produto, quantidade) in produtos) {
            println(
                "${produto.nome} (Quantidade: $quantidade) - R$" +
                        "${produto.preco * quantidade}"
            )
        }
    }

    fun calcularTotal(): Double {
        return produtos.sumOf { (produto, quantidade) -> produto.preco * quantidade }
    }

}

class Loja (
    val produtosDisponiveis: List<Produto>){
    fun listarProdutos(){
        println(" Produtos disponíveis:")
        for (produto in produtosDisponiveis){
            produto.exibirDetalhes()
        }
    }
    fun finalizarCompra(cliente: Cliente, carrinho: CarrinhoDeCompras){
        val total = carrinho.calcularTotal()
        if (cliente.saldo >= total){
            for ((produto, quantidade) in carrinho.produtos){
                produto.estoque -= quantidade
            }
            cliente.saldo -= total
            println("Compra finalizada com sucesso! Total: R$$total")
        }else {
            println("Saldo insuficiente para finalizar a compra.")
        }
    }
}

fun main (){
    val produto1 = Produto(1, "Notebook", 4500.00, 5)
    val produto2 = Produto(2, "Mouse Gamer", 500.0, 10)
    val cliente = Cliente(1, "Ana", 5000.0)
    val carrinho = CarrinhoDeCompras()
    val loja = Loja(listOf(produto1, produto2))

    carrinho.adicionarProduto(produto1, 1)
    carrinho.adicionarProduto(produto2, 2)

    carrinho.exibirCarrinho()

    loja.finalizarCompra(cliente, carrinho)


}