package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.Agencia;

public interface AgenciaInterface {

	public void agencia(Agencia agencia);

	public List<Agencia> listar();

	public void atualizar(Agencia cadastro);

	public void removerAgencia(int codigo);

	public Agencia buscarPorCod(int codigoBusca);
}
