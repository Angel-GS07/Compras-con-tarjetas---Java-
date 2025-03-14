package com.mycompany.p12_registrodecomprastcd;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.*;

public class P12_RegistroDeComprasTCD 
{
    public static void main(String[] args) 
    {
        try
        {
            String leer;
            char r = 0;
            int evaluar;
            int d = 1;
            int no;
            double mo;
            
            int noCuenta;
            double limite;
            double disponibilidad;
            
            Scanner scan = new Scanner(System.in);

            List<Tarjeta> cuentas = new ArrayList<>();

            BufferedReader a_entrada = new BufferedReader(new FileReader("Cuentas.txt")); 

            while((leer = a_entrada.readLine()) != null)
            {
                evaluar = Integer.parseInt(leer);
                if(evaluar >= 1000 && evaluar <=1999)
                {
                    noCuenta = Integer.parseInt(leer);
                    
                    leer = a_entrada.readLine();
                    limite = Double.parseDouble(leer);
                    
                    leer = a_entrada.readLine();
                    disponibilidad = Double.parseDouble(leer);
                    
                    cuentas.add(new Credito(noCuenta, limite, disponibilidad));
                }
                else if(evaluar >= 2000 && evaluar <= 2999)
                {
                    noCuenta = Integer.parseInt(leer);
                    
                    leer = a_entrada.readLine();
                    limite = Double.parseDouble(leer);
                         
                    cuentas.add(new Debito(noCuenta, limite));
                }
            }
            
            a_entrada.close();
            
            PrintWriter a_salida = new PrintWriter(new FileWriter("RegistroDeSesion.txt", false));
            
            System.out.println("Registro de compras.\n");
            a_salida.println("---------------------------------------- Inicio de sesion ----------------------------------------- \n");
            
            System.out.println("Estado inicial de las cuentas: ");
            a_salida.println("Estado inicial de las cuentas: ");
            
            for(Tarjeta t : cuentas)
            {
                if (t instanceof Debito) 
                { 
                    ((Debito)t).verEstadoInicial(a_salida);
                }
                else if (t instanceof Credito) 
                {
                    ((Credito)t).verEstadoInicial(a_salida);
                }   
            }
            
            a_salida.println("\n\n-------------------------------------- Movimientos realizados -------------------------------------- ");
             
            do{
                if(d == 1)
                {
                    System.out.print("\n\nDesea registrar una compra? [S/N]: ");
                    r = scan.next().charAt(0);
                    d++;
                }
                
                if (r == 'S' || r == 's' )
                {
                    System.out.print("\nCuenta: ");
                    no = scan.nextInt();
                    a_salida.print("\nCuenta: " + no);
                    
                    if(no >= 1001 && no <=1005)
                    {
                        no -= 1001;
                        System.out.print("Monto de la compra: $");
                        mo = scan.nextDouble();
                        cuentas.get(no).cargarTarjeta(mo, a_salida);
                        cuentas.get(no).verEstado(mo, a_salida);
                    }
                    else if(no >= 2001 && no <=2005)
                    {
                        no -= 1996;
                        System.out.print("Monto de la compra: $");
                        mo = scan.nextDouble();
                        cuentas.get(no).cargarTarjeta(mo, a_salida);
                        cuentas.get(no).verEstado(mo, a_salida);
                    }
                    else
                    {
                        System.out.println("Cuenta inexistente");
                        a_salida.print("\tCuenta inexistente");
                    }

                    System.out.print("\nDesea realizar otro registro? [S/N]: ");
                    r = scan.next().charAt(0);
                }
                else
                {
                    r = 'N';
                }
            }while(r == 'S' || r == 's' );
            
            a_salida.println("\n\n------------------------------------------ Fin de sesion ------------------------------------------- ");
            
            a_salida.close();

            System.out.println("\nEl respaldo de la sesion se encuentra en el archivo RegistroDeSesion.txt");   
        }
        catch(Exception e)
        {
            System.out.println("ERROR!");      
        }
    }
}