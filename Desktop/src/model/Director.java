package model;

/**
 * Created by naraujo on 29/05/17.
 */
public class Director extends Person {
    private String IDMuseu;

    public Director(String name, String cpf, String senha, String email, String IDMuseu) {
        super(name, cpf, senha, email);
        this.IDMuseu = IDMuseu;
    }


    public String getIDMuseu() {
        return IDMuseu;
    }
}
