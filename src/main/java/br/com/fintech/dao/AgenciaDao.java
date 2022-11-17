package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.Agencia;
import br.com.fintech.jdbc.FintechDB;

public class AgenciaDao {
	private Connection conexao;

	public void agencia(Agencia agencia) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "INSERT INTO T_FIN_CONTA(NR_AGENCIA, NM_AGENCIA) VALUES (?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(2, agencia.getNr_agencia());
			stmt.setString(1, agencia.getNm_agencia());

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

	public List<Agencia> listar() {
		List<Agencia> lista = new ArrayList<Agencia>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_AGENCIA");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int nr_agencia = rs.getInt("NR_AGENCIA");
				String nm_agencia = rs.getString("NM_AGENCIA");

				Agencia agencia = new Agencia(nr_agencia, nm_agencia);
				lista.add(agencia);
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

	public void atualizar(Agencia agencia) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "UPDATE T_FIN_AGENCIA SET NR_AGENCIA = ?, NM_AGENCIA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, agencia.getNr_agencia());
			stmt.setString(2, agencia.getNm_agencia());

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

	public void removerAgencia(int codigo) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "DELETE FROM T_FIN_AGENCIA WHERE NR_AGENCIA = ?";
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

	public Agencia buscarPorCod(int codigoBusca) {
		Agencia agencia = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_AGENCIA WHERE NR_AGENCIA = ?");
			stmt.setInt(1, codigoBusca);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int nr_agencia = rs.getInt("NR_AGENCIA");
				String nm_agencia = rs.getString("NM_AGENCIA");

				agencia = new Agencia(nr_agencia, nm_agencia);
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
		return agencia;
	}
}