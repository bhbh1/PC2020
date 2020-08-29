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
//        jugarRuleta();
        listarColeccion();
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

    public static boolean listarColeccion() {
        boolean suceso = true;
        int[] col = ingrColeccion();

        try {
            for (int i = 0; i < 7; i++) {
                System.out.println("Elem " + i + ": " + col[i]);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: el arreglo tiene menos de 7 elementos.");
            suceso = false;
        }

        return suceso;
    }

    public static int[] ingrColeccion() {
        int n;
        int[] col = new int[5];
        for (int i = 0; i < 5; i++) {
            System.out.println("Ingrese un número");
            n = TecladoIn.readLineInt();
            col[i] = n;
        }
        return col;
    }

}
