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
     * Código usado referente a máscara do CPF (abc.def.ghi-jk).
     */
    private static final int COD_A = 0;
    /**
     * Código usado referente a máscara do CPF (abc.def.ghi-jk).
     */
    private static final int COD_B = 1;
    /**
     * Código usado referente a máscara do CPF (abc.def.ghi-jk).
     */
    private static final int COD_C = 2;
    /**
     * Código usado referente a máscara do CPF (abc.def.ghi-jk).
     */
    private static final int COD_D = 3;
    /**
     * Código usado referente a máscara do CPF (abc.def.ghi-jk).
     */
    private static final int COD_E = 4;
    /**
     * Código usado referente a máscara do CPF (abc.def.ghi-jk).
     */
    private static final int COD_F = 5;
    /**
     * Código usado referente a máscara do CPF (abc.def.ghi-jk).
     */
    private static final int COD_G = 6;
    /**
     * Código usado referente a máscara do CPF (abc.def.ghi-jk).
     */
    private static final int COD_H = 7;
    /**
     * Código usado referente a máscara do CPF (abc.def.ghi-jk).
     */
    private static final int COD_I = 8;
    /**
     * Código usado referente a máscara do CPF (abc.def.ghi-jk).
     */
    private static final int COD_J = 9;
    /**
     * Código usado referente a máscara do CPF (abc.def.ghi-jk).
     */
    private static final int COD_K = 10;

    /**
     * Método 1 de verificação da validade de um cpf.
     *
     * @param d vetor onde cada um dos 11 elementos possui um dígito do cpf.
     * @return Verdadeiro se for válido
     */
    public static boolean cpf(final int[] d) {
        if (verificaDigitos(d, DIGITOS_CPF)) {
            int sj = d[COD_A] + ((COD_B + 1) * d[COD_B])
                    + ((COD_C + 1) * d[COD_C]) + ((COD_D + 1) * d[COD_D])
                    + ((COD_E + 1) * d[COD_E]) + ((COD_F + 1) * d[COD_F])
                    + ((COD_G + 1) * d[COD_G]) + ((COD_H + 1) * d[COD_H])
                    + ((COD_I + 1) * d[COD_I]);
            int sk = d[COD_B] + (COD_C * d[COD_C]) + (COD_D * d[COD_D])
                    + (COD_E * d[COD_E]) + (COD_F * d[COD_F])
                    + (COD_G * d[COD_G]) + (COD_H * d[COD_H])
                    + (COD_I * d[COD_I]) + (COD_J * d[COD_J]);
            int j = mod(mod(sj, DIGITOS_CPF), COD_K);
            int k = mod(mod(sk, DIGITOS_CPF), COD_K);
            return j == d[COD_J] && k == d[COD_K];
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
            int c = COD_H;
            int p = d[COD_I];
            int s = d[COD_I];

            while (0 <= c) {
                p += d[c];
                s += p;
                c--;
            }
            int j = mod(mod(s, DIGITOS_CPF), COD_K);
            int k = mod(mod(s - p + (COD_J * j), DIGITOS_CPF), COD_K);

            return j == d[COD_J] && k == d[COD_K];
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
