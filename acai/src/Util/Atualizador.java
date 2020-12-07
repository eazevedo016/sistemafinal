/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author eduar
 */
public class Atualizador 
{
    public static String Converte(String Data)
    {
        return Data.substring(6,10) + "-" + Data.substring(3,5) + "-" + Data.substring(0,2);
    }
    
     public static String ConverteJ(String Data)
    {
        return Data.substring(8,10) + "/" + Data.substring(5,7) + "/" + Data.substring(0,4);
    }
    
    public static void main (String args[])
    {
        System.out.println(Atualizador.ConverteJ("2001/04/16"));
        
    }
    

    
    
}
