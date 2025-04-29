package CamadaDAO;

import CamadaDTO.loginDTO;
import javax.swing.JOptionPane;
import java.sql.*;

public class loginDAO {

    public boolean remover(loginDTO login) {
        Connection conn = ConexaoDAO.conector();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!");
            return false;
        }

        String sql = "DELETE FROM user WHERE Gmail = ? and senha = ?"; // Ajustei para o uso correto de SQL

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, login.getGmail());
            pstm.setString(2, login.getSenha());

            int rowsAffected = pstm.executeUpdate(); // Usando executeUpdate para deleção

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Conta removida com sucesso!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Tentativa falhou. Verifique os dados.");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao deletar conta: " + e.getMessage());
            return false;
        }
    }

    public boolean criar(loginDTO login) {
        Connection conn = ConexaoDAO.conector();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!");
            return false;
        }

        String sql = "INSERT INTO user (nome, usuario, gmail, senha) VALUES (?, ?, ?, ?)";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, login.getNome());
            pstm.setString(2, login.getUsuario());
            pstm.setString(3, login.getGmail());
            pstm.setString(4, login.getSenha());

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Cadastro bem-sucedido!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Cadastro falhou. Verifique o preenchimento de tudo.");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer cadastro: " + e.getMessage());
            return false;
        }
    }

    public boolean entrar(loginDTO login) {
        Connection conn = ConexaoDAO.conector();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!");
            return false;
        }

        String sql = "SELECT * FROM user WHERE Nome = ? AND Usuario = ? AND Gmail = ? AND senha = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, login.getNome());
            pstm.setString(2, login.getUsuario());
            pstm.setString(3, login.getGmail());
            pstm.setString(4, login.getSenha());

            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Login bem-sucedido!");

                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Login falhou. Verifique suas credenciais.");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fazer login: " + e.getMessage());
            return false;
        }
    }

    public boolean atualizar(loginDTO login) {
        Connection conn = ConexaoDAO.conector();

        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Erro de conexão com o banco!");
            return false;
        }

        String sql = "UPDATE user SET nome = ?, usuario = ?, gmail = ?, senha = ? WHERE gmail = ?";

        try (PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setString(1, login.getNome()); 
            pstm.setString(2, login.getUsuario());
            pstm.setString(3, login.getGmail());   
            pstm.setString(4, login.getSenha());  
            pstm.setString(5, login.getGmail());

            int rowsAffected = pstm.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao atualizar dados. Verifique os dados.");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar dados: " + e.getMessage());
            return false;
        }
    }
}
