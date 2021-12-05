package projetoV4poo;

import java.util.ArrayList;

public class Variaveis {

    private boolean modoGrande = false;//declara modo grande como falso inicialmente
    private boolean modoEscuro = false;//declara modo escuro como falso inicialmente
    private ArrayList<Pessoa> lista = new ArrayList<>();//cria uma lista de pessoas inicialmente 
      
    public void inserir(Filho filho){//inserir filho
        this.lista.add(filho);//adiciona filho na lista
    }//inserir
    
    public void inserir(Mae mae){//inserir mae
        this.lista.add(mae);//adiciona mae na lista
    }//inserir
    
    public void inserir(Pai pai){//inserir pai
        this.lista.add(pai);//adiciona pai na lista
    }//inserir
    
    public String exibirFilho(){
        return this.lista.get(lista.size()-3).toString();//exibir informacoes do filho armazenado na lista
    }//exibirFilho

    public String exibirMae(){
        return this.lista.get(lista.size()-2).toString();//exibir informacoes da mae armazenado na lista
    }//exibirMae

    public String exibirPai(){
        return this.lista.get(lista.size()-1).toString();//exibir informacoes do pai armazenado na lista
    }//exibirPai
    
    public boolean isModoGrande() {
        return modoGrande;
    }//isModoGrande

    public void setModoGrande(boolean modoGrande) {
        this.modoGrande = modoGrande;
    }//setModoGrande

    public boolean isModoEscuro() {
        return modoEscuro;
    }//isModoEscuro

    public void setModoEscuro(boolean modoEscuro) {
        this.modoEscuro = modoEscuro;
    }//setModoEscuro      
}//Variaveis
