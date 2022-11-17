package br.com.fintech.banco;
/**
 * Classe de testes para a classe conta, entrada e saida de dados.
 */
public class TesteConta {
    public static void main(String[] args) {
        Conta cc  = new Conta();
        cc.setAgencia(184);
        cc.setNumero(323);
        cc.setSaldo(500.00);
        cc.depositar(1000.0);
        System.out.print(cc.verificarSaldo());

    }
}
