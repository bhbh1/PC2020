/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teoria.ejBufferFinitoMonitor;

/**
 *
 * @author b h
 */
public class ColaEst {

    private static final int TAM = 10;
    private Object[] arr;
    private int frente;
    private int fin;

    public ColaEst() {
        this.arr = new Object[this.TAM];
        this.frente = 0;
        this.fin = 0;
    }

    //Si la pila no esta llena define el elemento del fin
    //como el pasado por parametro y cambia el valor
    //de fin.
    //De estar lleno retorna false.
    public boolean poner(Object elem) {
        boolean suceso = true;
        int finAux = (this.fin + 1) % this.TAM;

        if (finAux != this.frente) {
            arr[this.fin] = elem;

            this.fin = (this.fin + 1) % this.TAM;

        } else {
            suceso = false;
        }

        return suceso;
    }

    //Si no es vacía define el elemento del frente como nulo y 
    //cambia el valor de frente.
    //Retorna si se sacó con exito el frente.
    public boolean sacar() {
        boolean suceso = true;

        if (this.esVacia()) {
            suceso = false;
        } else {
            this.arr[this.frente] = null;
            this.frente = (this.frente + 1) % this.TAM;
        }

        return suceso;
    }

    //De no estar vacia
    //retorna el elemento del frente, 
    //de lo contrario retorna null.
    public Object obtenerFrente() {
        Object elem = null;

        if (!this.esVacia()) {
            elem = this.arr[frente];
        }

        return elem;
    }

    //Comprueba si el elemento frente es nulo. 
    //De ser asi retorna true.
    public boolean esVacia() {
        boolean esVacia = false;

        if (this.frente == this.fin) {
            esVacia = true;
        }

        return esVacia;
    }

    public void vaciar() {
        this.frente = 0;
        this.fin = 0;
    }

    //Si no es vacia itera desde el valor de frente 
    //hasta fin, mientras añade los elementos recorridos
    //a la cola clon
    @Override
    public ColaEst clone() {
        ColaEst cClon = new ColaEst();

        int fr = this.frente;
        int finAux = this.frente;

        if (!this.esVacia()) {
            do {
                Object elem = this.arr[finAux];

                cClon.arr[finAux] = elem;
                finAux = (finAux + 1) % this.TAM;

//              System.out.println("ELEM: " + elem);
            } while (finAux != this.fin);
        }

        cClon.frente = fr;
        cClon.fin = finAux;

        return cClon;
    }

    @Override
    public String toString() {
        String s;
        int frAux = this.frente;

        if (this.esVacia()) {
            s = "Cola vacia";
        } else {
            s = "[";
            while (frAux != this.fin) {
                s += this.arr[frAux];

                frAux = (frAux + 1) % this.TAM;

                if (frAux != this.fin) {
                    s += ", ";
                }

            }

            s += "] \t   Frente: " + this.frente + ". Fin: " + this.fin;
        }

        return s;
    }

}
