package com.lideratec;

import java.util.Scanner;

public class ActividadPA1 {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int[] vector = {28, 15, 34, 21, 19, 40, 12, 26};

        System.out.println("=================================");
        System.out.println("        ACTIVIDAD 2 - VECTOR");
        System.out.println("=================================");

        System.out.println("\nVECTOR ORIGINAL");

        for (int i = 0; i < vector.length; i++) {
            System.out.println("Índice " + i + ": " + vector[i]);
        }

        int mayor = vector[0];
        int menor = vector[0];

        for (int i = 1; i < vector.length; i++) {

            if (vector[i] > mayor) {
                mayor = vector[i];
            } else if (vector[i] < menor) {
                menor = vector[i];
            }
        }

        System.out.println("\nValor mayor: " + mayor);
        System.out.println("Valor menor: " + menor);

        System.out.print("\nIngrese el nuevo valor: ");
        int nuevoValor = entrada.nextInt();

        System.out.print("Ingrese la posición donde desea insertarlo: ");
        int posicion = entrada.nextInt();

        if (posicion < 0 || posicion > vector.length) {

            System.out.println("Posición no válida.");

        } else {

            int[] nuevoVector = new int[vector.length + 1];

            for (int i = 0; i < posicion; i++) {
                nuevoVector[i] = vector[i];
            }

            nuevoVector[posicion] = nuevoValor;

            for (int i = posicion; i < vector.length; i++) {
                nuevoVector[i + 1] = vector[i];
            }

            System.out.println("\nVECTOR DESPUÉS DE INSERTAR");

            for (int i = 0; i < nuevoVector.length; i++) {
                System.out.print(nuevoVector[i] + " ");
            }

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

            System.out.println("\n\nVECTOR ORDENADO");

            for (int i = 0; i < nuevoVector.length; i++) {
                System.out.print(nuevoVector[i] + " ");
            }
        }

        int[][] matriz = {
                {20, 15, 18, 22, 17},
                {25, 19, 21, 16, 20},
                {12, 18, 15, 24, 19},
                {22, 20, 17, 21, 16}
        };

        System.out.println("\n\n=================================");
        System.out.println("       ACTIVIDAD 3 - MATRIZ");
        System.out.println("=================================");

        System.out.println("\nOCUPACIÓN DE AULAS");

        for (int i = 0; i < matriz.length; i++) {

            System.out.print("Aula " + i + ": ");

            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println("\nTOTAL DE ESTUDIANTES POR AULA");

        for (int i = 0; i < matriz.length; i++) {

            int totalAula = 0;

            for (int j = 0; j < matriz[i].length; j++) {
                totalAula += matriz[i][j];
            }

            System.out.println("Aula " + i + ": " + totalAula);
        }

        System.out.println("\nTOTAL DE ESTUDIANTES POR HORARIO");

        for (int j = 0; j < matriz[0].length; j++) {

            int totalHorario = 0;

            for (int i = 0; i < matriz.length; i++) {
                totalHorario += matriz[i][j];
            }

            System.out.println("Horario " + j + ": " + totalHorario);
        }

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

        System.out.println("\nMAYOR OCUPACIÓN");
        System.out.println("Cantidad de estudiantes: " + mayorOcupacion);
        System.out.println("Aula: " + aulaMayor);
        System.out.println("Horario: " + horarioMayor);

        entrada.close();
    }
}
}
