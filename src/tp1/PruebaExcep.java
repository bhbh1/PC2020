/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import Utiles.TecladoIn;
import java.util.Random;

/**
 *
 * @author b h
 */
public class PruebaExcep {

    public static void main() {
//        ingrEdad();
        jugarRuleta();
    }

    public static int ingrEdad() {
        int edad = 0;
        try {
            System.out.println("Ingrese una edad");
            edad = TecladoIn.readLineInt();
            if (edad >= 18) {
                System.out.println("Suceso!");
            } else {
                throw new Exception("Error: es menor de edad");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return edad;
    }

    public static boolean jugarRuleta() {
        boolean suceso = false;
        int numeroApostado = 0;
        Random r = new Random();
        int numeroRuleta = r.nextInt(30);
        System.out.println("N ruleta: " + numeroRuleta);
        numeroApostado = TecladoIn.readLineInt();
        try {
            if (numeroApostado == numeroRuleta) {
                System.out.println("Suceso!");
                suceso = true;
            } else {
                throw new Exception("Error: no salió el numero apostado");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        return suceso;
    }

}
