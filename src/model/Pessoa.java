package model;

/**
 *
 * @author Cristiano Neto
 */
public class Pessoa {

    private int id;
    private String Nome;
    private String Sobrenome;

    public Pessoa() {}

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

    public String getSobrenome() {
        return Sobrenome;
    }

    public void setSobrenome(String Sobrenome) {
        this.Sobrenome = Sobrenome;
    }

}
