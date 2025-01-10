package com.aluracursos.conversorDeMonedas.modelos;

public class CalcularConversion {
    public double calcular(BaseDeConversion informacionBase, double valorCalcular){
        double totalDeConversion = valorCalcular * informacionBase.valorBaseMonedaConvertir;
        return totalDeConversion;
    }
}
