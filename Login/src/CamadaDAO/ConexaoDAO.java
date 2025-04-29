package CamadaDAO;

import java.sql.*;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexaoDAO {

    public static Connection conector() {
        java.sql.Connection conexao = null;

        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/login_tecnico";
        String user = "root";
        String password = "root";

        try {
            Class.forName(driver); // Carrega o driver JDBC do MySQL
            conexao = DriverManager.getConnection(url, user, password); // Estabelece a conexão
            return conexao;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Conexão falhou: " + e.getMessage());
            return null;
        }
    }
}
