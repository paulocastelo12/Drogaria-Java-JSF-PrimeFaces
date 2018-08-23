/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.bean;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import br.com.drogaria.ultil.JSFUtil;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author PauloCastelo
 */
@ManagedBean(name = "MBProduto")
@ViewScoped
public class ProdutoBean {

    private Produto produto;
    private Fabricante fabricante;
    private List<Produto> itens;
    private List<Produto> itensFiltrados;
    private List<Fabricante> comboFabricantes;
   
    public void prepararPesquisa(){
        ProdutoDAO produtoDao = new ProdutoDAO();
        
        try {
            itens = produtoDao.listarTodos();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro("Pesquisa Nao Realizada" + ex.getMessage());
        }
    }
    
    public void prepararNovo(){
        produto = new Produto();
        
        FabricanteDAO fabricanteDao = new FabricanteDAO();
        
        try {
            comboFabricantes = fabricanteDao.listarTodos();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro("Pesquisa Nao Realizada" + ex.getMessage());
        }
    }
    
    public void salvar(){
        ProdutoDAO produtoDao = new ProdutoDAO();
        
        try {
            produtoDao.salvar(produto);
            
            itens = produtoDao.listarTodos();
            
            JSFUtil.addMsgSucesso("Produto Inserido Com Sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro("Erro ao Salvar" + ex.getMessage());
        }
    }
    
     public void receberCodigo() {
         ProdutoDAO produtoDao = new ProdutoDAO();
        int codigo;
        codigo = produto.getCodigo();

        try {
            produtoDao.excluir(codigo);
            //atualizar Lista!!
           itens = produtoDao.listarTodos();
            JSFUtil.addMsgSucesso("Dados Excluidos Com Sucesso");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro("Erro Ao excluir!" + ex.getMessage());
        }
    }
     
     public void prepararEditar(){
         FabricanteDAO fabricanteDao = new FabricanteDAO();
        
        try {
            comboFabricantes = fabricanteDao.listarTodos();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro("Pesquisa Nao Realizada" + ex.getMessage());
        }
     }
     
     public void alterarProduto(){
         
          ProdutoDAO produtoDao = new ProdutoDAO();
        
        try {
            produtoDao.alterar(produto);
            
            itens = produtoDao.listarTodos();
            
            JSFUtil.addMsgSucesso("Produto Editado Com Sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro("Erro ao Alterar" + ex.getMessage());
        }
     }
    
     public void save() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com Sucesso!"));
    }
    
    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    /**
     * @return the itens
     */
    public List<Produto> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<Produto> itens) {
        this.itens = itens;
    }
    
      /**
     * @return the itensFiltrados
     */
    public List<Produto> getItensFiltrados() {
        return itensFiltrados;
    }

    /**
     * @param itensFiltrados the itensFiltrados to set
     */
    public void setItensFiltrados(List<Produto> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }
    
    /**
     * @return the fabricante
     */
    public Fabricante getFabricante() {
        return fabricante;
    }

    /**
     * @param fabricante the fabricante to set
     */
    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    
     /**
     * @return the comboFabricantes
     */
    public List<Fabricante> getComboFabricantes() {
        return comboFabricantes;
    }

    /**
     * @param comboFabricantes the comboFabricantes to set
     */
    public void setComboFabricantes(List<Fabricante> comboFabricantes) {
        this.comboFabricantes = comboFabricantes;
    }
    
}
