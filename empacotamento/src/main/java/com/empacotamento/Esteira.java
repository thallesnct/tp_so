package com.empacotamento;

import java.util.ArrayList;

public class Esteira {
  private static final int TEMPO_TRANSICAO_MS = 500;
  private static final int TAMANHO_MAXIMO_PACOTE = 5000;
  private Braco braco;

  Esteira(Braco braco) {
    this.braco = braco;
  }

  public ArrayList<Pacote> processarPedido(Pedido pedido) {
    int tempoPercorrido = 0;
    ArrayList<Pacote> pacotes = new ArrayList<Pacote>();
    Produto produtoAtual = pedido.getProduto();

    while (produtoAtual.getQuantidade() > 0) {
      this.braco.embalar(produtoAtual);

      Pacote novoPacote = this.gerarPacote(produtoAtual);

      this.braco.removerEmbalagem(produtoAtual);

      pacotes.add(novoPacote);

      tempoPercorrido += Pacote.TEMPO_PRODUCAO_MS + Esteira.TEMPO_TRANSICAO_MS;
    }

    pedido.setTempoGastoProcessamento(tempoPercorrido);

    return pacotes;
  }

  public Pacote gerarPacote(Produto produto) {
    Pacote pacote = new Pacote(Esteira.TAMANHO_MAXIMO_PACOTE);

    pacote.adicionarProduto(produto);

    return pacote;
  }
}
