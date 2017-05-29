package model;


/**
 * Created by naraujo on 29/05/17.
 */
public class Item {

    private String ID;
    private String nome;
    private int year;
    private String status;


    public Item(String ID, String nome, int year) {
        this.ID = ID;
        this.nome = nome;
        this.year = year;
    }

    public String getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
