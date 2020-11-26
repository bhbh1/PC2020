/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej3;

/**
 *
 * @author b h
 */
public class Main {

    public static void main(String[] args) {
        int cantS = 68;
        Thread[] hilos = new Thread[cantS];
        MostradorSala mS = new MostradorSala();
        MostradorPostre mP = new MostradorPostre();

        Soldado s;
        int nRandom;
        //Crear soldados e hilos
        for (int i = 0; i < cantS; i++) {
            nRandom = (int) (Math.random() * 10);
            if (nRandom >= 0 && nRandom < 3) {
                s = new Soldado(i, true, true, mS, mP);
            } else if (nRandom >= 3 && nRandom < 6) {
                s = new Soldado(i, true, false, mS, mP);
            } else if (nRandom >= 6 && nRandom < 8) {
                s = new Soldado(i, false, true, mS, mP);
            } else {
                s = new Soldado(i, false, false, mS, mP);
            }
            hilos[i] = new Thread(s);
        }
        //Iniciar hilos
        for (int i = 0; i < cantS; i++) {
            hilos[i].start();
        }
    }
}
