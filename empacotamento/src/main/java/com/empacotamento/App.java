package com.empacotamento;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.naming.spi.DirStateFactory.Result;

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

        ExecutorService EXEC = Executors.newFixedThreadPool(2);
        List<Callable<Boolean>> tasks = new ArrayList<Callable<Boolean>>();

        for (Pedido pedido : pedidos) {
            Callable<Boolean> c = new Callable<Boolean>() {
                @Override
                public Boolean call() throws Exception {
                    pacotes.addAll(esteira1.processarPedido(pedido));

                    return true;
                }
            };
            tasks.add(c);
        }

        try {            
            EXEC.invokeAll(tasks);
    
            System.out.println("\n=============================\n");
    
            for (Pacote pacote : pacotes) {
                System.out.println(pacote);
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    

        // for (Pedido pedido : pedidos) {
        //     pacotes.addAll(esteira1.processarPedido(pedido));
        //     System.out.println(pedido);
        // }

    }
}

