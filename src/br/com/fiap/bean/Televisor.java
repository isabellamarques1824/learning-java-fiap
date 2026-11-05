package br.com.fiap.bean;

public class Televisor {
    private int volume;
    private int canal;

    public int getVolume(){
        return volume;
    }

    public void setVolume(int volume){
        try{
            if(volume >= 0 && volume <= 20){
                this.volume = volume;
            }else{
                throw new Exception("Volume invalido");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getCanal(){
        return canal;
    }

    public void setCanal(int novoCanal){
        try {
            if(novoCanal == 2 || novoCanal == 4 || novoCanal == 5 || novoCanal == 7 || novoCanal == 13){
                this.canal = novoCanal;
            }else{
                throw  new Exception("canal incorreto");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void aumentarVolume(){
        volume++;
    }
    public void diminuirVolume(){
        volume--;
    }
    public void trocarCanal(int novoCanal){
        canal = novoCanal;
    }
}
