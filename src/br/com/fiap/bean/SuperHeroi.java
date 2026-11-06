package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;

public class SuperHeroi {

    private String nome;
    private String idSecreta;
    private ArrayList<String> poderes;
    private ArrayList<String> fraquezas;

    // Construtor vazio
    public SuperHeroi() {
    }

    // Construtor com parâmetros
    public SuperHeroi(String nome, String idSecreta,
                      ArrayList<String> poderes,
                      ArrayList<String> fraquezas) {

        this.nome = nome;
        this.idSecreta = idSecreta;
        this.poderes = poderes;
        this.fraquezas = fraquezas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdSecreta() {
        return idSecreta;
    }

    public void setIdSecreta(String idSecreta) {
        this.idSecreta = idSecreta;
    }

    public ArrayList<String> getPoderes() {
        return poderes;
    }

    public void setPoderes(ArrayList<String> poderes) {
        this.poderes = poderes;
    }

    public ArrayList<String> getFraquezas() {
        return fraquezas;
    }

    public void setFraquezas(ArrayList<String> fraquezas) {
        this.fraquezas = fraquezas;
    }

    public void listarHeroi() {

        Collections.sort(poderes);
        Collections.sort(fraquezas);

        String mensagem = "Nome: " + nome;
        mensagem += "\nIdentidade secreta: " + idSecreta;

        mensagem += "\n\nPoderes:";
        for (String poder : poderes) {
            mensagem += "\n- " + poder;
        }

        mensagem += "\n\nFraquezas:";
        for (String fraqueza : fraquezas) {
            mensagem += "\n- " + fraqueza;
        }

        JOptionPane.showMessageDialog(
                null,
                mensagem,
                "Informações do Super-Herói",
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}