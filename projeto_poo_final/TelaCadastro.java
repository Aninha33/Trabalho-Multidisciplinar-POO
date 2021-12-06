package projetoV4poo;

import static java.lang.Math.round;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

public class TelaCadastro extends javax.swing.JFrame {
	
	//-----variaveis de instancia------------------
    private Variaveis var = new Variaveis();       
    private Filho filho = new Filho(); 
    private Mae mae = new Mae();   
    private Pai pai = new Pai();   
    private javax.swing.JButton jbMCor;
    private javax.swing.JButton jbMTam;
    private javax.swing.JButton jbSair;
    private javax.swing.JButton jbConcluir;
    private javax.swing.JLabel jlCPF;
    private javax.swing.JLabel jlCmae;
    private javax.swing.JLabel jlNmae;
    private javax.swing.JLabel jlNome;
    private javax.swing.JLabel jlNpai;
    private javax.swing.JLabel jlSpai;
    private javax.swing.JLabel jlWarning;
    private javax.swing.JTextField jtfCPF;
    private javax.swing.JTextField jtfCmae;
    private javax.swing.JTextField jtfNmae;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNpai;
    private javax.swing.JTextField jftCpai;
    private int controlecor = 0, controletam = 0;
    //--------------definir tamanho da janela--------------------------
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) round(screenSize.getWidth() * 0.7);
    int height = (int) round(screenSize.getHeight() * 0.7);
    //-----------------------------------------------------------------
    
    public TelaCadastro(Variaveis var) {
        
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
    }//construtor
                  
    private void initComponents() {
    	
    	//--instancia os botoes e "etiquetas"-----
        jbMTam = new javax.swing.JButton();
        jbMCor = new javax.swing.JButton();
        jlNome = new javax.swing.JLabel();
        jlNmae = new javax.swing.JLabel();
        jlNpai = new javax.swing.JLabel();
        jlCPF = new javax.swing.JLabel();
        jlWarning = new javax.swing.JLabel();
        jtfNpai = new javax.swing.JTextField();
        jtfCmae = new javax.swing.JTextField();
        jlCmae = new javax.swing.JLabel();
        jlSpai = new javax.swing.JLabel();
        jftCpai = new javax.swing.JTextField();
        jtfCPF = new javax.swing.JTextField();
        jtfNome = new javax.swing.JTextField();
        jtfNmae = new javax.swing.JTextField();
        jbSair = new javax.swing.JButton();
        jbConcluir = new javax.swing.JButton();
        //----------------------------------------
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//encerra o programa ao sair
        setTitle("Sistema CNISS - Cadastro");
        setSize(width, height);//define tamanho da tela
        setLocationRelativeTo(null);
        
        jlNome.setText("Nome:");
        jlNmae.setText("Nome da Mãe:");
        jlNpai.setText("Nome do Pai:");
        jlCPF.setText("CPF:");
        jlCmae.setText("Nº de Cadastro da Mãe:");
        jlSpai.setText("Nº de Cadastro do Pai:");

        jlWarning.setVisible(false);
        jlWarning.setForeground(new java.awt.Color(255, 0, 0));
        jlWarning.setText("Preencha todos os campos!");
        
        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {//adiciona ao botao uma funcao
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);//chama metodo de sair
            }
        });
        
        jbConcluir.setText("Concluir");
        jbConcluir.addActionListener(new java.awt.event.ActionListener() {//adiciona ao botao uma funcao
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {//testa se tem campos nulos
					jbConcluirActionPerformed(evt);//chama metodo de concluir cadastro
				} catch (NullPointerException e) {//se tiver
					e.printStackTrace();//printa stack
					jlWarning.setVisible(true);//deixa warning visivel
				}//catch
            }
        });
        
        jbMTam.setText("Modo Grande");
        jbMTam.addActionListener(new java.awt.event.ActionListener() {//adiciona ao botao uma funcao
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMTamActionPerformed(evt);//chama metodo de mudar tamanho
            }
        });

        jbMCor.setText("Modo Escuro");
        jbMCor.addActionListener(new java.awt.event.ActionListener() {//adiciona ao botao uma funcao
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMCorActionPerformed(evt);//chama metodo de mudar cor
            }
        });
        
        getContentPane().add(jlNome);
        getContentPane().add(jlNmae);
        getContentPane().add(jlNpai);
        getContentPane().add(jlCmae);
        getContentPane().add(jlSpai);
        getContentPane().add(jlCPF);
        getContentPane().add(jlWarning);
        getContentPane().add(jtfNpai);
        getContentPane().add(jtfCmae);
        getContentPane().add(jftCpai);
        getContentPane().add(jtfCPF);
        getContentPane().add(jtfNome);
        getContentPane().add(jtfNmae);
        getContentPane().add(jbMTam);
        getContentPane().add(jbSair);
        getContentPane().add(jbMCor);
        getContentPane().add(jbConcluir);
    }//initComponents                                                           

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {  //metodo de sair                                     
        
        dispose();//libera tela atual
    }//jbSairActionPerformed                                      
    
    //metodo de concluir cadastro
    private void jbConcluirActionPerformed(java.awt.event.ActionEvent evt) throws NullPointerException {                                            
    	
    	//se campos preenchidos
        if (!"".equals(jtfNpai.getText()) && !"".equals(jtfCmae.getText()) && !"".equals(jftCpai.getText()) &&
            !"".equals(jtfCPF.getText()) && !"".equals(jtfNome.getText()) && !"".equals(jtfNmae.getText()) ) {
        	//armazena informacoes digitadas
        	this.filho.setNome(jtfNome.getText());
            this.filho.setCpf(jtfCPF.getText());
            this.mae.setNome(jtfNmae.getText());
            this.mae.setNumeroCadastroM(jtfCmae.getText());
            this.pai.setNome(jtfNpai.getText());
            this.pai.setNumeroCadastroP(jftCpai.getText());
            //insere os cadastrados na lista de pessoas
            var.inserir(filho);
            var.inserir(mae);
            var.inserir(pai);
            
            new ExibeCadastro(this.var);//cria nova tela de exibir cadastro com as informacoes atualizadas
            dispose();//libera tela atual 
        } else {//se nao
        	
        	throw new NullPointerException();//lanca excecao de string nula
        }//end else
    }//jbConcluirActionPerformed                                           

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
        //--------------------------------redimensiona botoes e etiquetas------------------------------------------------------------------
        jlNome.setBounds((int) round(0.17 * width), (int) round(0.1 * height), (int) round(0.24 * width), (int) round(0.06 * height));
        jtfNome.setBounds((int) round(0.17 * width), (int) round(0.16 * height), (int) round(0.24 * width), (int) round(0.06 * height));
        jlCPF.setBounds((int) round(0.57 * width), (int) round(0.1 * height), (int) round(0.24 * width), (int) round(0.06 * height));
        jtfCPF.setBounds((int) round(0.57 * width), (int) round(0.16 * height), (int) round(0.24 * width), (int) round(0.06 * height));
        jlNmae.setBounds((int) round(0.17 * width), (int) round(0.25 * height), (int) round(0.24 * width), (int) round(0.06 * height));
        jtfNmae.setBounds((int) round(0.17 * width), (int) round(0.31 * height), (int) round(0.24 * width), (int) round(0.06 * height));
        jlCmae.setBounds((int) round(0.57 * width), (int) round(0.25 * height), (int) round(0.24 * width), (int) round(0.06 * height));
        jtfCmae.setBounds((int) round(0.57 * width), (int) round(0.31 * height), (int) round(0.24 * width), (int) round(0.06 * height));
        jlNpai.setBounds((int) round(0.17 * width), (int) round(0.4 * height), (int) round(0.24 * width), (int) round(0.06 * height));
        jtfNpai.setBounds((int) round(0.17 * width), (int) round(0.46 * height), (int) round(0.24 * width), (int) round(0.06 * height));
        jlSpai.setBounds((int) round(0.57 * width), (int) round(0.4 * height), (int) round(0.24 * width), (int) round(0.06 * height));
        jftCpai.setBounds((int) round(0.57 * width), (int) round(0.46 * height), (int) round(0.24 * width), (int) round(0.06 * height)); 
        jlWarning.setBounds((int) round(0.40 * width), (int) round(0.57 * height), (int) round(0.25 * width), (int) round(0.06 * height));
        jbConcluir.setBounds((int) round(0.50 * width), (int) round(0.68 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        jbSair.setBounds((int) round(0.34 * width), (int) round(0.68 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        jbMTam.setBounds((int) round(0.34 * width), (int) round(0.77 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        jbMCor.setBounds((int) round(0.50 * width), (int) round(0.77 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        //-------------------------------redimensiona tamanho das fontes---------------------------
        jlNome.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jtfNome.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jlCPF.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jtfCPF.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jlNmae.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jtfNmae.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jlCmae.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jtfCmae.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jlNpai.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jtfNpai.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jlSpai.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jftCpai.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));    
        jlWarning.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jbConcluir.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jbSair.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jbMTam.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jbMCor.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.015)));
        //-----------------------------------------------------------------------------------------
    }//modoTamanhoPadrao
    
    public void modoTamanhoGrande(){//metodo modo grande
    	
        this.var.setModoGrande(true);//modo grande ligado
        //--------------------------------redimensiona botoes e etiquetas------------------------------------------------------------------
        jlNome.setBounds((int) round(0.05 * width), (int) round(0.005 * height), (int) round(0.35 * width), (int) round(0.09 * height));
        jtfNome.setBounds((int) round(0.05 * width), (int) round(0.096 * height), (int) round(0.37 * width), (int) round(0.09 * height));
        jlCPF.setBounds((int) round(0.55 * width), (int) round(0.005 * height), (int) round(0.35 * width), (int) round(0.09 * height));
        jtfCPF.setBounds((int) round(0.55 * width), (int) round(0.096 * height), (int) round(0.37 * width), (int) round(0.09 * height));
        jlNmae.setBounds((int) round(0.05 * width), (int) round(0.18 * height), (int) round(0.35 * width), (int) round(0.09 * height));
        jtfNmae.setBounds((int) round(0.05 * width), (int) round(0.28 * height), (int) round(0.37 * width), (int) round(0.09 * height));
        jlCmae.setBounds((int) round(0.55 * width), (int) round(0.18 * height), (int) round(0.35 * width), (int) round(0.09 * height));
        jtfCmae.setBounds((int) round(0.55 * width), (int) round(0.28 * height), (int) round(0.37 * width), (int) round(0.09 * height));
        jlNpai.setBounds((int) round(0.05 * width), (int) round(0.37 * height), (int) round(0.35 * width), (int) round(0.09 * height));
        jtfNpai.setBounds((int) round(0.05 * width), (int) round(0.46 * height), (int) round(0.37 * width), (int) round(0.09 * height));
        jlSpai.setBounds((int) round(0.55 * width), (int) round(0.37 * height), (int) round(0.35 * width), (int) round(0.09 * height));
        jftCpai.setBounds((int) round(0.55 * width), (int) round(0.46 * height), (int) round(0.37 * width), (int) round(0.09 * height));  
        jlWarning.setBounds((int) round(0.35 * width), (int) round(0.55 * height), (int) round(0.35 * width), (int) round(0.09 * height));
        jbConcluir.setBounds((int) round(0.5 * width), (int) round(0.65 * height), (int) round(0.17 * width), (int) round(0.09 * height));
        jbSair.setBounds((int) round(0.3 * width), (int) round(0.65 * height), (int) round(0.17 * width), (int) round(0.09 * height));
        jbMTam.setBounds((int) round(0.3 * width), (int) round(0.8 * height), (int) round(0.17 * width), (int) round(0.09 * height));
        jbMCor.setBounds((int) round(0.5 * width), (int) round(0.8 * height), (int) round(0.17 * width), (int) round(0.09 * height));
        //-------------------------------redimensiona tamanho das fontes---------------------------
        jlNome.setFont(new Font(jlNome.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jtfNome.setFont(new Font(jtfNome.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jlCPF.setFont(new Font(jlCPF.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jtfCPF.setFont(new Font(jtfCPF.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jlNmae.setFont(new Font(jlNmae.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jtfNmae.setFont(new Font(jtfNmae.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jlCmae.setFont(new Font(jlCmae.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jtfCmae.setFont(new Font(jtfCmae.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jlNpai.setFont(new Font(jlNpai.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jtfNpai.setFont(new Font(jtfNpai.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jlSpai.setFont(new Font(jlSpai.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jftCpai.setFont(new Font(jftCpai.getName(), Font.PLAIN, (int) round(width * 0.02)));    
        jlWarning.setFont(new Font(jlWarning.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbConcluir.setFont(new Font(jbConcluir.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbSair.setFont(new Font(jbSair.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbMTam.setFont(new Font(jbMTam.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbMCor.setFont(new Font(jbMCor.getName(), Font.PLAIN, (int) round(width * 0.02))); 
        //------------------------------------------------------------------------------------------
    }//modoTamanhoGrande
    
    public void modoTelaEscura() {//metodo modo escuro
    	
        this.var.setModoEscuro(true);//modo escuro ligado
        //--------muda a cor do fundo e das etiquetas---------
        getContentPane().setBackground(new Color(50, 50, 50));
        jlNome.setForeground(new Color(255, 255, 255));
        jlNmae.setForeground(new Color(255, 255, 255));
        jlNpai.setForeground(new Color(255, 255, 255));
        jlCPF.setForeground(new Color(255, 255, 255));
        jlCmae.setForeground(new Color(255, 255, 255));
        jlSpai.setForeground(new Color(255, 255, 255));
        //----------------------------------------------------
    }//modoTelaEscura

    public void modoTelaClara() {//metodo modo claro
        
    	this.var.setModoEscuro(false);//modo escuro desligado
    	//--------muda a cor do fundo e das etiquetas------------
        getContentPane().setBackground(new Color(240, 240, 240));
        jlNome.setForeground(Color.black);
        jlNmae.setForeground(Color.black);
        jlNpai.setForeground(Color.black);
        jlCPF.setForeground(Color.black);
        jlCmae.setForeground(Color.black);
        jlSpai.setForeground(Color.black);
        //-------------------------------------------------------
    }//modoTelaClara
                
}//TelaCadastro
