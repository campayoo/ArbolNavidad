# 🎄 Árbol de Navidad en Java

Este proyecto consiste en un programa en **Java** que dibuja un **árbol de Navidad en la consola**, utilizando caracteres ASCII y **colores ANSI** para darle un aspecto vistoso y festivo. El árbol incluye **decoración de colores**, una **estrella en la parte superior**, un **tronco** y **regalos centrados debajo del árbol**.

<div align="center">
  <img 
    src="https://github.com/user-attachments/assets/3b7bf124-eb83-4db2-b9cc-cf57d90e15ce"
    width="500"
    alt="Árbol de Navidad en consola Java"
  />
</div>

---

## 📌 Características principales

- 🌲 Árbol de Navidad generado por consola.
- 🎨 Uso de **colores ANSI** (rojo, amarillo, verde, colores fosforitos, etc.).
- ⭐ Estrella en la punta del árbol.
- 🎁 Regalos dibujados y **centrados automáticamente** bajo el árbol.
- 📐 Ajuste dinámico del ancho del árbol.
- 💻 Compatible con terminales que soporten colores ANSI.

---

## 🛠️ Tecnologías usadas

- **Lenguaje:** Java  
- **Entrada de datos:** `Scanner`  
- **Salida:** Consola  
- **Estilo visual:** ASCII Art + Códigos ANSI  

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
* La lógica para dibujar el árbol.
* El tronco.
* Los regalos bajo el árbol.

### 🎨 Colores.java

Clase auxiliar que define los **códigos ANSI** usados para colorear el árbol, por ejemplo:

```java
public static final String ROJO = "\u001B[31m";
public static final String VERDE = "\u001B[32m";
public static final String AMARILLO = "\u001B[33m";
public static final String RESET = "\u001B[0m";
```

Esto permite cambiar fácilmente los colores sin modificar la lógica del programa.

---

## 🌲 Funcionamiento del programa

1. Se inicializa el ancho del árbol.
2. Se dibuja la estrella superior.
3. Se van generando las filas del árbol aumentando progresivamente su anchura.
4. Cada fila puede incluir colores aleatorios o definidos.
5. Se dibuja el tronco centrado.
6. Finalmente, se dibujan los regalos **alineados y centrados** debajo del árbol.

---

## 🎁 Regalos

Los regalos se representan mediante matrices de `String`, usando caracteres como `▓` y colores ANSI.

Ejemplo de regalo:

```
▓▓▓ ▓▓▓
   
▓▓▓ ▓▓▓
```

El programa calcula el **ancho visual real** (sin contar los códigos ANSI) para que los regalos queden centrados correctamente respecto al árbol.

---

## 📏 Centrado correcto (detalle técnico)

Para centrar correctamente textos con colores ANSI, se eliminan los códigos de color antes de calcular la longitud visual:

```java
int visualLength = linea.replaceAll("\u001B\\[[;\\d]*m", "").length();
```

Esto evita errores de alineación en la consola.

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
* Consola compatible con códigos ANSI (Windows Terminal, CMD moderno, Linux, macOS).

---

## 🎄 Resultado final

Al ejecutarlo, el programa mostrará un **árbol de Navidad colorido**, con decoración llamativa y regalos perfectamente centrados, ideal como ejercicio de Java o detalle festivo.

---

## ✨ Posibles mejoras

* Animaciones.
* Luces intermitentes.
* Elección de altura del árbol por el usuario.
* Exportar a archivo de texto.

---

¡Feliz programación y felices fiestas! 🎅🎁🎄


