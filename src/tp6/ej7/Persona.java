/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej7;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b h
 */
public class Persona implements Runnable {

    private int id;
    private int tipo;

    //tipo 0: visitante, 1: visitante en silla de ruedas
    //2: mantenimiento, 3: investigador
    public Persona(int id, int tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
