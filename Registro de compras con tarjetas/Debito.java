package com.mycompany.p12_registrodecomprastcd;

import java.io.*;

public class Debito extends Tarjeta
{
    Debito(int cuen, double disp)
    {
        super(cuen, disp);
    }
    
    Debito()
    {}
    
    @Override
    public void verEstadoInicial(PrintWriter a_salida)
    {
        System.out.print("\nTarjeta de Debito ");
        System.out.print("\tNumero de cuenta: " + this.getCuenta());
        System.out.print("\t   Saldo: $" + this.getDisponibilidad());
        
        a_salida.print("\nTarjeta de Debito ");
        a_salida.print("\tNumero de cuenta: " + this.getCuenta());
        a_salida.print("\t   Saldo: $" + this.getDisponibilidad());
    }
    
    @Override
    public void verEstado(double a, PrintWriter a_salida)
    {
        System.out.print("\nTarjeta de Debito ");
        System.out.print("\tNumero de cuenta: $" + this.getCuenta());
        System.out.println("\t   Saldo: $" + this.getDisponibilidad());
        
        a_salida.print("\tMonto de la compra: $" + a);
        a_salida.print("\t  Saldo: $" + this.getDisponibilidad());
    }
}