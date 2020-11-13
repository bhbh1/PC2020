/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej1;

import Utiles.IO;

/**
 *
 * @author b h
 */
import Utiles.IO;

public class Main {

    public static void main(String[] args) {
        String[] etiq = {"Agente", "Papel", "Tabaco",
            "Fosforos"};
        int[] ids = {6, 1, 2, 3};
        System.out.println(IO.infoEtiquetas(etiq, ids));
        SalaFumadores sala = new SalaFumadores();
        Fumador f1 = new Fumador(1, sala);
        Fumador f2 = new Fumador(2, sala);
        Fumador f3 = new Fumador(3, sala);
        Agente ag = new Agente(sala);

        Thread fumador1 = new Thread(f1);
        Thread fumador2 = new Thread(f2);
        Thread fumador3 = new Thread(f3);
        Thread agente = new Thread(ag);

        fumador1.start();
        fumador2.start();
        fumador3.start();
        agente.start();
    }
    //main
}
