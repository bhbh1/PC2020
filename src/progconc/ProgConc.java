/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progconc;

import tp3.Main;

/**
 *
 * @author b h
 */
public class ProgConc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Main.main(args);
        } catch (Exception e) {
            System.out.println("Excepción: ");
            e.printStackTrace();
        }
    }

}
