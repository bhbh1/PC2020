/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.ej3;

/**
 *
 * @author b h
 */
public class A implements Runnable {

    private Identificador id;

    public A(Identificador id) {
        this.id = id;
    }

    @Override
    public void run() {
        synchronized (id) {
            if (id.getValor() == 1) {
                System.out.print("A");
            }
            id.setValor(2);
        }
    }

}
