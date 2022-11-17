package br.com.fintech.teste;

import br.com.fintech.dao.CadastroDao;

public class TesteRemocao {

	public static void main(String[] args) {
		CadastroDao dao = new CadastroDao();
		int i = 0;
		int y = 1;

		do {

			dao.removerCadastro(1000 + y++);
			i++;
			System.out.println("Removido");
		} while (i < 100000000);

	}

}
