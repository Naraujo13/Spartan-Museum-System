package model;

import java.util.HashMap;
import java.util.TreeMap;

/**
 * Created by naraujo on 01/06/17.
 */
public final class System {
    private System(){}

    /* ------- Usuários ------- */
    /* -- Técnicos -- */
    private static TreeMap<String, Technician> techniciansTreeMap; /* -- TreeMap com CPF->Técnico dos técnicos-- */
    private static HashMap<String, String> nameToCPFTechnicians; /* -- HashMap Nome->CPF dos técnicos-- */

    /* -- Pesquisadores -- */
    private static TreeMap<String, Researcher> researchersTreeMap; /* -- TreeMap com CPF->Pesquisador dos pesquisadores -- */
    private static HashMap<String, String> nameToCPFResearchers; /* -- HashMap Nome->CPF dos pesquisadores-- */

    /* -- Diretores -- */
    private static TreeMap<String, Director> directorsTreeMap; /* -- TreeMap com CPF->Diretor dos diretores -- */
    private static HashMap<String, String> nameToCPFDirectors; /* -- HashMap Nome->CPF dos diretores-- */
    private static HashMap<String, String> museumIdToCPFDirectors; /* -- HashMap museuID->CPF dos diretores-- */
    /* ------------------------ */

     /* ------- Dados ------- */
     /* -- Museu -- */
     private static Museum museum;
     /* -- Usuário -- */
     private static Person activeUser;
    /* ---------------------- */


    /* -- Popula Arrays -- */
    static{

        /* -- Prepara HashMaps -- */
        techniciansTreeMap = new TreeMap<>();
        nameToCPFTechnicians = new HashMap<>();

        researchersTreeMap = new TreeMap<>();
        nameToCPFResearchers = new HashMap<>();

        directorsTreeMap = new TreeMap<>();
        nameToCPFDirectors = new HashMap<>();
        museumIdToCPFDirectors = new HashMap<>();

        /* -- Mock Museum -- */
        museum = new Museum(
                "TST",
                "Teste",
                "Rua Teste 123",
                "123123123123",
                "teste@testando.tst",
                "2:00 às 4:00hrs");
        Director joaozinho = new Director("Joãozinho", "123.123.123.123", "password", "joao@bonitao.uol.com", museum.getMuseumCode());
        museum.setDirector(joaozinho);

        /* -- Mock Collections -- */

        /* -- Mock Items -- */

        /* -- Mock Users -- */


    }


    public static TreeMap<String, Technician> getTechniciansTreeMap() {
        return techniciansTreeMap;
    }

    public static HashMap<String, String> getNameToCPFTechnicians() {
        return nameToCPFTechnicians;
    }

    public static TreeMap<String, Researcher> getResearchersTreeMap() {
        return researchersTreeMap;
    }

    public static HashMap<String, String> getNameToCPFResearchers() {
        return nameToCPFResearchers;
    }

    public static TreeMap<String, Director> getDirectorsTreeMap() {
        return directorsTreeMap;
    }

    public static HashMap<String, String> getNameToCPFDirectors() {
        return nameToCPFDirectors;
    }

    public static HashMap<String, String> getMuseumIdToCPFDirectors() {
        return museumIdToCPFDirectors;
    }

    public static Museum getMuseum() {
        return museum;
    }

    public static Person getActiveUser() {
        return activeUser;
    }

    public static void setActiveUser(Person activeUser) {
        System.activeUser = activeUser;
    }
}
