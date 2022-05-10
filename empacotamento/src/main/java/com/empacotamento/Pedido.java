package com.empacotamento;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Pedido {
  private Cliente cliente;
  private Produto produto;
  private int prazoEmpacotamento;
  private int horaChegada;
  private int tempoGastoProcessamento;

  public Pedido(Cliente cliente, int totalProdutos, int prazoEmpacotamento, int horaChegada) {
    this.setCliente(cliente);
    this.setProduto(new Produto(250, totalProdutos));
    this.setPrazoEmpacotamento(prazoEmpacotamento);
    this.setHoraChegada(horaChegada);
  }

  public Pedido(String cliente, int totalProdutos, int prazoEmpacotamento, int horaChegada) {
    this.setCliente(new Cliente(cliente));
    this.setProduto(new Produto(250, totalProdutos));
    this.setPrazoEmpacotamento(prazoEmpacotamento);
    this.setHoraChegada(horaChegada);
  }

  public static ArrayList<Pedido> carregarPedidos(String filePath) {
    ArrayList<Pedido> resultado = new ArrayList<Pedido>();

    try {
      String path = new File("").getAbsolutePath().concat("/" + filePath);
      System.out.println("File path: " + path);
      FileReader fileReader = new FileReader(path);
      BufferedReader reader = new BufferedReader(fileReader);
      int qtdePedidos = Integer.parseInt(reader.readLine());

      for (int i = 0; i < qtdePedidos; i++) {
        String[] dados = reader.readLine().split(";");
        Pedido pedido = new Pedido(dados[0], Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), Integer.parseInt(dados[3]));

        resultado.add(pedido);
      }

      reader.close();
    } catch (FileNotFoundException e) {
        System.out.println("Arquivo " + filePath + "não encontrado");
    } catch (IOException e) {
        System.out.println("Ocorreu um erro ao ler o arquivo " + filePath);
        e.printStackTrace();
    }

    return resultado;
  }

  @Override
  public final String toString() {
    return ("Cliente: " + this.getCliente().getNome() + 
           " | Total de produtos: " + this.getProduto().getQuantidade() + 
           " | Prazo: " + this.getPrazoEmpacotamento() + 
           " | Chegada: " + this.getHoraChegada());
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Produto getProduto() {
    return produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public int getPrazoEmpacotamento() {
    return prazoEmpacotamento;
  }

  public void setPrazoEmpacotamento(int prazoEmpacotamento) {
    this.prazoEmpacotamento = prazoEmpacotamento;
  }

  public int getHoraChegada() {
    return horaChegada;
  }

  public void setHoraChegada(int horaChegada) {
    this.horaChegada = horaChegada;
  }

  public int getTempoGastoProcessamento() {
    return tempoGastoProcessamento;
  }

  public void setTempoGastoProcessamento(int tempoGastoProcessamento) {
    this.tempoGastoProcessamento = tempoGastoProcessamento;
  }

  
}
