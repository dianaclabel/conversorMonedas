package com.aluracursos.conversorDeMonedas.modelos;

public record BaseDeConversionExchangeRate(String base_code, String target_code, double conversion_rate) {
}
