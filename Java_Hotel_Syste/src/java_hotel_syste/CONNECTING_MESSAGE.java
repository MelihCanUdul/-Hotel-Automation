/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_hotel_syste;

import javax.swing.JOptionPane;


public class CONNECTING_MESSAGE {
    public CONNECTING_MESSAGE()
    {
        JOptionPane.showConfirmDialog(null,"Rezervasyon Bölümününe Girdiniz.", "Giriş Başarılı", JOptionPane.CLOSED_OPTION); 
    }
    public String Ad;
    public String tebrik_mesaji;
    
    public CONNECTING_MESSAGE(String a)  //ilk constructorımızı tek parametre ile oluşturuyoruz
    {
        Ad= a;
            JOptionPane.showConfirmDialog(null,Ad+"  Oda Bölümününe Girdiniz.", "Giriş Başarılı", JOptionPane.CLOSED_OPTION); 
    }
    public CONNECTING_MESSAGE(String a, String  y)  //ikinci constructorımızı iki parametre ile oluşturuyor ve adiyla tebrik mesajının girilmesini istiyoruz.
    {
        Ad= a;
        tebrik_mesaji= y;
        JOptionPane.showConfirmDialog(null,Ad+"  Müşteri Bölümününe Girdiniz.\n"+tebrik_mesaji, "Giriş Başarılı", JOptionPane.CLOSED_OPTION); 
    }
}
