package projetoV4poo;

import static java.lang.Math.round;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class ExibeCadastro extends javax.swing.JFrame {
	
	//-----variaveis de instancia------------------
    private Variaveis var = new Variaveis();     
    private javax.swing.JButton jbMCor;
    private javax.swing.JButton jbMTam;
    private javax.swing.JButton jbNewCadastro;
    private javax.swing.JButton jbSair;
    private javax.swing.JLabel jlNmae;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlNpai;
    private javax.swing.JLabel jlsNmae;
    private javax.swing.JLabel jlsNome;
    private javax.swing.JLabel jlsNpai;
    private int controlecor = 0, controletam = 0;
    //--------------definir tamanho da janela--------------------------
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) round(screenSize.getWidth() * 0.7);
    int height = (int) round(screenSize.getHeight() * 0.7);
    //-----------------------------------------------------------------
    
    public ExibeCadastro(Variaveis var) {
        
        this.var = var;//recebe o valor do parametro
        initComponents();//inicia os componentes  
        setVisible(true);//deixa visivel
   
        if (this.var.isModoEscuro()) {//se estiver em modo escuro
            this.modoTelaEscura();//chama metodo do modo escuro
            this.controlecor = 1;//modo escuro ligado (1)
        }else{//se nao
            this.modoTelaClara();//chama funcao do modo claro
            this.controlecor = 0;//modo escuro desligado (0)
        }//end else
        
        if (this.var.isModoGrande()) {//se estiver em modo grande
            this.modoTamanhoGrande();//chama metodo do modo grande
            this.controletam = 1;//modo grande ligado
        }else{//se nao
            this.modoTamanhoPadrao();//chama funcao do modo padrao
            this.controletam = 0;//modo grande desligado
        }//end else
    }//contrutor
                        
    private void initComponents() {
    	
    	//--instancia os botoes e "etiquetas"-----
        jbMTam = new javax.swing.JButton();
        jbMCor = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jbNewCadastro = new javax.swing.JButton();
        jlNome = new javax.swing.JLabel();
        jlsNome = new javax.swing.JLabel();
        jlNmae = new javax.swing.JLabel();
        jlsNmae = new javax.swing.JLabel();
        jlNpai = new javax.swing.JLabel();
        jlsNpai = new javax.swing.JLabel();
        //----------------------------------------
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//encerra o programa ao sair
        setTitle("Sistema CNISS - Dados Cadastrados");
        setSize(width, height);//define tamanho da tela
        setLocationRelativeTo(null);
        
        jlNome.setText("Nome e Cpf:");      
        jlsNome.setText(this.var.exibirFilho());//exibe as informacoes sobre o filho guardadas na lista de cadastro

        jlNmae.setText("Nome da Mãe e Nº de Cadastro da Mãe:");
        jlsNmae.setText(this.var.exibirMae());//exibe as informacoes sobre a mae guardadas na lista de cadastro

        jlNpai.setText("Nome do Pai e Nº de Cadastro do Pai:");
        jlsNpai.setText(this.var.exibirPai());//exibe as informacoes sobre o pai guardadas na lista de cadastro

        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {//adiciona ao botao uma funcao
            public void actionPerformed(java.awt.event.ActionEvent evt) {//ao apertar
                jbSairActionPerformed(evt);//chama o metodo de sair
            }
        });
        
        jbNewCadastro.setText("Novo Cadastro");
        jbNewCadastro.addActionListener(new java.awt.event.ActionListener() {//adiciona ao botao uma funcao
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNewCadastroActionPerformed(evt);//chama metodo de criar novo cadastro
            }
        });
        
        jbMTam.setText("Modo Grande");
        jbMTam.addActionListener(new java.awt.event.ActionListener() {//adiciona ao botao uma funcao
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMTamActionPerformed(evt);//chama metodo de mudar de tamanho
            }
        });

        jbMCor.setText("Modo Escuro");
        jbMCor.addActionListener(new java.awt.event.ActionListener() {//adiciona ao botao uma funcao
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMCorActionPerformed(evt);//chama metodo de mudar de cor
            }
        });
        
        getContentPane().add(jlNome);
        getContentPane().add(jlNmae);
        getContentPane().add(jlNpai);
        getContentPane().add(jlsNpai);
        getContentPane().add(jlsNome);
        getContentPane().add(jlsNmae);   
        getContentPane().add(jbMTam);
        getContentPane().add(jbMCor);
        getContentPane().add(jbSair);
        getContentPane().add(jbNewCadastro);
    }//initComponents                                                            

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//metodo de sair                                     
       
    	dispose();//libera janela atual
    }//jbSairActionPerformed                                      

    private void jbNewCadastroActionPerformed(java.awt.event.ActionEvent evt) {//metodo de novo cadastro                                              
       
    	new TelaCadastro(this.var);//cria nova tela cadastro
        dispose();//libera janela atual
    }//jbNewCadastroActionPerformed                                             

    private void jbMTamActionPerformed(java.awt.event.ActionEvent evt) {//metodo de mudar tamanho                                       
        
    	if (this.controletam == 0) {//se tamanho padrao
           
        	jbMTam.setText("Modo Padrão");
            this.modoTamanhoGrande();//chama modo grande
            this.controletam = 1;//modo grande ligado

        } else if (this.controletam == 1) {//se tamanho grande
            
        	jbMTam.setText("Modo Grande");
            this.modoTamanhoPadrao();//chama modo padrao
            this.controletam = 0;//modo grande desligado
        }//end else
    }//jbMTamActionPerformed                                      

    private void jbMCorActionPerformed(java.awt.event.ActionEvent evt) {//metodo de mudar cor                                       
       
    	if (this.controlecor == 0) {//se cor clara
            
        	jbMCor.setText("Claro");
            this.modoTelaEscura();//chama tela escura
            this.controlecor = 1;//tela escura ligada

        } else if (this.controlecor == 1) {//se cor escura
            
        	jbMCor.setText("Escuro");
            this.modoTelaClara();//chama tela clara
            this.controlecor = 0;//tela clara ligada
        }//end else
    }//jbMCorActionPerformed
    
    public void modoTamanhoPadrao(){//metodo modo padrao
    	
        this.var.setModoGrande(false);//modo grande desligado
        //--------------------------------redimensiona botoes e etiquetas---------------------------------------------------------------------
        jlNome.setBounds((int) round(0.35 * width), (int) round(0.1 * height), (int) round(0.4 * width), (int) round(0.06 * height));
        jlsNome.setBounds((int) round(0.35 * width), (int) round(0.16 * height), (int) round(0.4 * width), (int) round(0.06 * height));
        jlNmae.setBounds((int) round(0.35 * width), (int) round(0.25 * height), (int) round(0.4 * width), (int) round(0.06 * height));
        jlsNmae.setBounds((int) round(0.35 * width), (int) round(0.31 * height), (int) round(0.4 * width), (int) round(0.06 * height));
        jlNpai.setBounds((int) round(0.35 * width), (int) round(0.4 * height), (int) round(0.4 * width), (int) round(0.06 * height));
        jlsNpai.setBounds((int) round(0.35 * width), (int) round(0.46 * height), (int) round(0.4 * width), (int) round(0.06 * height));    
        jbNewCadastro.setBounds((int) round(0.50 * width), (int) round(0.68 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        jbSair.setBounds((int) round(0.34 * width), (int) round(0.68 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        jbMTam.setBounds((int) round(0.34 * width), (int) round(0.77 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        jbMCor.setBounds((int) round(0.50 * width), (int) round(0.77 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        //-------------------------------redimensiona tamanho das fontes---------------------------------
        jlNome.setFont(new Font(jlNome.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jlsNome.setFont(new Font(jlsNome.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jlsNome.setFont(new Font(jlsNome.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jlNmae.setFont(new Font(jlNmae.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jlsNmae.setFont(new Font(jlsNmae.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jlNpai.setFont(new Font(jlNpai.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jlsNpai.setFont(new Font(jlsNpai.getName(), Font.PLAIN, (int) round(width * 0.015))); 
        jbSair.setFont(new Font(jbSair.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jbNewCadastro.setFont(new Font(jbNewCadastro.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jbMTam.setFont(new Font(jbMTam.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jbMCor.setFont(new Font(jbMCor.getName(), Font.PLAIN, (int) round(width * 0.015)));
        //-----------------------------------------------------------------------------------------------
    }//modoTamanhoPadrao
    
    public void modoTamanhoGrande(){//metodo modo grande
    	
        this.var.setModoGrande(true);//modo grande ligado
        //--------------------------------redimensiona botoes e etiquetas---------------------------------------------------------------------
        jlNome.setBounds((int) round(0.3 * width), (int) round(0.01 * height), (int) round(0.55 * width), (int) round(0.1 * height));
        jlsNome.setBounds((int) round(0.3 * width), (int) round(0.11 * height), (int) round(0.55 * width), (int) round(0.1 * height));
        jlNmae.setBounds((int) round(0.3 * width), (int) round(0.22 * height), (int) round(0.55 * width), (int) round(0.1 * height));
        jlsNmae.setBounds((int) round(0.3 * width), (int) round(0.32 * height), (int) round(0.55 * width), (int) round(0.1 * height));
        jlNpai.setBounds((int) round(0.3 * width), (int) round(0.42 * height), (int) round(0.55 * width), (int) round(0.1 * height));
        jlsNpai.setBounds((int) round(0.3 * width), (int) round(0.52 * height), (int) round(0.55 * width), (int) round(0.1 * height));
        jbNewCadastro.setBounds((int) round(0.5 * width), (int) round(0.65 * height), (int) round(0.17 * width), (int) round(0.1 * height));
        jbSair.setBounds((int) round(0.3 * width), (int) round(0.65 * height), (int) round(0.17 * width), (int) round(0.1 * height));
        jbMTam.setBounds((int) round(0.3 * width), (int) round(0.8 * height), (int) round(0.17 * width), (int) round(0.1 * height));
        jbMCor.setBounds((int) round(0.5 * width), (int) round(0.8 * height), (int) round(0.17 * width), (int) round(0.1 * height));
        //-------------------------------redimensiona tamanho das fontes---------------------------------
        jlNome.setFont(new Font(jlNome.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jlsNome.setFont(new Font(jlsNome.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jlNmae.setFont(new Font(jlNmae.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jlsNmae.setFont(new Font(jlsNmae.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jlNpai.setFont(new Font(jlNpai.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jlsNpai.setFont(new Font(jlsNpai.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbNewCadastro.setFont(new Font(jbNewCadastro.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbSair.setFont(new Font(jbSair.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbMTam.setFont(new Font(jbMTam.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbMCor.setFont(new Font(jbMCor.getName(), Font.PLAIN, (int) round(width * 0.02)));
        //-----------------------------------------------------------------------------------------------
    }//modoTamanhoGrande
    
    public void modoTelaEscura() {//metodo modo escuro
    	
    	this.var.setModoEscuro(true);//modo escuro ligado
    	//--------muda a cor do fundo e das etiquetas---------
    	getContentPane().setBackground(new Color(50, 50, 50));
        jlNome.setForeground(new Color(255, 255, 255));
        jlsNome.setForeground(new Color(255, 255, 255));
        jlsNome.setForeground(new Color(255, 255, 255));
        jlNmae.setForeground(new Color(255, 255, 255));
        jlsNmae.setForeground(new Color(255, 255, 255));
        jlNpai.setForeground(new Color(255, 255, 255));
        jlsNpai.setForeground(new Color(255, 255, 255));
        //----------------------------------------------------
    }//modoTelaEscura

    public void modoTelaClara() {//metodo modo claro
    	
    	this.var.setModoEscuro(false);//modo escuro desligado
    	//--------muda a cor do fundo e das etiquetas------------
        getContentPane().setBackground(new Color(240, 240, 240));
        jlNome.setForeground(Color.black);
        jlsNome.setForeground(Color.black);
        jlsNome.setForeground(Color.black);
        jlNmae.setForeground(Color.black);
        jlsNmae.setForeground(Color.black);
        jlNpai.setForeground(Color.black);
        jlsNpai.setForeground(Color.black);
        //-------------------------------------------------------
    }//modoTelaClara
                 
}//ExibeCadastro
