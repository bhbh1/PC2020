/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.ej2;

/**
 *
 * @author b h
 */
public class ThreadTesting {

    public static void main() {
        Thread miHilo = new MiEjecucion();
        try {
            miHilo.start();
            miHilo.sleep(14);
//        miHilo.join();
            System.out.println("En el main");
        } catch (InterruptedException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {

        }
    }
}
