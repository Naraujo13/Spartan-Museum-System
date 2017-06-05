package model;

import utils.Utils;

import java.sql.Date;
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
        System.addCollection("Século XXI");
        System.addCollection("Picasso");
        System.addCollection("Fezes Animais Raras");

        /* -- Mock Users -- */
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
        System.addItem(museum.getMuseumCode(), "Século XXI", "PS99", 2099, "Museu do Videogame de Roraima");
        System.addItem(museum.getMuseumCode(), "Século XXI", "PS50", 2050, "Museu do Videogame do Piauí");
        System.addItem(museum.getMuseumCode(), "Século XXI", "Xbox 0", 2050, "Museu do Videogame de Roraima");
        System.addItem(museum.getMuseumCode(), "Século XXI", "A mulher que sorri", 1974, "Museu do Videogame da Paraíba");
        System.addItem(museum.getMuseumCode(), "Século XXI", "Xbox 0.5", 2099,"Museu do Videogame de Rondonia");
        System.addItem(museum.getMuseumCode(), "Século XXI", "Nintendo Degraus (NDS)", 2024, "Museu do Videogame da Esquina");
        System.addItem(museum.getMuseumCode(), "Século XXI", "Nintendo Mario", 2099, "Museu do Videogame dei Berlim");
        System.addItem(museum.getMuseumCode(), "Picasso", "Mona Lisa Falsificada", 1907, "Museu da Falsificação");
        System.addItem(museum.getMuseumCode(), "Picasso", "O Grito Premeditado", 1908, "Museu da Falsificação");
        System.addItem(museum.getMuseumCode(), "Picasso", "Guernica", 1937, "Museu da Falsificação");
        System.addItem(museum.getMuseumCode(), "Picasso", "A mulher que sorri", 1974, "Museu da Falsificação");
        System.addItem(museum.getMuseumCode(), "Picasso", "Zero Musicians", 1900, "Museu da Falsificação");
        System.addItem(museum.getMuseumCode(), "Picasso", "Pixacação na Frente da Federal", 2014, "Museu da Falsificação");
        System.addItem(museum.getMuseumCode(), "Fezes Animais Raras", "Fezes de T-Rex", 0, "Sítio Arqueológico do Amapá");
        System.addItem(museum.getMuseumCode(), "Fezes Animais Raras", "Fezes de Urso Polar Albino", 1983, "Sítio Arqueológico Papai Noel");
        System.addItem(museum.getMuseumCode(), "Fezes Animais Raras", "Cérebro de Felipe Luzzardi", 2017, "Dom Joaquim, Pelotas");
        System.addItem(museum.getMuseumCode(), "Fezes Animais Raras", "Fezes de Aedes Aegypti", 2008, "Pneu do Terreno Baldio");
        System.addItem(museum.getMuseumCode(), "Fezes Animais Raras", "Fezes de Tutancamon", 200, "Pirâmide");
        System.addItem(museum.getMuseumCode(), "Fezes Animais Raras", "Fezes do Cusco da Esquina", 2017, "Esquina");

        /* -- Mock Movimentations -- */





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
    public static int addPerson(String name, String CPF, String password, String email, Integer universityRegistration){

        //Testa permissão
        if (!(activeUser instanceof Technician || activeUser instanceof Director || activeUser instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(activeUser.getCpf())
                || directorsTreeMap.containsKey(activeUser.getCpf())
                || coordinator.getCpf().equals(activeUser.getCpf())))
            return Utils.PERMISSION_ERROR;
        //Se já possui CPF, cancela inserção
        if (techniciansTreeMap.containsKey(CPF) || researchersTreeMap.containsKey(CPF) || directorsTreeMap.containsKey(CPF) || coordinator.getCpf().equals(CPF))
            return Utils.ALREADY_EXISTS_ERROR;

        Researcher researcher = new Researcher(name, CPF, password, email, universityRegistration);
        researchersTreeMap.put(CPF, researcher);
        nameToCPFResearchers.put(name, CPF);

        return Utils.REQUEST_OK;
    }

    /**
     * Adiciona Técnico
     * @param name - String com nome completo
     * @param CPF - String com cpf do usuário
     * @param password - String com senha
     * @param email - String com email
     * @return - true ou false representando sucesso ou fracasso na inserção
     */
    public static int addPerson(String name, String CPF, String password, String email){

        //Testa permissão
        if (!(activeUser instanceof Technician || activeUser instanceof Director || activeUser instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(activeUser.getCpf())
                || directorsTreeMap.containsKey(activeUser.getCpf())
                || coordinator.getCpf().equals(activeUser.getCpf())))
            return Utils.PERMISSION_ERROR;
        //Se já possui CPF, cancela inserção
        if (techniciansTreeMap.containsKey(CPF) || researchersTreeMap.containsKey(CPF) || directorsTreeMap.containsKey(CPF) || coordinator.getCpf().equals(CPF))
            return Utils.ALREADY_EXISTS_ERROR;

        Technician technician = new Technician(name, CPF, password, email);
        techniciansTreeMap.put(CPF, technician);
        nameToCPFTechnicians.put(name, CPF);

        return Utils.REQUEST_OK;
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
    public static int addPerson(String name, String CPF, String password, String email, String IDMuseum){

        //Testa permissão
        if (!(activeUser instanceof Technician || activeUser instanceof Director || activeUser instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(activeUser.getCpf())
                || directorsTreeMap.containsKey(activeUser.getCpf())
                || coordinator.getCpf().equals(activeUser.getCpf())))
            return Utils.PERMISSION_ERROR;
        //Se já possui CPF, cancela inserção
        if (techniciansTreeMap.containsKey(CPF) || researchersTreeMap.containsKey(CPF) || directorsTreeMap.containsKey(CPF) || coordinator.getCpf().equals(CPF))
            return Utils.ALREADY_EXISTS_ERROR;

        //Testa IDMuseum
        if (museum.getMuseumCode().equals(IDMuseum))
            return Utils.NOT_FOUND_ERROR;

        Director director = new Director(name, CPF, password, email, IDMuseum);
        directorsTreeMap.put(CPF, director);
        nameToCPFDirectors.put(name, CPF);

        museum.setDirector(director);

        return Utils.REQUEST_OK;
    }

    //Collections
    public static int addCollection(String name){
        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        return (museum.addCollection(name));
    }

    //Itens
    public static int addItem(String museumCode, String collectionName, String name, int year, String origin){

        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        //Verifica se coleção existe e insere item
        Collection collection = museum.getCollectionByName(collectionName);
        if (collection == null)
            return Utils.NOT_FOUND_ERROR;

        return collection.addItem(museumCode + collection.getItems().size(), name, year, origin);

    }

    //Movimentation

    /**
     * Função para dar baixa em um item
     * @param collectionName - Nome da coleção do Item
     * @param itemID - ID do item
     * @param timestamp - Timestamp da Movimentação de Baixa
     * @param origin - Origem da movimentação
     * @return - inteiro representando status (definidos em Utils)
     */
    public static int dischargeItem(String collectionName, String itemID, Date timestamp, String origin){
        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        //Procura coleção
        Collection collection = museum.getCollectionByName(collectionName);
        if (collection == null)
            return Utils.NOT_FOUND_ERROR;
        //Procura Items
        Item item = collection.getItemsByID(itemID);
        if (item == null)
            return Utils.NOT_FOUND_ERROR;
        //Realiza Movimentação
        return item.discharge(timestamp, origin);

    }

    /**
     * Função para realizar empréstimo de item
     * @param collectionName - Nome da coleção do Item
     * @param itemID - ID do item
     * @param timestamp - Timestamp da Movimentação de Empréstimo
     * @param dateOfReturn - Data esperada de retorno
     * @param origin - Origem da movimentação
     * @param destination - Destino do Empréstimo
     * @return - inteiro representando status (definidos em Utils)
     */
    public static int loanItem(String collectionName, String itemID, Date timestamp, Date dateOfReturn, String origin, String destination){
        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        //Procura coleção
        Collection collection = museum.getCollectionByName(collectionName);
        if (collection == null)
            return Utils.NOT_FOUND_ERROR;
        //Procura Items
        Item item = collection.getItemsByID(itemID);
        if (item == null)
            return Utils.NOT_FOUND_ERROR;
        //Realiza Movimentação
        return item.loan(timestamp, dateOfReturn, origin, destination);
    }

    /**
     * Função para realizar envio de item à restauração
     * @param collectionName - Nome da coleção do Item
     * @param itemID - ID do item
     * @param timestamp - Timestamp da Movimentação de Empréstimo
     * @param origin - Origem da movimentação
     * @param destination - Destino do Empréstimo
     * @return - inteiro representando status (definidos em Utils)
     */
    public static int restoreItem(String collectionName, String itemID, Date timestamp, String origin, String destination){
        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        //Procura coleção
        Collection collection = museum.getCollectionByName(collectionName);
        if (collection == null)
            return Utils.NOT_FOUND_ERROR;
        //Procura Items
        Item item = collection.getItemsByID(itemID);
        if (item == null)
            return Utils.NOT_FOUND_ERROR;
        //Realiza movimentação
        return item.restoration(timestamp, origin, destination);
    }

    public static int storeItem(String collectionName, String itemID, Date timestamp, String origin, String destination){
        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        //Procura coleção
        Collection collection = museum.getCollectionByName(collectionName);
        if (collection == null)
            return Utils.NOT_FOUND_ERROR;
        //Procura Items
        Item item = collection.getItemsByID(itemID);
        if (item == null)
            return Utils.NOT_FOUND_ERROR;
        //Realiza movimentação
        return item.storage(timestamp, origin, destination);
    }



}
