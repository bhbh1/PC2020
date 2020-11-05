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
public class Consumidor implements Runnable {

    private int id;
    private EspacioCompartido eC;

    public Consumidor(int id, EspacioCompartido eC) {
        this.id = id;
        this.eC = eC;
    }

    @Override
    public void run() {
        boolean esValido;
        int i = 0;
        try {
            while (true) {
                Thread.sleep((long) (Math.random() * 1000));
                esValido = eC.consumir(this.id);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
