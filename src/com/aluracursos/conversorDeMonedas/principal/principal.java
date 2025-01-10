package com.aluracursos.conversorDeMonedas.principal;

import com.aluracursos.conversorDeMonedas.modelos.BaseDeConversion;
import com.aluracursos.conversorDeMonedas.modelos.BaseDeConversionExchangeRate;
import com.aluracursos.conversorDeMonedas.modelos.CalcularConversion;
import com.aluracursos.conversorDeMonedas.modelos.ConsultarCambio;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class principal {
    public static void main(String[] args) {

        List<List<String>> listaTipoDeMonedas = new LinkedList<>();

        listaTipoDeMonedas.add(new LinkedList<>(List.of("USD","ARS")));
        listaTipoDeMonedas.add(new LinkedList<>(List.of("ARS","USD")));
        listaTipoDeMonedas.add(new LinkedList<>(List.of("USD","BRL")));
        listaTipoDeMonedas.add(new LinkedList<>(List.of("BRL","USD")));
        listaTipoDeMonedas.add(new LinkedList<>(List.of("USD","COP")));
        listaTipoDeMonedas.add(new LinkedList<>(List.of("COP","USD")));


        while(true){

            System.out.println("Sea bienvenido/a al conversor de Moneda");
            System.out.println(
                    "***********************************************************"+ "\n" +
                            "1) Dólar => Peso Argentino" + "\n" +
                            "2) Peso Argentino => Dólar" + "\n" +
                            "3) Dólar => Real Brasileño"+ "\n"+
                            "4) Real Brasileño => Dólar" + "\n"+
                            "5) Dólar => Peso Colombianp" + "\n"+
                            "6) Peso Colombiano => Dólar" + "\n"+
                            "7) Salir" + "\n"+
                            "Elija una opción válida:" + "\n"+
                            "***********************************************************"
            );

            Scanner input = new Scanner(System.in);
            var opcion= input.nextLine();
            int opcionElegida = Integer.valueOf(opcion) - 1;

            if(opcionElegida == 7 ){
                System.out.println("Finalizó el programa");
                break;
            } else if (opcionElegida >= 7 || opcionElegida < 0) {
                System.out.println("Esta opcion no esta disponible");
                break;
            }


            try{

                ConsultarCambio consultarApi = new ConsultarCambio();
                BaseDeConversionExchangeRate conversionExchangeRate = consultarApi.consultarCambioApi(listaTipoDeMonedas.get(opcionElegida));
                BaseDeConversion conversion = new BaseDeConversion(conversionExchangeRate);

                System.out.println("Ingresa el valor que desea convertir");
                double valorIngresado = input.nextDouble();

                CalcularConversion calcularTotal = new CalcularConversion();
                double conversionMontoTotal = calcularTotal.calcular(conversion, valorIngresado);

                System.out.println(
                        "El valor" + valorIngresado + "[" +conversion.getMonedaBase() + "] correspondeal valor de => " + conversionMontoTotal + "["+ conversion.getMonedaConvertir()+"]"
                );


            }catch (NumberFormatException e){
                System.out.println("Numero no encontrado" + e.getMessage());
            } catch (Exception e){
                System.out.println("Hay un error");
            }
        }







    }
}
