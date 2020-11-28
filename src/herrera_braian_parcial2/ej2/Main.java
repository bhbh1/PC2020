/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herrera_braian_parcial2.ej2;

import Utiles.IO;

/**
 *
 * @author b h
 */
public class Main {

    public static void main(String[] args) {
        int nPlatos = 1;
        int nRaciones = 2;
        int cantPerros = 9;
        Comedor c = new Comedor(nPlatos, nRaciones);
        Thread[] hilos = new Thread[1 + cantPerros];
        //Crea hilo encargado 
        hilos[0] = new Thread(new Encargado(c));
        //Crea hilos de perros
        for (int i = 1; i < 1 + cantPerros; i++) {
            hilos[i] = new Thread(new Perro(i, c));
        }
        //Inicia hilos
        for (int i = 0; i < cantPerros + 1; i++) {
            hilos[i].start();
        }
    }
}
