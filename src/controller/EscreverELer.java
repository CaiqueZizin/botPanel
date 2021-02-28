/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

/*
 *
 * @author caiqu
 */
/*
        !! Classe apenas para ler e escrever em arquivos TXT
*/

public class EscreverELer {
    
    //Método para atualizar dados em um aquivo !! o arquivo deve seguir o PADRÃO ->( campo:dado; ) ULTIMO_DADO -> ( campo:dado )
    public static void atualizarInfos(String caminho, String campo, String novoDado) {
        try {
            //Primeiro pegamos todo o conteudo do arquivo
            String conteudo = ler(caminho);
            //Damos Split nos Ponto&Virgulas para separarmos as linhas de dados
            String[] dds = conteudo.split(";");
            boolean achou = false;
            int i = 0;
            //Vamos procurar a linha em que há o CAMPO que informamos
            while (achou == false && dds.length > i) {
                if (dds[i].contains(campo)) {
                    //Após achar a Linha vamos atualiza-la
                    dds[i] = "\n" + campo + ":" + novoDado;
                    achou = true;
                }
                i++;
            }

            int a = 0;
            conteudo = "";
            //Após atualizado o DADO vamos agora transformar esse VETOR de string de volta em uma String Unica, Seguindo nosso PADRÃO
            while (dds.length > a) {
                if (a == (dds.length - 1)) {
                    conteudo = conteudo + dds[a];
                } else {
                    conteudo = conteudo + dds[a] + ";";
                }
                a++;
            }
            //Agora basta sobrescrever os dados no nosso arquivo
            escrever(caminho, conteudo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Falha ao atualizar aquivos","Aviso",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    //Método para devolver algum dado de um campo informado
    public static String pegarDado(String campo){
        String caminho = "config.txt", dadoSolicitado = "";
        //Primeiro pegamos todo o conteudo do arquivo
        String conteudo = ler(caminho);
        //Damos Split nos Ponto&Virgulas para separarmos as linhas de dados
        String[] dds = conteudo.split(";");
        boolean achou = false;
        int i = 0;
        //Vamos procurar a linha em que há o CAMPO que informamos
        while (achou == false && dds.length > i) {
            if (dds[i].contains(campo)) {
                //Após achar a Linha vamos atualiza-la
                String[] dd = dds[i].split(":");
                dadoSolicitado = dd[1];
                achou = true;
            }
            i++;
        }
        return dadoSolicitado;
    }
    
    //Método para escrever no arquivo !!Ele sobrescreve tudo quanto nele há!!
    public static boolean escrever(String caminho, String texto){
        try{
            //o FileWriter aponta para o arquivo e o PrintWriter escrever no arquivo apontado
            FileWriter arq = new FileWriter(caminho);
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.print(texto);
            gravarArq.close();
            return true;
        }catch(IOException ex){
            JOptionPane.showMessageDialog(null,"Erro :" + ex,"Aviso",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    
    //Método para ler os arquivos de texto de devolver tudo quanto nele tiver
    public static String ler(String caminho){
        String conteudo = "";
        try{
            //Primeiro ele tenta encontrar o aquivo, criando um FileReader com o caminho informado
            FileReader arq = new FileReader(caminho);
            //Em cima do FileReader criado ele irá agora criar um BufferedReader
            BufferedReader lerArq = new BufferedReader(arq);
            //String linha pois ele fará a leitura linha a linha e depois vai devolver o arquivo completo
            String linha = "";
            try{
                //Pega a 1° linha
                linha = lerArq.readLine();
                //ENQUANTO tenha algo escrito nessa linha, ou seja linha != null
                while(linha!=null){
                   //pegamos o conteudo dessa linha e JUNTAMOS com o resto do conteudo que ja temos
                   conteudo += linha+"\r\n";//Pega a linha e com \r\n pula a linha, trazendo assim o conteudo de forma correta
                   //Pegamos a proxima linha e assim vai...
                   linha = lerArq.readLine();
                }
                //Após ler todas as linhas fechamos o FileReader
                arq.close();
                return conteudo;
            }catch(IOException ex){
                //Catch para caso não consigamos ler o arquivo
                JOptionPane.showMessageDialog(null,"Erro: Não foi possivel ler o arquivo!","Aviso",JOptionPane.ERROR_MESSAGE);
                return "";
            }
        }catch(FileNotFoundException ex){
            //Catch para caso não consigamos encontrar o arquivo
            JOptionPane.showMessageDialog(null,"Erro: Arquivo não encontrado!","Aviso",JOptionPane.ERROR_MESSAGE);
            return "";
        }
    }
    
}
