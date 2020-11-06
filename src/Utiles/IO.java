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

    //id: numero que se muestra y que define el segundo color
    //mensaje: texto a mostrar, colorFijo: define el primer color
    public static String sCol(int id, String mensaje,
            int colorFijo) {
        String cero = "";
        String espacio = "";
        ///Alternativa: usar String.format("%02d", id),
        //pero es mas costosa
        if (id < 10) {
            cero = "0";
        }
        //Primer color e id
        String marcador = colores[colorFijo % 7] + "■" + ANSI_RESET +
                cero + id;
        //Alterna espaciado durante 6 elementos
        if (id % 12 > 5) {
            marcador += "  ";
        } else {
            espacio = "  ";
        }
        //Segundo color con o sin espaciado
        marcador += colores[(id % 6)] + "■" + ANSI_RESET +
                espacio + "|";

        return marcador + mensaje;
    }

    public static void sColLibre(int id, String mensaje) {
        System.out.println(sCol(id, mensaje, id));
    }

    public static void sColFijo(int id, String mensaje,
            int colorFijo) {
        System.out.println(sCol(id, mensaje, colorFijo));
    }

    public static String getMarcador(int id) {
        return colores[id % 7] + "■" + ANSI_RESET;
    }

    //Para ser usado antes de que haya concurrencia
    //Lista las etiquetas acompañadas de su respectivo color
    public static String infoEtiquetas(String[] etiquetas, int[] ids) {
        String s = "";
        int tamEt = etiquetas.length;
        try {
            for (int i = 0; i < tamEt; i++) {
                //Baja linea cada dos etiquetas
                if ((i % 2 == 0) && (i != 0)) {
                    s += "\n";
                }
                s += etiquetas[i] + ": ";
                s += getMarcador(ids[i]);
                //Agrega coma si no es la ultima etiqueta
                if (i < tamEt - 1) {
                    s += ", ";
                }

            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.print("El arreglo de etiquetas tiene mas elementos " +
                    "que el arreglo de ids");
        }
        return s;
    }

}
