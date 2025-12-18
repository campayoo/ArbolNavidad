# 🎄 Árbol de Navidad en Java

Este proyecto consiste en un **programa en Java** que dibuja un **árbol de Navidad en la consola**, utilizando **caracteres ASCII/Unicode** y **colores ANSI** para darle un aspecto vistoso y festivo. El árbol es **interactivo** y permite al usuario configurar varios aspectos antes de dibujarlo.

Incluye **decoración de colores aleatorios**, una **estrella en la parte superior**, un **tronco opcional**, **regalos centrados debajo del árbol** y un **suelo decorativo**.

<div align="center">
  <img
    src="https://github.com/user-attachments/assets/737c38ea-c264-4cb3-99ea-05484bf5c1e2"
    width="500"
    alt="Árbol de Navidad en consola Java"
  />
</div>

---

## 📌 Características principales

* 🌲 Árbol generado dinámicamente por **ramas/pisos**.
* 🎨 Decoración opcional con **luces de colores aleatorios**.
* ⭐ Estrella fosforita en la parte superior del árbol.
* 🪵 Tronco opcional, centrado automáticamente.
* 🎁 Regalos dibujados con ASCII y **alineados correctamente** bajo el árbol.
* 📐 Cálculo automático del ancho máximo para un **centrado perfecto**.
* 💻 Compatible con terminales que soporten **códigos ANSI**.

---

## 🛠️ Tecnologías usadas

* **Lenguaje:** Java
* **Entrada de datos:** `Scanner`
* **Salida:** Consola
* **Estilo visual:** ASCII Art + Unicode + Códigos ANSI

---

## 📂 Estructura del proyecto

```
Arbol.java
Colores.java
README.md
```

### 📄 Arbol.java

Archivo principal del programa. Contiene:

* El método `main()`.
* La lógica para generar el árbol por pisos.
* La estrella superior.
* El tronco opcional.
* Los regalos centrados bajo el árbol.
* El suelo decorativo.

El programa solicita al usuario:

* Número de ramas del árbol.
* Si desea mostrar el tronco.
* Si desea añadir decoración.

---

### 🎨 Colores.java

Clase auxiliar que define los **códigos ANSI** utilizados para colorear el árbol y los regalos.

Ejemplo:

```java
public static final String ROJO = "\u001B[31m";
public static final String VERDE = "\u001B[32m";
public static final String AMARILLO = "\u001B[33m";
public static final String RESET = "\u001B[0m";
```

También incluye un método para devolver **colores aleatorios** usados en la decoración.

---

## 🌲 Funcionamiento del programa

1. El usuario introduce las opciones iniciales (ramas, tronco y decoración).
2. Se calcula la altura total del árbol por pisos.
3. Se genera el árbol línea a línea aumentando su anchura progresivamente.
4. Se añade decoración aleatoria con una probabilidad del 25%.
5. Se dibuja la estrella centrada en la parte superior.
6. Se muestra el árbol completo.
7. Si se ha activado, se dibuja el tronco y los regalos.
8. Finalmente, se dibuja el suelo.

---

## 🎁 Regalos

Los regalos se representan mediante **matrices de `String`**, usando caracteres como `▓` y distintos colores ANSI.

Cada regalo tiene forma simétrica y se colocan calculando su **ancho visual real** para que queden perfectamente centrados bajo el árbol.

---

## 📏 Centrado correcto (detalle técnico)

Para evitar errores de alineación causados por los códigos ANSI, el programa elimina dichos códigos antes de calcular la longitud visible de cada línea:

```java
int visualLength = linea.replaceAll("\u001B\\[[;\\d]*m", "").length();
```

Esto garantiza un centrado preciso tanto del árbol como de los regalos.

---

## ▶️ Cómo ejecutar el programa

1. Clona el repositorio:

```bash
git clone https://github.com/tu-usuario/arbol-navidad-java.git
```

2. Compila el programa:

```bash
javac Arbol.java
```

3. Ejecuta:

```bash
java Arbol
```

---

## ⚠️ Requisitos

* Java 8 o superior.
* Terminal compatible con códigos ANSI:

  * Windows Terminal / CMD moderno
  * Linux
  * macOS

---

## 🎄 Resultado final

Al ejecutarlo, el programa mostrará un **árbol de Navidad colorido**, configurable e interactivo, con decoración llamativa y regalos perfectamente centrados. Ideal como proyecto de práctica en Java o detalle festivo.

---

## ✨ Posibles mejoras

* Animaciones.
* Luces intermitentes.
* Música navideña.
* Exportar el resultado a un archivo `.txt`.
* Más tipos de decoración.

---

¡Feliz programación y felices fiestas! 🎅🎁🎄
