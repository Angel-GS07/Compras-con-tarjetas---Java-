package com.mycompany.p12_registrodecomprastcd;

import java.io.*;

public class Credito extends Tarjeta
{
    private double limite;
    
    Credito(int cuen, double disp, double lim)
    {
        super(cuen, disp);
        this.setLimite(lim);
    }
    
    Credito()
    {}
    
    private void setLimite(double l)
    {
        if ( l >= 0 ) 
        {
            this.limite = l;
        }
        else 
        {
            this.limite = 0;
        }
    }
    
    public double getLimite()
    {
        return this.limite;
    }
    
    @Override
    public void verEstadoInicial(PrintWriter a_salida)
    {
        System.out.print("\nTarjeta de Credito ");
        System.out.print("\tNumero de cuenta: " + this.getCuenta());
        System.out.print("\t   Limite de credito: $" + this.getLimite());
        System.out.print("\t Credito disponible: $" + this.getDisponibilidad());
        
        a_salida.print("\nTarjeta de Credito ");
        a_salida.print("\tNumero de cuenta: " + this.getCuenta());
        a_salida.print("\t   Limite de credito: $" + this.getLimite());
        a_salida.print("\t   Saldo: $" + this.getDisponibilidad());
    }
    
    @Override
    public void verEstado(double a, PrintWriter a_salida)
    {
        System.out.print("\nTarjeta de Credito ");
        System.out.print("\tNumero de cuenta: " + this.getCuenta());
        System.out.print("\t   Limite de credito: $" + this.getLimite());
        System.out.println("\t Credito disponible: $" + this.getDisponibilidad());
        
        a_salida.print("\tMonto de la compra: $" + a);
        a_salida.print("\t  Limite de credito: $" + this.getLimite());
        a_salida.print("\t  Credito disponible: $" + this.getDisponibilidad());
    }
}