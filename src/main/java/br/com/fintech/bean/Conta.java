package br.com.fintech.bean;

public class Conta {

	private int cd_conta;

	private int cd_cadastro;

	private String cd_carteira;

	private int nr_agencia;

	private int nr_conta;

	private int vl_saldo;

	private String ds_conta;

	public Conta(int cd_conta, int cd_cadastro, String cd_carteira, int nr_agencia, int nr_conta, int vl_saldo,
			String ds_conta) {
		super();
		this.cd_conta = cd_conta;
		this.cd_cadastro = cd_cadastro;
		this.cd_carteira = cd_carteira;
		this.nr_agencia = nr_agencia;
		this.nr_conta = nr_conta;
		this.vl_saldo = vl_saldo;
		this.ds_conta = ds_conta;
	}

	public Conta() {
		super();
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

	public String getCd_carteira() {
		return cd_carteira;
	}

	public void setCd_carteira(String cd_carteira) {
		this.cd_carteira = cd_carteira;
	}

	public int getNr_agencia() {
		return nr_agencia;
	}

	public void setNr_agencia(int nr_agencia) {
		this.nr_agencia = nr_agencia;
	}

	public int getNr_conta() {
		return nr_conta;
	}

	public void setNr_conta(int nr_conta) {
		this.nr_conta = nr_conta;
	}

	public int getVl_saldo() {
		return vl_saldo;
	}

	public void setVl_saldo(int vl_saldo) {
		this.vl_saldo = vl_saldo;
	}

	public String getDs_conta() {
		return ds_conta;
	}

	public void setDs_conta(String ds_conta) {
		this.ds_conta = ds_conta;
	}

}
