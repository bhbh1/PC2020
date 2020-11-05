/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ej3;

import Utiles.EntradaSalida;
import java.util.concurrent.Semaphore;

/**
 *
 * @author abcd
 */
public class VendedorTicket {

    private int ticketsParaVender;
    private Semaphore mutex;

    public VendedorTicket(int nTickets) {
        this.ticketsParaVender = nTickets;
        this.mutex = new Semaphore(1);
    }

    //Espera que el vendedor esté disponible y si quedan tickets,
    //adquiere uno
    public boolean comprar(int idPas) throws InterruptedException {
        boolean suceso = false;
        try {
            mutex.tryAcquire();
        } finally {
            if (ticketsParaVender > 0) {
                suceso = true;
                EntradaSalida.salidaColoresId(idPas, "Tiene un ticket");
//                Thread.sleep(600);
            } else {
                System.out.println("No hay mas tickets por hoy");
            }
            mutex.release();
        }

        return suceso;
    }
}
