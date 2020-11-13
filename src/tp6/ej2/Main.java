/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej2;

import Utiles.IO;

/**
 *
 * @author b h
 */
public class Main {

    public static void main(String[] args) {
        String[] etiq = {"Sala", "Persona", "Jubilado"};
        int[] ids = {6, 0, 1};
        System.out.println(IO.infoEtiquetas(etiq, ids));

        int cantPersonas = 12;
        int cantJubilados = 7;
        GestorSala sala = new GestorSala(10, 30);
        Persona p;
        Medidor m = new Medidor(sala);
        Thread[] hilos = new Thread[cantPersonas + cantJubilados + 1];
        //Crear personas
        for (int i = 0; i < cantPersonas; i++) {
            p = new Persona(i, false, sala);
            hilos[i] = new Thread(p);
        }
        //Crear personas jubiladas
        for (int i = 0; i < cantJubilados; i++) {
            p = new Persona(i, true, sala);
            hilos[i + cantPersonas] = new Thread(p);
        }
        //Crear hilo medidor
        hilos[cantPersonas + cantJubilados] = new Thread(m);
        //Iniciar hilos
        for (int i = 0; i < cantPersonas + cantJubilados + 1; i++) {
            hilos[i].start();
        }
    }
}
