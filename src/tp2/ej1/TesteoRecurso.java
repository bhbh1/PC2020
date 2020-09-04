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
public class TesteoRecurso {
    public static void main(){
        Cliente juan = new Cliente();
        juan.setName("Juan lopez");
        Cliente ines = new Cliente();
        juan.setName("ines");
        juan.start();
        ines.start();
    }
}
