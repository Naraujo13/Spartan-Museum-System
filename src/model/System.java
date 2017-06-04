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

    /* -- Coordinator -- */
    private static Coordinator coordinator;

     /* ------- Dados ------- */
     /* -- Museu -- */
     private static Museum museum;
     /* -- Usuário -- */
     private static Person activeUser;
    /* ---------------------- */


    /* -- Popula Arrays -- */
    static{

        /* -- Cria Admin -- */
        System.coordinator = new Coordinator("Administrador", "000.000.000-00", "admin", "admin@admin.admin");
        activeUser = coordinator;

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

        /* -- Mock Collections -- */
        Collection secXXI, picasso, fezes;
        museum.addCollection("Século XXI");
        secXXI = museum.getCollectionByName("Século XXI");
        museum.addCollection("Picasso");
        picasso = museum.getCollectionByName("Picasso");
        museum.addCollection("Fezes Animais Raras");
        fezes = museum.getCollectionByName("Fezes Animais Raras");

        /* -- Mock Technician -- */
        //Adiciona Diretor
        System.addPerson("Joãozinho", "123.123.123.123", "password", "joao@bonitao.uol.com", museum.getMuseumCode());

        //Adiciona Técnicos
        System.addPerson("Paulo", "111.111.111.11", "paulo123", "paulo@banco.de.dados");
        System.addPerson("Lisane", "222.222.222.22", "lisane123", "lisane@diagrama.es");

        //Adiciona Pesquisador
        System.addPerson("Nicolas", "333.333.333.33", "nicolas123", "nicolas@ufpel.com");
        System.addPerson("Kellerson", "444.444.444.44", "kellerson123", "kellerson@ufpel.com");
        System.addPerson("Xlager", "555.555.555.55", "kellerson123", "kellerson@ufpel.com");
        System.addPerson("Sias", "666.666.666.66", "sias123", "jonathan@ufpel.com");

        /* -- Mock Items -- */
        secXXI.addItem(museum.getMuseumCode(), "PS99", 2099, "Museu do Videogame de Roraima");
        secXXI.addItem(museum.getMuseumCode(), "PS50", 2050, "Museu do Videogame do Piauí");
        secXXI.addItem(museum.getMuseumCode(), "Xbox 0", 2050, "Museu do Videogame de Roraima");
        picasso.addItem(museum.getMuseumCode(), "A mulher que sorri", 1974, "Museu do Videogame da Paraíba");
        secXXI.addItem(museum.getMuseumCode(), "Xbox 0.5", 2099,"Museu do Videogame de Rondonia");
        secXXI.addItem(museum.getMuseumCode(), "Nintendo Degraus (NDS)", 2024, "Museu do Videogame da Esquina");
        secXXI.addItem(museum.getMuseumCode(), "Nintendo Mario", 2099, "Museu do Videogame dei Berlim");
        picasso.addItem(museum.getMuseumCode(), "Mona Lisa Falsificada", 1907, "Museu da Falsificação");
        picasso.addItem(museum.getMuseumCode(), "O Grito Premeditado", 1908, "Museu da Falsificação");
        picasso.addItem(museum.getMuseumCode(), "Guernica", 1937, "Museu da Falsificação");
        picasso.addItem(museum.getMuseumCode(), "A mulher que sorri", 1974, "Museu da Falsificação");
        picasso.addItem(museum.getMuseumCode(), "Zero Musicians", 1900, "Museu da Falsificação");
        picasso.addItem(museum.getMuseumCode(), "Pixacação na Frente da Federal", 2014, "Museu da Falsificação");
        fezes.addItem(museum.getMuseumCode(), "Fezes de T-Rex", 0, "Sítio Arqueológico do Amapá");
        fezes.addItem(museum.getMuseumCode(), "Fezes de Urso Polar Albino", 1983, "Sítio Arqueológico Papai Noel");
        fezes.addItem(museum.getMuseumCode(), "Cérebro de Felipe Luzzardi", 2017, "Dom Joaquim, Pelotas");
        fezes.addItem(museum.getMuseumCode(), "Fezes de Aedes Aegypti", 2008, "Pneu do Terreno Baldio");
        fezes.addItem(museum.getMuseumCode(), "Fezes de Tutancamon", 200, "Pirâmide");
        fezes.addItem(museum.getMuseumCode(), "Fezes do Cusco da Esquina", 2017, "Esquina");

        /* -- Mock Movimentations -- */


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
    };

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

    public static Coordinator getCoordinator() {
        return coordinator;
    }

    /* -- Funções de Inserção -- */

    //Usuários
    /**
     * Insere Pesquisador
     * @param name - String com nome completo
     * @param CPF - String com cpf do usuário
     * @param password - String com senha
     * @param email - String com email
     * @param universityRegistration - Integer contendo número de matrícula na universidade
     * @return - true ou false representando sucesso ou fracasso na inserção
     */
    public static boolean addPerson(String name, String CPF, String password, String email, Integer universityRegistration){

        //Testa permissão
        if (!(activeUser instanceof Technician || activeUser instanceof Director || activeUser instanceof Coordinator))
            return false;
        if (!(techniciansTreeMap.containsKey(activeUser.getCpf())
                || directorsTreeMap.containsKey(activeUser.getCpf())
                || coordinator.getCpf().equals(activeUser.getCpf())))
            return false;
        //Se já possui CPF, cancela inserção
        if (techniciansTreeMap.containsKey(CPF) || researchersTreeMap.containsKey(CPF) || directorsTreeMap.containsKey(CPF) || coordinator.getCpf().equals(CPF))
            return false;

        Researcher researcher = new Researcher(name, CPF, password, email, universityRegistration);
        researchersTreeMap.put(CPF, researcher);
        nameToCPFResearchers.put(name, CPF);

        return true;
    }

    /**
     * Adiciona Técnico
     * @param name - String com nome completo
     * @param CPF - String com cpf do usuário
     * @param password - String com senha
     * @param email - String com email
     * @return - true ou false representando sucesso ou fracasso na inserção
     */
    public static boolean addPerson(String name, String CPF, String password, String email){

        //Testa permissão
        if (!(activeUser instanceof Technician || activeUser instanceof Director || activeUser instanceof Coordinator))
            return false;
        if (!(techniciansTreeMap.containsKey(activeUser.getCpf())
                || directorsTreeMap.containsKey(activeUser.getCpf())
                || coordinator.getCpf().equals(activeUser.getCpf())))
            return false;
        //Se já possui CPF, cancela inserção
        if (techniciansTreeMap.containsKey(CPF) || researchersTreeMap.containsKey(CPF) || directorsTreeMap.containsKey(CPF) || coordinator.getCpf().equals(CPF))
            return false;

        Technician technician = new Technician(name, CPF, password, email);
        techniciansTreeMap.put(CPF, technician);
        nameToCPFTechnicians.put(name, CPF);

        return true;
    }

    /**
     * Adiciona Diretor
     * @param name - String com nome completo
     * @param CPF - String com cpf do usuário
     * @param password - String com senha
     * @param email - String com email
     * @param IDMuseum - String com ID do Museu
     * @return - true ou false representando sucesso ou fracasso na inserção
     */
    public static boolean addPerson(String name, String CPF, String password, String email, String IDMuseum){

        //Testa permissão
        if (!(activeUser instanceof Technician || activeUser instanceof Director || activeUser instanceof Coordinator))
            return false;
        if (!(techniciansTreeMap.containsKey(activeUser.getCpf())
                || directorsTreeMap.containsKey(activeUser.getCpf())
                || coordinator.getCpf().equals(activeUser.getCpf())))
            return false;
        //Se já possui CPF, cancela inserção
        if (techniciansTreeMap.containsKey(CPF) || researchersTreeMap.containsKey(CPF) || directorsTreeMap.containsKey(CPF) || coordinator.getCpf().equals(CPF))
            return false;

        //Testa IDMuseum
        if (museum.getMuseumCode().equals(IDMuseum))
            return false;

        Director director = new Director(name, CPF, password, email, IDMuseum);
        directorsTreeMap.put(CPF, director);
        nameToCPFDirectors.put(name, CPF);

        museum.setDirector(director);

        return true;
    }

    //Collections
    public boolean addCollection(String name){
        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return false;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return false;

        return (museum.addCollection(name));
    }

    //Itens
    public boolean addItem(String museumCode, String collectionName, String name, int year, String origin){

        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return false;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return false;

        //Insere item
        Collection collection = museum.getCollectionByName(collectionName);
        return collection != null && collection.addItem(museumCode + collection.getItems().size(), name, year, origin);
    }


}
