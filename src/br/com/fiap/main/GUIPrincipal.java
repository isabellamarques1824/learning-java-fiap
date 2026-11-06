package br.com.fiap.main;

import javax.swing.*;

public class GUIPrincipal extends JFrame {

    private JMenuBar mnBarra;
    private JMenu mnArquivo, mnFuncionario;
    private JMenuItem miSair, miFreelancer, miVendedor, miVigiaNoturno;

    public GUIPrincipal() {
        inicializarComponentes();
        definirEventos();
    }

    private void inicializarComponentes() {
        setTitle("Sistema de Pagamento");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mnBarra = new JMenuBar();

        mnArquivo = new JMenu("Arquivo");
        mnFuncionario = new JMenu("Funcionário");

        miSair = new JMenuItem("Sair");
        miFreelancer = new JMenuItem("Freelancer");
        miVendedor = new JMenuItem("Vendedor");
        miVigiaNoturno = new JMenuItem("Vigia Noturno");

        mnArquivo.add(miSair);

        mnFuncionario.add(miFreelancer);
        mnFuncionario.add(miVendedor);
        mnFuncionario.add(miVigiaNoturno);

        mnBarra.add(mnArquivo);
        mnBarra.add(mnFuncionario);

        setJMenuBar(mnBarra);
    }

    private void definirEventos() {
        miSair.addActionListener(e -> System.exit(0));

        miFreelancer.addActionListener(e ->
                setContentPane(new GUIFreelancer()));

        miVendedor.addActionListener(e ->
                setContentPane(new GUIVendedor()));

        miVigiaNoturno.addActionListener(e ->
                setContentPane(new GUIVigiaNoturno()));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GUIPrincipal janela = new GUIPrincipal();
            janela.setVisible(true);
        });
    }
}