/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ej3;

import Utiles.EntradaSalida;

/**
 *
 * @author abcd
 */
public class Main {

    public static void main(String[] args) {
        int CPasajeros = 10;
        Thread[] hilosPas = new Thread[CPasajeros];
        ControlTren controlTren = new ControlTren(5);
        Thread hiloCT = new Thread(controlTren);
        VendedorTicket vendedorTicket = new VendedorTicket(CPasajeros);
        Pasajero p;
        for (int i = 0; i < CPasajeros; i++) {
            p = new Pasajero(i, vendedorTicket, controlTren);
            hilosPas[i] = new Thread(p);
        }
        hiloCT.start();
        for (int i = 0; i < CPasajeros; i++) {
            hilosPas[i].start();
        }

    }
}
