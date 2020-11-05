/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ej3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author abcd
 */
public class ControlTren implements Runnable {

    private int nLugares;
    private Semaphore semLugares;
    private Semaphore trenLleno;

    public ControlTren(int nLugares) {
        this.nLugares = nLugares;
        this.semLugares = new Semaphore(nLugares);
        this.trenLleno = new Semaphore(1);
    }

    @Override
    public void run() {
        int i = 0;
        try {
            do {
                //Comprueba cada 400ms que el tren
                //no esta completo
                while (trenLleno.tryAcquire() ==true ) {
                    System.out.println("-");
                    try {
                        Thread.sleep(400);
                    } finally {
                        trenLleno.release();
                    }

                }
                System.out.println("Empieza el viaje N: "+i);
                this.hacerViaje();
                i++;
            } while (i < 3);
            System.out.println("Cierra la atraccion");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean solicitarLugar() throws InterruptedException {
        boolean suceso = false;
        try {
            //Trata de obtener un lugar
            suceso = semLugares.tryAcquire(1, TimeUnit.SECONDS);
        } finally {
            if (suceso) {
                //El tren no está lleno
            } else {
                trenLleno.acquire();
                System.out.println("El tren está lleno o en viaje");
            }
        }

        return suceso;
    }

    public void hacerViaje() throws InterruptedException {
        try {
            System.out.println("El tren inicia el viaje");
            Thread.sleep(500);
            System.out.println("El tren termina el viaje");
        } finally {
            trenLleno.release();
            semLugares.release(nLugares);
        }
    }

}
