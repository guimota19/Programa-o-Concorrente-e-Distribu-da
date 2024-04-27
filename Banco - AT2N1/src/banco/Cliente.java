/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author guimo
 */
class Cliente extends Thread {
    private String nome;
    private Conta conta;
    private Loja loja1;
    private Loja loja2;

    public Cliente(String nome, double saldoInicial, Loja loja1, Loja loja2) {
        this.nome = nome;
        this.conta = new Conta(saldoInicial);
        this.loja1 = loja1;
        this.loja2 = loja2;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            synchronized (conta) {
                double valorCompra = (i % 2 == 0) ? 100.0 : 200.0;
                if (conta.getSaldo() >= valorCompra) {
                    conta.sacar(valorCompra);
                    if (i % 2 == 0) {
                        loja1.receberPagamento(valorCompra);
                    } else {
                        loja2.receberPagamento(valorCompra);
                    }
                    System.out.println(nome + " realizou uma compra de R$" + valorCompra);
                }
            }
        }
    }
    
    public void mostrarSaldoFinal() {
        System.out.println("Saldo final do cliente " + nome + ": R$" + conta.getSaldo());
    }

  
}


