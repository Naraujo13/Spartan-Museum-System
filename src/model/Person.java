package model;

/**
 * Created by naraujo on 29/05/17.
 */
public class Person implements Comparable<Person>{
    private String name;
    private String cpf;
    private String senha;
    private String email;
    private String telefone;

    public Person(String name, String cpf, String senha, String email) {
        this.name = name;
        this.cpf = cpf;
        this.senha = senha;
        this.email = email;
    }

    @Override
    public int compareTo(Person person) {
        return this.getName().compareToIgnoreCase(person.getName());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
