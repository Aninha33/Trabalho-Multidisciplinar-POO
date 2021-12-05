package projetoV4poo;

public class CamposVaziosException extends Exception {
    
	public CamposVaziosException(){
		super("Campos Vazios");
	}
	
	public CamposVaziosException(String errorMessage, Throwable err){
		super(errorMessage, err);
	}

}
