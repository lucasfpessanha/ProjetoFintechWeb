package br.com.fintech.usuario;
/**
 * Classe que abstrai uma Pessoa
 * @author Rafael Feitosa, Adriano Ferreira, João Mota, Beatriz de Menezes, Lucas Pessanha
 * @version 1.2
 */
public abstract class Pessoa {
    private int codPessoa;
    private String nome;
    private String endereco;
    private String fone;

    public Pessoa(){

    }

    public Pessoa(int codPessoa, String nome, String endereco, String fone) {
        this.codPessoa = codPessoa;
        this.nome = nome;
        this.endereco = endereco;
        this.fone = fone;
    }

    public int getCodPessoa() {
        return codPessoa;
    }

    public void setCodPessoa(int codPessoa) {
        this.codPessoa = codPessoa;
    }

    /**
     *
     * @return Nome registrado
     */
    public String getNome() {
        return nome;
    }
    /**
     *
     * @param nome o nome do usuário
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return Endereço registrado
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Altera o endereço do usuário
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @return Telefone registrado
     */
    public String getFone() {
        return fone;
    }

    /**
     * Registra o numero de telefone
     * @param fone
     */
    public void setFone(String fone) {
        this.fone = fone;
    }


    /**
     * Metodo abstrato para retornar um valor ao registrar o usuário
     */
    public abstract void gravarusuario();

    /**
     * Metodo abstrato para visualizar cadastro do usuário
     */
    public abstract String visualizarCadastro();

}



