package com.gabrieljuarez.models;

public class Cuenta_bancaria {
    String titular;
    double saldo;

    public Cuenta_bancaria(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public void depositar(double valor){
        this.saldo += valor;
    }

    public void  retirar(double valor){
        if (valor > this.saldo){
            System.out.println("No tienes saldo suficiente para hacer el retiro");
        }else{
            this.saldo -= valor;
        }
    }

    public void mostrar_datos_cuenta(){
        System.out.println("La cuenta con el titular: " + this.titular + " " + "tiene " + this.saldo + "$");
    }
}
