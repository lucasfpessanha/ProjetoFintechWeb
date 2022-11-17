package br.com.fintech.usuario;

/**
 * Classe de testes para a classe filha PessoaFisica, entrada e saida de dados.
 */
public class TestePessoaFisica {
    public static void main(String[] args) {

        PessoaFisica cc = new PessoaFisica(1,"Rafael","Rua Mota","11 0000-0000","0123456-88");

        System.out.print(cc.visualizarCadastro());

    }
}

