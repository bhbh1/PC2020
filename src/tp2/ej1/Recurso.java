package tp2.ej1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author b h
 */
public class Recurso {

    static void uso() {
        Thread t = Thread.currentThread();
        System.out.println("en recurso- Soy: " + t.getName());
    }
}
