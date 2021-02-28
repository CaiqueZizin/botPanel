/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author Caique
 */
public class InfosGlobais {
    
    private static String caminhoPadraoFuncoes = "C:/botPanel/funcoes/";
    private static String caminhoPadraoLista = "C:/botPanel/controller/lista.txt";
    private static String versaoDoPrograma = "0.0.7";
    
    public static String getVersaoDoPrograma() {
        return versaoDoPrograma;
    }
    
    public static String getCaminhoPadraoFuncoes() {
        return caminhoPadraoFuncoes;
    }

    public  void setCaminhoPadraoFuncoes(String caminhoPadraoFuncoes) {
        this.caminhoPadraoFuncoes = caminhoPadraoFuncoes;
    }

    public static String getCaminhoPadraoLista() {
        return caminhoPadraoLista;
    }

    public void setCaminhoPadraoLista(String caminhoPadraoDados) {
        this.caminhoPadraoLista = caminhoPadraoDados;
    }
}
