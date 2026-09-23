# README — Evaluación

> **Curso:** PROGRAMACION WEB - II  
> **Código:** 30690  
> **Evaluación:** PA1
> **Equipo:** [Grupo 3]  

## 1. Integrantes

| Integrante | Rol | Aporte principal |
|---|---|---|
| Milise Garcia Quezada | Actividades 1, 2, 3, 4 | Desarrollo de Análisis del problema y selección de estructura, Modelado y operaciones con vectores, Matrices y recorrido completo de datos y Matrices especiales y decisión técnica |
| [Nombre 2] | [Rol] | [Aporte] |
| [Nombre 3] | [Rol] | [Aporte] |
| [Nombre 4] | [Rol] | [Aporte] |
| [Nombre 5] | [Rol] | [Aporte] |

## 2. Descripción y objetivo

**Problema:**  
La evaluación plantea el desarrollo de una solución para una coordinación académica que necesita organizar información relacionada con talleres estudiantiles.

Para resolver el problema se utilizan estructuras de datos estáticas, principalmente arreglos unidimensionales y matrices bidimensionales. Estas estructuras permiten almacenar las cantidades de estudiantes, realizar búsquedas de valores, insertar nuevos datos, ordenar información y analizar la ocupación de aulas en diferentes horarios.

**Objetivo:**  
Aplicar conceptos de datos, algoritmos y estructuras de datos mediante el uso de arreglos unidimensionales y matrices, desarrollando algoritmos para realizar operaciones, recorridos, búsquedas, inserciones, ordenamientos y cálculos de totales.

También se busca comprender cómo la elección de una estructura de datos permite organizar la información de acuerdo con las características del problema

**Solución desarrollada:**  
Se desarrollaron cuatro actividades.

En la Actividad 1 se analizan conceptos fundamentales relacionados con datos, algoritmos y estructuras de datos, además de la diferencia entre estructuras estáticas y dinámicas.

En la Actividad 2 se trabaja con un vector que contiene la cantidad de inscritos en diferentes talleres. Se realiza su representación, búsqueda del valor mayor y menor, inserción de un nuevo valor y ordenamiento de los elementos.

En la Actividad 3 se utiliza una matriz de 4 filas por 5 columnas para representar la ocupación de aulas en diferentes bloques horarios. Se realizan recorridos para calcular el total de estudiantes por aula y por horario, además de identificar la posición que contiene la mayor cantidad de estudiantes.

En la Actividad 4 se estudian las matrices especiales, específicamente las matrices cuadradas y las matrices dispersas, analizando sus características y posibles aplicaciones.


## Actividad 1 — Conceptos fundamentales
1.1 Diferencia entre estructura estática y dinámica

Una estructura de datos estática tiene un tamaño definido y no puede cambiar durante la ejecución del programa. 

Por otro lado, una estructura de datos dinámica puede cambiar su tamaño durante la ejecución dependiendo de las necesidades del programa. 

En esta evaluación se utilizan principalmente estructuras estáticas porque conocemos previamente la cantidad de datos que se desean almacenar.

1.2 ¿Por qué utilizar arreglos y matrices?

Los arreglos y matrices permiten almacenar datos del mismo tipo de forma organizada.

Un arreglo unidimensional o vector es adecuado cuando los datos se encuentran organizados en una sola dimensión. En este caso se utiliza para almacenar la cantidad de inscritos de los talleres.

Por ejemplo:

[28, 15, 34, 21, 19, 40, 12, 26]

Cada elemento puede ser consultado mediante un índice.

Una matriz permite organizar información utilizando filas y columnas. En este caso, las filas representan las aulas y las columnas representan los horarios.

Esta estructura permite realizar recorridos horizontales para obtener información por aula y recorridos verticales para obtener información por horario.

1.3 Relación entre dato, algoritmo y estructura de datos

Los datos son los valores que se necesitan almacenar y procesar. 

La estructura de datos determina cómo se organizan esos valores. Por ejemplo, se utiliza un vector para los inscritos y una matriz para representar la ocupación de aulas y horarios.

El algoritmo indica los pasos que debe seguir el programa para procesar esos datos. Por ejemplo, recorrer un vector para encontrar el mayor y menor valor, o recorrer una matriz para calcular los totales.

Por lo tanto, los tres conceptos están relacionados: los datos representan la información, la estructura permite organizarla y el algoritmo permite procesarla para obtener un resultado.

## Actividad 2 — Arreglo unidimensional

El vector utilizado en el programa es:

[28, 15, 34, 21, 19, 40, 12, 26]

2.1 Representación del vector

Índice:  0   1   2   3   4   5   6   7
        ┌───┬───┬───┬───┬───┬───┬───┬───┐
Valor:  │28 │15 │34 │21 │19 │40 │12 │26 │
        └───┴───┴───┴───┴───┴───┴───┴───┘

En Java se representa mediante:

int[] vector = {28, 15, 34, 21, 19, 40, 12, 26};

