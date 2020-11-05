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
        System.out.println(IO.colMsg(0, 1, s));
    }

}
