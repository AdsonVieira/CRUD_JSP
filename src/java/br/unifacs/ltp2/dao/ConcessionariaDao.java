package br.unifacs.ltp2.dao;

import br.unifacs.ltp2.connection.ConnectionFactory;
import br.unifacs.ltp2.model.Concessionaria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConcessionariaDao {

    
    public int count() throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            stmt = con.prepareStatement("SELECT count(*) AS total FROM CONCESSIONARIA");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                count = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return count;
    }
    
    
    public List<Concessionaria> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Concessionaria> concessionariaList = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM CONCESSIONARIA");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Concessionaria c = new Concessionaria();
                c.setId(rs.getInt("ID"));
                c.setNome(rs.getString("NOME"));
                c.setCnpj(rs.getString("CNPJ"));
                concessionariaList.add(c);

            }
        } catch (SQLException ex) {
            System.out.println("ERRO AO LER TABELA CONCESSIONARIA");
            Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection((com.mysql.jdbc.Connection) con, stmt);
        }

        return concessionariaList;
    }
    
    public String add(Concessionaria concessionaria) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO CONCESSIONARIA (NOME,CNPJ) VALUES(?,?)");
            stmt.setString(1, concessionaria.getNome());
            stmt.setString(2, concessionaria.getCnpj());
            stmt.executeUpdate();

            return "SALVO COM SUCESSO";
        } catch (SQLException ex) {
            return ex.getMessage();
        } finally {
            ConnectionFactory.CloseConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
    
    public Concessionaria find(String id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        Concessionaria c = new Concessionaria();
        try {
            stmt = con.prepareStatement("SELECT * FROM CONCESSIONARIA WHERE ID = ?");
            stmt.setString(1, id); 
            rs = stmt.executeQuery();

            while (rs.next()) {
                c.setId(rs.getInt("ID"));
                c.setNome(rs.getString("NOME"));
                c.setCnpj(rs.getString("CNPJ"));
            }
        } catch (SQLException ex) {
            System.out.println("ERRO AO LER TABELA CONCESSIONARIA");
            Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection((com.mysql.jdbc.Connection) con, stmt);
        }

        return c;
    }
    
   
    public String update(Concessionaria concessionaria) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE CONCESSIONARIA SET NOME = ?, CNPJ = ? WHERE ID = ?");
            stmt.setString(1, concessionaria.getNome());
            stmt.setString(2, concessionaria.getCnpj());
            stmt.setInt(3, concessionaria.getId());
            stmt.executeUpdate();

            return "REGISTRO ATUALIZADO COM SUCESSO";
        } catch (SQLException ex) {
            return ex.getMessage();
        } finally {
            ConnectionFactory.CloseConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }

    public String delete(Concessionaria concessionaria) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM CONCESSIONARIA WHERE ID = ?");
            stmt.setInt(1, concessionaria.getId());
            stmt.executeUpdate();

            return "REGISTRO DELETADO COM SUCESSO";
        } catch (SQLException ex) {
            return ex.getMessage();
        } finally {
            ConnectionFactory.CloseConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }

}
