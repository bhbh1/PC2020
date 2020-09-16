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
public class ManejadorTurnos {

    private int turnoActual;
    private int ultimoTurno;

    public ManejadorTurnos() {
        this.turnoActual = 1;
        this.ultimoTurno = 0;
    }

    public synchronized int getTurnoActual() {
        return turnoActual;
    }

    public synchronized void aumentarTurnoActual() {
        this.turnoActual++;
    }

    public synchronized void aumentarUltimoTurno() {
        this.ultimoTurno++;
    }

    public synchronized int obtenerTurno() {
        this.ultimoTurno++;
        return ultimoTurno;
    }
}
