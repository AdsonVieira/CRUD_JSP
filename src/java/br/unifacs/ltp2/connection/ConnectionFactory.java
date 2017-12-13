package br.unifacs.ltp2.connection;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.unifacs.ltp2.config.Environment;

public class ConnectionFactory {

    /**
     *
     * classe que realiza a conexão com o banco
     * @return 
     */
    public static Connection getConnection() {
        try {
            Class.forName(Environment.DRIVER);
            return (Connection) DriverManager.getConnection(Environment.URL, Environment.USER, Environment.PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Erro na conexão");
            throw new RuntimeException("Erro na conexão", ex);
        }
    }

    public static void CloseConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void CloseConnection(Connection con, PreparedStatement stmt) {
        CloseConnection(con);
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void CloseConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
        CloseConnection(con);
        CloseConnection(con, stmt);
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
