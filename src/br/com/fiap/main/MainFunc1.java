package br.com.fiap.main;
import br.com.fiap.bean.Funcionario;
import br.com.fiap.bean.Garcom;
import br.com.fiap.bean.Gerente;

import java.time.LocalDate;
import java.util.Scanner;

public class MainFunc1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String continuar = "S";

        do {
            System.out.println("\n=== CALCULADORA DE SALARIOS ===");
            System.out.println("1 - Funcionario");
            System.out.println("2 - Garcom");
            System.out.println("3 - Gerente");
            System.out.print("Escolha uma opcao: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao < 1 || opcao > 3) {
                System.out.println("Opcao invalida!");
                continue;
            }

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Ano de nascimento: ");
            int ano = scanner.nextInt();

            System.out.print("Mes de nascimento: ");
            int mes = scanner.nextInt();

            System.out.print("Dia de nascimento: ");
            int dia = scanner.nextInt();

            LocalDate nascimento;

            try {
                nascimento = LocalDate.of(ano, mes, dia);
            } catch (java.time.DateTimeException e) {
                System.out.println("Data invalida!");
                continue;
            }

            System.out.print("Valor por hora: ");
            float valorHora = scanner.nextFloat();

            Funcionario funcionario;

            try {
                switch (opcao) {

                    case 1:
                        funcionario = new Funcionario(
                                nome, nascimento, valorHora);
                        break;

                    case 2:
                        System.out.print("Valor das gorjetas: ");
                        float gorjeta = scanner.nextFloat();

                        funcionario = new Garcom(
                                nome, nascimento, valorHora, gorjeta);
                        break;

                    case 3:
                        System.out.print("Bonus percentual: ");
                        float bonus = scanner.nextFloat();

                        funcionario = new Gerente(
                                nome, nascimento, valorHora, bonus);
                        break;

                    default:
                        throw new IllegalStateException("Opcao invalida");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }

            System.out.println("\n=== RESULTADO ===");
            System.out.println("Nome: " + funcionario.getNome());
            System.out.println("Nascimento: " + funcionario.getDataNascimento());
            System.out.println("Idade: " + funcionario.calcularIdade());
            System.out.printf("Salario: R$ %.2f%n",
                    funcionario.calcularSalario());

            System.out.print("\nDeseja continuar? (S/N): ");
            continuar = scanner.next();

        } while (continuar.equalsIgnoreCase("S"));

        System.out.println("Programa encerrado. Ate logo!");
        scanner.close();
    }
}
