package br.com.fintech.teste;

import br.com.fintech.bean.Cadastro;
import br.com.fintech.dao.CadastroDao;

public class TesteCadastro {

	public static void main(String[] args) {
		CadastroDao dao = new CadastroDao();
		int i = 0;
		int y = 1;
		do {

			Cadastro cadastro = new Cadastro();
			cadastro.setCodigo(0 + y++);
			cadastro.setNome("João Mota");
			cadastro.setEmail("motaSpears@Britney.com");
			cadastro.setEndereco("Pindamonhagaba");
			cadastro.setTelefone("11 92392342942");
			cadastro.setSexo("M");

			dao.cadastrar(cadastro);

			System.out.println("DALE DELE DOLLY");
			i++;
		} while (i < 100000000);
	}

}
