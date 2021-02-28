package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Espaco;
import utils.Conexao;

/**
 *
 * @author Cristiano Neto
 */
public class EspacoDAO {

    private final Connection connection = Conexao.getConexao();

    public void save(Espaco espaco) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO espaco (Lotacao) VALUES (?)");
            ps.setInt(1, espaco.getLotacao());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Espaço cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(EspacoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
