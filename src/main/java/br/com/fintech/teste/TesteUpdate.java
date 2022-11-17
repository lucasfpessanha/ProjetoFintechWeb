package br.com.fintech.teste;

import br.com.fintech.bean.Cadastro;
import br.com.fintech.dao.CadastroDao;

public class TesteUpdate {

	public static void main(String[] args) {
		CadastroDao dao = new CadastroDao();

		Cadastro cadastro = dao.buscarPorCod(50);

		System.out.println("Código: " + cadastro.getCodigo() + "\nNome: " + cadastro.getNome() + "\nEmail: "
				+ cadastro.getEmail() + "\nEnderço: " + cadastro.getEndereco() + "\nTelefone: " + cadastro.getTelefone()
				+ "\nSexo: " + cadastro.getSexo());

		cadastro.setNome("Rafael Feitosa");
		cadastro.setEmail("RafaelSpears@Gmail.com");

		dao.atualizar(cadastro);

	}

}
