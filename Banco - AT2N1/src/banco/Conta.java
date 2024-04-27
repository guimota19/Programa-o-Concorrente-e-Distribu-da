/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author guimo
 */
class Conta {
    private static int nextId = 1;
    private int id;
    private double saldo;
    private Lock lock;

    public Conta(double saldoInicial) {
        this.id = nextId++;
        this.saldo = saldoInicial;
        this.lock = new ReentrantLock();
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public void sacar(double valor) {
        saldo -= valor;
    }

    public Lock getLock() {
        return lock;
    }
}
