package br.com.fiap.main;

import br.com.fiap.bean.ArCondicionado;

public class UsaArCondicionado {
    public static void main(String[] args) {
        ArCondicionado ar = new ArCondicionado();
        ar.temperatura = 25;
        ar.modo = "Ventilação";

        ar.diminuirTemperatura();
        ar.modo = "Refriação";

        System.out.println("Temperatura: " + ar.temperatura);
        System.out.println("Modo: " + ar.modo);
    }
}
