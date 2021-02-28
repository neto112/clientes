package model;

/**
 *
 * @author Cristiano Neto
 */
public class Sala {

    private int id;
    private String Nome;
    private Integer Lotacao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public Integer getLotacao() {
        return Lotacao;
    }

    public void setLotacao(Integer Lotacao) {
        this.Lotacao = Lotacao;
    }
    
     
}