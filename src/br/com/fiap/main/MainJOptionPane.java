package br.com.fiap.main;

import br.com.fiap.bean.FolhaDePagamento;

import javax.swing.*;

public class MainJOptionPane {
    public static void main(String[] args) {
        FolhaDePagamento folha = new FolhaDePagamento();
        double salarioBruto, descontoINSS, valorPlanoDeSaude;
        int numeroDependentes;
        String auxiliar, mensagem;
        try {
            auxiliar = JOptionPane.showInputDialog("Digite o salario bruto: ");
            salarioBruto = Double.parseDouble(auxiliar);

            auxiliar = JOptionPane.showInputDialog("Digite o numero de dependentes: ");
            numeroDependentes = Integer.parseInt(auxiliar);

            auxiliar = JOptionPane.showInputDialog("Digite o desconto INSS: ");
            descontoINSS = Double.parseDouble(auxiliar);

            auxiliar = JOptionPane.showInputDialog("Digite o valor do plano: ");
            valorPlanoDeSaude = Double.parseDouble(auxiliar);

            folha.salarioBruto = salarioBruto;
            folha.numeroDeDependentes = numeroDependentes;
            folha.descontoINSS = descontoINSS;
            folha.valorPlanoDeSaude = valorPlanoDeSaude;

            mensagem = String.format("Salario bruto: %.2f\n Dependentes: %d\nINSS: %.1f\nPlano: %.2f\nSalario: %.2f\n", folha.salarioBruto, folha.numeroDeDependentes, folha.descontoINSS, folha.valorPlanoDeSaude, folha.calcularSalarioLiquido());
            JOptionPane.showMessageDialog(null, mensagem);
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Formato incorreto");
        }
    }
}
