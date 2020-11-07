/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progconc;

import Utiles.IO;

/**
 *
 * @author b h
 */
public class ProgConc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String s = "Test";
        System.out.println("Mensaje coloreado");
        System.out.println(IO.colMsg(0, 1, s, false));
        System.out.println("Varian ambos");
        for (int i = 0; i < 12; i++) {
            IO.sCol(i, s);
        }
        System.out.println("Varia el segundo");
        for (int i = 0; i < 12; i++) {
            IO.sCol(1, i, s);
        }
        System.out.println("Varian ambos con mucho espaciado");
        for (int i = 0; i < 4; i++) {
            IO.sColE(i, s);
        }
        System.out.println("Varia el segundo con mucho espaciado");
        for (int i = 0; i < 4; i++) {
            IO.sColE(1, i, s);
        }
    }
}
