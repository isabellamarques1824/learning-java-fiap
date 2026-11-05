package br.com.fiap.main;

import br.com.fiap.bean.Televisor;

import java.util.Scanner;

public class UsaTelevisor {
    public static void main(String[] args) {
        Scanner scan;
        Televisor tv = new Televisor();
        int escolha = 0;

        try {
            scan = new Scanner(System.in);
            System.out.println("Escolha um canal: ");
            tv.setCanal(scan.nextInt());

            System.out.println("Escolha um volume: ");
            tv.setVolume(scan.nextInt());

            System.out.println("Escolha:\n(1)Definir canal\n(2)Definir volume\n(3)Aumentar volume\n(4)Diminuir volume");
            escolha = scan.nextInt();

            if(escolha == 1){
                System.out.println("Escolha o canal: ");
                tv.setCanal(scan.nextInt());
            } else if (escolha == 2) {
                System.out.println("Escolha o volume: ");
                tv.setVolume(scan.nextInt());
            } else if (escolha == 3) {
                System.out.println("AUmentado.");
                tv.aumentarVolume();
            } else if (escolha == 4) {
                System.out.println("diminuindo..");
                tv.diminuirVolume();
            }else {
                System.out.println("Valor invalido");
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
