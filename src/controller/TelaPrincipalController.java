/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.Desktop;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import model.scriptsAHK;
import personalizado.meuDefaultTableModel;
import view.TelaAddFuncao;
import view.TelaPrincipal;

/**
 *
 * @author Caique
 */
public class TelaPrincipalController {
    public static String nomeFuncaoAdd = "";
    public static String caminhoFuncaoAdd = "";
    public static ArrayList<scriptsAHK> listaDeScripts = new ArrayList<>();
    public static meuDefaultTableModel dados;
    public static String colunas[] = {"Nome","Descrição"};
    public static TelaAddFuncao isTelaAddFuncao = null;

    
    private final TelaPrincipal view;

    public TelaPrincipalController(TelaPrincipal view) {
        this.view = view;
    }
    
    public static void mostrarVersaoPrograma(){
        TelaPrincipal.lblVersaoDoPrograma.setText("Versão : " + InfosGlobais.getVersaoDoPrograma());
    }
    
    public static void deletarFuncao(){
        String nomeDaFuncao = "";
        try{
            nomeDaFuncao = dados.getValueAt(TelaPrincipal.jtFuncoes.getSelectedRow(),0).toString();;
            int res = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir a Função : "+nomeDaFuncao+" ?", "Aviso", 0, 2);
            if(res == JOptionPane.YES_OPTION){
                int i = 0, a = 0;
                while (nomeDaFuncao != listaDeScripts.get(i).getNome()) {
                    i++;
                }
                listaDeScripts.remove(i);
                String dadosAtt = "";
                for (scriptsAHK s : listaDeScripts) {
                    if (a == 0) {
                        dadosAtt = dadosAtt + s.getNome() + ";" + s.getDescricao();
                        a++;
                    } else {
                        dadosAtt = dadosAtt + "=" + s.getNome() + ";" + s.getDescricao();
                    }
                }
                EscreverELer.escrever(InfosGlobais.getCaminhoPadraoLista(), dadosAtt);
                buscarDados();
                JOptionPane.showMessageDialog(null, "Função Deletada da Lista com Sucesso.");

                File funcao = new File(InfosGlobais.getCaminhoPadraoFuncoes() + nomeDaFuncao);
                if (funcao.delete()) {
                    JOptionPane.showMessageDialog(null, "Função Removida com Sucesso.");
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao Remover o Arquivo da Função");
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selecione uma Função.");
        }
    }
    
    public static void buscarDados(){
        try{    
            limparTabela();
            listaDeScripts.removeAll(listaDeScripts);

            String arquivo = controller.EscreverELer.ler(InfosGlobais.getCaminhoPadraoLista());
            String dadoss[] = arquivo.split("=");

            for (int i = 0; i < dadoss.length; i++){
                scriptsAHK script = new scriptsAHK();
                String dados2[] = dadoss[i].split(";");
                script.setNome(dados2[0]);
                script.setDescricao(dados2[1]);
                listaDeScripts.add(script);
                dados.addRow(dados2);
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Sua Lista de Funções está ilegivel, ausente ou Vazia!","Aviso",JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void mostrarPopUp(String texto,MouseEvent evt, JButton botao){
        TelaPrincipal.jPopupMenu1.setVisible(true);
        TelaPrincipal.jMenuItem1.setText(texto);
        TelaPrincipal.jMenuItem1.setEnabled(false);
        TelaPrincipal.jPopupMenu1.show(botao, botao.getWidth(), botao.getHeight());
    }
    
    public static void ocultarPopUp(){
        TelaPrincipal.jPopupMenu1.setVisible(false);
    }
    
    public static void limparTabela(){
        //Método para sempre limpar as linhas antigas da tabela
        //para quando ele pesquisar ele atualize a tabela
        int tamanho = TelaPrincipal.jtFuncoes.getRowCount();
        for(int i = 0; i < tamanho; i++){
            dados.removeRow(0);
        }
                
    }

    public static void pegarArquivo(){
        JFileChooser chooser = new JFileChooser();
        int retorno = chooser.showOpenDialog(null);
        
        if(retorno == JFileChooser.APPROVE_OPTION){
            File arquivo = chooser.getSelectedFile();
            boolean funcaoRepetida = false;

            nomeFuncaoAdd = "";
            caminhoFuncaoAdd = "";
            nomeFuncaoAdd = arquivo.getName();
            caminhoFuncaoAdd = arquivo.getAbsolutePath();
            for (scriptsAHK s : listaDeScripts) {
                if (nomeFuncaoAdd.equals(s.getNome())) {
                    JOptionPane.showMessageDialog(null, "Já há uma função instalada com o nome : " + nomeFuncaoAdd, "Aviso", JOptionPane.WARNING_MESSAGE);
                    funcaoRepetida = true;
                }
            }

            if (nomeFuncaoAdd.contains("=")) {
                JOptionPane.showMessageDialog(null, "Erro : O Nome da Função NÃO pode conter o Caracter especial : '=' (Sinal de Igual)", "Aviso", JOptionPane.ERROR_MESSAGE);
            } else {
                if (funcaoRepetida == false) {
                    if (nomeFuncaoAdd.contains(".ahk")) {
                        abrirTelaAddFuncao();
                    } else {
                        JOptionPane.showMessageDialog(null, "Erro : O Arquivo Selecionado não tem a extenção '.ahk'.", "Aviso", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
        
    }
    
    public static void abrirTelaAddFuncao(){
        if(isTelaAddFuncao != null){
            isTelaAddFuncao.dispose();
        }
        TelaAddFuncao tela = new TelaAddFuncao();
        tela.setVisible(true);
    }

    public static void executarFuncao(){
        try {
            String nomeDaFuncao = "";
            try{
                nomeDaFuncao  = dados.getValueAt(TelaPrincipal.jtFuncoes.getSelectedRow(),0).toString();
                //Comando para executar um arquivo
                Desktop.getDesktop().open(new File(InfosGlobais.getCaminhoPadraoFuncoes() + nomeDaFuncao));

                //Comando para executar um programa
                //Runtime.getRuntime().exec("C:/Windows/System32/notepad");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Nenhuma Função foi Selecionada.","Aviso",JOptionPane.WARNING_MESSAGE);
                System.out.println("Erro : " + e);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar Arquivo","Aviso",JOptionPane.ERROR_MESSAGE);
            System.out.println("Erro : " + ex);
        }
    }
    
    public static void mostrarMsgVersao(){
        JOptionPane.showMessageDialog(null, "Desenvolvedor : Caique de Souza. \n"
                                           +"Data de Criação do Projeto : 08/09/2020. \n"
                                           +"Contato : caiqueifrj2018@gmail.com");
    }
    
}
