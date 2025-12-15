public class Colores {

    public static final String RESET = "\u001B[0m"; // resetea el color (no es ningún color).

    public static final String VERDE = "\u001B[38;5;35m"; // Verde del árbol


    public static final String AMARILLO = "\u001B[38;5;191m"; // Amarillo de la estrella

    public static final String MARRON = "\u001B[38;5;94m"; // Marrón para el tronco

    public static final String ROJO = "\u001B[38;5;196m"; // Rojo para regalos

    public static final String AZUL = "\u001B[38;5;51m"; // Azul para regalos


    public static final String[] DECORACION = {
            "\u001B[38;5;196m", // Rojo fosforito
            "\u001B[38;5;201m", // Rosa fosforito
            "\u001B[38;5;46m",  // Verde fosforito
            "\u001B[38;5;51m",  // Azul fosforito
            "\u001B[38;5;208m"  // Naranja fosforito
    };

    // Devuelve un color aleatorio
    public static String colorRandom() {
        int i = (int)(Math.random() * DECORACION.length);
        return DECORACION[i];
    }
}
