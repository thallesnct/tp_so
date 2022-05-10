package com.empacotamento;

public class Braco {
  Braco() {
  }

  public void embalar(Produto produto) {
    if (!produto.isEmbalado()) {
      produto.setEmbalado(true);
    }
  }

  public void removerEmbalagem(Produto produto) {
    if (produto.isEmbalado()) {
      produto.setEmbalado(false);
    }
  }
}