Cada elemento se puede acceder utilizando su índice. Por ejemplo, vector[0] contiene el valor 28.

2.2 Obtener el valor mayor y menor

Código utilizado
int mayor = vector[0];
int menor = vector[0];

for (int i = 1; i < vector.length; i++) {

    if (vector[i] > mayor) {
        mayor = vector[i];
    } else if (vector[i] < menor) {
        menor = vector[i];
    }
}
Resultado
Valor mayor: 40
Valor menor: 12

2.3 Insertar un nuevo valor

Como los arreglos de Java tienen un tamaño fijo, para insertar un nuevo elemento se crea un segundo arreglo con una posición adicional.

El programa solicita al usuario:

El nuevo valor.
La posición donde desea insertarlo.

Código utilizado
int[] nuevoVector = new int[vector.length + 1];

for (int i = 0; i < posicion; i++) {
    nuevoVector[i] = vector[i];
}

nuevoVector[posicion] = nuevoValor;

for (int i = posicion; i < vector.length; i++) {
    nuevoVector[i + 1] = vector[i];
}

Antes de realizar la inserción también se valida que la posición se encuentre dentro del rango permitido:

if (posicion < 0 || posicion > vector.length) {
    System.out.println("Posición no válida.");
}

2.4 Ordenamiento de menor a mayor

Código utilizado
for (int i = 0; i < nuevoVector.length - 1; i++) {

    int posicionMenor = i;

    for (int j = i + 1; j < nuevoVector.length; j++) {

        if (nuevoVector[j] < nuevoVector[posicionMenor]) {
            posicionMenor = j;
        }
    }

    if (posicionMenor != i) {

        int temporal = nuevoVector[i];
        nuevoVector[i] = nuevoVector[posicionMenor];
        nuevoVector[posicionMenor] = temporal;
    }
}

2.5 Costo aproximado del ordenamiento

Su complejidad temporal es aproximadamente:

Mejor caso: O(n²)
Peor caso:  O(n²)

Esto se debe a que el algoritmo sigue recorriendo los elementos aunque el vector ya se encuentre ordenado.

## Actividad 3 — Matriz bidimensional

Para representar la ocupación de las aulas se utiliza una matriz de 4 filas × 5 columnas.

Las filas representan las aulas y las columnas representan los horarios.

La matriz utilizada en el programa es:

             H0  H1  H2  H3  H4
           ┌───┬───┬───┬───┬───┐
Aula 0     │20 │15 │18 │22 │17 │
Aula 1     │25 │19 │21 │16 │20 │
Aula 2     │12 │18 │15 │24 │19 │
Aula 3     │22 │20 │17 │21 │16 │
           └───┴───┴───┴───┴───┘

En Java:

int[][] matriz = {
    {20, 15, 18, 22, 17},
    {25, 19, 21, 16, 20},
    {12, 18, 15, 24, 19},
    {22, 20, 17, 21, 16}
};

3.1 Recorrido de la matriz

Para recorrer la matriz se utilizan dos ciclos for.

El primer ciclo controla las filas y el segundo las columnas:

for (int i = 0; i < matriz.length; i++) {

    for (int j = 0; j < matriz[i].length; j++) {
        System.out.print(matriz[i][j] + " ");
    }
}

El índice i representa la fila y el índice j representa la columna.

3.2 Total de estudiantes por aula

Para obtener el total de cada aula se mantiene fija una fila y se recorren todas sus columnas.

for (int i = 0; i < matriz.length; i++) {

    int totalAula = 0;

    for (int j = 0; j < matriz[i].length; j++) {
        totalAula += matriz[i][j];
    }

    System.out.println("Aula " + i + ": " + totalAula);
}
Resultados
Aula 0: 92
Aula 1: 101
Aula 2: 88
Aula 3: 96

3.3 Total de estudiantes por horario

Para obtener el total de cada horario se mantiene fija una columna y se recorren todas las filas.

for (int j = 0; j < matriz[0].length; j++) {

    int totalHorario = 0;

    for (int i = 0; i < matriz.length; i++) {
        totalHorario += matriz[i][j];
    }

    System.out.println("Horario " + j + ": " + totalHorario);
}
Resultados
Horario 0: 79
Horario 1: 72
Horario 2: 71
Horario 3: 83
Horario 4: 72

3.4 Identificar la mayor ocupación

Para encontrar la celda con mayor ocupación se toma inicialmente la primera posición de la matriz como referencia.

Durante el recorrido se compara cada elemento con el mayor valor encontrado.

int mayorOcupacion = matriz[0][0];
int aulaMayor = 0;
int horarioMayor = 0;

for (int i = 0; i < matriz.length; i++) {

    for (int j = 0; j < matriz[i].length; j++) {

        if (matriz[i][j] > mayorOcupacion) {

            mayorOcupacion = matriz[i][j];
            aulaMayor = i;
            horarioMayor = j;
        }
    }
}
Resultado
Cantidad de estudiantes: 25
Aula: 1
Horario: 0

