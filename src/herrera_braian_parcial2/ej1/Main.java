/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herrera_braian_parcial2.ej1;

import Utiles.IO;

/**
 *
 * @author b h
 */
public class Main {

    public static void main(String[] args) {
        String[] etiquetas = {"Manga", "Cuerpo", "Ensamblador",};
        int[] ids = {4, 5, 6};
        System.out.println(IO.infoEtiquetas(etiquetas, ids));

        //Capacidad de los cestos
        int capMangas = 2;
        int capCuerpos = 1;

        //Crea la fabrica 
        Fabrica fabrica = new Fabrica(capMangas, capCuerpos);

        Thread[] hilos = new Thread[3];
        //Crea el hilo del ensamblador
        hilos[0] = new Thread(new Ensamblador(fabrica));

        //Crea hilos de productores de mangas
        hilos[1] = new Thread(new Productor(4, fabrica));

        //Crea hilos de productores de cuerpos
        hilos[2] = new Thread(new Productor(5, fabrica));

        //Inicia hilos
        for (int i = 0; i < 3; i++) {
            hilos[i].start();
        }
    }
}
