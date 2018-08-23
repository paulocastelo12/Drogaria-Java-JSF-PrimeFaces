package br.com.drogaria.bean;

import br.com.drogaria.dao.FabricanteDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.ultil.JSFUtil;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;


@ManagedBean(name = "MBFabricante")
@ViewScoped
public class FabricanteBean {

    private Fabricante fabricante;
    private List<Fabricante> itens;
    private List<Fabricante> itensFiltrados;
    
    @PostConstruct
    /*esse metodo vai ser chamado automaticamente
    antes da minha tela ser desenhada*/
    public void prepararPesquisa() {
        FabricanteDAO fabricanteDao = new FabricanteDAO();
        try {
            itens = fabricanteDao.listarTodos();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro("Pesquisa Nao Realizada" + ex.getMessage());
        }
    }

    public void prepararNovo() {
        fabricante = new Fabricante();
    }

    public void salvar() {
        FabricanteDAO fabricanteDao = new FabricanteDAO();
        try {
            fabricanteDao.salvar(fabricante);
            //atualizar Lista!!
           itens = fabricanteDao.listarTodos();
            JSFUtil.addMsgSucesso("Dados Salvos Com Sucesso");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro("Erro Ao Salvar!" + ex.getMessage());
        }
    }

    public void receberCodigo() {
        int codigo;
        codigo = fabricante.getCodigo();

        FabricanteDAO fabricanteDao = new FabricanteDAO();
        try {
            fabricanteDao.excluir(codigo);
            //atualizar Lista!!
           itens = fabricanteDao.listarTodos();
            JSFUtil.addMsgSucesso("Dados Excluidos Com Sucesso");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro("Erro Ao excluir!" + ex.getMessage());
        }
    }
    
   
    
    public void receberAlterar(){
        FabricanteDAO fabricanteDao = new FabricanteDAO();
        try {
            fabricanteDao.alterar(fabricante);
            //atualizar Lista!!
            itens = fabricanteDao.listarTodos();
            JSFUtil.addMsgSucesso("Dados Alterados Com Sucesso");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JSFUtil.addMsgErro("Erro Ao Alterar!" + ex.getMessage());
        }
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
     * @return the itens
     */
    public List<Fabricante> getItens() {
        return itens;
    }

    /**
     * @param itens the itens to set
     */
    public void setItens(List<Fabricante> itens) {
        this.itens = itens;
    }


    /**
     * @return the itensFiltrados
     */
    public List<Fabricante> getItensFiltrados() {
        return itensFiltrados;
    }

    /**
     * @param itensFiltrados the itensFiltrados to set
     */
    public void setItensFiltrados(List<Fabricante> itensFiltrados) {
        this.itensFiltrados = itensFiltrados;
    }

}
