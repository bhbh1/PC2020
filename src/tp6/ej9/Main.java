/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej9;

/**
 *
 * @author b h
 */
public class Main {

    public static void main(String[] args) {
        int cantPersonas = 10;
        Thread[] hilos = new Thread[cantPersonas];
        SalaEspera salaEspera = new SalaEspera();
        //Crear hilos
        for (int i = 0; i < cantPersonas; i++) {
            hilos[i] = new Thread(
                    new Persona(i, salaEspera));
        }
        //Iniciar hilos
        for (int i = 0; i < cantPersonas; i++) {
            hilos[i].start();
        }
    }
}
