# Objetivo
Desenvolver um sistema de Loja Virtual em Kotlin, utilizando Orientação a Objetos (POO). O sistema deve permitir que os clientes simulem a compra de produtos,
adicionem itens ao carrinho de compras e finalizem a compra com pagamento.
### Requisitos do Sistema
#### 1. Criar a Classe Produto
• Cada produto deve ter:
*  id (Int) – Identificador único do produto
*  nome (String) – Nome do produto
*  preco (Double) – Preço do produto
*  estoque (Int) – Quantidade disponível

• Método exibirDetalhes() → Exibe informações do produto
#### 2. Criar a Classe Cliente
• Cada cliente deve ter:
* id (Int) – Identificador único
* nome (String) – Nome do cliente
* saldo (Double) – Saldo disponível para compras
  
• Método adicionarSaldo(valor: Double) → Permite recarregar o saldo do cliente
#### 3. Criar a Classe CarrinhoDeCompras
• O carrinho deve:
* Conter uma lista de produtos adicionados pelo cliente
* Permitir adicionar e remover produtos
* Calcular o total da compra
  
• Métodos:
* adicionarProduto(produto: Produto, quantidade: Int)
* removerProduto(produto: Produto)
* exibirCarrinho() → Exibe os itens no carrinho
* calcularTotal(): Double
#### 4. Criar a Classe Loja
• A loja deve:
* Conter uma lista de produtos disponíveis
* Permitir que o cliente compre os produtos do carrinho
* Atualizar o estoque dos produtos
  
• Métodos:
* listarProdutos() → Exibe os produtos disponíveis
* finalizarCompra(cliente: Cliente, carrinho: CarrinhoDeCompras)

 Regras de Negócio
 
 O cliente só pode comprar se tiver saldo suficiente.
 Se um produto não estiver no estoque, não pode ser comprado.
 Ao finalizar a compra, o estoque dos produtos deve ser atualizado.

## EXEMPLO DE USO / TESTE
// Criando produtos

* val produto1 = Produto(1, "Notebook", 4500.0, 5)
* val produto2 = Produto(2, "Mouse Gamer", 250.0, 10)

// Criando cliente

* val cliente = Cliente(1, "Ana", 5000.0)

// Criando carrinho e loja

* val carrinho = CarrinhoDeCompras()
* val loja = Loja(listOf(produto1, produto2))

// Adicionando produtos ao carrinho

* carrinho.adicionarProduto(produto1, 1)
* carrinho.adicionarProduto(produto2, 2)

// Exibindo o carrinho

* carrinho.exibirCarrinho()

// Tentando finalizar a compra

* loja.finalizarCompra(cliente, carrinho)

**CENTRO UNIVERSITÁRIO SATC**

**ENGENHARIA DE SOFTWARE - DISCIPLINA DE SOLUÇÕES MOBILE**

**Professor: Thyerri Mezzari**
