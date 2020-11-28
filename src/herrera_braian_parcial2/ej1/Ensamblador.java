/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herrera_braian_parcial2.ej1;

/**
 *
 * @author b h
 */
public class Ensamblador implements Runnable {

    private Fabrica fabrica;

    public Ensamblador(Fabrica fabrica) {
        this.fabrica = fabrica;
    }

    @Override
    public void run() {
        boolean debeEmbalar = false;
        int i = 0;
        do {
            try {
                debeEmbalar = fabrica.armarSueter();
                Thread.sleep(500);
                if (debeEmbalar) {
//                    fabrica.embalar();
                    Thread.sleep(1000);
                }
                if (i % 10 == 0) {
                    fabrica.consultarCantCajas();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        } while (true);

    }
}
