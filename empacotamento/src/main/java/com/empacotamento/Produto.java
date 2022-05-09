package com.empacotamento;

public class Produto {
  private int tamanho;
  private int quantidade;
  private boolean embalado = false;

  Produto(Produto produtoBase, int quantidade) {
    this.setTamanho(produtoBase.getTamanho());
    this.setQuantidade(quantidade);
  }

  Produto(int tamanho, int quantidade) {
    this.setTamanho(tamanho);
    this.setQuantidade(quantidade);
  }

  public static Produto extrairQuantidade(Produto produto, int quantidade) {
    produto.setQuantidade(produto.getQuantidade() - quantidade);

    return new Produto(produto, quantidade);
  }

  public static void moverQuantidade(Produto produtoOrigem, Produto produtoDestino, int quantidade) {
    produtoOrigem.setQuantidade(produtoOrigem.getQuantidade() - quantidade);
    produtoDestino.setQuantidade(produtoDestino.getQuantidade() + quantidade);
  }

  public int getTamanho() {
    return tamanho;
  }

  public void setTamanho(int tamanho) {
    this.tamanho = tamanho;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public boolean isEmbalado() {
    return embalado;
  }

  public void setEmbalado(boolean embalado) {
    this.embalado = embalado;
  }
}
