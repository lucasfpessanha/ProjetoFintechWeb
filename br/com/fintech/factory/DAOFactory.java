package br.com.fintech.factory;
import br.com.fintech.dao;

public class DAOFactory {	public static CadastroDao getCadastroDao() {
	return new CadastroInterface();
}


}
