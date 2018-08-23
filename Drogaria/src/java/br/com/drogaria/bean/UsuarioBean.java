/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.bean;

import br.com.drogaria.dao.UsuarioDAO;
import br.com.drogaria.domain.Usuario;
import br.com.drogaria.ultil.JSFUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PauloCastelo
 */
@ManagedBean(name = "MBUsuario")
@ViewScoped
public class UsuarioBean {

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }


    private Usuario usuario;
    private String login;
    private String senha;
    private String nome;
    
    public Usuario validarLogin(String login, String senha){
        try {
            UsuarioDAO dao = new UsuarioDAO();
            usuario = dao.validarLogin(login, senha);
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro("Erro ao Logar" + ex.getMessage());
        }
        return usuario;
    }

    public void validar() {
        usuario = validarLogin(login, senha);
        if(usuario != null){
            JSFUtil.addMsgSucesso("Bem Vindo: "+usuario.getNome());
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect("principal.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JSFUtil.addMsgErro("Usuário ou Senha Inválida!");
        }
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
        /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }


}
