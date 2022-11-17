package br.com.fintech.teste;

import java.util.List;

import br.com.fintech.bean.Cadastro;
import br.com.fintech.dao.CadastroDao;

public class TesteLista {

	public static void main(String[] args) {

		CadastroDao dao = new CadastroDao();

		List<Cadastro> lista = dao.listar();
		for (Cadastro item : lista) {
			System.out.println("\nCódigo: " + item.getCodigo() + "\nNome: " + item.getNome() + "\nE-mail: "
					+ item.getEmail() + "\nEndereço: " + item.getEndereco() + "\nTelefone: " + item.getTelefone()
					+ "\nSexo: " + item.getSexo() + "\n---------------------------");
		}

	}

}
