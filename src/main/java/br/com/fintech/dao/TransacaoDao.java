package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.Transacao;
import br.com.fintech.jdbc.FintechDB;

public class TransacaoDao implements TransacaoInterface {
	private Connection conexao;

	public void transacao(Transacao transacao) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "INSERT INTO T_FIN_TRANSACAO(NR_TANSACAO, CD_CONTA, VL_RECEITA, VL_DESPESA, DT_TRANSACAO) VALUES (?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, transacao.getNr_transacao());
			stmt.setInt(2, transacao.getCd_conta());
			stmt.setInt(3, transacao.getVl_receita());
			stmt.setInt(4, transacao.getVl_despesa());
			stmt.setDate(5, transacao.getDt_transacao());

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

	public List<Transacao> listar() {
		List<Transacao> lista = new ArrayList<Transacao>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_TRANSACAO");
			rs = stmt.executeQuery();

			while (rs.next()) {
				int nr_transacao = rs.getInt("NR_TRANSACAO");
				int cd_conta = rs.getInt("CD_CONTA");
				int vl_receita = rs.getInt("CD_CADASTRO");
				int vl_despesa = rs.getInt("VL_INVESTIDO");
				Date dt_transacao = rs.getDate("DT_INVESTIMENTO");

				Transacao transacao = new Transacao(nr_transacao, cd_conta, vl_receita, vl_despesa, dt_transacao);
				lista.add(transacao);
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

	public void atualizar(Transacao transacao) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "UPDATE T_FIN_TRANSACAO SET CD_CONTA = ?, VL_RECEITA = ?, VL_DESPESA = ?, DT_TRANSACAO WHERE NR_TRANSACAO = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, transacao.getNr_transacao());
			stmt.setInt(2, transacao.getCd_conta());
			stmt.setInt(3, transacao.getVl_receita());
			stmt.setInt(4, transacao.getVl_despesa());
			stmt.setDate(5, transacao.getDt_transacao());

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

	public void removerTransacao(int codigo) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "DELETE FROM T_FIN_TRANSACAO WHERE NR_TRANSACAO = ?";
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

	public Transacao buscarPorCod(int codigoBusca) {
		Transacao transacao = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_TRANSACAO WHERE NR_TRANSACAO = ?");
			stmt.setInt(1, codigoBusca);
			rs = stmt.executeQuery();

			if (rs.next()) {
				int nr_transacao = rs.getInt("NR_TRANSACAO");
				int cd_conta = rs.getInt("CD_CONTA");
				int vl_receita = rs.getInt("VL_RECEITA");
				int vl_despesa = rs.getInt("VL_DESPESA");
				Date dt_transacao = rs.getDate("DT_TRANSACAO");

				transacao = new Transacao(nr_transacao, cd_conta, vl_receita, vl_despesa, dt_transacao);
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
		return transacao;
	}
}
