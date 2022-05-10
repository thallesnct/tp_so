package com.empacotamento;

public class Cliente {
  private String nome;

  Cliente(String nome) {
    this.setNome(nome);
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
  
}
