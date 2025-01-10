package com.aluracursos.conversorDeMonedas.modelos;

public class BaseDeConversion {
    String monedaBase;
    String monedaConvertir;
    double valorBaseMonedaConvertir;

    public BaseDeConversion(String monedaBase, String monedaConvertir, int valorBaseMonedaConvertir) {
        this.monedaBase = monedaBase;
        this.monedaConvertir = monedaConvertir;
        this.valorBaseMonedaConvertir = valorBaseMonedaConvertir;
    }

    public BaseDeConversion(BaseDeConversionExchangeRate baseConversion) {
        this.monedaBase = baseConversion.base_code();
        this.monedaConvertir = baseConversion.target_code();
        this.valorBaseMonedaConvertir = baseConversion.conversion_rate();
    }

    public String getMonedaBase() {
        return monedaBase;
    }

    public void setMonedaBase(String monedaBase) {
        this.monedaBase = monedaBase;
    }

    public String getMonedaConvertir() {
        return monedaConvertir;
    }

    public void setMonedaConvertir(String monedaConvertir) {
        this.monedaConvertir = monedaConvertir;
    }

    public double getValorBaseMonedaConvertir() {
        return valorBaseMonedaConvertir;
    }

    public void setValorBaseMonedaConvertir(int valorBaseMonedaConvertir) {
        this.valorBaseMonedaConvertir = valorBaseMonedaConvertir;
    }

    @Override
    public String toString() {
        return
                "(monedaBase='" + monedaBase +
                "', monedaConvertir='" + monedaConvertir +
                "', valorBaseMonedaConvertir='" + valorBaseMonedaConvertir +"'";
    }
}
