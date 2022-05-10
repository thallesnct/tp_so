package com.empacotamento;

import java.util.ArrayList;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        String filePath = "";

        for (String arg : args) {
            if (arg.startsWith("-i=")) {
                filePath = arg.split("-i=")[1];
            }
        }

        System.out.println(filePath);

        ArrayList<Pedido> pedidos = Pedido.carregarPedidos(filePath);
        ArrayList<Pacote> pacotes = new ArrayList<Pacote>();

        Braco braco1 = new Braco();
        Esteira esteira1 = new Esteira(braco1);

        for (Pedido pedido : pedidos) {
            pacotes.addAll(esteira1.processarPedido(pedido));
            System.out.println(pedido);
        }

        System.out.println("/n=============================/n");

        for (Pacote pacote : pacotes) {
            System.out.println(pacote);
        }

    }
}

