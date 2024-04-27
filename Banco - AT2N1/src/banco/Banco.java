/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author guimo
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    public static void main(String[] args) {
        // Criação das lojas, funcionários e clientes
        Loja loja1 = new Loja("Loja1", 0.0);
        Loja loja2 = new Loja("Loja2", 0.0);
        Funcionario func1 = new Funcionario("Func1", loja1);
        Funcionario func2 = new Funcionario("Func2", loja1);
        Funcionario func3 = new Funcionario("Func3", loja2);
        Funcionario func4 = new Funcionario("Func4", loja2);
        Cliente cliente1 = new Cliente("Cliente1", 1000.0, loja1, loja2);
        Cliente cliente2 = new Cliente("Cliente2", 1000.0, loja1, loja2);
        Cliente cliente3 = new Cliente("Cliente3", 1000.0, loja1, loja2);
        Cliente cliente4 = new Cliente("Cliente4", 1000.0, loja1, loja2);
        Cliente cliente5 = new Cliente("Cliente5", 1000.0, loja1, loja2);

        // Início das threads
        func1.start();
        func2.start();
        func3.start();
        func4.start();
        cliente1.start();
        cliente2.start();
        cliente3.start();
        cliente4.start();
        cliente5.start();

        // Espera todas as threads terminarem
        try {
            func1.join();
            func2.join();
            func3.join();
            func4.join();
            cliente1.join();
            cliente2.join();
            cliente3.join();
            cliente4.join();
            cliente5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibir saldos finais
        System.out.println("Saldo final das lojas:");
        loja1.mostrarSaldoFinal();
        loja2.mostrarSaldoFinal();
        System.out.println("Saldo final dos funcionários:");
        func1.mostrarSaldoFinal();
        func2.mostrarSaldoFinal();
        func3.mostrarSaldoFinal();
        func4.mostrarSaldoFinal();
        System.out.println("Saldo final dos clientes:");
        cliente1.mostrarSaldoFinal();
        cliente2.mostrarSaldoFinal();
        cliente3.mostrarSaldoFinal();
        cliente4.mostrarSaldoFinal();
        cliente5.mostrarSaldoFinal();
    }
}