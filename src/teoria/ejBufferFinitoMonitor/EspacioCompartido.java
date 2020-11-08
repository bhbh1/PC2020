/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria.ejBufferFinitoMonitor;

import Utiles.IO;
import java.util.concurrent.Semaphore;

/**
 *
 * @author b h
 */
public class EspacioCompartido {

    private ColaEst buffer;
    int espacioDisp;

    public EspacioCompartido() {
        //Puede contener 9 elementos
        this.buffer = new ColaEst();
        this.espacioDisp = 9;
    }

    public synchronized void producir(int id) throws InterruptedException {
        while (espacioDisp < 1) {
            IO.sColE(1, id, "Espera lugar p/poner" + "\t" + this.buffer.toString());
            this.wait();
        }

        buffer.poner(id);
        System.out.print(">"
                + IO.colMsg(1, id, true) + "Puso: " + id + "\t");
        System.out.println(this.buffer.toString());

        espacioDisp--;
        this.notifyAll();
    }

    public synchronized void consumir(int id) throws InterruptedException {
        while (espacioDisp > 9) {
            IO.sColE(0, id, "Espera algo p/sacar" + "\t" + this.buffer.toString());
            this.wait();
        }
        buffer.sacar();
        System.out.print("<"
                + IO.colMsg(0, id, true) + "Saco del frente" + "\t");
        System.out.println(this.buffer.toString());

        espacioDisp++;
        this.notifyAll();

    }

}
