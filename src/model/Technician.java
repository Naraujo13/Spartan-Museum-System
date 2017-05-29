package model;

import java.util.ArrayList;

/**
 * Created by naraujo on 29/05/17.
 */
public class Technician extends Person{

    private ArrayList<String> IDMuseus;

    public Technician(String name, String cpf, String senha, String email) {
        super(name, cpf, senha, email);
        this.IDMuseus = new ArrayList<>();
    }


    public ArrayList<String> getIDMuseus() {
        return IDMuseus;
    }

    public void addIDMuseus(String IDMuseu) {
        this.IDMuseus.add(IDMuseu);
    }
}
