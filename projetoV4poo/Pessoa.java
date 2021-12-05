package projetoV4poo;

public class Pessoa {
    
    private String nome;//variavel de instancia

    public String getNome() {
        return nome;
    }//getNmoe

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString(){
      return getNome();  
    }//toString
    
}//Pessoa
