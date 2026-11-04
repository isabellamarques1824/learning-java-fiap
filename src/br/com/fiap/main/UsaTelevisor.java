package br.com.fiap.main;

import br.com.fiap.bean.Televisor;

public class UsaTelevisor {
    public static void main(String[] args) {
        Televisor tv = new Televisor();
        tv.canal = 3;
        tv.volume = 50;
        tv.aumentarVolume();
        tv.diminuirVolume();
        tv.trocarCanal(10);

        System.out.println("Canal:" + tv.canal);
        System.out.println("Volume: " + tv.volume);
    }
}
