/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.MouseEvent;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import view.TelaAddFuncao;
import view.TelaPrincipal;

/**
 *
 * @author Caique
 */
public class TelaAddFuncaoController {

    private final TelaAddFuncao view;

    public TelaAddFuncaoController(TelaAddFuncao view) {
        this.view = view;
    }
    
    public static void adicionarFuncao(String caminhoArquivoAdd,String nomeDaFuncaoAdd){
        String descDaFuncao = "";
        if(TelaAddFuncao.tfDescricao.getText().isEmpty()){
            descDaFuncao = "Nenhuma";
        }else{
            descDaFuncao = TelaAddFuncao.tfDescricao.getText();
        }
        String dados = EscreverELer.ler(InfosGlobais.getCaminhoPadraoLista());
        if (dados.isEmpty()) {
            dados = nomeDaFuncaoAdd + ";" + descDaFuncao;
        } else {
            dados = dados + "=" + nomeDaFuncaoAdd + ";" + descDaFuncao;
        }
        EscreverELer.escrever(InfosGlobais.getCaminhoPadraoLista(), dados);
        JOptionPane.showMessageDialog(null, "Função Adicionada a Lista.");
        try{
            Path temp = Files.move(Paths.get(caminhoArquivoAdd),
                    Paths.get(InfosGlobais.getCaminhoPadraoFuncoes()+nomeDaFuncaoAdd));
            
            JOptionPane.showMessageDialog(null, "Função Adicionada com Sucesso.");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Erro ao Adicionar Função a Area de Funções.");
        }
        TelaPrincipalController.buscarDados();
        //TelaAddFuncao.fecharTela(); Devido ao Erro onde o metodo fecharTela não pode ser chamado tendo em vista que o mesmo tbm precisa ser static porém ao  mudarmos fecharTela para static Recebemos o Erro que dipose() não é static 
        //vamos então copiar o método adicionarFuncao() (que deveria ser exclusivo desta classe) inteiro e ainda ficará e será usado em TelaAddFuncao
    }
    
    public static void mostrarPopUp(String texto,MouseEvent evt, JButton botao){
        TelaAddFuncao.jPopupMenu1.setVisible(true);
        TelaAddFuncao.jMenuItem1.setText(texto);
        TelaAddFuncao.jMenuItem1.setEnabled(false);
        TelaAddFuncao.jPopupMenu1.show(botao, botao.getWidth(), botao.getHeight());
    }

   public static void ocultarPopUp(){
       TelaAddFuncao.jPopupMenu1.setVisible(false);
   }
}
