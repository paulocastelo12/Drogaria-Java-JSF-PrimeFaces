/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.drogaria.dao;

import br.com.drogaria.conexao.FabricaConexao;
import br.com.drogaria.domain.Fabricante;
import br.com.drogaria.domain.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Toshiba
 */
public class ProdutoDAO {
    
    private PreparedStatement pstm;
    private ResultSet rs;
    private String sql;
    Connection conexao;
    //metodo para salvar os dados do bairro
    public void salvar(Produto produto) throws SQLException{
        conexao = FabricaConexao.conexaoBanco();
        sql = "INSERT INTO produto VALUES(null,?,?,?,?)";
        pstm = conexao.prepareStatement(sql);
        pstm.setString(1,produto.getDescricao());
        pstm.setInt(2, produto.getQuantidade());
        pstm.setDouble(3, produto.getValor());
        pstm.setInt(4, produto.getFabricante().getCodigo());
        pstm.execute();
        FabricaConexao.fecharConexao();
    }//fim do metodo salvar
    
    //metodo para listar todos os bairros cadastrados no banco
    public List<Produto> listarTodos() throws SQLException{
        conexao = FabricaConexao.conexaoBanco();
        sql = "select procodigo, prodescricao, proquantidade, provalor, fabcodigo, fabdescricao from produto inner join fabricante on fabcodigo = profab_codigo";
        pstm = conexao.prepareStatement(sql);
        rs = pstm.executeQuery();
        List<Produto> minhaLista = new ArrayList<>();
        while (rs.next()) {            
            Produto produto = new Produto();
            produto.setCodigo(rs.getInt("procodigo"));
            produto.setDescricao(rs.getString("prodescricao"));
            produto.setQuantidade(rs.getInt("proquantidade"));
            produto.setValor(rs.getDouble("provalor"));
            
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(rs.getInt("fabcodigo"));
            fabricante.setDescricao(rs.getString("fabdescricao"));
            produto.setFabricante(fabricante);
            minhaLista.add(produto);
        }
        FabricaConexao.fecharConexao();
        return minhaLista;
    }//fim do metodo
    
    public void excluir(int codigo) throws SQLException{
        conexao = FabricaConexao.conexaoBanco();
        sql = "DELETE FROM produto WHERE procodigo = ?";
        pstm = conexao.prepareStatement(sql);
        pstm.setInt(1, codigo);
        pstm.execute();
        FabricaConexao.fecharConexao();
    }//fim do metodo
    
    //metodo para alterar o bairro
    public void alterar(Produto produto) throws SQLException{
        conexao = FabricaConexao.conexaoBanco();
        sql = "update produto set prodescricao =?,proquantidade =?,provalor =?,profab_codigo =? where procodigo = ?";
        pstm = conexao.prepareStatement(sql);
        pstm.setString(1,produto.getDescricao());
        pstm.setInt(2, produto.getQuantidade());
        pstm.setDouble(3, produto.getValor());
        pstm.setInt(4, produto.getFabricante().getCodigo());
        pstm.setInt(5, produto.getCodigo());
        pstm.executeUpdate();
        FabricaConexao.fecharConexao();
    }//fim do metodo
    
    //metodo para pesquisar o bairro por codigo
    public Produto consultarCodigo(int codigo) throws SQLException{
        Produto produto = null;
        conexao = FabricaConexao.conexaoBanco();
        sql = "select * from produto where procodigo = ?";
        pstm = conexao.prepareStatement(sql);
        pstm.setInt(1, codigo);
        rs = pstm.executeQuery();
        if(rs.next()){
            produto = new Produto();
            produto.setCodigo(rs.getInt("procodigo"));
            produto.setDescricao(rs.getString("prodescricao"));
            
            Fabricante fabricante = new Fabricante();
            fabricante.setCodigo(rs.getInt("procodigo"));
            fabricante.setDescricao(rs.getString("prodescricao"));
        }
        FabricaConexao.fecharConexao();
        return produto;
    }//fim do metodo
}
