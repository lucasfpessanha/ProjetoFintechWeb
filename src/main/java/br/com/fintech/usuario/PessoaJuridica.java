package br.com.fintech.usuario;
/**
 * Subclasse PessoaJuridica filha da Superclasse Pessoa
 * @author Rafael Feitosa, Adriano Ferreira, João Mota, Beatriz de Menezes, Lucas Pessanha
 * @version 1.2
 * @see Pessoa
 */
public class PessoaJuridica extends Pessoa {

    private String cnpj;

    public PessoaJuridica(int codPessoa, String nome, String endereco, String fone, String cnpj) {
        super(codPessoa, nome, endereco, fone);
        this.cnpj = cnpj;
    }
    /**
     * @return Cnpj registrado
     */
    public String getCnpj() {
        return cnpj;
    }
    /**
     * Altera o valor de cnpj
     * @param cnpj que deseja registrar
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
    /**
     * Metodo para gravar o usuário
     */
    @Override
    public void gravarusuario() {
        System.out.println("Gravando Pessoa Juridica");
    }
    /**
     * @return Cadastro do usuário
     */
    @Override
    public String visualizarCadastro() {
        return "Pessoa Juridica: " + super.getNome() + " \nCNPJ: " + this.getCnpj() + "\nEndereço: " + super.getEndereco()
                + "\nTelefone: " + super.getFone();
    }


}
