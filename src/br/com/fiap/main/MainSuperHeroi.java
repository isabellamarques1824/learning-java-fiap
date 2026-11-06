package br.com.fiap.main;

import br.com.fiap.bean.SuperHeroi;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class MainSuperHeroi {

    public static void main(String[] args) {

        int continuar;

        do {
            try {
                // Dados do super-herói
                String nome = JOptionPane.showInputDialog(
                        "Digite o nome do super-herói:");

                if (nome == null) break;

                String idSecreta = JOptionPane.showInputDialog(
                        "Digite a identidade secreta:");

                if (idSecreta == null) break;

                // Listas de poderes e fraquezas
                ArrayList<String> poderes = new ArrayList<>();
                ArrayList<String> fraquezas = new ArrayList<>();

                // Cadastro dos poderes
                while (true) {

                    String poder = JOptionPane.showInputDialog(
                            "Digite um poder (ou 'fim' para encerrar):");

                    if (poder == null || poder.equalsIgnoreCase("fim")) {
                        break;
                    }

                    if (!poder.isBlank()) {
                        poderes.add(poder);
                    }
                }

                // Cadastro das fraquezas
                while (true) {

                    String fraqueza = JOptionPane.showInputDialog(
                            "Digite uma fraqueza (ou 'fim' para encerrar):");

                    if (fraqueza == null || fraqueza.equalsIgnoreCase("fim")) {
                        break;
                    }

                    if (!fraqueza.isBlank()) {
                        fraquezas.add(fraqueza);
                    }
                }

                // Criando o objeto SuperHeroi
                SuperHeroi heroi = new SuperHeroi(
                        nome,
                        idSecreta,
                        poderes,
                        fraquezas
                );

                // Exibindo as informações
                heroi.listarHeroi();

            } catch (Exception e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Erro: " + e.getMessage(),
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            // Pergunta se deseja continuar
            continuar = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja cadastrar outro super-herói?",
                    "Continuar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

        } while (continuar == JOptionPane.YES_OPTION);

        // Mensagem de despedida
        JOptionPane.showMessageDialog(
                null,
                "Programa encerrado! Até logo!",
                "Encerrando",
                JOptionPane.WARNING_MESSAGE
        );
    }
}