package projetoV4poo;

public class Pai extends Pessoa {
    
    private String numeroCadastroP;

    public String getNumeroCadastroP() {
        return numeroCadastroP;
    }//getNumeroCadastroP

    public void setNumeroCadastroP(String numeroCadastroP) {
        this.numeroCadastroP = numeroCadastroP;
    }//setNumeroCadastroP
    
    @Override
    public String toString() {
        return super.toString() + "     |     " + numeroCadastroP;
    }//toString
    
}//Pai
