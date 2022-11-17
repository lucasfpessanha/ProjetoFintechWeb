package br.com.fintech.usuario;
/**
 * Subclasse PessoaFisica filha da Superclasse Pessoa
 * @author Rafael Feitosa, Adriano Ferreira, João Mota, Beatriz de Menezes, Lucas Pessanha
 * @version 1.2
 * @see Pessoa
 */
public class PessoaFisica extends Pessoa {

    private String cpf;

    public PessoaFisica(int codPessoa, String nome, String endereco, String fone, String cpf) {
        super(codPessoa, nome, endereco, fone);
        this.cpf = cpf;
    }

    /**
     * @return CPF registrado
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Altera o valor de cpf
     * @param cpf que deseja registrar
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Metodo para gravar o usuário
     */
    @Override
    public void gravarusuario() {
        System.out.println("Gravando Pessoa Física");
    }
    /**
     * @return Cadastro do usuário
     */
    @Override
    public String visualizarCadastro() {
        return "\nPessoa Física: " + super.getNome() + "\nCPF: " + this.getCpf() + "\nEndereço: " + super.getEndereco()
                + "\nTelefone: " + super.getFone();
    }

}
