/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.dao;

import br.com.drogaria.conexao.FabricaConexao;
import br.com.drogaria.domain.Fabricante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toshiba
 */
public class FabricanteDAO {
    
     private Statement st;
    
    private PreparedStatement pstm;
    private ResultSet rs;
    private String sql;
    Connection conexao;
    //metodo para salvar os dados do fabricante
    public void salvar(Fabricante fabricante) throws SQLException{
        conexao = FabricaConexao.conexaoBanco();
        sql = "INSERT INTO fabricante VALUES(null,?)";
        pstm = conexao.prepareStatement(sql);
        pstm.setString(1, fabricante.getDescricao());
        pstm.execute();
        FabricaConexao.fecharConexao();
    }//fim do metodo salvar
    
    //metodo para listar todos os bairros cadastrados no banco
    public List<Fabricante> listarTodos() throws SQLException{
        conexao = FabricaConexao.conexaoBanco();
        sql = "SELECT * FROM fabricante";
        pstm = conexao.prepareStatement(sql);
        rs = pstm.executeQuery();
        List<Fabricante> minhaLista = new ArrayList<>();
        while (rs.next()) {            
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(rs.getInt("fabcodigo"));
            fabricante.setDescricao(rs.getString("fabdescricao"));
            minhaLista.add(fabricante);
        }
        FabricaConexao.fecharConexao();
        return minhaLista;
    }//fim do metodo
    
     public void excluir(int codigo) throws SQLException{
        conexao = FabricaConexao.conexaoBanco();
        sql = "DELETE FROM fabricante WHERE fabcodigo = ?";
        pstm = conexao.prepareStatement(sql);
        pstm.setInt(1, codigo);
        pstm.execute();
        FabricaConexao.fecharConexao();
    }//fim do metodo
     
     //metodo para alterar o fabricante
    public void alterar(Fabricante fabricante) throws SQLException{
        conexao = FabricaConexao.conexaoBanco();
        sql = "update fabricante set fabdescricao =? where fabcodigo = ?";
        pstm = conexao.prepareStatement(sql);
        pstm.setString(1, fabricante.getDescricao());
        pstm.setInt(2, fabricante.getCodigo());
        pstm.executeUpdate();
        FabricaConexao.fecharConexao();
    }//fim do metodo
    
    //metodo para pesquisar o fabricante por codigo
    public Fabricante consultarCodigo(int codigo) throws SQLException{
        Fabricante fabricante = null;
        conexao = FabricaConexao.conexaoBanco();
        sql = "select * from fabricante where fabcodigo = ?";
        pstm = conexao.prepareStatement(sql);
        pstm.setInt(1, codigo);
        rs = pstm.executeQuery();
        if(rs.next()){
            fabricante = new Fabricante();
            fabricante.setCodigo(rs.getInt("fabcodigo"));
            
            fabricante.setDescricao(rs.getString("fabdescricao"));
        }
        FabricaConexao.fecharConexao();
        return fabricante;
    }//fim do metodo
}
