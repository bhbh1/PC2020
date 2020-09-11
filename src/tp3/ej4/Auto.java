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
public class Auto extends Vehiculo implements Runnable {

    private final String patente;
    private final String modelo;
    private final String marca;
    private int kmFaltantesParaElService;
    private int kmTotal = 0;

    public Auto(String patente, String modelo, String marca, int kmFaltantesParaElService) {
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.kmFaltantesParaElService = kmFaltantesParaElService;
        this.cantRuedas = 4;
    }

    public String getPatente() {
        return patente;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public int getKmFaltantesParaElService() {
        return kmFaltantesParaElService;
    }

    public void setKmFaltantesParaElService(int kmFaltantesParaElService) {
        this.kmFaltantesParaElService = kmFaltantesParaElService;
    }

    public void run() {
        try {
            while (this.kmTotal < 500) {
                int delay = (int) (Math.random() * 600);
                Thread.sleep(delay);

                this.avanzar(delay / 3);

            }
            System.out.println(this.patente + " dejó de avanzar");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void avanzar(int km) throws InterruptedException {
        if (this.kmFaltantesParaElService <= 0) {
            this.cargarNafta();
            this.kmFaltantesParaElService = 300;
        }

        System.out.println(this.patente + " avanzó " +
                km + "km");
        this.kmFaltantesParaElService =
                (this.kmFaltantesParaElService - km) % 300;
        this.kmTotal = (this.kmTotal + km);
    }

    private synchronized void cargarNafta() throws InterruptedException {
        System.out.println(this.patente + " carga nafta ");
        Thread.sleep(650);
    }

}
