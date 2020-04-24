package br.mack.ps2;

import java.math.BigDecimal;

public class Conta {
    private int id;
    private String nome;
    private BigDecimal saldo;
    private int agencia;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public int getAgencia() {
        return this.agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }


    public String toString() {
        return "|" +
            " id  " + getId() + "|" +
            " nome  " + getNome() + "|" +
            " saldo " + getSaldo() + "|" +
            " agencia  " + getAgencia() + "|";
    }

}