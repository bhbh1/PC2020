/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej1;

import Utiles.IO;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author b h
 */
public class SalaFumadores {

    private ReentrantLock lockSala;
    private Condition hayPapel;
    private Condition hayTabaco;
    private Condition hayFosforos;
    private boolean pusoPapel = false;
    private boolean pusoTabaco = false;
    private boolean pusoFosforos = false;

    public SalaFumadores() {
        this.lockSala = new ReentrantLock();
        this.hayPapel = lockSala.newCondition();
        this.hayTabaco = lockSala.newCondition();
        this.hayFosforos = lockSala.newCondition();
    }

    public Condition getHayPapel() {
        return hayPapel;
    }

    public Condition getHayTabaco() {
        return hayTabaco;
    }

    public Condition getHayFosforos() {
        return hayFosforos;
    }

    //idElemAgente 1: papel, 2: tabaco, 3: fosforos
    public void colocar(int idElemAgente) {
        //Hacer que ponga de a dos, agregar un lock o algo para que pueda volver a poner 
        //El agente coloca un ingrediente
        lockSala.lock();
        try {
            switch (idElemAgente) {
                case 1:
                    if (!pusoPapel) {
                        pusoPapel = true;
                        IO.sColE(6, 1, "Pone papel" + ".\tP: " + pusoPapel + ". T: " + pusoTabaco
                                + ". F: " + pusoFosforos);
                        hayPapel.signalAll();
                    }
                    break;
                case 2:
                    if (!pusoTabaco) {
                        pusoTabaco = true;
                        IO.sColE(6, 2, "Pone tabaco" + ".\tP: " + pusoPapel + ". T: " + pusoTabaco
                                + ". F: " + pusoFosforos);
                        hayTabaco.signalAll();
                    }
                    break;
                case 3:
                    if (!pusoFosforos) {
                        pusoFosforos = true;
                        IO.sCol(6, 3, "Pone fosforos" + ".\tP: " + pusoPapel + ".T: " + pusoTabaco
                                + ". F: " + pusoFosforos);
                        hayFosforos.signalAll();
                    }
                    break;
                default:
                    break;
            }
        } finally {
            lockSala.unlock();
        }
    }

    public void entraFumar(int idElemFumador) throws InterruptedException {
        lockSala.lock();
        try {

            //Espera el primer ingrediente
            switch (idElemFumador) {
                case 1:
                    while (!pusoTabaco || !pusoFosforos) {
                        //Tiene papel
                        if (!pusoTabaco) {
                            hayTabaco.await();
                        }
                        if (!pusoFosforos) {
                            hayFosforos.await();
                        }
                    }
                    //Obtuvo ambos
                    pusoTabaco = false;
                    pusoFosforos = false;
                    break;
                case 2:
                    while (!pusoPapel || !pusoFosforos) {
                        //Tiene tabaco
                        if (!pusoPapel) {
                            hayPapel.await();
                        }
                        if (!pusoFosforos) {
                            hayFosforos.await();
                        }
                    }
                    //Obtuvo ambos
                    pusoPapel = false;
                    pusoFosforos = false;
                    break;
                case 3:
                    while (!pusoPapel || !pusoTabaco) {
                        //Tiene fosforos
                        if (!pusoPapel) {
                            hayPapel.await();
                        }
                        if (!pusoTabaco) {
                            hayTabaco.await();
                        }
                    }
                    //Obtuvo ambos
                    pusoPapel = false;
                    pusoTabaco = false;
                    break;
                default:
                    break;
            }//switch
        } finally {
//            lockSala.unlock();
        }
//        IO.sColE(idElemFumador, "Ciclo");

//        lockSala.lock();
        IO.sColE(idElemFumador, "Pone su ingrediente y empieza a fumar");

    }

    public void terminaFumar(int idElemFumador) {
        try {

            IO.sColE(idElemFumador, "Termino de fumar");
        } finally {
            lockSala.unlock();
        }
    }
}
