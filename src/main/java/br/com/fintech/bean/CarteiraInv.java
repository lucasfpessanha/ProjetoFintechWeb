package br.com.fintech.bean;

import java.sql.Date;

public class CarteiraInv {

	private String cd_carteira;

	private int cd_conta;

	private int cd_cadastro;

	private int vl_investido;

	private Date dt_investimento;

	public CarteiraInv(String cd_carteira, int cd_conta, int cd_cadastro, int vl_investido, Date dt_investimento) {
		this.cd_carteira = cd_carteira;
		this.cd_conta = cd_conta;
		this.cd_cadastro = cd_cadastro;
		this.vl_investido = vl_investido;
		this.dt_investimento = dt_investimento;
	}

	public CarteiraInv() {

	}

	public String getCd_carteira() {
		return cd_carteira;
	}

	public void setCd_carteira(String cd_carteira) {
		this.cd_carteira = cd_carteira;
	}

	public int getCd_conta() {
		return cd_conta;
	}

	public void setCd_conta(int cd_conta) {
		this.cd_conta = cd_conta;
	}

	public int getCd_cadastro() {
		return cd_cadastro;
	}

	public void setCd_cadastro(int cd_cadastro) {
		this.cd_cadastro = cd_cadastro;
	}

	public int getVl_investido() {
		return vl_investido;
	}

	public void setVl_investido(int vl_investido) {
		this.vl_investido = vl_investido;
	}

	public Date getDt_investimento() {
		return dt_investimento;
	}

	public void setDt_investimento(Date dt_investimento) {
		this.dt_investimento = dt_investimento;
	}

}
