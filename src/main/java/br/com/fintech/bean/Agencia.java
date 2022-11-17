package br.com.fintech.bean;

public class Agencia {

	private int nr_agencia;

	private String nm_agencia;

	public Agencia(int nr_agencia, String nm_agencia) {
		super();
		this.nr_agencia = nr_agencia;
		this.nm_agencia = nm_agencia;
	}

	public Agencia() {
		super();
	}

	public int getNr_agencia() {
		return nr_agencia;
	}

	public void setNr_agencia(int nr_agencia) {
		this.nr_agencia = nr_agencia;
	}

	public String getNm_agencia() {
		return nm_agencia;
	}

	public void setNm_agencia(String nm_agencia) {
		this.nm_agencia = nm_agencia;
	}

}
