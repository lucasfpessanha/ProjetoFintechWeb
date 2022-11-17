package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.Conta;
import br.com.fintech.jdbc.FintechDB;

public class ContaDao implements ContaInterface {

	private Connection conexao;

	public void conta(Conta conta) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "INSERT INTO T_FIN_CONTA(CD_CONTA, CD_CADASTRO, CD_CARTEIRA, NR_AGENCIA, NR_CONTA, VL_SALDO, DS_TIPO_CONTA) VALUES (?, ?, ?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCd_conta());
			stmt.setInt(2, conta.getCd_cadastro());
			stmt.setString(3, conta.getCd_carteira());
			stmt.setInt(4, conta.getNr_agencia());
			stmt.setInt(5, conta.getNr_conta());
			stmt.setInt(6, conta.getVl_saldo());
			stmt.setString(7, conta.getDs_conta());

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

	public List<Conta> listar() {
		List<Conta> lista = new ArrayList<Conta>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CONTA");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int cd_codigo = rs.getInt("CD_CONTA");
				int cd_cadastro = rs.getInt("CD_CADASTRO");
				String cd_carteira = rs.getNString("CD_CARTEIRA");
				int nr_agencia = rs.getInt("NR_AGENCIA");
				int nr_conta = rs.getInt("NR_CONTA");
				int vl_saldo = rs.getInt("VL_SALDO");
				String tipo_conta = rs.getString("DS_TIPO_CONTA");

				Conta conta = new Conta(cd_codigo, cd_cadastro, cd_carteira, nr_agencia, nr_conta, vl_saldo,
						tipo_conta);
				lista.add(conta);
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

	public void atualizar(Conta conta) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "UPDATE T_FIN_CADASTRO SET CD_CADASTRO = ?, CD_CARTEIRA = ?, NR_AGENCIA = ?, NR_CONTA = ?, VL_SALDO = ?, DS_TIPO_CONTA = ? WHERE CD_CONTA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getCd_conta());
			stmt.setInt(2, conta.getCd_cadastro());
			stmt.setNString(3, conta.getCd_carteira());
			stmt.setInt(4, conta.getNr_agencia());
			stmt.setInt(5, conta.getNr_conta());
			stmt.setInt(6, conta.getVl_saldo());
			stmt.setString(7, conta.getDs_conta());

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

	public void removerConta(int codigo) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "DELETE FROM T_FIN_CONTA WHERE CD_CONTA = ?";
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

	public Conta buscarPorCod(int codigoBusca) {
		Conta conta = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CONTA WHERE CD_CONTA = ?");
			stmt.setInt(1, codigoBusca);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int cd_codigo = rs.getInt("CD_CONTA");
				int cd_cadastro = rs.getInt("CD_CADASTRO");
				String cd_carteira = rs.getNString("CD_CARTEIRA");
				int nr_agencia = rs.getInt("NR_AGENCIA");
				int nr_conta = rs.getInt("NR_CONTA");
				int vl_saldo = rs.getInt("VL_SALDO");
				String tipo_conta = rs.getString("DS_TIPO_CONTA");

				conta = new Conta(cd_codigo, cd_cadastro, cd_carteira, nr_agencia, nr_conta, vl_saldo, tipo_conta);
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
		return conta;
	}
}
