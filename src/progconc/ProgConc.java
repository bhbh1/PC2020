/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progconc;

import tp3.PingPong;

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
            PingPong.main(args);
        } catch (InterruptedException e) {
            System.err.println("Interrupted exception");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Excepción: ");
            e.printStackTrace();
        }
    }

}
