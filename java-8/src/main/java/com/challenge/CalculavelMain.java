package com.challenge;

import com.challenge.desafio.CalculadorDeClasses;
import com.challenge.interfaces.Calculavel;

import java.math.BigDecimal;

public class CalculavelMain {
    public static void main(String[] args) {
        Calculavel calculavel = new CalculadorDeClasses();
        BigDecimal somar = calculavel.somar(BigDecimal.TEN);
    }
}
