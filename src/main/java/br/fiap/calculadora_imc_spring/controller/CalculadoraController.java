package br.fiap.calculadora_imc_spring.controller;

import br.fiap.calculadora_imc_spring.service.CalculadoraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class CalculadoraController {
    private final CalculadoraService service;

    public CalculadoraController(CalculadoraService service) {
        this.service = service;
    }

    @PostMapping("/calcular")
    public String calcular(@RequestParam String peso,
                           @RequestParam String altura,
                           Model model)
    {
        BigDecimal resultado = null;
        String erro = "";

        try{
            resultado = service.calcular(peso, altura);
        }catch (Exception e){
            erro = e.getMessage();
        }

        model.addAttribute("resultado", resultado);
        model.addAttribute("erro", erro);
        model.addAttribute("altura", altura);
        model.addAttribute("peso", peso);
        return "index";
    }
}
