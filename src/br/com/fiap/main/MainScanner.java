package br.com.fiap.main;

import br.com.fiap.bean.FolhaDePagamento;

import java.util.Scanner;

public class MainScanner {
    public static void main(String[] args) {
        FolhaDePagamento folha = new FolhaDePagamento();
        double salarioBruto, descontoINSS, valorPlanoDeSaude;
        int numeroDependentes;
        Scanner scan;
        try {
            scan = new Scanner(System.in);

            System.out.println("Digite o seu salario bruto: ");
            salarioBruto = scan.nextDouble();
            System.out.println("Digite o numero de dependentes: ");
            numeroDependentes = scan.nextInt();
            System.out.println("Digite o desconto INSS: ");
            descontoINSS = scan.nextDouble();
            System.out.println("Digite o valor do plano de saúde: ");
            valorPlanoDeSaude = scan.nextDouble();

            folha.salarioBruto = salarioBruto;
            folha.numeroDeDependentes = numeroDependentes;
            folha.descontoINSS = descontoINSS;
            folha.valorPlanoDeSaude = valorPlanoDeSaude;

        }catch (Exception e){
            System.out.println("Erro de formato");
        }

    }


}
