/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herrera_braian_parcial2.ej2;

import Utiles.IO;
import java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author b h
 */
public class Comedor {

    private ReentrantLock lockComedor = new ReentrantLock();
    private Condition hayComida = lockComedor.newCondition();
    private Condition faltaComida = lockComedor.newCondition();
    private int nPlatos;
    private int nRaciones;
    //Almacena cuantas raciones tiene cada plato
    private int[] racionesPlato;
    private boolean huboAviso = false;

    public Comedor(int nPlatos, int nRaciones) {
        this.nPlatos = nPlatos;
        this.nRaciones = nRaciones;
        //Almacena cuantas raciones tiene cada plato y los llena
        racionesPlato = new int[nPlatos];
        for (int i = 0; i < nPlatos; i++) {
            racionesPlato[i] = nRaciones;
        }
    }

    public void comer(int id) throws InterruptedException {
        int nPlato = 0;
        boolean encontroComida = false;
        try {
            lockComedor.lock();
            while (!encontroComida) {
                //Verifica que no se haya quedado sin platos por revisar
                if (nPlato == nPlatos) {
                    if (!huboAviso) {
                        huboAviso = true;
                        IO.sColM(id, id, "Ladra y avisa que no hay comida", '!');
                        faltaComida.signal();
                    }
                    hayComida.await();
                    nPlato = 0;
                } else {
                    //Recorre los platos buscando comida
                    if (racionesPlato[nPlato] > 0) {
                        racionesPlato[nPlato] = racionesPlato[nPlato] - 1;
                        encontroComida = true;
                        IO.sColM(id, id, "Encontro comida y come", '<');
                    } else {
                        nPlato++;
                    }
                }
            }

        } finally {
            lockComedor.unlock();
        }
    }

    public void dormir() throws InterruptedException {
        try {
            lockComedor.lock();
            while (!huboAviso) {
                IO.sColC(7, 0, "El encargado esta durmiendo");
                faltaComida.await();
            }
            IO.sColC(7, 2, "El encargado se despierta y empieza a llenar platos");
        } finally {
            lockComedor.unlock();
        }

    }

    //Consideracion: puede llenar platos aunque haya perros aun comiendo
    public void rellenarPlatos() throws InterruptedException {
        try {
            lockComedor.lock();
            //Rellena los platos
            for (int i = 0; i < nPlatos; i++) {
                racionesPlato[i] = nRaciones;
            }
            IO.sColMC(7, 1, "Termina de llenar platos y se vuelve a dormir", '>');
        } finally {
            huboAviso = false;
            hayComida.signalAll();
            lockComedor.unlock();
        }

    }

}
