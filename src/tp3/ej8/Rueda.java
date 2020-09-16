/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej8;

/**
 *
 * @author b h
 */
public class Rueda {

    public synchronized void usarRueda(String nombreHamster) throws InterruptedException {
        System.out.println(nombreHamster + " empezó a usar la RUEDA");
        Thread.sleep(3000);
        System.out.println(nombreHamster + " terminó de usar la RUEDA");
    }
}
