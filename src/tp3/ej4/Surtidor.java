/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej4;

/**
 *
 * @author b h
 */
public class Surtidor {

    private ManejadorTurnos turnos;

    public Surtidor() {
        this.turnos = new ManejadorTurnos();
    }

    public ManejadorTurnos getTurnos() {
        return turnos;
    }

    public synchronized void cargarNafta(String patente) throws InterruptedException {
        System.out.println(patente + " cargando nafta" + "turnoActual: " +
                turnos.getTurnoActual() + ". ultimo: " +
                turnos.getTurnoActual());
        Thread.sleep(700);
        System.out.println(patente + " cargó nafta");
        this.turnos.aumentarTurnoActual();
    }
}
