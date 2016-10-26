package com.github.kyriosdata.exemplo;

import org.junit.Test;

import static org.junit.Assert.*;

public class CpfTest {

    @Test
    public void CpfTeste01MenosDe11Digitos() {
        int[] test = new int[10];
        assertEquals(false, Cpf.cpf(test));
    }

    @Test
    public void CpfTeste02DigitoNegativo() {
        int[] test;
        test = new int[]{1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1};
        assertEquals(false, Cpf.cpf(test));
    }

    @Test
    public void CpfTeste03Valido() {
        int[] test;
        test = new int[]{4, 5, 2, 3, 4, 6, 8, 8, 6, 9, 0};
        assertEquals(true, Cpf.cpf(test));
    }
    
    @Test
    public void CpfTeste04InvalidoCodK() {
        int[] test;
        test = new int[]{4, 5, 2, 3, 4, 6, 8, 8, 6, 9, 1};
        assertEquals(false, Cpf.cpf(test));
    }
    
    @Test
    public void CpfTeste05InvalidoCodKCodJ() {
        int[] test;
        test = new int[]{4, 5, 2, 3, 4, 6, 8, 8, 6, 8, 1};
        assertEquals(false, Cpf.cpf(test));
    }
    
    @Test
    public void Cpf2Teste01MenosDe11Digitos() {
        int[] test = new int[10];
        assertEquals(false, Cpf.cpf2(test));
    }

    @Test
    public void Cpf2Teste02DigitoNegativo() {
        int[] test;
        test = new int[]{1, 1, 1, 1, -1, 1, 1, 1, 1, 1, 1};
        assertEquals(false, Cpf.cpf2(test));
    }

    @Test
    public void Cpf2Teste03Valido() {
        int[] test;
        test = new int[]{4, 5, 2, 3, 4, 6, 8, 8, 6, 9, 0};
        assertEquals(true, Cpf.cpf2(test));
    }
    
    @Test
    public void Cpf2Teste04InvalidoCodK() {
        int[] test;
        test = new int[]{4, 5, 2, 3, 4, 6, 8, 8, 6, 9, 1};
        assertEquals(false, Cpf.cpf2(test));
    }
    
    @Test
    public void Cpf2Teste05InvalidoCodKCodJ() {
        int[] test;
        test = new int[]{4, 5, 2, 3, 4, 6, 8, 8, 6, 8, 1};
        assertEquals(false, Cpf.cpf2(test));
    }
}
