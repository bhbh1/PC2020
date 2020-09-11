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
public class B implements Runnable {

    private Identificador id;

    public B(Identificador id) {
        this.id = id;
    }

    @Override
    public void run() {
        while ((id.getValor() == 1) || (id.getValor() == 2)) {
            if (id.getValor() == 2) {
                synchronized (id) {
                    System.out.print("BB");
                    id.setValor(3);
                }
            }
        }
    }

}
