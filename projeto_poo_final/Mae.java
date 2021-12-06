package projetoV4poo;

public class Mae extends Pessoa{
    
    private String numeroCadastroM;//variavel de instancia

    public String getNumeroCadastroM() {
        return numeroCadastroM;
    }//getNumeroCadastroM

    public void setNumeroCadastroM(String numeroCadastroM) {
        this.numeroCadastroM = numeroCadastroM;
    }//setNumeroCadastroM

    @Override
    public String toString() {
        return super.toString() + "     |     " + numeroCadastroM;
    }//toString
    
}//Mae
