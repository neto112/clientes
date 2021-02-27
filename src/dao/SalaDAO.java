package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import Sistema.Sala;
import utils.Conexao;

/**
 *
 * @author Cristiano Neto
 */
public class SalaDAO {
    private Connection connection = Conexao.getConexao();
    
    public void save (Sala sala) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO salas (nome, lotacao) VALUES (?,?)");
            ps.setString(1, "nome");
            ps.setString(2, "lotacao");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Sala cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
        public void update (Sala sala) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE salas SET nome=?, lotacao=? WHERE id=?");
            ps.setString(1, sala.getNome());
            ps.setString(2, sala.getSala());
            ps.setInt(3, sala.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Sala atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
        
    public void saveOrUpdate(Sala sala) {
        if(sala.getId() == 0) {
            save(sala);
        } else {
            update(sala);
        }
    }
    
            public void delete(Sala sala) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM salas WHERE id=?");
            ps.setInt(1, sala.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Sala deletado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
    } 
            
    public List<Sala> getAll() {
        List<Sala> salas= new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM salas");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Sala sala = new Sala();
                sala.setId(rs.getInt("id"));
                sala.setNome(rs.getString("nome"));
                sala.setlotacao(rs.getString("lotacao"));
            salas.add(sala);    
            }
            return salas;

        } catch (SQLException ex) {
            Logger.getLogger(SalaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
}
