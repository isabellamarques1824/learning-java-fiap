package br.com.fiap.bean;

public class Vendedor implements Funcionario{
    private String nome;
    private float valorHoraTrabalho;
    private float comissao;

    public Vendedor(){

    }

    public Vendedor(String nome, float valorHoraTrabalho, float comissao){
        this.nome = nome;
        this.valorHoraTrabalho = valorHoraTrabalho;
        this.comissao = comissao;
    }

    public float getValorHoraTrabalho() {
        return valorHoraTrabalho;
    }

    public String getNome() {
        return nome;
    }

    public float getComissao() {
        return comissao;
    }

    public void setValorHoraTrabalho(float valorHoraTrabalho) {
        this.valorHoraTrabalho = valorHoraTrabalho;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setComissao(float comissao) {
        this.comissao = comissao;
    }

    @Override
    public float calcularSalario(){
        return (((valorHoraTrabalho * 40) * 4) *
                (1 + comissao/100));
    }
}
