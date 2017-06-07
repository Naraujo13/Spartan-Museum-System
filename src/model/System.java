package model;

import utils.Utils;

import java.sql.Date;
import java.util.*;

/**
 * Created by naraujo on 01/06/17.
 */
public final class System {
    /* ------- Usuários ------- */
    /* -- Técnicos -- */
    private static HashMap<String, Technician> techniciansTreeMap; /* -- TreeMap com CPF->Técnico dos técnicos-- */
    private static TreeMap<String, String> nameToCPFTechnicians; /* -- HashMap Nome->CPF dos técnicos-- */
    /* -- Pesquisadores -- */
    private static HashMap<String, Researcher> researchersTreeMap; /* -- TreeMap com CPF->Pesquisador dos pesquisadores -- */
    private static TreeMap<String, String> nameToCPFResearchers; /* -- HashMap Nome->CPF dos pesquisadores-- */
    /* -- Diretores -- */
    private static HashMap<String, Director> directorsTreeMap; /* -- TreeMap com CPF->Diretor dos diretores -- */
    private static TreeMap<String, String> nameToCPFDirectors; /* -- HashMap Nome->CPF dos diretores-- */
    private static TreeMap<String, String> museumIdToCPFDirectors; /* -- HashMap museuID->CPF dos diretores-- */
    /* -- Coordinator -- */
    private static Coordinator coordinator;
    /* ------------------------ */
     /* ------- Dados ------- */
     /* -- Museu -- */
     private static Museum museum;
     /* -- Usuário -- */
     private static Person activeUser;

