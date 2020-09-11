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
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Identificador id = new Identificador(1);
        Runnable a = new A(id);
        Runnable b = new B(id);
        Runnable c = new C(id);
        Thread h1 = new Thread(a, "h A");
        Thread h2 = new Thread(b, "h B");
        Thread h3 = new Thread(c, "h C");

        h1.start();
        h2.start();
        h3.start();

    }
}
