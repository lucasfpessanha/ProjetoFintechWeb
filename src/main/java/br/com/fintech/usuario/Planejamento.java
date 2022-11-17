package br.com.fintech.usuario;

import java.util.Date;
import java.io.Serializable;


/**
 * Classe que abstrai um planejamento;
 *
 * @author , Adriano Ferreira, Beatriz de Menezes, João Mota, Lucas Pessanha, Rafael Feitosa
 * @version 1.1
 */
public class Planejamento implements Serializable {

    private Integer metaFinanceira;

    private Date periodo;

    private Double valor;

    public Planejamento() {

    }

    public Planejamento(Integer metaFinanceira, Date periodo, Double valor, Integer metaFinanceira1) {
        this.metaFinanceira = getMetaFinanceira(metaFinanceira);
        this.periodo = getPeriodo(periodo);
        this.valor = getValor(valor);

    }

    /**
     * @return Meta financeira.
     */
    public static Integer getMetaFinanceira(Integer metaFinanceira) {
        return metaFinanceira;
    }

    /**
     * @return Período
     */
    public static Date getPeriodo(Date periodo) {
        return periodo;
    }

    /**
     * @return Valor da meta financeira do usuário.
     */
    public static Double getValor(Double valor) {
        return valor;
    }

    /**
     * @return MetaFinanceira do Planejamento.
     */
    public Integer getMetaFinanceira() {
        return metaFinanceira;
    }

    /**
     * Altera a Meta Finaceira do usuário.
     *
     * @param metaFinanceira do Planejamento.
     */
    public void setMetaFinanceira(Integer metaFinanceira) {
        this.metaFinanceira = metaFinanceira;
    }

    public Date getPeriodo() {
        return periodo;
    }

    /**
     * Altera a periodo da meta do usuário.
     *
     * @param periodo da meta financeira do Planejamento.
     */
    public void setPeriodo(Date periodo) {
        this.periodo = periodo;


    }

    /**
     * @return Valor do meta financeira do Planejamento.
     */
    public Double getValor() {
        return valor;
    }

    /**
     * Altera a valor da meta do usuário.
     *
     * @param valor da meta financeira do Planejamento.
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

}

