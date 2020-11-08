/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria.ejBufferFinitoMonitor;

/**
 *
 * @author b h
 */
public class Main {

    public static void main(String[] args) {
        int cantProd = 10;
        int cantCons = 3;
        Thread[] hilos = new Thread[cantProd + cantCons];

        EspacioCompartido eC = new EspacioCompartido();

        //Crear prods
        Productor prod;
        for (int i = 0; i < cantProd; i++) {
            prod = new Productor(i, eC);
            hilos[i] = new Thread(prod);
        }
        //Crear cons
        Consumidor cons;
        for (int i = 0; i < cantCons; i++) {
            cons = new Consumidor(i + cantProd, eC);
            hilos[i + cantProd] = new Thread(cons);
        }

        //iniciar hilos
        for (int i = 0; i < cantProd + cantCons; i++) {
            hilos[i].start();
        }
    }
}
