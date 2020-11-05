/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria.ejBufferFinito;

/**
 *
 * @author b h
 */
public class Productor implements Runnable {

    private int id;
    private EspacioCompartido eC;

    public Productor(int id, EspacioCompartido eC) {
        this.id = id;
        this.eC = eC;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep((long) (Math.random() * 10000));
                eC.producir(this.id);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
