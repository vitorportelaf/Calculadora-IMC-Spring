package br.fiap.calculadora_imc_spring.service;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class CalculadoraService {
    public BigDecimal calcular(String peso, String altura){
        BigDecimal p = toBigDecimal(peso);
        BigDecimal a = toBigDecimal(altura);
        if(a.compareTo(BigDecimal.ZERO) == 0){
            throw new IllegalArgumentException("Não existe divisão por zero!");
        }

        BigDecimal alturaQuadrada = a.pow(2);
        return p.divide(alturaQuadrada, 2, RoundingMode.HALF_UP);
    }

    private BigDecimal toBigDecimal(String valor) {
        String aux = valor.trim().replace(",", ".");
        try{
            return new BigDecimal(aux);
        }catch (Exception e){
            throw new IllegalArgumentException("Você deverá informar apenas números!");
        }
    }
}
