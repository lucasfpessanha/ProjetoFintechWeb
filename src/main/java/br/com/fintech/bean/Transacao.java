package br.com.fintech.bean;

import java.sql.Date;

public class Transacao {

	private int nr_transacao;

	private int cd_conta;

	private int vl_receita;

	private int vl_despesa;

	private Date dt_transacao;

	public Transacao(int nr_transacao, int cd_conta, int vl_receita, int vl_despesa, Date dt_transacao) {
		this.nr_transacao = nr_transacao;
		this.cd_conta = cd_conta;
		this.vl_receita = vl_receita;
		this.vl_despesa = vl_despesa;
		this.dt_transacao = dt_transacao;
	}

	public Transacao() {

	}

	public int getNr_transacao() {
		return nr_transacao;
	}

	public void setNr_transacao(int nr_transacao) {
		this.nr_transacao = nr_transacao;
	}

	public int getCd_conta() {
		return cd_conta;
	}

	public void setCd_conta(int cd_conta) {
		this.cd_conta = cd_conta;
	}

	public int getVl_receita() {
		return vl_receita;
	}

	public void setVl_receita(int vl_receita) {
		this.vl_receita = vl_receita;
	}

	public int getVl_despesa() {
		return vl_despesa;
	}

	public void setVl_despesa(int vl_despesa) {
		this.vl_despesa = vl_despesa;
	}

	public Date getDt_transacao() {
		return dt_transacao;
	}

	public void setDt_transacao(Date dt_transacao) {
		this.dt_transacao = dt_transacao;
	}

}
