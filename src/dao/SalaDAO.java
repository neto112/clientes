package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Sala;
import utils.Conexao;

/**
 *
 * @author Cristiano Neto
 */
public class SalaDAO {

    private final Connection connection = Conexao.getConexao();

    public void save(Sala sala) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO sala (Nome, Lotacao) VALUES (?,?)");
            ps.setString(1, sala.getNome());
            ps.setInt(2, sala.getLotacao());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Sala cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
