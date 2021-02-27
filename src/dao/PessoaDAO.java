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
import model.Pessoa;
import utils.Conexao;

/**
 *
 * @author Cristiano Neto
 */
public class PessoaDAO {
    private Connection connection = Conexao.getConexao();
    
    public void save (Pessoa pessoa) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO pessoas (nome, sobrenome) VALUES (?,?)");
            ps.setString(1, "nome");
            ps.setString(2, "sobrenome");
            ps.execute();
            JOptionPane.showMessageDialog(null, "Pessoa cadastrado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
    
        public void update (Pessoa pessoa) {
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE pessoas SET nome=?, sobrenome=? WHERE id=?");
            ps.setString(1, pessoa.getNome());
            ps.setString(2, pessoa.getSobrenome());
            ps.setInt(3, pessoa.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Pessoa atualizado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }
        
    public void saveOrUpdate(Pessoa pessoa) {
        if(pessoa.getId() == 0) {
            save(pessoa);
        } else {
            update(pessoa);
        }
    }
    
            public void delete(Pessoa pessoa) {
        try {
            PreparedStatement ps = connection.prepareStatement("DELETE FROM pessoas WHERE id=?");
            ps.setInt(1, pessoa.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Pessoa deletado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      
    } 
            
    public List<Pessoa> getAll() {
        List<Pessoa> pessoas= new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM pessoas");
            ResultSet rs = ps.executeQuery();
 
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setSobrenome(rs.getString("sobrenome"));
            pessoas.add(pessoa);    
            }
            return pessoas;

        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return null;
    }
}
