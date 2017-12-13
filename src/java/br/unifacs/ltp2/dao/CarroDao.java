package br.unifacs.ltp2.dao;

import br.unifacs.ltp2.connection.ConnectionFactory;
import br.unifacs.ltp2.model.Carro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarroDao {

    
    public int count() throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int count = 0;
        try {
            stmt = con.prepareStatement("SELECT count(*) AS total FROM CARRO");
            rs = stmt.executeQuery();
            
            while(rs.next()){
                count = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return count;
    }
   
   
    public Carro Find(String id) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Carro carro = new Carro();
        try {
            stmt = con.prepareStatement("SELECT * FROM CARRO WHERE ID = ?");
            stmt.setString(1, id); 
            rs = stmt.executeQuery();
            while (rs.next()) {
                carro.setId(rs.getInt("ID"));
                carro.setFabricante(rs.getString("FABRICANTE"));
                carro.setModelo(rs.getString("MODELO"));
                carro.setAno(rs.getString("ANO"));
                carro.setQuilometragem(rs.getString("QUILOMETRAGEM"));
                carro.setPreco(rs.getString("PRECO"));
                carro.setConcessionariaId(rs.getInt("CONCESSIONARIA_ID"));

            }
        } catch (SQLException ex) {
            System.out.println("ERRO AO LER TABELA CARRO");
            Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection((com.mysql.jdbc.Connection) con, stmt);
        }

        return carro;
    }
    
    public List<Carro> readJoin() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Carro> carroList = new ArrayList<>();
        try {
            stmt = con.prepareStatement("select * from CARRO INNER JOIN CONCESSIONARIA ON CARRO.CONCESSIONARIA_ID = CONCESSIONARIA.ID");
            rs = stmt.executeQuery();

            while (rs.next()) {
                Carro carro = new Carro();
                carro.setId(rs.getInt("ID"));
                carro.setFabricante(rs.getString("FABRICANTE"));
                carro.setModelo(rs.getString("MODELO"));
                carro.setAno(rs.getString("ANO"));
                carro.setQuilometragem(rs.getString("QUILOMETRAGEM"));
                carro.setPreco(rs.getString("PRECO"));
                carro.setConcessionariaId(rs.getInt("CONCESSIONARIA_ID"));
                carro.setConcessionariaString(rs.getString("NOME"));
                carroList.add(carro);

            }
        } catch (SQLException ex) {
            System.out.println("ERRO AO LER TABELA CARRO");
            Logger.getLogger(CarroDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.CloseConnection((com.mysql.jdbc.Connection) con, stmt);
        }

        return carroList;
    }
    
    public String add(Carro carro) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("INSERT INTO CARRO (FABRICANTE,MODELO,ANO,QUILOMETRAGEM,PRECO,CONCESSIONARIA_ID)"
                    + "VALUES(?,?,?,?,?,?)");
            stmt.setString(1, carro.getFabricante());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getAno());
            stmt.setString(4, carro.getQuilometragem());
            stmt.setString(5, carro.getPreco());
            stmt.setInt(6, carro.getConcessionariaId());
            stmt.executeUpdate();

            return "SALVO COM SUCESSO";
        } catch (SQLException ex) {
            return ex.getMessage();
        } finally {
            ConnectionFactory.CloseConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }
    
    public String update(Carro carro) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE CARRO "
                    + "SET FABRICANTE = ?, MODELO = ?, ANO = ?, "
                    + "QUILOMETRAGEM = ?, PRECO = ?, CONCESSIONARIA_ID = ? WHERE ID = ?");
            stmt.setString(1, carro.getFabricante());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getAno());
            stmt.setString(4, carro.getQuilometragem());
            stmt.setString(5, carro.getPreco());
            stmt.setInt(6, carro.getConcessionariaId());
            stmt.setInt(7, carro.getId());
            stmt.executeUpdate();

            return "REGISTRO ATUALIZADO COM SUCESSO";
        } catch (SQLException ex) {
            return ex.getMessage();
        } finally {
            ConnectionFactory.CloseConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }

    public String delete(Carro carro) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM CARRO WHERE ID = ?");
            stmt.setInt(1, carro.getId());
            stmt.executeUpdate();

            return "REGISTRO DELETADO COM SUCESSO";
        } catch (SQLException ex) {
            return ex.getMessage();
        } finally {
            ConnectionFactory.CloseConnection((com.mysql.jdbc.Connection) con, stmt);
        }
    }

}
