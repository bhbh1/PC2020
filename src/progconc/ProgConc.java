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
//        System.out.println("Mensaje coloreado");
//        System.out.println(IO.colMsg(0, 1, false)+s);
//        System.out.println("Varian ambos");
//        for (int i = 0; i < 12; i++) {
//            IO.sCol(i, s);
//        }
//        System.out.println("Varia el segundo");
//        for (int i = 0; i < 12; i++) {
//            IO.sCol(1, i, s);
//        }
//        System.out.println("Varian ambos con mucho espaciado");
//        for (int i = 0; i < 4; i++) {
//            IO.sColE(i, s);
//        }
//        System.out.println("Varia el segundo con mucho espaciado");
//        for (int i = 0; i < 4; i++) {
//            IO.sColE(1, i, s);
//        }
//        System.out.println("Varian ambos c/marca");
//        for (int i = 0; i < 12; i++) {
//            IO.sColM(i, s, '>');
//        }
//        System.out.println("Varia el segundo c/marca");
//        for (int i = 0; i < 12; i++) {
//            IO.sColM(1, i, s, '>');
//        }
//        System.out.println("Varian ambos con mucho espaciado y c/marca");
//        for (int i = 0; i < 4; i++) {
//            IO.sColEM(i, s, '>');
//        }
//        System.out.println("Varia el segundo con mucho espaciado y c/marca");
//        for (int i = 0; i < 4; i++) {
//            IO.sColEM(1, i, s, '>');
//        }
//        System.out.println("Marcador, varian ambos");
//        for (int i = 0; i < 42; i++) {
//            System.out.println(IO.getMarcadorCompleto(i));
//        }
//        System.out.println("Marcador, varia el segundo");
//        for (int i = 0; i < 6; i++) {
//            System.out.println(IO.getMarcadorCompleto(1, i));
//        }
        System.out.println("Varia el segundo con mensaje a color");
        for (int i = 0; i < 12; i++) {
            if (i % 4 < 2) {
                IO.sColC(1, i, s);
            } else {
                IO.sColC(2, i, s);
            }
        }
    }
}
