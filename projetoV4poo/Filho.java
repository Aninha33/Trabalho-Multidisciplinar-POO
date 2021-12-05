package projetoV4poo;

public class Filho extends Pessoa {
    
    private String cpf;//variavel de instancia

    public String getCpf() {
        return cpf;
    }//getCpf

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }//setCpf

    @Override
    public String toString() {
        return super.toString() + "     |     " + cpf ;
    }//toString
    
}//Filho
