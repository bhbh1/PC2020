/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ej3;

import Utiles.EntradaSalida;

/**
 *
 * @author b h
 */
public class Pasajero implements Runnable {

    private int id;
    private VendedorTicket vendedor;
    private ControlTren control;

    public Pasajero(int id,
            VendedorTicket vendedor, ControlTren control) {
        this.id = id;
        this.vendedor = vendedor;
        this.control = control;
    }

    @Override
    public void run() {
        boolean tieneTicket;

        try {
            EntradaSalida.salidaColoresId(id, "Trata de comprar un ticket");
            tieneTicket = vendedor.comprar(id);
            if (tieneTicket) {
                
                this.solicitarLugar();
            } else {
                EntradaSalida.salidaColoresId(id, "No tiene un ticket");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void solicitarLugar() throws InterruptedException {
        boolean suceso;
        do {
            suceso = control.solicitarLugar();
            if (!suceso) {
                EntradaSalida.salidaColoresId(id, "Espera que termine el recorrido");
                Thread.sleep(1000);
            }
        } while (!suceso);

        EntradaSalida.salidaColoresId(id, "Consigue lugar y"
                + " espera que se llene el tren");
    }
}
