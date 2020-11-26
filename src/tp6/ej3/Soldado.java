/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b h
 */
public class Soldado implements Runnable {

    public int id;
    public boolean quiereGaseosa;
    public boolean quierePostre;
    public MostradorSala mSala;
    public MostradorPostre mPostre;

    public Soldado(int id, boolean quiereGaseosa,
            boolean quierePostre, MostradorSala mSala,
            MostradorPostre mPostre) {
        this.id = id;
        this.quiereGaseosa = quiereGaseosa;
        this.quierePostre = quierePostre;
        this.mSala = mSala;
        this.mPostre = mPostre;
    }

    @Override
    public void run() {
        try {
            mSala.obtenerBandeja(id);
            Thread.sleep(2000);
            if (quiereGaseosa) {
                mSala.obtenerAbridor(id);
                Thread.sleep(600);
                mSala.soltarAbridor(id);
            }
            if (quierePostre) {
                mPostre.obtenerPostre(id);
                Thread.sleep(600);
                mPostre.soltarPostre(id);
            }
            mSala.salir(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
