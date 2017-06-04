package model;

/**
 * Created by naraujo on 29/05/17.
 */
public class Researcher extends Person {

    private Integer matricula;

    public Researcher(String name, String cpf, String senha, String email, Integer matricula) {
        super(name, cpf, senha, email);
        this.matricula = matricula;
    }

    public Integer getMatricula() {
        return matricula;
    }
}