La mayor ocupación corresponde a 25 estudiantes, ubicada en el Aula 1, Horario 0.

3.5 ¿Por qué es necesario recorrer la matriz?

Es necesario recorrer las diferentes posiciones porque no conocemos de antemano dónde se encuentra el valor mayor.

El programa compara cada elemento con el valor máximo encontrado hasta ese momento. Cuando encuentra un valor superior, actualiza tanto el valor máximo como sus índices de fila y columna.

De esta manera se puede conocer no solamente la cantidad de estudiantes, sino también la ubicación de esa cantidad dentro de la matriz.

## Actividad 4 — Matrices especiales
4.1 Matriz cuadrada

Una matriz cuadrada es aquella que tiene la misma cantidad de filas y columnas.

Por ejemplo:

┌───┬───┬───┐
│ 5 │ 2 │ 8 │
├───┼───┼───┤
│ 1 │ 4 │ 7 │
├───┼───┼───┤
│ 3 │ 6 │ 9 │
└───┴───┴───┘

Esta matriz tiene 3 filas y 3 columnas, por lo que es una matriz cuadrada de dimensión 3 × 3.

4.2 Matriz dispersa

Una matriz dispersa es una matriz en la que la mayoría de sus elementos son cero y solamente unas pocas posiciones contienen valores diferentes de cero.

Por ejemplo:

             H0  H1  H2  H3  H4
           ┌───┬───┬───┬───┬───┐
Aula 0     │ 0 │ 0 │20 │ 0 │ 0 │
Aula 1     │ 0 │ 0 │ 0 │ 0 │15 │
Aula 2     │ 0 │ 0 │ 0 │ 0 │ 0 │
Aula 3     │25 │ 0 │ 0 │ 0 │ 0 │
           └───┴───┴───┴───┴───┘

En este ejemplo, la mayoría de las posiciones contienen 0, por lo que se considera una matriz dispersa.


## 3. Cómo ejecutar o revisar

Este proyecto puede revisarse directamente desde el repositorio de GitHub. El código Java se encuentra en la clase ActividadPA1, la cual contiene un método main y permite ejecutar las actividades desarrolladas.

**Pasos de revisión:**
1. Ingresar al repositorio y localizar el archivo ActividadPA1.java.
2. Revisar la implementación de la Actividad 2, incluyendo el vector, la búsqueda del valor mayor y menor, la inserción de un nuevo valor y el ordenamiento mediante Selection Sort.
3. Revisar la implementación de la Actividad 3, incluyendo el recorrido de la matriz, los totales por aula y horario y la búsqueda de la mayor ocupación.
4. Ejecutar la clase ActividadPA1 desde un entorno compatible con Java y seguir las indicaciones de la consola para ingresar el nuevo valor y la posición de inserción.
5. Comparar los resultados obtenidos durante la ejecución con los valores esperados descritos en este README.

> No publicar contraseñas, tokens, credenciales ni datos sensibles.

## 4. Evidencias

Las evidencias corresponden al código desarrollado y a los resultados obtenidos durante la ejecución del programa.

Evidencia 1: Código fuente de la clase ActividadPA1.java.
Evidencia 2: Ejecución de la Actividad 2, mostrando el vector original, el valor mayor y menor, la inserción de un nuevo valor y el vector ordenado.
Evidencia 3: Ejecución de la Actividad 3, mostrando la matriz de ocupación, los totales por aula y horario y la mayor ocupación encontrada.

## 5. Matriz de participación

| Integrante | Desarrollo | Pruebas | Documentación | Exposición | Evidencia de participación |
|---|---|---|---|---|---|
| Milise Garcia Quezada | Alta | Alta | Alta | No | Desarrollo de las actividades 1, 2, 3 y 4.. |
| [Nombre 2] | [Alta/Media/Baja] | [Alta/Media/Baja] | [Alta/Media/Baja] | [Sí/No] | [Commits, avances, etc.] |
| [Nombre 3] | [Alta/Media/Baja] | [Alta/Media/Baja] | [Alta/Media/Baja] | [Sí/No] | [Commits, avances, etc.] |
| [Nombre 4] | [Alta/Media/Baja] | [Alta/Media/Baja] | [Alta/Media/Baja] | [Sí/No] | [Commits, avances, etc.] |
| [Nombre 5] | [Alta/Media/Baja] | [Alta/Media/Baja] | [Alta/Media/Baja] | [Sí/No] | [Commits, avances, etc.] |

## 6. Video de exposición

**Video público de YouTube:** No se realizó por falta de tiempo


## 7. Conclusiones

- El desarrollo de la evaluación permitió aplicar conceptos relacionados con datos, algoritmos y estructuras de datos.
- La solución permitió comprender la diferencia entre trabajar con un arreglo unidimensional y una estructura bidimensional como una matriz.
- El uso de recorridos sobre arreglos permitió realizar operaciones como búsquedas, inserciones, ordenamientos y cálculos de totales.

---

**Última actualización:** [22/09/2026]
