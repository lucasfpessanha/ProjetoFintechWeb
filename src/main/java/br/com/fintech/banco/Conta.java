package br.com.fintech.banco;

import java.io.Serializable;

/**
 * Classe que abstrai uma Conta Bancária
 * @author Rafael Feitosa, Adriano Ferreira, João Mota, Beatriz de Menezes, Lucas Pessanha
 * @version 1.2
 */
public class Conta implements Serializable {
    private Integer agencia;
    private Integer numero;
    private Double saldo;

    public Conta() {

    }

    public Conta(Integer numero, Double saldo, Integer agencia) {
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = saldo;
    }

    /**
     * @return digitos da agencia
     */
    public int getAgencia() {
        return agencia;
    }

    /**
     * Altera a Agencia da conta
     * @param agencia da conta
     */
    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }
    /**
     * Verifica o saldo da conta
     * @return Saldo da conta
     */
    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return Numero da Conta
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Altera o numero da conta
     * @param numero da conta
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    /**
     * Acrescenta valor ao Saldo da Conta
     * @param valor que será depositado
     */
    public void depositar(Double valor) {
        this.saldo += valor;
    }

    /**
     * Retira um valor do Saldo da Conta
     * @param valor
     * @see depositar
     */
    public void retirar(Double valor) {
        this.saldo -= valor;
    }

    /**
     * Verificar saldo disponivel na conta
     * @return saldo disponivel na conta
     */
    public Double verificarSaldo(){
        return saldo;
    }
}
