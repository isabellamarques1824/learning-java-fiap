package br.com.fiap.main;

import br.com.fiap.bean.Funcionario;
import br.com.fiap.bean.VigiaNoturno;
import br.com.fiap.bean.Vendedor;
import br.com.fiap.bean.Freelancer;

import javax.swing.JOptionPane;

public class MainPagamento {

    public static void main(String[] args) {

        int continuar;

        do {
            try {
                String menu = """
                        === SISTEMA DE PAGAMENTO ===

                        1 - Vigia Noturno
                        2 - Vendedor
                        3 - Freelancer

                        Escolha uma opção:
                        """;

                String entrada = JOptionPane.showInputDialog(
                        null,
                        menu,
                        "Sistema de Pagamento",
                        JOptionPane.QUESTION_MESSAGE
                );

                if (entrada == null) {
                    break;
                }

                int opcao = Integer.parseInt(entrada);

                if (opcao < 1 || opcao > 3) {
                    throw new IllegalArgumentException("Opção inválida!");
                }

                String nome = JOptionPane.showInputDialog(
                        null,
                        "Digite o nome do funcionário:"
                );

                if (nome == null) {
                    break;
                }

                String valor = JOptionPane.showInputDialog(
                        null,
                        "Digite o valor da hora trabalhada:"
                );

                if (valor == null) {
                    break;
                }

                float valorHora = Float.parseFloat(
                        valor.replace(",", ".")
                );

                Funcionario funcionario;

                switch (opcao) {

                    case 1:
                        String entradaAdicional = JOptionPane.showInputDialog(
                                null,
                                "Digite o adicional noturno:"
                        );

                        if (entradaAdicional == null) {
                            return;
                        }

                        float adicional = Float.parseFloat(
                                entradaAdicional.replace(",", ".")
                        );

                        funcionario = new VigiaNoturno(
                                nome,
                                valorHora,
                                adicional
                        );
                        break;

                    case 2:
                        String entradaComissao = JOptionPane.showInputDialog(
                                null,
                                "Digite a comissão (%):"
                        );

                        if (entradaComissao == null) {
                            return;
                        }

                        float comissao = Float.parseFloat(
                                entradaComissao.replace(",", ".")
                        );

                        funcionario = new Vendedor(
                                nome,
                                valorHora,
                                comissao
                        );
                        break;

                    case 3:
                        String entradaCnpj = JOptionPane.showInputDialog(
                                null,
                                "Digite o CNPJ (somente números):"
                        );

                        if (entradaCnpj == null) {
                            return;
                        }

                        long cnpj = Long.parseLong(entradaCnpj);

                        funcionario = new Freelancer(
                                nome,
                                valorHora,
                                cnpj
                        );
                        break;

                    default:
                        throw new IllegalArgumentException("Opção inválida!");
                }

                JOptionPane.showMessageDialog(
                        null,
                        String.format(
                                "Funcionário: %s%nSalário: R$ %.2f",
                                nome,
                                funcionario.calcularSalario()
                        ),
                        "Resultado do Pagamento",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (IllegalArgumentException e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Erro: " + e.getMessage(),
                        "Dados inválidos",
                        JOptionPane.ERROR_MESSAGE
                );
            }

            continuar = JOptionPane.showConfirmDialog(
                    null,
                    "Deseja calcular outro salário?",
                    "Continuar",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE
            );

        } while (continuar == JOptionPane.YES_OPTION);

        JOptionPane.showMessageDialog(
                null,
                "Obrigado por utilizar o sistema!\nAté logo!",
                "Encerrando",
                JOptionPane.WARNING_MESSAGE
        );
    }
}