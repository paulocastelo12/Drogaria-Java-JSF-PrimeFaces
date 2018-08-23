/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.ultil;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author PauloCastelo
 */
public class JSFUtil {
    
    public static void addMsgSucesso(String mensagem){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, mensagem);
        FacesContext contexto =  FacesContext.getCurrentInstance();
        contexto.addMessage(null, msg);
    }
    public static void addMsgErro(String mensagem){
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, mensagem);
        FacesContext contexto =  FacesContext.getCurrentInstance();
        contexto.addMessage(null, msg);
    }
}
