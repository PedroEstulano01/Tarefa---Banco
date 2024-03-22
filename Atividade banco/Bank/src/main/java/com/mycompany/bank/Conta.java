package com.mycompany.bank;


public class Conta{
    //atributos
    private Pessoa titular;
    private String agencia;
    private String numero;
    private int banco; 
    private double saldo;

    public Conta(Pessoa titular, String agencia, String numero, int banco, double saldo) {
        this.titular = titular;
        this.agencia = agencia;
        this.numero = numero;
        this.banco = banco;
        if(saldo > 0) this.saldo = saldo;
        else this.saldo = 0;
    }

    public Conta(String numero, int banco, Pessoa titular){
        this.numero = numero;
        this.banco = banco;
        this.titular = titular;
        this.agencia = "0001";
        this.saldo = 0;
    }

    public Conta(String numero, int banco, Pessoa titular, String agencia){
        this.numero = numero;
        this.banco = banco;
        this.titular = titular;
        this.agencia = agencia;
        this.saldo = 0;
    }

    
    
    //métodos
    // Regra: Saldo não pode ser negativo!

    

    public boolean depositar(double valor){
        if(valor > 0){
            saldo = saldo + valor;
            return true;
        }
        return false;
    }

    public boolean sacar(double valor){
        if(valor > 0 && valor <= saldo){
            saldo = saldo - valor;
            return true;
        }
        return false;
    }

    public boolean transferir(double valor, Conta contaDestino){
        if(sacar(valor)){
            contaDestino.depositar(valor);
            return true;
        }
        return false;
    }

    // getXXXXXX - Entrega a informação do atributo XXXXX
    // setXXXXX - Altera a informação do atributo XXXXXX
 
    public Pessoa getTitular() {
        return titular;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getBanco() {
        return banco;
    }

    public void setBanco(int banco) {
        this.banco = banco;
    }

    public double getSaldo(){
        return this.saldo;
    }

}

