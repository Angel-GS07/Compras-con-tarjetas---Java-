package com.mycompany.p12_registrodecomprastcd;

import java.io.*;

public class Tarjeta 
{
    private int cuenta;
    private double disponibilidad;
    
    Tarjeta()
    {}
    
    Tarjeta(int cuen, double disp)
    {
        this.setCuenta(cuen);
        this.setDisponibilidad(disp);
    }
    
    private void setCuenta(int c)
    {
        if ( c > 1000 ) 
        {
            this.cuenta = c;
        }
        else 
        {
            this.cuenta = 0;
        }
    }
    
    private void setDisponibilidad(double d)
    {
        this.disponibilidad = d;
    }
    
    public int getCuenta()
    {
        return this.cuenta;
    }
    
    public double getDisponibilidad()
    {
        return this.disponibilidad;
    }
    
    public void cargarTarjeta(double a, PrintWriter a_salida) 
    {
        if (a <= this.getDisponibilidad()) 
        {
            this.setDisponibilidad(getDisponibilidad() - a);
        }
        else 
        {
            System.out.println("El cargo no se pudo realizar.");
            a_salida.print("\tEl cargo no se pudo realizar" );
        }
    }
    
    public void verEstadoInicial(PrintWriter a_salida) 
    {}
    
    public void verEstado(double a, PrintWriter a_salida)
    {}
}