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
public class Plato {
    public synchronized void usarPlato(String nombreHamster) throws InterruptedException {
        System.out.println(nombreHamster + " empezó a usar el PLATO");
        Thread.sleep(1200);
        System.out.println(nombreHamster + " terminó de usar el PLATO");
    }
}
