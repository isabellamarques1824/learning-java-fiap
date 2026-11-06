package br.com.fiap.main;

import br.com.fiap.bean.VigiaNoturno;

import javax.swing.*;
import java.awt.*;

public class GUIVigiaNoturno extends JPanel {

    private JLabel lbNome, lbValorHora, lbAdicional;
    private JTextField tfNome, tfValorHora, tfAdicional;
    private JTextArea taResultados;
    private JButton btCalcularSalario;

    public GUIVigiaNoturno() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setLayout(null);
        setBackground(Color.GREEN);

        lbNome = new JLabel("Nome:");
        lbValorHora = new JLabel("Valor da hora:");
        lbAdicional = new JLabel("Adicional noturno:");

        tfNome = new JTextField();
        tfValorHora = new JTextField();
        tfAdicional = new JTextField();

        btCalcularSalario = new JButton("Calcular Salário");
        taResultados = new JTextArea();
        taResultados.setEditable(false);

        lbNome.setBounds(30, 30, 130, 25);
        tfNome.setBounds(170, 30, 180, 25);

        lbValorHora.setBounds(30, 70, 130, 25);
        tfValorHora.setBounds(170, 70, 180, 25);

        lbAdicional.setBounds(30, 110, 130, 25);
        tfAdicional.setBounds(170, 110, 180, 25);

        btCalcularSalario.setBounds(30, 160, 160, 30);
        taResultados.setBounds(30, 210, 400, 80);

        add(lbNome);
        add(tfNome);
        add(lbValorHora);
        add(tfValorHora);
        add(lbAdicional);
        add(tfAdicional);
        add(btCalcularSalario);
        add(taResultados);
    }

    private void definirEventos() {
        btCalcularSalario.addActionListener(e -> {
            try {
                if (tfNome.getText().isBlank() ||
                        tfValorHora.getText().isBlank() ||
                        tfAdicional.getText().isBlank()) {

                    throw new IllegalArgumentException(
                            "Preencha todos os campos!");
                }

                VigiaNoturno funcionario = new VigiaNoturno(
                        tfNome.getText(),
                        Float.parseFloat(tfValorHora.getText().replace(",", ".")),
                        Float.parseFloat(tfAdicional.getText().replace(",", "."))
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