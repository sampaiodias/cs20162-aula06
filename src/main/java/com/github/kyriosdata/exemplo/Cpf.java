/*
 * Copyright (c) 2016. Fábrica de Software - Instituto de Informática (UFG)
 * Creative Commons Attribution 4.0 International License.
 */
package com.github.kyriosdata.exemplo;

/**
 * Classe Cpf que verifica se um cpf é válido.
 */
public final class Cpf {

    /**
     * Construtor.
     */
    private Cpf() {
    }
    /**
     * Número de dígitos do CPF.
     */
    private static final int DIGITOS_CPF = 11;

    /**
     * Método 1 de verificação da validade de um cpf.
     *
     * @param d vetor onde cada um dos 11 elementos possui um dígito do cpf.
     * @return Verdadeiro se for válido
     */
    public static boolean cpf(final int[] d) {
        if (verificaDigitos(d, DIGITOS_CPF)) {
            int sj = d[0] + (2 * d[1]) + (3 * d[2]) + (4 * d[3]) + (5 * d[4])
                    + (6 * d[5]) + (7 * d[6]) + (8 * d[7]) + (9 * d[8]);
            int sk = d[1] + (2 * d[2]) + (3 * d[3]) + (4 * d[4]) + (5 * d[5])
                    + (6 * d[6]) + (7 * d[7]) + (8 * d[8]) + (9 * d[9]);
            int j = mod(mod(sj, 11), 10);
            int k = mod(mod(sk, 11), 10);
            return j == d[9] && k == d[10];
        }
        return false;
    }

    /**
     * Método 2 de verificação da validade de um cpf.
     *
     * @param d vetor onde cada um dos 11 elementos possui um dígito do cpf.
     * @return Verdadeiro se for válido
     */
    public static boolean cpf2(final int[] d) {
        if (verificaDigitos(d, DIGITOS_CPF)) {
            int c = 7;
            int p = d[8];
            int s = d[8];

            while (0 <= c) {
                p += d[c];
                s += p;
                c--;
            }
            int j = mod(mod(s, 11), 10);
            int k = mod(mod(s - p + (9 * j), 11), 10);

            return j == d[9] && k == d[10];
        }
        return false;
    }

    /**
     * Verifica se o vetor vet possui X digitos não negativos.
     *
     * @param vet vetor analisado
     * @param num número de digitos requeridos
     * @return Verdadeiro se possuir X digitos não negativos
     */
    private static boolean verificaDigitos(final int[] vet, final int num) {
        for (int repeticoes = 0; repeticoes < num; repeticoes++) {
            try {
                if (vet[repeticoes] < 0) {
                    return false;
                }
            } catch (IndexOutOfBoundsException e) {
                return false;
            }
        }
        return true;
    }

    /**
     * Calcula o resto da divisão entre dois inteiros.
     *
     * @param x dividendo
     * @param y divisor
     * @return resto
     */
    private static int mod(final int x, final int y) {
        return x % y;
    }
}
