/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej9;

import Utiles.IO;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author b h
 */
public class SalaEspera {

    private ReentrantLock lockSala = new ReentrantLock();
    private Condition cambioTurno = lockSala.newCondition();
    private Semaphore semRev = new Semaphore(3);

    private int turnoActual = 0;
    private int ultimoTurno = 0;
    private int cantCamDisp = 4;

    public int obtenerTurno(int id) {
        int turnoPersona;
        try {
            lockSala.lock();
            turnoPersona = ultimoTurno++;
            IO.sColE(id, "Obtuvo el turno: " + turnoPersona);
        } finally {
            lockSala.unlock();
        }
        return turnoPersona;
    }

    public boolean entrar(int id, int turnoPersona) throws InterruptedException {
        boolean obtuvoRev = false;
        try {
            lockSala.lock();
            //Si no es su turno se pone a esperar
            if (turnoPersona != turnoActual
                    || cantCamDisp < 1) {
                //Intenta obtener una revista
                if (!semRev.tryAcquire()) {
                    //Intenta obtener una revista mientras
                    //no sea su turno o no haya camas
                    while (turnoPersona != turnoActual
                            || cantCamDisp < 1) {
                        cambioTurno.await();
                        //Intenta obtener una revista
                        if (!obtuvoRev) {
                            if (semRev.tryAcquire()) {
                                IO.sColE(id, "Obtuvo una revista");
                                IO.sColE(id, "Lee mientras espera");
                            } else {
                                IO.sColE(id, "Ve TV mientras espera");
                            }
                        } else {
                            IO.sColE(id, "Lee mientras espera");
                        }

                    }

                } else {
                    obtuvoRev = true;
                    IO.sColE(id, "Obtuvo una revista");
                    //Espera su turno mientras
                    //no sea su turno o no haya camas
                    while (turnoPersona != turnoActual
                            || cantCamDisp < 1) {
                        cambioTurno.await();
                        IO.sColE(id, "Lee mientras espera");
                    }
                }
            }
        } finally {
            IO.sColE(id, "Es su turno / hay camas disponibles");
            cantCamDisp--;
            lockSala.unlock();
        }
        return obtuvoRev;
    }

    public void atender(int id, boolean obtuvoRev) {
        try {
            lockSala.lock();
            //Deja la revista
            if (obtuvoRev) {
                semRev.release();
                IO.sColEM(id,
                        "Es atendido y deja revista. Turno: " + turnoActual, '>');
            } else {
                IO.sColEM(id, "Es atendido. Turno: " + turnoActual, '>');
            }

        } finally {
            turnoActual++;
            cambioTurno.signalAll();
            lockSala.unlock();
        }
    }

    public void salir(int id) {
        try {
            lockSala.lock();
            IO.sColEM(id, "Sale del centro", '<');
            cantCamDisp++;
            cambioTurno.signalAll();
        } finally {
            lockSala.unlock();
        }
    }
}
