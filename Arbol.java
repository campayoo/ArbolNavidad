import java.util.Scanner;

public class Arbol {
    static Scanner sc = new Scanner(System.in); // defino el escáner fuera para poderlo utilizar en caso de que lo utilicemos fuera del metodo main.

    private static int anchoActual = 1;
    private static int anchoMax = 1; // Inicializamos el ancho del árbol en 1 y el máximo en 1 por ahora. Esto lo hago en privado estático ya que quiero que se actualice en los metodos.

    public static void main(String[] args) {

        System.out.print("Número de ramas: ");
        int ramas = sc.nextInt(); // Establecemos el número de pisos que va a tener el árbol.

        System.out.print("Tronco (S/N): ");
        String opcionTronco = sc.next(); // Definimos si va a haber tronco o no en el árbol.

        System.out.print("Decoración (S/N): ");
        String opcionDecoracion = sc.next(); // Establecemos la decoración, si la hay o no.

        boolean decoracion = opcionDecoracion.equalsIgnoreCase("S"); // creamos la variable decoración para dibujarlo con O o sin O.

        int alturaPiso = 4; // Establecemos que cada piso tenga una altura de 4 para que quede bien.
        int totalLineas = ramas * alturaPiso; // creamos la variable totalLineas para posteriormente utilizarla para hacer el largo del String de arbol.

        String[] arbol = new String[totalLineas]; // creamos el string del arbol para después mostrarlo con colores o no.
        int cont = 0;

        anchoActual = obtenerArbol(ramas, alturaPiso, decoracion, cont, arbol, anchoActual);

        dibujarEstrella(anchoMax);

        dibujarArbol(arbol, anchoMax);

        // En caso de que haya tronco, lo muestra con el metodo, también mostrará los regalos.
        if (opcionTronco.equalsIgnoreCase("S")) {
            dibujarTronco(anchoActual);
            dibujarRegalos();
        }

        dibujarSuelo(anchoActual);
    }

    // Dibuja la estrella calculando los espacios.
    public static void dibujarEstrella(int anchoMax) {
        int espaciosEstrella = (anchoMax - 1) / 2 + 50;
        System.out.println(" ".repeat(espaciosEstrella) + Colores.AMARILLO + Caracteres.ESTRELLA + Colores.AMARILLO); // muestra la estrella en amarillo fosforito para que resalte.
    }

    // Muestra el árbol de forma centrada.
    public static void dibujarArbol(String[] arbol, int ancho) {
        for (String linea : arbol) {
            int longitudEspacios = linea.replaceAll("\u001B\\[[;\\d]*m", "").length(); // Longitud visible ignorando los códigos de colores ANSI
            int espacios = (ancho - longitudEspacios) / 2 + 50;

            System.out.println(" ".repeat(espacios) + linea);
        }
    }

    // Metodo para tener la forma del árbol, para después solo añadir los espacios.
    public static int obtenerArbol(int ramas, int alturaPiso, boolean decoracion, int cont, String[] arbol, int anchoActual) {
        for (int piso = 1; piso <= ramas; piso++) { // Construir el árbol por pisos

            for (int fila = 0; fila < alturaPiso; fila++) {
                int estrellas = anchoActual + fila * 2;


                StringBuilder linea = new StringBuilder(); // Línea de solo asteriscos.

                for (int i = 0; i < estrellas; i++) {

                    if (decoracion && Math.random() < 0.25 && i!=estrellas-1 && i!=0) { // aquí se establece la probabilidad de que sea luz o hoja de árbol (25% de ser luz).
                        linea.append(Colores.colorRandom()).append(Caracteres.BOLAS).append(Colores.RESET); // escoge color ALEATORIO y lo muestra con O para hacer de bolas de colores.
                    } else {
                        if (i == 0)
                            linea.append(Colores.VERDE).append(Caracteres.RAMAIZQUIERDA).append(Colores.RESET); // si no hay decoración simplemente muestra la hoja con el color verde del árbol.
                        else if (i == estrellas-1)
                            linea.append(Colores.VERDE).append(Caracteres.RAMADERECHA).append(Colores.RESET); // si no hay decoración simplemente muestra la hoja con el color verde del árbol.
                        else
                            linea.append(Colores.VERDE).append(Caracteres.RAMA).append(Colores.RESET); // si no hay decoración simplemente muestra la hoja con el color verde del árbol.
                    }
                }

                arbol[cont++] = linea.toString();

                if (estrellas > anchoMax) anchoMax = estrellas;
            }

            anchoActual += 4;   // hace que los pisos destaquen más y se marquen.
        }
        return anchoActual;
    }

