/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej8;

/**
 *
 * @author b h
 */
public class Horno implements Runnable {

    private int id;
    private int tipo;
    private int peso;
    private Mostrador mostrador;

    public Horno(int id, int tipo, int peso, Mostrador mostrador) {
        this.id = id;
        this.tipo = tipo;
        this.peso = peso;
        this.mostrador = mostrador;
    }

    public int getPeso() {
        return peso;
    }

    @Override
    public void run() {
        int i = 0;
        try {
            Thread.sleep((long) (Math.random() * 5000));
            do {
                mostrador.poner(id, tipo, peso);
                i++;
                Thread.sleep(2000);
            } while (i < 15);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
