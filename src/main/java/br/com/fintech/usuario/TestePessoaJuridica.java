package br.com.fintech.usuario;

/**
 * Classe de testes para a classe filha PessoaJuridica, entrada e saida de dados.
 */
public class TestePessoaJuridica {
    public static void main(String[] args) {

        PessoaJuridica cc = new PessoaJuridica(1,"Rafael","Rua Mota","11 0000-0000", "XX. XXX. XXX/0001-XX.");

        System.out.print(cc.visualizarCadastro());

    }
}

