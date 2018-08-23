/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.testes;

import br.com.drogaria.dao.ProdutoDAO;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Toshiba
 */
public class Testes {
 
    public static void main(String[] args){
        
        ProdutoDAO pdao = new ProdutoDAO();
        
        try {
            /*p.setDescricao("Novalgina");
            p.setQuantidade(5);
            p.setValor(2.90);
            
            Fabricante f = new Fabricante();
            f.setCodigo(1);
            
            p.setFabricante(f);
            
            try {
            pdao.salvar(p);
            JOptionPane.showMessageDialog(null,"salvo com sucesso");
            } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro AO SALVAR"+ex.getMessage());
            }
            */
            
            List<Produto> lista = pdao.listarTodos();
            
            for(Produto p: lista){
                System.out.println("Codigo do Produto:" + p.getCodigo());
                System.out.println("Descricao do produto:" + p.getDescricao());
                System.out.println("Quantidade:" + p.getQuantidade());
                System.out.println("Valor:" + p.getValor());
                System.out.println("Codigo Fabricante:" + p.getFabricante().getCodigo());
                System.out.println("Descricao Fabricante:" + p.getFabricante().getDescricao());
                System.out.println("----------//-----------");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Testes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
