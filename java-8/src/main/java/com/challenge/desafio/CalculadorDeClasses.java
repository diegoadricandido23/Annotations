package com.challenge.desafio;

import com.challenge.annotation.Somar;
import com.challenge.annotation.Subtrair;
import com.challenge.interfaces.Calculavel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;

public class CalculadorDeClasses implements Calculavel {

    @Override
    public BigDecimal somar(Object object) {
        return calcular(object, Somar.class);
    }

    @Override
    public BigDecimal subtrair(Object object) {
        return calcular(object, Subtrair.class);
    }

    @Override
    public BigDecimal totalizar(Object object) {
        return somar(object).subtract(subtrair(object));
    }

    public BigDecimal calcular(Object objeto, Class<? extends Annotation> anotado) {
        BigDecimal soma = BigDecimal.ZERO;


        for (Field field: objeto.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            if(field.isAnnotationPresent(anotado)) {
                try {
                    soma = soma.add((BigDecimal) field.get(objeto));
                } catch (Exception e) {
                    return BigDecimal.ZERO;
                }
            }
        }
        return soma;
    }
}
