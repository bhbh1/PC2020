/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ej1;

import Utiles.IO;

/**
 *
 * @author b h
 */
public class Main {

    public static void main(String[] args) {
        int cantComedores = 2;
        int capacidad = 2;
        int cantGatos = 8;
        int cantPerros = 12;
        Comedor[] comedores = new Comedor[cantComedores];
        Manejador manejador;
        Comedor c;
        Gato g;
        Perro p;
        Thread[] hilosAnim = new Thread[cantGatos + cantPerros];

        //Inicializa comedores
        for (int i = 0; i < cantComedores; i++) {
            c = new Comedor(i, capacidad);
            comedores[i] = c;
        }
        manejador = new Manejador(cantPerros, comedores);
        //Inicializa gatos
        for (int i = 0; i < cantGatos; i++) {
            g = new Gato(i, manejador, 1);
            hilosAnim[i] = new Thread(g);
        }
        //Inicializa perros
        for (int i = 0; i < cantPerros; i++) {
            p = new Perro(i, manejador, 0);
            hilosAnim[i + cantGatos] = new Thread(p);
        }
        System.out.println("Gato: " + IO.getMarcador(1)
                + ". Perro: " + IO.getMarcador(0)
                + ". Comedor: " + IO.getMarcador(6));
        //Ejecuta hilos
        for (int i = 0; i < cantGatos + cantPerros; i++) {
            hilosAnim[i].start();
        }
    }
}
