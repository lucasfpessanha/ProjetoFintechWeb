package br.com.fintech.teste;

import java.util.List;

import br.com.fintech.bean.Cadastro;
import br.com.fintech.dao.CadastroDao;

public class TesteNome {

	public static void main(String[] args) {
		CadastroDao dao = new CadastroDao();

		List<Cadastro> lista = dao.listar();
		for (Cadastro nome : lista) {
			System.out.println(nome.getNome());
		}

	}

}
