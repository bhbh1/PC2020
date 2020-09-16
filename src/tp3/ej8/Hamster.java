/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej8;

/**
 *
 * @author b h
 */
public class Hamster implements Runnable {

    private String nombre;
    private Rueda rueda;
    private Plato plato;
    private Hamaca hamaca;

    public Hamster(String nombre, Rueda rueda, Plato plato, Hamaca hamaca) {
        this.nombre = nombre;
        this.rueda = rueda;
        this.plato = plato;
        this.hamaca = hamaca;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 4; i++) {
                this.elegirAccion();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private int elegirAccion() throws InterruptedException {
        int opcion = (int) (Math.random() * 10);

        switch (opcion % 3) {
            case 0:
                this.rueda.usarRueda(this.nombre);
                break;
            case 1:
                this.plato.usarPlato(this.nombre);
                break;
            default:
                this.hamaca.usarHamaca(this.nombre);
                break;
        }
        return opcion;
    }
}