    // Metodo para dibujar el tronco.
    public static void dibujarTronco(int ancho) {

        int troncoAncho = ancho / 5; // establecemos el ancho del tronco dividiendo el ancho maximo del árbol entre 5 para que sea en compensación con el árbol ancho.
        if (troncoAncho % 2 == 0) troncoAncho++;

        int troncoAltura = 3; // de alto el tronco siempre será de 3 para que no sea muy alto.
        int espacios = (anchoMax - troncoAncho) / 2 + 50;

        for (int i = 0; i < troncoAltura; i++) {
            System.out.println(" ".repeat(espacios) + Colores.MARRON + Caracteres.TRONCO.repeat(troncoAncho)); // muestra siempre el tronco en color marrón y utiliza los espacios para centrarlo.
        }
    }

    // Metodo para dibujar el suelo.
    public static void dibujarSuelo(int anchoMax) {
        for (int i = 0; i < anchoMax*5; i++) {
            System.out.print(Colores.MARRON + Caracteres.SUELO); // El suelo es marrón representando tierra.
        }
    }

    // Metodo para dibujar regalos debajo del árbol
    public static void dibujarRegalos() {
        String[][] regalos = {
                {
                        Colores.ROJO + "▓▓▓" + Colores.AMARILLO + "▓" + Colores.ROJO + "▓▓▓" + Colores.RESET,
                        Colores.AMARILLO + "▓▓▓▓▓▓▓" + Colores.RESET,
                        Colores.ROJO + "▓▓▓" + Colores.AMARILLO + "▓" + Colores.ROJO + "▓▓▓" + Colores.RESET
                },
                {
                        Colores.AMARILLO + "▓▓▓" + Colores.ROJO + "▓" + Colores.AMARILLO + "▓▓▓" + Colores.RESET,
                        Colores.ROJO + "▓▓▓▓▓▓▓" + Colores.RESET,
                        Colores.AMARILLO + "▓▓▓" + Colores.ROJO + "▓" + Colores.AMARILLO + "▓▓▓" + Colores.RESET
                },
                {
                        Colores.AZUL + "▓▓▓" + Colores.AMARILLO + "▓" + Colores.AZUL + "▓▓▓" + Colores.RESET,
                        Colores.AMARILLO + "▓▓▓▓▓▓▓" + Colores.RESET,
                        Colores.AZUL + "▓▓▓" + Colores.AMARILLO + "▓" + Colores.AZUL + "▓▓▓" + Colores.RESET
                }
        };

        int anchoRegaloVisible = 7; // carácteres que tiene cada línea de regalo.
        int espacioEntreRegalos = 3; // el espacio que va a haber entre regalo y regalo.


        int anchoTotal = regalos.length * anchoRegaloVisible
                + (regalos.length - 1) * espacioEntreRegalos;

        int espacios = (anchoMax - anchoTotal) / 2 + 50;

        for (int linea = 0; linea < 3; linea++) {
            System.out.print(" ".repeat(espacios));
            for (int i = 0; i < regalos.length; i++) {
                System.out.print(regalos[i][linea]);
                if (i < regalos.length - 1) {
                    System.out.print(" ".repeat(espacioEntreRegalos));
                }
            }
            System.out.println();
        }
    }

}
