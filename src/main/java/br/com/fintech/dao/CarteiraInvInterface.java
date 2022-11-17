package br.com.fintech.dao;

import java.util.List;

import br.com.fintech.bean.CarteiraInv;

public interface CarteiraInvInterface {

	public void carteira(CarteiraInv carteira);

	public List<CarteiraInv> listar();

	public void atualizar(CarteiraInv carteira);

	public void removerCarteira(int codigo);

	public CarteiraInv buscarPorCod(int codigoBusca);

}
