/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej2;

/**
 *
 * @author b h
 */
public class Vida {

    private int valor;

    public Vida(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void aumentarValor(int n) {
        valor += n;
    }

    public void reducirValor(int n) {
        valor -= n;
    }
}
