package model;


import utils.Utils;

import javax.xml.transform.Result;
import java.sql.*;
import java.sql.Date;
import java.util.*;

/**
 * Created by naraujo on 01/06/17.
 */
public final class DatabaseHelper {

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

     /* -- DB INFO -- */
    /* -- DB INFO -- */
    private static String DBNAME = "MuseumSystemDB"; //SUBSTITUAM PELO NOME DO BANCO
    private static String USER = "naraujo";     //SUBSTITUAM AQUI PELO NOME DO USUÁRIO NO BANCO
    private static String PASS = "noaicolas";   //SUBSTITUAM AQUI PELA SENHA NO BANCO

    private static Connection databaseConnection;
    private static Statement statement = null;

    /* -- Popula Arrays -- */
    static{

        //Cria conexão com database
        databaseConnection = null;
        try {
            Class.forName("org.postgresql.Driver");
            databaseConnection = DriverManager
                    .getConnection("jdbc:postgresql://localhost:5432/" + DBNAME,
                            USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String sql = "";

            //Create PERSON
            statement = databaseConnection.createStatement();
            sql =   "CREATE TABLE IF NOT EXISTS PERSON" +
                    " (CPF CHAR(11) PRIMARY KEY NOT NULL," +
                    " NAME VARCHAR(50) NOT NULL," +
                    " PASSWORD VARCHAR(30) NOT NULL," +
                    " EMAIL VARCHAR (30) NOT NULL," +
                    " MATRICULA INT," +
                    " FUNCAO INT NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();

            //Create MUSEUM
            statement = databaseConnection.createStatement();
            sql =   "CREATE TABLE IF NOT EXISTS MUSEUM" +
                    " (CODMUSEUM VARCHAR(10) PRIMARY KEY NOT NULL," +
                    " CPFTECHNICIAN CHAR(11) REFERENCES PERSON(CPF) ON DELETE SET NULL," +
                    " CPFDIRECTOR CHAR(11) REFERENCES PERSON(CPF) ON DELETE SET NULL," +
                    " ADRESS VARCHAR (50) NOT NULL," +
                    " PHONE VARCHAR (10)," +
                    " OPENINGHOURS VARCHAR(30)," +
                    " DESCRIPTION VARCHAR(100))";
            statement.executeUpdate(sql);
            statement.close();

            //Create COLLECTION
            statement = databaseConnection.createStatement();
            sql =   "CREATE TABLE IF NOT EXISTS COLLECTION" +
                    " (COLLECTIONID VARCHAR(10) PRIMARY KEY NOT NULL," +
                    " CODMUSEUM VARCHAR(10) NOT NULL REFERENCES MUSEUM(CODMUSEUM) ON DELETE CASCADE," +
                    " NAME VARCHAR(30) UNIQUE NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();

            //Create ITEM
            statement = databaseConnection.createStatement();
            sql =   "CREATE TABLE IF NOT EXISTS ITEM" +
                    " (ITEMID VARCHAR(15) PRIMARY KEY NOT NULL," +
                    " COLLECTIONID VARCHAR(10) NOT NULL REFERENCES COLLECTION(COLLECTIONID) ON DELETE CASCADE," +
                    " NAME VARCHAR(30) NOT NULL," +
                    " YEAR INT NOT NULL," +
                    " STATUS VARCHAR(18) NOT NULL," +
                    " LENGHT FLOAT," +
                    " HEIGHT FLOAT," +
                    " WIDTH FLOAT," +
                    " THICKNESS FLOAT," +
                    " OUTERCIRCUMFERENCE FLOAT," +
                    " INNERCIRCUMFERENCE FLOAT," +
                    " WEIGHT FLOAT," +
                    " AUTHOR VARCHAR (50)," +
                    " CONSERVATIONSTATE VARCHAR(100)," +
                    " BIOGRAPHY VARCHAR(150)," +
                    " DESCRIPTION VARCHAR (150)," +
                    " HISTORICALCONTEXT VARCHAR (150)," +
                    " AQUISITIONDATE DATE NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();

            //Creates MOVIMENTATION
            statement = databaseConnection.createStatement();
            sql =   "CREATE TABLE IF NOT EXISTS MOVIMENTATION" +
                    " (TIMESTAMP DATE PRIMARY KEY NOT NULL," +
                    " ITEMID VARCHAR(15) NOT NULL REFERENCES ITEM(ITEMID) ON DELETE CASCADE," +
                    " TYPE INTEGER NOT NULL," +
                    " ORIGIN VARCHAR(20) NOT NULL," +
                    " DESTINATION VARCHAR(20) NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();

            //Creates RESTORATION
            statement = databaseConnection.createStatement();
            sql =   "CREATE TABLE IF NOT EXISTS RESTORATION" +
                    " (TIMESTAMP DATE PRIMARY KEY NOT NULL REFERENCES MOVIMENTATION(TIMESTAMP) ON DELETE CASCADE," +
                    " ITEMID VARCHAR(15) NOT NULL REFERENCES ITEM(ITEMID) ON DELETE CASCADE," +
                    " DATEOFRETURN DATE NOT NULL," +
                    " DAMAGE VARCHAR(100) NOT NULL," +
                    " RESTORER VARCHAR(30) NOT NULL," +
                    " REPAIR VARCHAR(100) NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();

            //Creates LOAN
            statement = databaseConnection.createStatement();
            sql =   "CREATE TABLE IF NOT EXISTS LOAN" +
                    " (TIMESTAMP DATE PRIMARY KEY NOT NULL REFERENCES MOVIMENTATION(TIMESTAMP) ON DELETE CASCADE," +
                    " ITEMID VARCHAR(15) NOT NULL REFERENCES ITEM(ITEMID) ON DELETE CASCADE," +
                    " DATEOFRETURN DATE NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();


            /* -- Inserts -- */

            //INSERT COORDINATOR
            statement = databaseConnection.createStatement();
            sql =   "INSERT INTO PERSON (CPF, NAME, PASSWORD, EMAIL, MATRICULA, FUNCAO) " +
                    " VALUES " +
                    "('00000000000', 'Administrador', 'admin'," +
                    " 'admin@admin.admin', null," +
                    Utils.COORDINATOR +
                    ") ON CONFLICT (CPF) DO NOTHING";
            statement.executeUpdate(sql);
            statement.close();

            //INSERT MUSEUM
            statement = databaseConnection.createStatement();
            sql = "INSERT INTO MUSEUM (CODMUSEUM, CPFTECHNICIAN, CPFDIRECTOR, ADRESS, PHONE, OPENINGHOURS, DESCRIPTION)" +
                    " VALUES ('TST', null, null, 'Rua Teste 123', '123123123', '2:00 as 4:00', 'Descricao teste')" +
                    " ON CONFLICT (CODMUSEUM) DO NOTHING ";
            statement.executeUpdate(sql);
            statement.close();

            /* --------------- */
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }


        DatabaseHelper.coordinator = new Coordinator("Administrador", "00000000000", "admin", "admin@admin.admin");
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
        DatabaseHelper.addCollection("Século XXI");
        DatabaseHelper.addCollection("Picasso");
        DatabaseHelper.addCollection("Fezes Animais Raras");

        /* -- Mock Users -- */
        //Adiciona Diretor
        DatabaseHelper.addPerson("Joãozinho", "123123123123", "password", "joao@bonitao.uol.com", museum.getMuseumCode());

        //Adiciona Técnicos
        DatabaseHelper.addPerson("Paulo", "11111111111", "paulo123", "paulo@banco.de.dados");
        DatabaseHelper.addPerson("Lisane", "22222222222", "lisane123", "lisane@diagrama.es");

        //Adiciona Pesquisador
        DatabaseHelper.addPerson("Nicolas", "03369037076", "nicolas123", "nicolas@ufpel.com", 14101238);
        DatabaseHelper.addPerson("Kellerson", "01939512077", "kellerson123", "kellerson@ufpel.com", 14101237);
        DatabaseHelper.addPerson("Xlager", "55555555555", "kellerson123", "kellerson@ufpel.com", 14101236);
        DatabaseHelper.addPerson("Sias", "66666666666", "sias123", "jonathan@ufpel.com", 14101235);

        /* -- Mock Items -- */

        java.sql.Date data = new java.sql.Date(Calendar.getInstance().getTime().getTime());

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                museum.getMuseumCode() + "P99",
                "PS99",
                2099,
                "Museu do Videogame de Roraima",
                "Armazém 51",
                2,
                20,
                40,
                15,
                new java.sql.Date(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                museum.getMuseumCode() + "P50",
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

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                museum.getMuseumCode() + "XB0",
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

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                museum.getMuseumCode() + "MQS",
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

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                museum.getMuseumCode() + "XB.5",
                "Xbox 0.5",
                2099,
                "Museu do Videogame de Rondonia",
                "Armazém 52",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                museum.getMuseumCode() + "NDGS",
                "Nintendo Degraus",
                2024, "Museu do Videogame da Esquina",
                "Armazém 02",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Século XXI",
                "Nintendo Mario",
                museum.getMuseumCode() + "NMR",
                2099,
                "Museu do Videogame dei Berlim",
                "Armazém 51",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Picasso",
                museum.getMuseumCode() + "MLS",
                "Mona Lisa",
                1907, "Museu da Falsificação",
                "Armazém 51",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Picasso",
                museum.getMuseumCode() + "GPDT",
                "O Grito Premeditado",
                1908, "Museu da Falsificação",
                "Armazém 43",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Picasso",
                museum.getMuseumCode() + "GNCA",
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

        DatabaseHelper.addItem(museum.getMuseumCode(),
                "Picasso",
                museum.getMuseumCode() + "AMS",
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

        DatabaseHelper.addItem(museum.getMuseumCode(),
                "Picasso",
                museum.getMuseumCode() + "0MSC",
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

        DatabaseHelper.addItem(museum.getMuseumCode(),
                "Picasso",
                museum.getMuseumCode() + "PXC",
                "Pixacação da Federal",
                2014, "Museu da Falsificação",
                "Armazém 21",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(museum.getMuseumCode(),
                "Fezes Animais Raras",
                museum.getMuseumCode() + "FTRX",
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

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Fezes Animais Raras",
                museum.getMuseumCode() + "FURS",
                "Fezes de Urso",
                1983, "Sítio Arqueológico Papai Noel",
                "Armazém 03",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Fezes Animais Raras",
                museum.getMuseumCode() + "LUZZ",
                "Cérebro do Felipe",
                2017,
                "Dom Joaquim, Pelotas",
                "Armazém 21",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Fezes Animais Raras",
                museum.getMuseumCode() + "FAEPT",
                "Fezes de Aedes Egypt",
                2008,
                "Pneu do Terreno Baldio",
                "Armazém 32",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(museum.getMuseumCode(),
                "Fezes Animais Raras",
                "FZTTM",
                "Fezes de Tutancamon",
                200,
                "Pirâmide",
                "Armazém 76",
                2,
                20,
                40,
                15,
                new Date(java.lang.System.currentTimeMillis()));

        DatabaseHelper.addItem(
                museum.getMuseumCode(),
                "Fezes Animais Raras",
                "FZCSC",
                "Fezes do Cusco",
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


    private DatabaseHelper(){}

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
        DatabaseHelper.activeUser = activeUser;
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


        Statement stm = null;
        try {
            stm = databaseConnection.createStatement();
            String sql =    "INSERT INTO PERSON " +
                    "(CPF, NAME, PASSWORD, EMAIL, MATRICULA, FUNCAO) " +
                    "VALUES (" +
                            CPF + "," +
                            "'"+ name + "'" + "," +
                            "'"+ password + "'" + "," +
                            "'"+ email + "'" + "," +
                            universityRegistration + "," +
                            Utils.RESEARCHER +
                    ") ON CONFLICT (CPF) DO NOTHING ";
            stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

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

        Statement stm = null;
        try {
            stm = databaseConnection.createStatement();
            String sql =    "INSERT INTO PERSON " +
                    "(CPF, NAME, PASSWORD, EMAIL, MATRICULA, FUNCAO) " +
                    "VALUES (" +
                    CPF + "," +
                    "'"+ name + "'" + "," +
                    "'"+ password + "'" + "," +
                    "'"+ email + "'" + "," +
                    null + "," +
                    Utils.TECHNICIAN +
                    ") ON CONFLICT (CPF) DO NOTHING ";
            stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

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

        Statement stm = null;
        try {
            stm = databaseConnection.createStatement();
            String sql =    "INSERT INTO PERSON " +
                    "(CPF, NAME, PASSWORD, EMAIL, MATRICULA, FUNCAO) " +
                    "VALUES (" +
                        CPF + "," +
                        "'"+ name + "'" + "," +
                        "'"+ password + "'" + "," +
                        "'"+ email + "'" + "," +
                        null + "," +
                        Utils.DIRECTOR +
                    ") ON CONFLICT (CPF) DO NOTHING ";
            stm.executeUpdate(sql);

            //TODO: ADD DIRECTOR CPF INTO MUSEUM

            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

        Director director = new Director(name, CPF, password, email, IDMuseum);
        directorsTreeMap.put(CPF, director);
        nameToCPFDirectors.put(name, CPF);

        museum.setDirector(director);

        return Utils.REQUEST_OK;
    }

    //Collections
    public static int addCollection(String name){
        //Testa permissão
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || coordinator.getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        Statement stm = null;
        try {
            stm = databaseConnection.createStatement();
            Statement stm2 = databaseConnection.createStatement();

            ResultSet resultSet = stm2.executeQuery("SELECT COUNT(DISTINCT COLLECTIONID) AS NUMCOL FROM COLLECTION");
            resultSet.next();
            int collectionID = resultSet.getInt("NUMCOL");

            if (collectionID < 10000)
                collectionID = Integer.parseInt("0" + collectionID);
            if (collectionID < 1000)
                collectionID = Integer.parseInt("0" + collectionID);
            if (collectionID < 100)
                collectionID = Integer.parseInt("0" + collectionID);
            if (collectionID < 10)
                collectionID = Integer.parseInt("0" + collectionID);



            String sql =    "INSERT INTO COLLECTION " +
                    "(COLLECTIONID, CODMUSEUM, NAME) " +
                    "VALUES (" +
                       "'" + collectionID + "'," +
                        "'" + museum.getMuseumCode() + "'," +
                        "'" + name + "'" +
                    ") ON CONFLICT (NAME) DO NOTHING";
            stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

        return (museum.addCollection(name));
    }

    public static int addItem(String museumCode, String collectionName, String itemID, String name, int year, String origin, String destination,
                              float weight, float lenght, float width, float height, java.sql.Date aquisitionDate){

        //Testa permissão
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || coordinator.getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;

        try {
            //Crates statement
            statement = databaseConnection.createStatement();

            //Querys for CollectionID
            String sql = "SELECT * FROM collection WHERE NAME = '" + collectionName + "'";
            ResultSet resultSet = statement.executeQuery(sql);

            String collectionID;
            if (resultSet.next())
                collectionID = resultSet.getString("COLLECTIONID");
            else
                return Utils.NOT_FOUND_ERROR;   //Collection not found

            //Creates SQL for insertion
            sql =   "INSERT INTO ITEM" +
                    "(ITEMID, COLLECTIONID, NAME, YEAR, STATUS, LENGHT," +
                    " OUTERCIRCUMFERENCE, INNERCIRCUMFERENCE, WEIGHT," +
                    " AUTHOR, CONSERVATIONSTATE, BIOGRAPHY, DESCRIPTION, AQUISITIONDATE)" +
                    "VALUES (" +
                    "'" + itemID + "'," +
                    "'" + collectionID + "'," +
                    "'" + name + "'," +
                    year + "," +
                    "'" + Utils.AT_STORAGE + "'," +
                    lenght + "," +
                    null + "," + //Falta parâmetro
                    null + "," + //Falta parâmetro
                    weight + "," +
                    null + "," + //Falta parâmetro
                    null + "," + //Falta parâmetro
                    null + "," + //Falta parâmetro
                    null + "," + //Falta parâmetro
                    "'" + aquisitionDate + "'" +
                    ") ON CONFLICT (ITEMID) DO NOTHING ";

            //Execute Statement
            statement.executeUpdate(sql);

            //Close Statement
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

        return Utils.REQUEST_OK;

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
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || coordinator.getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
            return Utils.PERMISSION_ERROR;


        try {
            //INSERT COORDINATOR
            statement = databaseConnection.createStatement();
            String sql =
                    "INSERT INTO MOVIMENTATION (TIMESTAMP, ITEMID, ORIGIN, DESTINATION, TYPE) " +
                    " VALUES (" +
                    timestamp + ", " +
                    itemID + ", " +
                    "ORIGIN" + ", " + //TODO: QUERY FOR LAST MOVIMENTATION AND GET DESTINATION TO SET AS NEW ORIGIN
                    null + ", " +   //discharge movimentation has no destination
                    Utils.DISCHARGE +
                    ") ON CONFLICT (timestamp) DO NOTHING";
            statement.executeUpdate(sql);
            statement.close();



        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }




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
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || coordinator.getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
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
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || coordinator.getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
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
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || coordinator.getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
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
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || coordinator.getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
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
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || coordinator.getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
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
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;
        if (!(techniciansTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || coordinator.getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
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
        if (!(techniciansTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || coordinator.getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
            return null;

        ArrayList<Item> objectsArray = new ArrayList<>();

        try {

            //Make query
            statement = databaseConnection.createStatement();
            String sql = "SELECT * FROM ITEM WHERE UPPER(ITEMID) LIKE UPPER('%" + ID + "%')";
            ResultSet resultSet = statement.executeQuery(sql);

            objectsArray = itemResultSetToArray(resultSet);

            //Closes statement
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }
        return objectsArray;
    }

    /**
     * Pesquisa item que contenham a substring no nome
     * @param searchString - string desejada
     * @return - retorna ArrayList com itens que contenham searchstring no nome
     */
    public static ArrayList<Item> searchItemByName(String searchString){
        if (!(techniciansTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || coordinator.getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
            return null;

        ArrayList<Item> objectsArray = new ArrayList<>();

        try {

            //Make query
            statement = databaseConnection.createStatement();
            String sql = "SELECT * FROM ITEM WHERE UPPER(NAME) LIKE UPPER('%" + searchString + "%')";
            ResultSet resultSet = statement.executeQuery(sql);

            objectsArray = itemResultSetToArray(resultSet);

            //Closes statement
            statement.close();
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }
        return objectsArray;
    }

    private static ArrayList<Item> itemResultSetToArray(ResultSet resultSet){

        ArrayList<Item> objectsArray = new ArrayList<>();
        try {
            //Puts results in array list
            while (resultSet.next()) {
                //Gets info
                //Basic info
                String resultsID = resultSet.getString(("itemid"));
                String resultsName = resultSet.getString(("name"));
                int resultsYear = resultSet.getInt(("year"));
                String resultsStatus = resultSet.getString(("status"));
                //Measures
                float resultsLenght = resultSet.getFloat("lenght");
                //float resultsHeight = resultSet.getFloat("height");
                float resultsHeight = 0.0f;
                float resultsWidht = resultSet.getFloat("width");
                float resultsThickness = resultSet.getFloat("thickness");
                float resultsOuterCircumference = resultSet.getFloat("outerCircumference");
                float resultsInnerCircumference = resultSet.getFloat("innerCircumference");
                float resultsWeight = resultSet.getFloat("weight");
                //Extra info
                String resultsAuthor = resultSet.getString(("author"));
                String resultsConservationState = resultSet.getString(("conservationState"));
                String resultsHistoricalContext = resultSet.getString(("historicalContext"));
                String resultsBiography = resultSet.getString(("biography"));
                String resultsDescription = resultSet.getString(("description"));

                //TODO: GETS ITEM ORIGIN AND DESTINATION FROM ENTRY MOVIMENTATION
                String resultsOrigin = "NO ENTRY";
                String resultsDestination = "NO ENTRY";

                //Creates object
                Item item = new Item(
                        resultsID,
                        resultsName,
                        resultsYear,
                        resultsOrigin,
                        resultsDestination,
                        resultsWeight,
                        resultsLenght,
                        resultsWidht,
                        resultsHeight, resultsThickness,
                        resultsDescription,
                        resultsAuthor,
                        resultsOuterCircumference,
                        resultsInnerCircumference,
                        0,
                        resultsStatus);
                item.setConservationState(resultsConservationState);
                item.setHistoricalContext(resultsHistoricalContext);
                item.setBiography(resultsBiography);

                //Add object to array
                objectsArray.add(item);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }
        return objectsArray;
    }

    //Coleções
    /**
     * Pesquisa coleção por substring no nome
     * @param searchString - substring de pesquisa
     * @return - ArrayList de coleções correspondentes
     */
    public static ArrayList<Collection> searchCollectionByName(String searchString){
        if (!(techniciansTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || coordinator.getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
            return null;

        ArrayList<Collection> objectsArray = new ArrayList<>();

        try {
            //Crates statement
            statement = databaseConnection.createStatement();

            //Querys for CollectionID
            String sql = "SELECT * FROM collection WHERE NAME = UPPER('%" + searchString + "%')";
            ResultSet resultSet = statement.executeQuery(sql);


            //Puts results in array list
            while (resultSet.next()) {
                //Gets info
                //Basic info
                String resultsID = resultSet.getString(("collectionid"));
                String resultsCodMuseum = resultSet.getString(("codmuseum"));
                String resultsName = resultSet.getString(("name"));

                //Creates object
                Collection collection = new Collection(
                        resultsID,
                        resultsCodMuseum,
                        resultsName
                );
                //Add object to array
                objectsArray.add(collection);
            }


        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

        return objectsArray;
    }

    //Users
    /**
     * Pesquisa usuários por substring no nome
     * @param searchString - substring de pesquisa
     * @return - ArrayList de usuários correspondentes
     */
    public static ArrayList<Person> searchUsersByName(String searchString) {
        if (!(techniciansTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || directorsTreeMap.containsKey(DatabaseHelper.getActiveUser().getCpf())
                || coordinator.getCpf().equals(DatabaseHelper.getActiveUser().getCpf())))
            return null;

        //Results array
        ArrayList<Person> objectsArray = new ArrayList<>();

        try {
            //Crates statement
            statement = databaseConnection.createStatement();

            //Querys for CollectionID
            String sql = "SELECT * FROM PERSON WHERE NAME = UPPER('%" + searchString + "%')";
            ResultSet resultSet = statement.executeQuery(sql);


            //Puts results in array list
            while (resultSet.next()) {
                //Gets info
                //Basic info
                String resultsCPF = resultSet.getString(("cpf"));
                String resultsName = resultSet.getString(("name"));
                String resultsPassword = resultSet.getString("password");
                String resultsEmail = resultSet.getString(("email"));
                int resultsMatricula = resultSet.getInt(("matricula"));
                int resultsFuncao = resultSet.getInt(("funcao"));

                //Creates object
                Person person;
                switch (resultsFuncao){
                    case Utils.RESEARCHER:
                        person = new Researcher(resultsName, resultsCPF, resultsPassword, resultsEmail, resultsMatricula);
                        break;
                    case Utils.TECHNICIAN:
                        person = new Technician(resultsName, resultsCPF, resultsPassword, resultsEmail);
                        break;
                    case Utils.DIRECTOR:
                        //Query for MuseumID
                        sql = "SELECT codmuseum FROM museum WHERE cpfdirector = UPPER('" + resultsCPF + "')";
                        ResultSet museums = statement.executeQuery(sql);

                        String codMuseum = "";
                        if (museums.next()){
                            codMuseum = museums.getString("codmuseum");
                        }

                        //Creates Director
                        person = new Director(resultsName, resultsCPF, resultsPassword, resultsEmail, codMuseum);
                        break;
                    case Utils.COORDINATOR:
                        person = new Coordinator(resultsName, resultsCPF, resultsPassword, resultsEmail);
                        break;
                    default:
                        person = new Technician(resultsName, resultsCPF, resultsPassword, resultsEmail);
                        break;
                }

                //Add object to array
                objectsArray.add(person);
            }
            statement.closeOnCompletion();
        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

        return objectsArray;
    }

}