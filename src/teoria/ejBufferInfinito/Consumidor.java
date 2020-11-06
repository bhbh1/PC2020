/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria.ejBufferInfinito;

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
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep((long) (Math.random() * 10000));
                consumir();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void consumir() throws InterruptedException {
        eC.consumir(this.id);
    }
}
