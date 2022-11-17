package br.com.fintech.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fintech.bean.CarteiraInv;
import br.com.fintech.jdbc.FintechDB;

public class CarteiraInvDao implements CarteiraInvInterface {
	private Connection conexao;

	public void carteira(CarteiraInv carteira) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "INSERT INTO T_FIN_CARTEIRA_INV(CD_CARTEIRA, CD_CONTA, CD_CADASTRO, VL_INVESTIDO, DT_INVESTIMENTO) VALUES (?, ?, ?, ?, ?)";
			stmt = conexao.prepareStatement(sql);
			stmt.setNString(1, carteira.getCd_carteira());
			stmt.setInt(2, carteira.getCd_conta());
			stmt.setInt(3, carteira.getCd_cadastro());
			stmt.setInt(4, carteira.getVl_investido());
			stmt.setDate(5, carteira.getDt_investimento());

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

	public List<CarteiraInv> listar() {
		List<CarteiraInv> lista = new ArrayList<CarteiraInv>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CARTEIRA_INV");
			rs = stmt.executeQuery();

			while (rs.next()) {
				String cd_carteira = rs.getNString("CD_CARTEIRA");
				int cd_conta = rs.getInt("CD_CONTA");
				int cd_cadastro = rs.getInt("CD_CADASTRO");
				int vl_investido = rs.getInt("VL_INVESTIDO");
				Date dt_investimento = rs.getDate("DT_INVESTIMENTO");

				CarteiraInv carteira = new CarteiraInv(cd_carteira, cd_cadastro, cd_conta, vl_investido,
						dt_investimento);
				lista.add(carteira);
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

	public void atualizar(CarteiraInv carteira) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "UPDATE T_FIN_CARTEIRA_INV SET CD_CONTA = ?, CD_CADASTRO = ?, VL_INVESTIDO = ?, DT_INVESTIMENTO = ? WHERE CD_CARTEIRA = ?";
			stmt = conexao.prepareStatement(sql);
			stmt.setNString(1, carteira.getCd_carteira());
			stmt.setInt(2, carteira.getCd_conta());
			stmt.setInt(3, carteira.getCd_cadastro());
			stmt.setInt(4, carteira.getVl_investido());
			stmt.setDate(5, carteira.getDt_investimento());

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

	public void removerCarteira(int codigo) {
		PreparedStatement stmt = null;

		try {
			conexao = FintechDB.obterconexao();
			String sql = "DELETE FROM T_FIN_CARTEIRA_INV WHERE CD_CARTEIRA = ?";
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

	public CarteiraInv buscarPorCod(int codigoBusca) {
		CarteiraInv carteira = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			conexao = FintechDB.obterconexao();
			stmt = conexao.prepareStatement("SELECT * FROM T_FIN_CARTEIRA_INV WHERE CD_CARTEIRA = ?");
			stmt.setInt(1, codigoBusca);
			rs = stmt.executeQuery();

			if (rs.next()) {
				String cd_carteira = rs.getNString("CD_CARTEIRA");
				int cd_conta = rs.getInt("CD_CONTA");
				int cd_cadastro = rs.getInt("CD_CADASTRO");
				int vl_investido = rs.getInt("VL_INVESTIDO");
				Date dt_investimento = rs.getDate("DT_INVESTIMENTO");

				carteira = new CarteiraInv(cd_carteira, cd_conta, cd_cadastro, vl_investido, dt_investimento);
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
		return carteira;
	}
}
