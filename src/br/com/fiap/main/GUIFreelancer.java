package br.com.fiap.main;

import br.com.fiap.bean.Freelancer;

import javax.swing.*;
import java.awt.*;

public class GUIFreelancer extends JPanel {

    private JLabel lbNome, lbValorHora, lbCNPJ;
    private JTextField tfNome, tfValorHora, tfCNPJ;
    private JTextArea taResultados;
    private JButton btCalcularSalario;

    public GUIFreelancer() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setBackground(Color.ORANGE);

        lbNome = new JLabel("Nome:");
        lbValorHora = new JLabel("Valor da hora:");
        lbCNPJ = new JLabel("CNPJ:");

        tfNome = new JTextField();
        tfValorHora = new JTextField();
        tfCNPJ = new JTextField();

        btCalcularSalario = new JButton("Calcular Salário");
        taResultados = new JTextArea();
        taResultados.setEditable(false);

        lbNome.setBounds(30, 30, 120, 25);
        tfNome.setBounds(160, 30, 180, 25);

        lbValorHora.setBounds(30, 70, 120, 25);
        tfValorHora.setBounds(160, 70, 180, 25);

        lbCNPJ.setBounds(30, 110, 120, 25);
        tfCNPJ.setBounds(160, 110, 180, 25);

        btCalcularSalario.setBounds(30, 160, 160, 30);
        taResultados.setBounds(30, 210, 400, 80);

        add(lbNome);
        add(tfNome);
        add(lbValorHora);
        add(tfValorHora);
        add(lbCNPJ);
        add(tfCNPJ);
        add(btCalcularSalario);
        add(taResultados);
    }

    private void definirEventos() {
        btCalcularSalario.addActionListener(e -> {
            try {
                if (tfNome.getText().isBlank() ||
                        tfValorHora.getText().isBlank() ||
                        tfCNPJ.getText().isBlank()) {

                    throw new IllegalArgumentException(
                            "Preencha todos os campos!");
                }

                Freelancer funcionario = new Freelancer(
                        tfNome.getText(),
                        Float.parseFloat(tfValorHora.getText().replace(",", ".")),
                        Long.parseLong(tfCNPJ.getText())
                );

                taResultados.setText(
                        String.format("Nome: %s%nSalário: R$ %.2f",
                                funcionario.getNome(),
                                funcionario.calcularSalario())
                );

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(
                        this, ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}