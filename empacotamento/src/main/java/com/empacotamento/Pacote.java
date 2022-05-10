package com.empacotamento;

/**
 * Pacote
 */
public class Pacote {

  public static final int TEMPO_PRODUCAO_MS = 5000;
  private int tamanhoMaximo;
  private int tamanho;
  private Produto produto = null;

  Pacote(int tamanhoMaximo) {
    this.setTamanhoMaximo(tamanhoMaximo);
    this.setTamanho(0);
  }

  @Override
  public final String toString() {
    return ("Produto: " + this.getProduto().getQuantidade() + 
           " | Tamanho pacote: " + this.getTamanho());
  }

  public boolean adicionarProduto(Produto produto) {
    if (this.produto == null) {
      int quantidadeCabivel = this.tamanhoMaximo / produto.getTamanho();

      if (produto.getQuantidade() <= quantidadeCabivel) {
        this.produto = produto;
        this.setTamanho(produto.getQuantidade() * produto.getTamanho());

        return false;
      } else {
        this.produto = Produto.extrairQuantidade(produto, quantidadeCabivel);
        this.setTamanho(this.produto.getQuantidade() * produto.getTamanho());

        return true;
      }

    } else if (this.tamanho < this.tamanhoMaximo) {
      int espacoDisponivel = (this.tamanhoMaximo - this.tamanho) / produto.getTamanho();

      Produto.moverQuantidade(produto, this.produto, espacoDisponivel);

      this.setTamanho(this.produto.getTamanho() + (produto.getTamanho() * espacoDisponivel));

      return false;
    }

    return false;
  }

  public int getTamanhoMaximo() {
    return tamanhoMaximo;
  }

  public void setTamanhoMaximo(int tamanhoMaximo) {
    this.tamanhoMaximo = tamanhoMaximo;
  }

  public int getTamanho() {
    return tamanho;
  }

  public void setTamanho(int tamanho) {
    this.tamanho = tamanho;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }
    
}