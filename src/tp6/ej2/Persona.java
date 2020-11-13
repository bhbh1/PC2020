/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej2;

/**
 *
 * @author b h
 */
public class Persona implements Runnable {

    private int id;
    private boolean esJubilado;
    private GestorSala sala;

    public Persona(int id, boolean esJubilado,
            GestorSala sala) {
        this.id = id;
        this.esJubilado = esJubilado;
        this.sala = sala;
    }

    public boolean isEsJubilado() {
        return esJubilado;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 1000));
            if (esJubilado) {
                sala.entrarSalaJubilado(id);
            } else {
                sala.entrarSala(id);
            }
            Thread.sleep((long) (Math.random() * 10000));
            sala.salirSala(id, esJubilado);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
