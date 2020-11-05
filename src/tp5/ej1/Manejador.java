/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ej1;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author b h
 */
public class Manejador {
    
    private int gatosEspera = 0;
    private int perrosEspera = 0;
    private int maxEspera;
    private Comedor[] comedores;
    private int cantComedores;
    
    public Manejador(int maxEspera, Comedor[] comedores) {
        this.maxEspera = maxEspera;
        this.comedores = comedores;
        this.cantComedores = comedores.length;
    }
    
    public Comedor buscarComedor(Animal anim, boolean esGato)
            throws InterruptedException {
        Thread.sleep((int) (Math.random() * 1000));
        int i = 0;
        Comedor c;
        Semaphore semGeneral;
        Semaphore semComedor;
        
        int idC = -1;
        //Itera en los comedores hasta que pueda usar uno
        do {
            
            c = comedores[i % cantComedores];
            semGeneral = c.getSemGeneral();
            if (esGato) {
                semComedor = c.getSemGatos();
            } else {
                semComedor = c.getSemPerros();
            }
            //Uno tiene la posibilidad de bloquear al otro
            if (semGeneral.tryAcquire()) {
                idC = c.usar(anim, esGato);
            }
            
            i++;
        } while (idC < 0);
        
        return c;
    }
    
}