    /* -- Popula Arrays -- */
    static{

        /* -- Cria Admin -- */
        System.coordinator = new Coordinator("Administrador", "000.000.000-00", "admin", "admin@admin.admin");
        activeUser = coordinator;

        /* -- Prepara HashMaps -- */
        techniciansTreeMap = new HashMap<>();
        nameToCPFTechnicians = new TreeMap<>();

        researchersTreeMap = new HashMap<>();
        nameToCPFResearchers = new TreeMap<>();

        directorsTreeMap = new HashMap<>();
        nameToCPFDirectors = new TreeMap<>();
        museumIdToCPFDirectors = new TreeMap<>();

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
        System.addPerson("Nicolas", "333.333.333.33", "nicolas123", "nicolas@ufpel.com", 14101238);
        System.addPerson("Kellerson", "444.444.444.44", "kellerson123", "kellerson@ufpel.com", 14101237);
        System.addPerson("Xlager", "555.555.555.55", "kellerson123", "kellerson@ufpel.com", 14101236);
        System.addPerson("Sias", "666.666.666.66", "sias123", "jonathan@ufpel.com", 14101235);

        /* -- Mock Items -- */
        System.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                "PS99",
                2099,
                "Museu do Videogame de Roraima",
                "Armazém 51",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                "PS50",
                2050,
                "Museu do Videogame do Piauí",
                "Armazém 56",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                "Xbox 0",
                2050,
                "Museu do Videogame de Roraima",
                "Armazém 535",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                "A mulher que sorri",
                1974,
                "Museu do Videogame da Paraíba",
                "Armazém 21",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                "Xbox 0.5", 2099,
                "Museu do Videogame de Rondonia",
                "Armazém 52",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                "Nintendo Degraus (NDS)",
                2024, "Museu do Videogame da Esquina",
                "Armazém 02",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                "Nintendo Mario",
                2099,
                "Museu do Videogame dei Berlim",
                "Armazém 51",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(
                museum.getMuseumCode(),
                "Picasso",
                "Mona Lisa Falsificada",
                1907, "Museu da Falsificação",
                "Armazém 51",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(
                museum.getMuseumCode(),
                "Picasso",
                "O Grito Premeditado",
                1908, "Museu da Falsificação",
                "Armazém 43",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(
                museum.getMuseumCode(),
                "Picasso",
                "Guernica",
                1937,
                "Museu da Falsificação",
                "Armazém 54",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(museum.getMuseumCode(),
                "Picasso",
                "A mulher que sorri",
                1974,
                "Museu da Falsificação",
                "Armazém 53",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(museum.getMuseumCode(),
                "Picasso",
                "Zero Musicians",
                1900,
                "Museu da Falsificação",
                "Armazém 51",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(museum.getMuseumCode(),
                "Picasso",
                "Pixacação na Frente da Federal",
                2014, "Museu da Falsificação",
                "Armazém 21",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(museum.getMuseumCode(),
                "Fezes Animais Raras",
                "Fezes de T-Rex",
                0,
                "Sítio Arqueológico do Amapá",
                "Armazém 76",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(
                museum.getMuseumCode(),
                "Fezes Animais Raras",
                "Fezes de Urso Polar Albino",
                1983, "Sítio Arqueológico Papai Noel",
                "Armazém 03",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(
                museum.getMuseumCode(),
                "Fezes Animais Raras",
                "Cérebro de Felipe Luzzardi",
                2017,
                "Dom Joaquim, Pelotas",
                "Armazém 21",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(
                museum.getMuseumCode(),
                "Fezes Animais Raras",
                "Fezes de Aedes Aegypti",
                2008,
                "Pneu do Terreno Baldio",
                "Armazém 32",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        System.addItem(museum.getMuseumCode(),
                "Fezes Animais Raras",
                "Fezes de Tutancamon",
                200,
                "Pirâmide",
                "Armazém 76",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis()));

        System.addItem(
                museum.getMuseumCode(),
                "Fezes Animais Raras",
                "Fezes do Cusco da Esquina",
                2017,
                "Esquina",
                "Armazém 15",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        /* -- Mock Movimentations -- */





    }
    /* ---------------------- */


    private System(){}

    public static HashMap<String, Technician> getTechniciansTreeMap() {
        return techniciansTreeMap;
    }

    public static TreeMap<String, String> getNameToCPFTechnicians() {
        return nameToCPFTechnicians;
    }

    public static HashMap<String, Researcher> getResearchersTreeMap() {
        return researchersTreeMap;
    }

    public static TreeMap<String, String> getNameToCPFResearchers() {
        return nameToCPFResearchers;
    }

    public static HashMap<String, Director> getDirectorsTreeMap() {
        return directorsTreeMap;
    }

    public static TreeMap<String, String> getNameToCPFDirectors() {
        return nameToCPFDirectors;
    }

    public static TreeMap<String, String> getMuseumIdToCPFDirectors() {
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

    /* -- Login -- */

    /**
     * Método de login
     * @param cpf - cpf digitado
     * @param password - senha digitada
     * @return - Utils.NOT_FOUND_ERROR para usuário não encontrado (CPF nao esta cadastrado) ou Utils.PERMISSION_ERROR
     * para senha incorreta.
     */
    public static int login(String cpf, String password){
        Person newUser;
        //Pesquisa usuário
        if (coordinator.getCpf().equals(cpf)){
            newUser = coordinator;
        }
        else if (directorsTreeMap.containsKey(cpf)){
            newUser = directorsTreeMap.get(cpf);
        }
        else if (researchersTreeMap.containsKey(cpf)){
            newUser = researchersTreeMap.get(cpf);
        }
        else if (techniciansTreeMap.containsKey(cpf)){
            newUser = techniciansTreeMap.get(cpf);
        }
        else
            return Utils.NOT_FOUND_ERROR;   //Não há usuário cadastrado com este CPF

        if (newUser == null)
            return Utils.NOT_FOUND_ERROR; //Não encontrado
        else if (!newUser.getSenha().equals(password))
            return Utils.PERMISSION_ERROR;      //Senha incorreta
        else{
            activeUser = newUser;
            return Utils.REQUEST_OK; //Login Realizado com sucesso
        }
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
    public static int addItem(String museumCode, String collectionName, String name, int year, String origin, String destination,
                              float weight, float lenght, float width, float height, java.sql.Date aquisitionDate){

        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        //Verifica se coleção existe e insere item
        Collection collection = museum.getCollectionByName(collectionName).get(0);
        if (collection == null)
            return Utils.NOT_FOUND_ERROR;

        return collection.addItem(museumCode + collection.getItems().size(), name, year, origin, destination, weight, lenght, width, height, aquisitionDate);

    }

    //Movimentation

    /**
     * Função para dar baixa em um item
     * @param collectionName - Nome da coleção do Item
     * @param itemID - ID do item
     * @param timestamp - Timestamp da Movimentação de Baixa
     * @return - inteiro representando status (definidos em Utils)
     */
    public static int dischargeItem(String collectionName, String itemID, Date timestamp){
        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        //Procura coleção
        Collection collection = museum.getCollectionByName(collectionName).get(0);
        if (collection == null)
            return Utils.NOT_FOUND_ERROR;
        //Procura Items
        Item item = collection.getItemsByID(itemID);
        if (item == null)
            return Utils.NOT_FOUND_ERROR;
        //Realiza Movimentação
        return item.discharge(timestamp);

    }

    /**
     * Função para realizar empréstimo de item
     * @param collectionName - Nome da coleção do Item
     * @param itemID - ID do item
     * @param timestamp - Timestamp da Movimentação de Empréstimo
     * @param dateOfReturn - Data esperada de retorno
     * @param destination - Destino do Empréstimo
     * @return - inteiro representando status (definidos em Utils)
     */
    public static int loanItem(String collectionName, String itemID, Date timestamp, Date dateOfReturn, String destination){
        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        //Procura coleção
        Collection collection = museum.getCollectionByName(collectionName).get(0);
        if (collection == null)
            return Utils.NOT_FOUND_ERROR;
        //Procura Items
        Item item = collection.getItemsByID(itemID);
        if (item == null)
            return Utils.NOT_FOUND_ERROR;
        //Realiza Movimentação
        return item.sendToLoan(timestamp, dateOfReturn, destination);
    }

    /**
     * Função para realizar envio de item à restauração
     * @param collectionName - Nome da coleção do Item
     * @param itemID - ID do item
     * @param timestamp - Timestamp da Movimentação de Empréstimo
     * @param destination - Destino do Empréstimo
     * @return - inteiro representando status (definidos em Utils)
     */
    public static int restoreItem(String collectionName, String itemID, Date timestamp, String destination){
        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        //Procura coleção
        Collection collection = museum.getCollectionByName(collectionName).get(0);
        if (collection == null)
            return Utils.NOT_FOUND_ERROR;
        //Procura Items
        Item item = collection.getItemsByID(itemID);
        if (item == null)
            return Utils.NOT_FOUND_ERROR;
        //Realiza movimentação
        return item.sendToRestoration(timestamp, destination);
    }

    public static int storeItem(String collectionName, String itemID, Date timestamp, String destination){
        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        //Procura coleção
        Collection collection = museum.getCollectionByName(collectionName).get(0);
        if (collection == null)
            return Utils.NOT_FOUND_ERROR;
        //Procura Items
        Item item = collection.getItemsByID(itemID);
        if (item == null)
            return Utils.NOT_FOUND_ERROR;
        //Realiza movimentação
        return item.putToStorage(timestamp, destination);
    }

    public static int exposeItem(String collectionName, String itemID, Date timestamp, String destination){
        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        //Procura coleção
        Collection collection = museum.getCollectionByName(collectionName).get(0);
        if (collection == null)
            return Utils.NOT_FOUND_ERROR;
        //Procura Items
        Item item = collection.getItemsByID(itemID);
        if (item == null)
            return Utils.NOT_FOUND_ERROR;
        //Realiza movimentação
        return item.putToExposition(timestamp, destination);
    }

    public static int returnFromLoan(String collectionName, String itemID, Date timestamp, String destination){
        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        //Procura coleção
        Collection collection = museum.getCollectionByName(collectionName).get(0);
        if (collection == null)
            return Utils.NOT_FOUND_ERROR;
        //Procura Items
        Item item = collection.getItemsByID(itemID);
        if (item == null)
            return Utils.NOT_FOUND_ERROR;
        //Realiza movimentação
        return item.returnFromLoan(timestamp, destination);
    }

    public static int returnFromRestoration(String collectionName, String itemID, Date timestamp, String destination){
        //Testa permissão
        if (!(System.getActiveUser() instanceof Technician || System.getActiveUser() instanceof Director || System.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        //Procura coleção
        Collection collection = museum.getCollectionByName(collectionName).get(0);
        if (collection == null)
            return Utils.NOT_FOUND_ERROR;
        //Procura Items
        Item item = collection.getItemsByID(itemID);
        if (item == null)
            return Utils.NOT_FOUND_ERROR;
        //Realiza movimentação
        return item.returnFromRestauration(timestamp, destination);
    }

    /* -- Funções de Pesquisa -- */

    //Items
    /**
     * Função para pesquisa de Items por seu ID
     * @param ID - ID desejado
     * @return - ArrayList com itens com ID desejado
     */
    public static ArrayList<Item> searchItemByID(String ID){
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return null;

        ArrayList<Item> results = new ArrayList<>();

        for (Collection collection : museum.getCollectionsTreeMap().values()){
            results.add(collection.getItemsByID(ID));
        }

        return results;
    }

    /**
     * Pesquisa item que contenham a substring no nome
     * @param searchString - string desejada
     * @return - retorna ArrayList com itens que contenham searchstring no nome
     */
    public static ArrayList<Item> searchItemByName(String searchString){
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return null;

        ArrayList<Item> results = new ArrayList<>();

        for (Collection collection : museum.getCollectionsTreeMap().values()){
            results.addAll(collection.getItemsByName(searchString));
        }

        results.sort(Comparator.naturalOrder());
        return results;
    }

    //Coleções

    /**
     * Pesquisa coleção por substring no nome
     * @param searchString - substring de pesquisa
     * @return - ArrayList de coleções correspondentes
     */
    public static ArrayList<Collection> searchCollectionByName(String searchString){
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return null;
        return museum.getCollectionByName(searchString);
    }

    //Users
    /**
     * Pesquisa usuários por substring no nome
     * @param searchString - substring de pesquisa
     * @return - ArrayList de usuários correspondentes
     */
    public static ArrayList<Person> searchUsersByName(String searchString){
        if (!(techniciansTreeMap.containsKey(System.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(System.getActiveUser().getCpf())
                || coordinator.getCpf().equals(System.getActiveUser().getCpf())))
            return null;

        //Results array
        ArrayList<Person> results = new ArrayList<>();

        //Get Researchers
        ArrayList<String> cpfs = new ArrayList<>(Utils.searchByPrefix(System.getNameToCPFResearchers(), searchString).values());
        for (String cpf : cpfs)
            results.add(System.getResearchersTreeMap().get(cpf));

        //Get Technicians
        cpfs = new ArrayList<>(Utils.searchByPrefix(System.getNameToCPFTechnicians(), searchString).values());
        for (String cpf : cpfs)
            results.add(System.getTechniciansTreeMap().get(cpf));

        //Get Technicians
        cpfs = new ArrayList<>(Utils.searchByPrefix(System.getNameToCPFDirectors(), searchString).values());
        for (String cpf : cpfs)
            results.add(System.getDirectorsTreeMap().get(cpf));

        //Get Coordinator
        if (coordinator.getName().contains(searchString))
            results.add(coordinator);

        //Return results
        return results;
    }

}
