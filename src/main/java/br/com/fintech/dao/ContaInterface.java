package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Conta;

public interface ContaInterface {

	public void conta(Conta cadastro);

	public List<Conta> listar();

	public void atualizar(Conta cadastro);

	public void removerConta(int codigo);

	public Conta buscarPorCod(int codigoBusca);

}
