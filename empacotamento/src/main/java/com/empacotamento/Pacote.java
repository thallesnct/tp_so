package com.empacotamento;

/**
 * Pacote
 */
public class Pacote {

  private static final int TEMPO_PRODUCAO_MS = 5000;
  private int tamanhoMaximo;
  private int tamanho;
  private Produto produto = null;

  private boolean adicionarProduto(Produto produto) {
    if (this.produto == null) {
      int quantidadeCabivel = this.tamanhoMaximo / produto.getTamanho();

      if (produto.getQuantidade() <= quantidadeCabivel) {
        this.produto = produto;

        return false;
      } else {
        this.produto = Produto.extrairQuantidade(produto, quantidadeCabivel);

        return true;
      }

    } else if (this.tamanho < this.tamanhoMaximo) {
      int espacoDisponivel = (this.tamanhoMaximo - this.tamanho) / produto.getTamanho();

      Produto.moverQuantidade(produto, this.produto, espacoDisponivel);
    }
  }
}