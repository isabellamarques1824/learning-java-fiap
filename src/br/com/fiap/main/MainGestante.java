package br.com.fiap.main;

import br.com.fiap.bean.Gestante;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MainGestante {

    public static void main(String[] args) {

        Gestante gravida1;

        String nome, data1, dataBrasil;

        LocalDate dataDaGestacao;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try{

            nome = JOptionPane.showInputDialog("Digite seu nome");
            data1 = JOptionPane.showInputDialog("Digite inicio da gestacao (dd/MM/yyyy)");

            dataDaGestacao = LocalDate.parse(data1, dtf);
            gravida1 = new Gestante(nome, dataDaGestacao);
            JOptionPane.showMessageDialog(null, gravida1.getDataDaGestacao());

            dataBrasil = gravida1.getDataDaGestacao().format (dtf);
            JOptionPane.showMessageDialog(null, String.format ("Exibindo informacoes\nNome: Ns \nData da gestacao: %s \nTempo de gestacao: %d mès(es)", gravida1.getNome(), dataBrasil, gravida1 .tempoDeGestacao()));

    } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}