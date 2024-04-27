/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author guimo
 */
class Loja {
    private String nome;
    private Conta contaLoja;
    private double salarioFuncionario = 1400.00;

    public Loja(String nome, double saldoInicial) {
        this.nome = nome;
        this.contaLoja = new Conta(saldoInicial);
    }

    public void receberPagamento(double valor) {
        synchronized (contaLoja) {
            contaLoja.depositar(valor);
            System.out.println("Loja " + nome + " recebeu pagamento de R$" + valor);
        }
    }

    public void pagarFuncionario() {
        synchronized (contaLoja) {
            if (contaLoja.getSaldo() >= salarioFuncionario) {
                contaLoja.sacar(salarioFuncionario);
                System.out.println("Loja " + nome + " pagou salário de R$" + salarioFuncionario + " para funcionários.");
            }
        }
    }
    
    public void mostrarSaldoFinal() {
        System.out.println("Saldo final da loja " + nome + ": R$" + contaLoja.getSaldo());
    }
    
    
    
    
}
