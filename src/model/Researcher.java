package model;

/**
 * Created by naraujo on 29/05/17.
 */
public class Researcher extends Person {

    private String matricula;

    public Researcher(String name, String cpf, String senha, String email, String matricula) {
        super(name, cpf, senha, email);
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }
}