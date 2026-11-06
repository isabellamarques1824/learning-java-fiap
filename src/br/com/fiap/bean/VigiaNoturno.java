package br.com.fiap.bean;

public class VigiaNoturno implements Funcionario{
    private String nome;
    private float valorHoraTrabalho;
    private float adicionalNoturno;

    public VigiaNoturno(){

    }

    public VigiaNoturno(String nome, float valorHoraTrabalho, float adicionalNoturno){
        this.nome = nome;
        this.valorHoraTrabalho = valorHoraTrabalho;
        this.adicionalNoturno = adicionalNoturno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getAdicionalNoturno() {
        return adicionalNoturno;
    }

    public void setAdicionalNoturno(float adicionalNoturno) {
        this.adicionalNoturno = adicionalNoturno;
    }

    public float getValorHoraTrabalho() {
        return valorHoraTrabalho;
    }

    public void setValorHoraTrabalho(float valorHoraTrabalho) {
        this.valorHoraTrabalho = valorHoraTrabalho;
    }

    @Override
    public float calcularSalario(){
        return ((valorHoraTrabalho * 40) * 4 + adicionalNoturno);
    }
}
