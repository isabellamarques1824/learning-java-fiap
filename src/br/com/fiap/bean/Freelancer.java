package br.com.fiap.bean;

public class Freelancer implements Funcionario {
    private String nome;
    private float valorHoraTrabalho;
    private long CNPJ;

    public Freelancer(){

    }

    public Freelancer(String nome, float valorHoraTrabalho, long CNPJ){
        this.nome = nome;
        this.valorHoraTrabalho = valorHoraTrabalho;
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorHoraTrabalho() {
        return valorHoraTrabalho;
    }

    public void setValorHoraTrabalho(float valorHoraTrabalho) {
        this.valorHoraTrabalho = valorHoraTrabalho;
    }

    public long getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(long CNPJ) {
        this.CNPJ = CNPJ;
    }

    @Override
    public float calcularSalario(){
        return ((valorHoraTrabalho * 40) * 4) *
                1.5f;
    }
}
