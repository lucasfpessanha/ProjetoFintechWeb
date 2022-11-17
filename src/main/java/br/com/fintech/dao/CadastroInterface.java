package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Cadastro;

public interface CadastroInterface {

	public void cadastrar(Cadastro cadastro);

	public List<Cadastro> listar();

	public void atualizar(Cadastro cadastro);

	public void removerCadastro(int codigo);

	public Cadastro buscarPorCod(int codigoBusca);

}
