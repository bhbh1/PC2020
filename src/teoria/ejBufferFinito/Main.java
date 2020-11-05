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
public class Main {

    public static void main(String[] args) {
        int cantProd = 1;
        int cantCons = 10;
        Thread[] hilos = new Thread[cantProd + cantCons];

        EspacioCompartido eC = new EspacioCompartido();

        Productor[] arrProd = new Productor[cantProd];
        Consumidor[] arrCons = new Consumidor[cantCons];

        //Crear prods
        Productor prod;
        for (int i = 0; i < cantProd; i++) {
            prod = new Productor(i, eC);
            arrProd[i] = prod;
        }
        //Crear cons
        Consumidor cons;
        for (int i = 0; i < cantCons; i++) {
            cons = new Consumidor(i, eC);
            arrCons[i] = cons;
        }

        //crear hilos
        //productores
        Thread hilo;
        for (int i = 0; i < (cantProd); i++) {
            hilo = new Thread(arrProd[i]);
            hilos[i] = hilo;
        }
        //consumidores
        for (int i = 0; i < cantCons; i++) {
            hilo = new Thread(arrCons[i]);
            hilos[i + cantProd] = hilo;
        }
        //iniciar hilos
        for (int i = 0; i < cantProd + cantCons; i++) {
            hilos[i].start();
        }
    }
}
