/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej2;

import Utiles.IO;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author b h
 */
public class GestorSala {

    private int temperatura;
    private int tUmbral;
    private int maxOcupantes;
    private int cantOcupantes = 0;
    private int jubEspera = 0;
    private ReentrantLock entrarLock = new ReentrantLock();
    private Condition cambioCant = entrarLock.newCondition();
//    private Condition cambioTemp = entrarLock.newCondition();

    public GestorSala(int maxOcupantes, int tUmbral) {
        this.maxOcupantes = maxOcupantes;
        this.tUmbral = tUmbral;
    }

    //se invoca cuando una persona quiere entrar en la sala.
    public void entrarSala(int idPersona) throws InterruptedException {
        try {
            entrarLock.lock();
            IO.sColM(0, idPersona, "Quiere entrar", '?');
            while (cantOcupantes >= maxOcupantes || jubEspera > 0) {
                cambioCant.await();
            }
        } finally {
            cantOcupantes++;
            entrarLock.unlock();
        }
        IO.sColM(0, idPersona, "Entro a la sala. Cant: " + cantOcupantes
                + ". Temp: " + temperatura + ". CJ esp: " + jubEspera, '>');
    }

    //se invoca cuando una persona jubilada quiere entrar en la sala.
    public void entrarSalaJubilado(int idJubilado) throws InterruptedException {
        try {
            entrarLock.lock();
            IO.sColM(1, idJubilado, "Quiere entrar", '!');
            jubEspera++;
            while (cantOcupantes >= maxOcupantes) {
                cambioCant.await();
            }
        } finally {
            jubEspera--;
            cantOcupantes++;
            entrarLock.unlock();
        }
        IO.sColM(1, idJubilado, "Entro a la sala. Cant: " + cantOcupantes
                + ". Temp: " + temperatura + ". CJ esp: " + jubEspera, '>');
    }

    //se invoca cuando una persona, jubilada o no, quiere salir de la sala.
    public void salirSala(int idPersona, boolean esJubilado) {
        String s = "<";
        try {
            entrarLock.lock();
            cantOcupantes--;

        } finally {
            if (esJubilado) {
                s += IO.colMsg(1, idPersona, false);
            } else {
                s += IO.colMsg(0, idPersona, false);
            }
            s += "Salio de la sala .Cant: " + cantOcupantes
                    + ". Temp: " + temperatura;
            System.out.println(s);
            cambioCant.signalAll();
            entrarLock.unlock();
        }
    }

    //lo invoca la hebra que mide la temperatura de la sala para indicar el último valor medido
    public void notificarTemperatura(int temp) {
        try {
            entrarLock.lock();
            temperatura = temp;
            IO.sCol(6, 3, "El medidor indica: " + temp + "°C");
            if (temp > tUmbral && maxOcupantes != 8) {
                IO.sCol(6, 0, "Se redujo el maximo de ocupantes a 8");
                maxOcupantes = 8;
            } else if (temp < tUmbral && maxOcupantes == 8) {
                IO.sCol(6, 0, "Se aumento el maximo de ocupantes a 8");
                maxOcupantes = 8;
            }
        } finally {
            //cambioCant.signalAll()  ?
            entrarLock.unlock();
        }
    }
}
