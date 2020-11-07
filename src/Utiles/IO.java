/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

/**
 *
 * @author b h
 */
public class IO {

    private static final String ANSI_RESET = "\u001B[0m";
    //1:rojo, 2:verde, 3:amarillo, 4:azul, 5:purpura
    //6:cyan, 7: blanco 
    private static final String[] colores = {"\u001B[31m",
        "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m",
        "\u001B[36m", "\u001B[37m"};

    //colorFijo: define el primer color
    //id: numero que se muestra y que define el segundo color
    //mensaje: texto a mostrar
    public static String colMsg(int colorFijo, int id, String mensaje) {
        String cero = "";
        String espacio = "";
        ///Alternativa: usar String.format("%02d", id),
        //pero es mas costosa
        if (id < 10) {
            cero = "0";
        }
        //Primer color e id
        String marcador = colores[colorFijo % 7] + "■" + ANSI_RESET
                + cero + id;
        //Alterna espaciado durante 6 elementos
        if (id % 12 > 5) {
            marcador += "  ";
        } else {
            espacio = "  ";
        }
        //Segundo color con o sin espaciado
        marcador += colores[(id % 6)] + "■" + ANSI_RESET
                + espacio + "|";

        return marcador + mensaje;
    }
    
    //Simple
    //Varian ambos colores
    public static void sCol(int id, String mensaje) {
        System.out.println(colMsg(id, id, mensaje));
    }

    //Varia el segundo color
    public static void sCol(int colorFijo, int id, String mensaje) {
        System.out.println(colMsg(colorFijo, id, mensaje));
    }
}
