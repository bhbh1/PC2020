/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herrera_braian_parcial2.ej1;

import Utiles.IO;

import java.util.concurrent.Semaphore;

/**
 *
 * @author b h
 */
public class Fabrica {

    private Semaphore semMangas;
    private Semaphore semCuerpos;
    private Semaphore semEnsamblador;
    private Semaphore semEmbalaje;
    //Cantidad actual en los cestos
    private int cantMangas = 0;
    private int cantCuerpos = 0;
    private int cantSueters = 0;
    private int cantCajas = 0;
    private boolean listoParaArmar = false;
    private boolean listoParaEmbalar = false;

    public Fabrica(int capCestoMangas, int capCestoCuerpos) {
        //Controla cuando puede armar un sueter
        this.semEnsamblador = new Semaphore(0);
        //Controlan que haya lugar en el cesto
        this.semMangas = new Semaphore(capCestoMangas);
        this.semCuerpos = new Semaphore(capCestoCuerpos);
        //Controla el ensamblaje y 
        //la consulta de la cantidad de cajas
        this.semEmbalaje = new Semaphore(1);
    }

    //Deposita una parte en el cesto basado en su tipo
    //tipo 4: manga, 5: cuerpo
    public void almacenar(int tipo) throws InterruptedException {
        if (tipo == 4) {
            semMangas.acquire();
            cantMangas++;
            IO.sCol(tipo, tipo,
                    "Deposita una manga. [" + cantMangas + "]");
        } else {
            semCuerpos.acquire();
            cantCuerpos++;
            IO.sColC(tipo, tipo,
                    "Deposita un cuerpo. [" + cantCuerpos + "]");
        }
        if (!listoParaArmar) {
            if (cantMangas >= 2 && cantCuerpos >= 1) {
                listoParaArmar = true;
                semEnsamblador.release();
            }
        }
    }

    public boolean armarSueter() throws InterruptedException {
        //Avisa cuando ya puede embalar
        boolean debeEmbalar = false;

        semEnsamblador.acquire();
        cantSueters++;
        //Decrementa las partes usadas
        cantMangas -= 2;
        cantCuerpos -= 1;
        listoParaArmar = false;
        //Libera permisos por cada parte usada
        semMangas.release(2);
        semCuerpos.release();
        IO.sColM(6, 2,
                "Arma un sueter. \t[" + cantMangas
                + ", " + cantCuerpos + "]", '<');
        if (!listoParaEmbalar && cantSueters >= 10) {
            debeEmbalar = true;
        }

        return debeEmbalar;
    }

    public void embalar() throws InterruptedException {
        try {
            semEmbalaje.acquire();
            IO.sColM(6, 1, "Embala 10 sueters y los coloca en una caja", '!');
            cantSueters -= 10;
            cantCajas++;
            listoParaEmbalar = false;
        } finally {
            semEmbalaje.release();
        }
    }

    public void consultarCantCajas() throws InterruptedException {
        try {
            semEmbalaje.acquire();
            System.out.println("Cantidad de cajas actual: " + cantCajas);
        } finally {
            semEmbalaje.release();
        }
    }

}
