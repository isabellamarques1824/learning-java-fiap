package br.com.fiap.bean;
import java.time.LocalDate;
import java.time.Period;

public class Funcionario {

    private String nome;
    private LocalDate dataNascimento;
    private float valorHoraTrabalho;

    // Construtor vazio
    public Funcionario() {
    }

    // Construtor com parâmetros
    public Funcionario(String nome, LocalDate dataNascimento, float valorHoraTrabalho) {
        this.nome = nome;
        setDataNascimento(dataNascimento);
        this.valorHoraTrabalho = valorHoraTrabalho;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        LocalDate dataMinima = LocalDate.of(1900, 1, 1);

        if (dataNascimento == null ||
                dataNascimento.isBefore(dataMinima) ||
                dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida!");
        }

        this.dataNascimento = dataNascimento;
    }

    public float getValorHoraTrabalho() {
        return valorHoraTrabalho;
    }

    public void setValorHoraTrabalho(float valorHoraTrabalho) {
        this.valorHoraTrabalho = valorHoraTrabalho;
    }

    // Métodos
    public int calcularIdade() {
        return Period.between(dataNascimento, LocalDate.now()).getYears();
    }

    public float calcularSalario() {
        return (valorHoraTrabalho * 40) * 4;
    }
}