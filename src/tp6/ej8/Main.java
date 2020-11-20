/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej8;

import Utiles.IO;

/**
 *
 * @author b h
 */
public class Main {

    public static void main(String[] args) {
        String[] etiquetas = {"HornoA", "HornoB", "HornoC", "Empaquetador",
            "Brazo"};
        int[] ids = {0, 1, 2, 6, 5};
        System.out.println(IO.infoEtiquetas(etiquetas, ids));
        int cantA = 5;
        int cantB = 5;
        int cantC = 5;
        int cantEmp = 3;
        //Creo la caja con peso maximo
        Caja caja = new Caja(50);
        Mostrador mostrador = new Mostrador();
        Thread[] hilos = new Thread[cantA + cantB + cantC + cantEmp];
        Horno h;
        //Inicio hornos
        for (int i = 0; i < cantA + cantB + cantC; i++) {
            if (i < cantA) {
                h = new Horno(i, 0, 5, mostrador);
                hilos[i] = new Thread(h);
            }
            if (i < cantB) {
                h = new Horno(i, 1, 8, mostrador);
                hilos[i + cantA] = new Thread(h);
            }
            if (i < cantC) {
                h = new Horno(i, 2, 10, mostrador);
                hilos[i + cantA + cantB] = new Thread(h);
            }
        }
        //Inicio empaquetadoras
        for (int i = 0; i < cantEmp; i++) {
            hilos[i + cantA + cantB + cantC]
                    = new Thread(new Empaquetador(i, mostrador, caja));
        }
        //Inicio hilos
        for (int i = 0; i < cantA + cantB + cantC + cantEmp; i++) {
            hilos[i].start();
        }
    }

}
