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
        for (int i = 0; i < 13; i++) {
            IO.sColFijo(i, "Test", 1);
        }
    }

}
