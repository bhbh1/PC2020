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
//Clon de IO, solo que sus metodos retornan en vez
//de escribir
public class IOR {

    private static final String ANSI_RESET = "\u001B[0m";
    //1:rojo, 2:verde, 3:amarillo, 4:azul, 5:purpura
    //6:cyan, 7: blanco 
    private static final String[] colores = {"\u001B[31m",
        "\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m",
        "\u001B[36m", "\u001B[37m"};

    //colorFijo: define el primer color
    //id: numero que se muestra y que define el segundo color
    //muchoEsp: define la frecuencia del espaciado
    public static String colMsg(int colorFijo, int id, boolean muchoEsp) {
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
        //muchoEsp varia cada que tan frecuente se agrega espaciado
        if (muchoEsp) {
            if (id % 4 > 1) {
                marcador += "  ";
            } else {
                espacio = "  ";
            }
        } else {
            if (id % 12 > 5) {
                marcador += "  ";
            } else {
                espacio = "  ";
            }
        }

        //Segundo color con o sin espaciado
        marcador += colores[(id % 6)] + "■" + ANSI_RESET
                + espacio + "|";

        return marcador;
    }

    public static String colTxt(int colorFijo, String msg) {
        return colores[colorFijo % 7] + msg + ANSI_RESET;
    }

    //Simple
    //Varian ambos colores
    public static String sCol(int id, String mensaje) {
        return " " + colMsg(id, id, false) + mensaje;
    }

    //Varia el segundo color
    public static String sCol(int colorFijo, int id, String mensaje) {
        return " " + colMsg(colorFijo, id, false) + mensaje;
    }

    //Espaciado
    //Varian ambos colores y tiene mucho espaciado
    public static String sColE(int id, String mensaje) {
        return " " + colMsg(id, id, true) + mensaje;
    }

    //Varia el segundo color y tiene mucho espaciado
    public static String sColE(int colorFijo, int id, String mensaje) {
        return " " + colMsg(colorFijo, id, true) + mensaje;
    }

    //Marcado
    //Varian ambos colores y esta marcado
    public static String sColM(int id, String mensaje, char marca) {
        return marca + colMsg(id, id, false) + mensaje;
    }

    //Varia el segundo color y tiene marca
    public static String sColM(int colorFijo, int id, String mensaje,
            char marca) {
        return marca + colMsg(colorFijo, id, false) + mensaje;
    }

    //Varian ambos colores, tiene mucho espaciado y tiene marca
    public static String sColEM(int id, String mensaje, char marca) {
        return marca + colMsg(id, id, true) + mensaje;
    }

    //Varia el segundo color, tiene mucho espaciado y esta marcado
    public static String sColEM(int colorFijo, int id, String mensaje,
            char marca) {
        return marca + colMsg(colorFijo, id, true) + mensaje;
    }

    //Mensajes a color en metodos con colorFijo
    //Simple
    //Varia el segundo color
    public static String sColC(int colorFijo, int id, String mensaje) {
        return " " + colMsg(colorFijo, id, false)
                + colores[colorFijo % 7] + mensaje + ANSI_RESET;
    }

    //Espaciado
    //Varia el segundo color y tiene mucho espaciado
    public static String sColEC(int colorFijo, int id, String mensaje) {
        return " " + colMsg(colorFijo, id, true)
                + colores[colorFijo % 7] + mensaje + ANSI_RESET;
    }

    //Marcado
    //Varia el segundo color y tiene marca
    public static String sColMC(int colorFijo, int id, String mensaje,
            char marca) {
        return marca + colMsg(colorFijo, id, false)
                + colores[colorFijo % 7] + mensaje + ANSI_RESET;
    }

    //Marcado y espaciado
    //Varia el segundo color, tiene mucho espaciado y esta marcado
    public static String sColEMC(int colorFijo, int id, String mensaje,
            char marca) {
        return marca + colMsg(colorFijo, id, true)
                + colores[colorFijo % 7] + mensaje + ANSI_RESET;
    }

    public static String getMarcador(int id) {
        return colores[id % 7] + "■" + ANSI_RESET;
    }

    public static String getMarcadorCompleto(int id) {
        String cero = "";
        if (id < 10) {
            cero = "0";
        }
        return colores[id % 7] + "■" + ANSI_RESET
                + cero + id + colores[id % 6] + "■" + ANSI_RESET;
    }

    public static String getMarcadorCompleto(int colorFijo, int id) {
        String cero = "";
        if (id < 10) {
            cero = "0";
        }
        return colores[colorFijo % 7] + "■" + ANSI_RESET
                + cero + id + colores[id % 6] + "■" + ANSI_RESET;
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
            System.err.print("El arreglo de etiquetas tiene mas elementos "
                    + "que el arreglo de ids");
        }
        return s;
    }

}
