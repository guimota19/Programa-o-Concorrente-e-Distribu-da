/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banco;

/**
 *
 * @author guimo
 */
class Funcionario extends Thread {
    private String nome;
    private Loja loja;
    private Conta contaSalario;
    private Conta contaInvestimentos;
    private double salario;

    public Funcionario(String nome, Loja loja) {
        this.nome = nome;
        this.loja = loja;
        this.salario = 1400.00;
        this.contaSalario = new Conta(salario);
        this.contaInvestimentos = new Conta(0.0);
    }

    @Override
    public void run() {
        synchronized (loja) {
            loja.pagarFuncionario();
            contaInvestimentos.depositar(salario * 0.2);
            System.out.println("Funcionario " + nome + " recebeu salario e investiu R$" + (salario * 0.2) + " em investimentos.");
        }
    }
    
    public void mostrarSaldoFinal() {
        System.out.println("Saldo final do funcionário " + nome + ": R$" + contaSalario.getSaldo());
        System.out.println("Saldo final dos investimentos do funcionário " + nome + ": R$" + contaInvestimentos.getSaldo());
    }
    
}
