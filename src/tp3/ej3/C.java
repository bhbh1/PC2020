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
public class C implements Runnable {

    private Identificador id;

    public C(Identificador id) {
        this.id = id;
    }

    @Override
    public void run() {
//        System.out.println("C");
        while (id.getValor() != 4) {
            if (id.getValor() == 3) {
                synchronized (id) {
                    System.out.print("CCC.");
                    id.setValor(1);
                }
            }
        }

    }

}
