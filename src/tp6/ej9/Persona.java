/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej9;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b h
 */
public class Persona implements Runnable {

    private int id;
    private int turno;
    private SalaEspera salaEspera;

    public Persona(int id, SalaEspera salaEspera) {
        this.id = id;
        this.salaEspera = salaEspera;
    }

    @Override
    public void run() {
        boolean obtuvoRev;
        try {
            Thread.sleep((long) (Math.random() * 1000));
            turno = salaEspera.obtenerTurno(id);
            Thread.sleep(4000);
            obtuvoRev = salaEspera.entrar(id, turno);
            salaEspera.atender(id, obtuvoRev);
            Thread.sleep(4000);
            salaEspera.salir(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
