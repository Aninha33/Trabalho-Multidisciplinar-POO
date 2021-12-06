package projetoV4poo;

import java.awt.Font;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import static java.lang.Math.round;

public class TelaLogin extends javax.swing.JFrame {
	
	//-----variaveis de instancia------------------
    private Variaveis var = new Variaveis();                  
    private javax.swing.JButton jbEntrar;
    private javax.swing.JButton jbLimpar;
    private javax.swing.JButton jbMCor;
    private javax.swing.JButton jbMO;
    private javax.swing.JButton jbMTam;
    private javax.swing.JButton jbSair;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlSenha;
    private javax.swing.JLabel jlWarning;
    private javax.swing.JPasswordField jpSenha;
    private javax.swing.JTextField jtfEmail;
    private int controle = 0, controlecor = 0, controletam = 0;
    //--------------definir tamanho da janela--------------------------
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) round(screenSize.getWidth() * 0.7);
    int height = (int) round(screenSize.getHeight() * 0.7);
    //-----------------------------------------------------------------
    
    public TelaLogin() {
    	
    	mudalayout();//muda o layout da janela
        initComponents();//inicia os componentes
        modoTamanhoPadrao();//inicia com tamanho padrao
        
    }//construtor
                   
    private void initComponents() {
    	
    	//--instancia os botoes e "etiquetas"-----
        jlEmail = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jlSenha = new javax.swing.JLabel();
        jpSenha = new javax.swing.JPasswordField();
        jbMO = new javax.swing.JButton();
        jbLimpar = new javax.swing.JButton();
        jbEntrar = new javax.swing.JButton();
        jbSair = new javax.swing.JButton();
        jlWarning = new javax.swing.JLabel();
        jbMTam = new javax.swing.JButton();
        jbMCor = new javax.swing.JButton();
        //----------------------------------------
        getContentPane().setLayout(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);//encerra o programa ao sair
        setTitle("Sistema CNISS - Login");
        setSize(width, height);//define tamanho da tela
        setLocationRelativeTo(null);

        jlEmail.setText("Email:");
        jlSenha.setText("Senha:");
        jpSenha.setEchoChar('\u2665');//oculta senha

        jbMO.setText("Mostrar");
        jbMO.addActionListener(new java.awt.event.ActionListener() {//adiciona ao botao uma funcao
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMOActionPerformed(evt);//chama metodo de mostrar a senha
            }
        });

        jlWarning.setVisible(false);
        jlWarning.setForeground(new java.awt.Color(255, 0, 0));
        jlWarning.setText("Email ou senha incorretos!");
        
        jbLimpar.setText("Limpar");
        jbLimpar.addActionListener(new java.awt.event.ActionListener() {//adiciona ao botao uma funcao
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimparActionPerformed(evt);//chama metodo de limpar campos
            }
        });

        jbSair.setText("Sair");
        jbSair.addActionListener(new java.awt.event.ActionListener() {//adiciona ao botao uma funcao
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSairActionPerformed(evt);//chama metodo de sair
            }
        });
        
        jbEntrar.setText("Entrar");
        jbEntrar.addActionListener(new java.awt.event.ActionListener() {//adiciona ao botao uma funcao
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEntrarActionPerformed(evt);//chama metodo de efetuar login
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
        
        getContentPane().add(jlEmail);
        getContentPane().add(jtfEmail);
        getContentPane().add(jlSenha);
        getContentPane().add(jpSenha);
        getContentPane().add(jbMO);
        getContentPane().add(jlWarning);
        getContentPane().add(jbLimpar);
        getContentPane().add(jbSair);
        getContentPane().add(jbEntrar);
        getContentPane().add(jbMTam);
        getContentPane().add(jbMCor);

    }//initComponents                      

    private void jbMOActionPerformed(java.awt.event.ActionEvent evt) {//metodo de ocultar/mostrar senha                                     
        
    	if (this.controle == 0) {//se senha oculta

            jbMO.setText("Ocultar");
            jpSenha.setEchoChar((char) 0);//remove ocultamento de senha
            this.controle = 1;//senha à mostra

        } else if (this.controle == 1) {//se senha à mostra
            jbMO.setText("Mostrar");
            jpSenha.setEchoChar('\u2665');//oculta senha
            this.controle = 0;//senha oculta

        }//end else
    }//jbMOActionPerformed                                    

    private void jbLimparActionPerformed(java.awt.event.ActionEvent evt) {//metodo de limpar campos                                         
        jtfEmail.setText("");//limpa campo email
    	jpSenha.setText("");//limpa campo senha
    }//jbLimparActionPerformed                                        

    private void jbSairActionPerformed(java.awt.event.ActionEvent evt) {//metodo de sair                                       
        dispose();
    }//jbSairActionPerformed                                      

    private void jbEntrarActionPerformed(java.awt.event.ActionEvent evt) {//metodo de efetuar login                                         
        
    	if (jtfEmail.getText().equals("a") && new String(jpSenha.getPassword()).equals("a")) {//se email e senha digitados batem com esses
            
            new TelaCadastro(this.var);//inicia tela de cadastro
            dispose();//libera tela atual
        } else {//se nao

            jlWarning.setVisible(true);//deixa warning visivel
        }//end else
    }//jbEntrarActionPerformed                                        

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
        jlEmail.setBounds((int) round(0.25 * width), (int) round(0.17 * height), (int) round(0.25 * width), (int) round(0.06 * height));
        jtfEmail.setBounds((int) round(0.25 * width), (int) round(0.23 * height), (int) round(0.25 * width), (int) round(0.06 * height));
        jlSenha.setBounds((int) round(0.25 * width), (int) round(0.29 * height), (int) round(0.25 * width), (int) round(0.06 * height));
        jpSenha.setBounds((int) round(0.25 * width), (int) round(0.35 * height), (int) round(0.25 * width), (int) round(0.06 * height));
        jbMO.setBounds((int) round(0.52 * width), (int) round(0.35 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        jbLimpar.setBounds((int) round(0.2 * width), (int) round(0.47 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        jbEntrar.setBounds((int) round(0.5 * width), (int) round(0.47 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        jbSair.setBounds((int) round(0.35 * width), (int) round(0.47 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        jlWarning.setBounds((int) round(0.25 * width), (int) round(0.4 * height), (int) round(0.25 * width), (int) round(0.06 * height));
        jbMTam.setBounds((int) round(0.27 * width), (int) round(0.6 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        jbMCor.setBounds((int) round(0.42 * width), (int) round(0.6 * height), (int) round(0.14 * width), (int) round(0.06 * height));
        //-------------------------------redimensiona tamanho das fontes---------------------------
        jlEmail.setFont(new Font(jlEmail.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jtfEmail.setFont(new Font(jtfEmail.getName(), Font.PLAIN, (int) round(width * 0.015)));    
        jlSenha.setFont(new Font(jlSenha.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jpSenha.setFont(new Font(jpSenha.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jbMO.setFont(new Font(jbMO.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jbLimpar.setFont(new Font(jbLimpar.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jbEntrar.setFont(new Font(jbEntrar.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jbSair.setFont(new Font(jbSair.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jlWarning.setFont(new Font(jlWarning.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jbMTam.setFont(new Font(jbMTam.getName(), Font.PLAIN, (int) round(width * 0.015)));
        jbMCor.setFont(new Font(jbMCor.getName(), Font.PLAIN, (int) round(width * 0.015)));
        //-----------------------------------------------------------------------------------------
    }//modoTamanhoPadrao
    
    public void modoTamanhoGrande(){//metodo modo grande
    	
        this.var.setModoGrande(true);//modo grande ligado
        //--------------------------------redimensiona botoes e etiquetas------------------------------------------------------------------
        jlEmail.setBounds((int) round(0.25 * width), (int) round(0.1 * height), (int) round(0.35 * width), (int) round(0.1 * height));
        jtfEmail.setBounds((int) round(0.25 * width), (int) round(0.2 * height), (int) round(0.37 * width), (int) round(0.1 * height));
        jlSenha.setBounds((int) round(0.25 * width), (int) round(0.3 * height), (int) round(0.35 * width), (int) round(0.1 * height));
        jpSenha.setBounds((int) round(0.25 * width), (int) round(0.4 * height), (int) round(0.37 * width), (int) round(0.1 * height));
        jbMO.setBounds((int) round(0.65 * width), (int) round(0.4 * height), (int) round(0.17 * width), (int) round(0.1 * height));
        jbLimpar.setBounds((int) round(0.20 * width), (int) round(0.6 * height), (int) round(0.17 * width), (int) round(0.1 * height));
        jbEntrar.setBounds((int) round(0.60 * width), (int) round(0.6 * height), (int) round(0.17 * width), (int) round(0.1 * height));
        jbSair.setBounds((int) round(0.40 * width), (int) round(0.6 * height), (int) round(0.17 * width), (int) round(0.1 * height));
        jlWarning.setBounds((int) round(0.25 * width), (int) round(0.50 * height), (int) round(0.25 * width), (int) round(0.1 * height));
        jbMTam.setBounds((int) round(0.30 * width), (int) round(0.75 * height), (int) round(0.17 * width), (int) round(0.1 * height));
        jbMCor.setBounds((int) round(0.50 * width), (int) round(0.75 * height), (int) round(0.17 * width), (int) round(0.1 * height));
        //-------------------------------redimensiona tamanho das fontes---------------------------
        jlEmail.setFont(new Font(jlEmail.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jtfEmail.setFont(new Font(jtfEmail.getName(), Font.PLAIN, (int) round(width * 0.02)));    
        jlSenha.setFont(new Font(jlSenha.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jpSenha.setFont(new Font(jpSenha.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbMO.setFont(new Font(jbMO.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbLimpar.setFont(new Font(jbLimpar.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbEntrar.setFont(new Font(jbEntrar.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbSair.setFont(new Font(jbSair.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jlWarning.setFont(new Font(jlWarning.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbMTam.setFont(new Font(jbMTam.getName(), Font.PLAIN, (int) round(width * 0.02)));
        jbMCor.setFont(new Font(jbMCor.getName(), Font.PLAIN, (int) round(width * 0.02)));
        //-----------------------------------------------------------------------------------------
    }//modoTamanhoGrande
    
    public void modoTelaEscura() {//metodo tela escura
    	
        this.var.setModoEscuro(true);//modo escuro ligado
        //--------muda a cor do fundo e das etiquetas---------
        getContentPane().setBackground(new Color(50, 50, 50));
        jlEmail.setForeground(new Color(255, 255, 255));
        jlSenha.setForeground(new Color(255, 255, 255));
        //----------------------------------------------------
    }//modoTelaEscura

    public void modoTelaClara() {//metodo tela clara
    	
        this.var.setModoEscuro(false);//modo escuro desligado
        //--------muda a cor do fundo e das etiquetas------------
        getContentPane().setBackground(new Color(240, 240, 240));
        jlEmail.setForeground(Color.black);
        jlSenha.setForeground(Color.black);
        //----------------------------------------------------
    }//modoTelaClara
     
    public void mudalayout(){
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }//mudalayout
                 
}//TelaLogin

