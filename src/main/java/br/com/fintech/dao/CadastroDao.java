package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.Cadastro;
import br.com.fintech.jdbc.FintechDB;

public class CadastroDao implements CadastroInterface {

	private Connection conexao;

	public void cadastrar(Cadastro cadastro) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "INSERT INTO T_FIN_CADASTRO(CD_CADASTRO, NM_PESSOA, DS_EMAIL, DS_ENDERECO, NR_TELEFONE, DS_SEXO) VALUES (?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cadastro.getCodigo());
			stmt.setString(2, cadastro.getNome());
			stmt.setString(3, cadastro.getEmail());
			stmt.setString(4, cadastro.getEndereco());
			stmt.setString(5, cadastro.getTelefone());
			stmt.setString(6, cadastro.getSexo());

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<Cadastro> listar() {
		List<Cadastro> lista = new ArrayList<Cadastro>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CADASTRO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int codigo = rs.getInt("CD_CADASTRO");
				String nome = rs.getString("NM_PESSOA");
				String email = rs.getString("DS_EMAIL");
				String endereco = rs.getString("DS_ENDERECO");
				String telefone = rs.getString("NR_TELEFONE");
				String sexo = rs.getString("DS_SEXO");

				Cadastro cadastro = new Cadastro(codigo, nome, email, endereco, telefone, sexo);
				lista.add(cadastro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return lista;

	}

	public void atualizar(Cadastro cadastro) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "UPDATE T_FIN_CADASTRO SET NM_PESSOA = ?, DS_EMAIL = ?, DS_ENDERECO = ?, NR_TELEFONE = ?, DS_SEXO = ? WHERE CD_CADASTRO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cadastro.getNome());
			stmt.setString(2, cadastro.getEmail());
			stmt.setString(3, cadastro.getEndereco());
			stmt.setString(4, cadastro.getTelefone());
			stmt.setString(5, cadastro.getSexo());
			stmt.setInt(6, cadastro.getCodigo());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void removerCadastro(int codigo) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "DELETE FROM T_FIN_CADASTRO WHERE CD_CADASTRO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, codigo);
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Cadastro buscarPorCod(int codigoBusca) {
		Cadastro cadastro = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CADASTRO WHERE CD_CADASTRO = ?");
			stmt.setInt(1, codigoBusca);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int codigo = rs.getInt("CD_CADASTRO");
				String nome = rs.getString("NM_PESSOA");
				String email = rs.getString("DS_EMAIL");
				String endereco = rs.getString("DS_ENDERECO");
				String telefone = rs.getString("NR_TELEFONE");
				String sexo = rs.getString("DS_SEXO");

				cadastro = new Cadastro(codigo, nome, email, endereco, telefone, sexo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cadastro;
	}

}
