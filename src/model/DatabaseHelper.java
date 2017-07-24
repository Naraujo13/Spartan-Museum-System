package model;


import utils.Utils;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.*;

/**
 * Created by naraujo on 01/06/17.
 */
public final class DatabaseHelper {

    /* ------- Usuários ------- */

     /* -- Usuário Ativo -- */
     private static Person activeUser;
     private static Museum museum;

     /* -- DB INFO -- */
    /* -- DB INFO -- */
    private static String DBNAME = "MuseumSystemDB"; //SUBSTITUAM PELO NOME DO BANCO
    private static String USER = "postgres";     //SUBSTITUAM AQUI PELO NOME DO USUÁRIO NO BANCO
    private static String PASS = "admin";   //SUBSTITUAM AQUI PELA SENHA NO BANCO

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
            String sql;

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
                    " NAME VARCHAR (30) NOT NULL," +
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
                    " (TIMESTAMP TIMESTAMP PRIMARY KEY NOT NULL," +
                    " ITEMID VARCHAR(15) NOT NULL REFERENCES ITEM(ITEMID) ON DELETE CASCADE," +
                    " CPFAUTHOR CHAR(11) NOT NULL REFERENCES PERSON(CPF) ON DELETE RESTRICT," +
                    " TYPE INTEGER NOT NULL," +
                    " ORIGIN VARCHAR(30) NOT NULL," +
                    " DESTINATION VARCHAR(30)" +
                    ")";
            statement.executeUpdate(sql);
            statement.close();

            //Creates RESTORATION
            statement = databaseConnection.createStatement();
            sql =   "CREATE TABLE IF NOT EXISTS RESTORATION" +
                    " (TIMESTAMP TIMESTAMP PRIMARY KEY NOT NULL REFERENCES MOVIMENTATION(TIMESTAMP) ON DELETE CASCADE," +
                    " ITEMID VARCHAR(15) NOT NULL REFERENCES ITEM(ITEMID) ON DELETE CASCADE," +
                    " DATEOFRETURN TIMESTAMP NOT NULL," +
                    " DAMAGE VARCHAR(100) NOT NULL," +
                    " RESTORER VARCHAR(40) NOT NULL," +
                    " REPAIR VARCHAR(100) NOT NULL)";
            statement.executeUpdate(sql);
            statement.close();

            //Creates LOAN
            statement = databaseConnection.createStatement();
            sql =   "CREATE TABLE IF NOT EXISTS LOAN" +
                    " (TIMESTAMP TIMESTAMP PRIMARY KEY NOT NULL REFERENCES MOVIMENTATION(TIMESTAMP) ON DELETE CASCADE," +
                    " ITEMID VARCHAR(15) NOT NULL REFERENCES ITEM(ITEMID) ON DELETE CASCADE," +
                    " DATEOFRETURN TIMESTAMP NOT NULL)";
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

            activeUser = new Coordinator("Administrador", "00000000000","admin", "admin@admin.admin");

            //INSERT MUSEUM
            statement = databaseConnection.createStatement();
            sql = "INSERT INTO MUSEUM (CODMUSEUM, NAME, CPFTECHNICIAN, CPFDIRECTOR, ADRESS, PHONE, OPENINGHOURS, DESCRIPTION)" +
                    " VALUES ('TST', 'Teste', null, null, 'Rua Teste 123', '123123123', '2:00 as 4:00', 'Descricao teste')" +
                    " ON CONFLICT (CODMUSEUM) DO NOTHING ";
            statement.executeUpdate(sql);
            statement.close();

            museum = new Museum(
                    "TST",
                    "Teste",
                    "Rua Teste 123",
                    "123123123",
                    "teste@museum.org",
                    "2:00 as 4:00");
            museum.setDescription("Descrição Teste");

            /* --------------- */
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }



        /* -- Mock Collections -- */
        Collection secXXI, picasso, fezes;
        DatabaseHelper.addCollection("Século XXI");
        DatabaseHelper.addCollection("Picasso");
        DatabaseHelper.addCollection("Fezes Animais Raras");

        /* -- Mock Users -- */
        //Adiciona Diretor
        //Adiciona Técnicos
        DatabaseHelper.addPerson("Paulo", "11111111111", "paulo123", "paulo@banco.de.dados");
        DatabaseHelper.addPerson("Lisane", "22222222222", "lisane123", "lisane@diagrama.es");
        DatabaseHelper.addPerson("Lisane2", "0", "0", "lisane2@diagrama.es");

        //Adiciona Pesquisador
        DatabaseHelper.addPerson("Nicolas", "03369037076", "nicolas123", "nicolas@ufpel.com", 14101238);
        DatabaseHelper.addPerson("Kellerson", "01939512077", "kellerson123", "kellerson@ufpel.com", 14101237);
        DatabaseHelper.addPerson("Xlager", "55555555555", "kellerson123", "kellerson@ufpel.com", 14101236);
        DatabaseHelper.addPerson("Sias", "66666666666", "sias123", "jonathan@ufpel.com", 14101235);

        /* -- Mock Items -- */

        DatabaseHelper.addItem(
                "TST",
                "Século XXI",
                "TST" + "P99",
                "PS99",
                2099,
                "Museu do Videogame de Roraima",
                "Armazém 51",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Século XXI",
                "TST" + "P50",
                "PS50",
                2050,
                "Museu do Videogame do Piauí",
                "Armazém 56",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Século XXI",
                "TST" + "XB0",
                "Xbox 0",
                2050,
                "Museu do Videogame de Roraima",
                "Armazém 535",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Século XXI",
                "TST" + "MQS",
                "A mulher que sorri",
                1974,
                "Museu do Videogame da Paraíba",
                "Armazém 21",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Século XXI",
                "TST" + "XB.5",
                "Xbox 0.5",
                2099,
                "Museu do Videogame de Rondonia",
                "Armazém 52",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Século XXI",
                "TST" + "NDGS",
                "Nintendo Degraus",
                2024, "Museu do Videogame da Esquina",
                "Armazém 02",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Século XXI",
                "Nintendo Mario",
                "TST" + "NMR",
                2099,
                "Museu do Videogame dei Berlim",
                "Armazém 51",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Picasso",
                "TST" + "MLS",
                "Mona Lisa",
                1907, "Museu da Falsificação",
                "Armazém 51",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Picasso",
                "TST" + "GPDT",
                "O Grito Premeditado",
                1908, "Museu da Falsificação",
                "Armazém 43",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Picasso",
                "TST" + "GNCA",
                "Guernica",
                1937,
                "Museu da Falsificação",
                "Armazém 54",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Picasso",
                "TST" + "AMS",
                "A mulher que sorri",
                1974,
                "Museu da Falsificação",
                "Armazém 53",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Picasso",
                "TST" + "0MSC",
                "Zero Musicians",
                1900,
                "Museu da Falsificação",
                "Armazém 51",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Picasso",
                "TST" + "PXC",
                "Pixacação da Federal",
                2014, "Museu da Falsificação",
                "Armazém 21",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Fezes Animais Raras",
                "TST" + "FTRX",
                "Fezes de T-Rex",
                0,
                "Sítio Arqueológico do Amapá",
                "Armazém 76",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Fezes Animais Raras",
                "TST" + "FURS",
                "Fezes de Urso",
                1983, "Sítio Arqueológico Papai Noel",
                "Armazém 03",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Fezes Animais Raras",
                "TST" + "LUZZ",
                "Cérebro do Felipe",
                2017,
                "Dom Joaquim, Pelotas",
                "Armazém 21",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
                "Fezes Animais Raras",
                "TST" + "FAEPT",
                "Fezes de Aedes Egypt",
                2008,
                "Pneu do Terreno Baldio",
                "Armazém 32",
                2,
                20,
                40,
                15,
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        DatabaseHelper.addItem(
                "TST",
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
                new Timestamp(java.lang.System.currentTimeMillis()));

        DatabaseHelper.addItem(
                "TST",
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
                new Timestamp(java.lang.System.currentTimeMillis())
        );

        /* -- Mock Movimentations -- */





    }
    /* ---------------------- */


    private DatabaseHelper(){}

    public static Person getActiveUser() {
        return activeUser;
    }

    public static Museum getMuseum() {
        return museum;
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
        try {
            statement = databaseConnection.createStatement();
            String sql = "SELECT * FROM PERSON WHERE UPPER(CPF) = UPPER('" + cpf + "')";

            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String resultsCpf = resultSet.getString("CPF");
                String resultsPassword = resultSet.getString("PASSWORD");

                if (!password.equals(resultsPassword))
                    return Utils.PERMISSION_ERROR;  //Wrong Password

                String resultsName = resultSet.getString("NAME");
                String resultsEmail = resultSet.getString("EMAIL");
                int resultsMatricula = resultSet.getInt("MATRICULA");
                int resultsFuncao = resultSet.getInt("FUNCAO");

                switch (resultsFuncao){
                    case Utils.RESEARCHER:
                        newUser = new Researcher(resultsName, resultsCpf, resultsPassword, resultsEmail, resultsMatricula);
                        break;
                    case Utils.TECHNICIAN:
                        newUser = new Technician(resultsName, resultsCpf, resultsPassword, resultsEmail);
                        break;
                    case Utils.DIRECTOR:
                        sql = "SELECT codmuseum FROM museum WHERE cpfdirector = UPPER('" + resultsCpf + "')";
                        ResultSet museums = statement.executeQuery(sql);
                        String codMuseum = "";
                        if (museums.next())
                            codMuseum = museums.getString("codmuseum");
                        newUser = new Director(resultsName, resultsCpf, resultsPassword, resultsEmail, codMuseum);
                        break;
                    case Utils.COORDINATOR:
                        newUser = new Coordinator(resultsName, resultsCpf, resultsPassword, resultsEmail);
                        break;
                    default:
                        newUser = new Researcher(resultsName, resultsCpf, resultsPassword, resultsEmail, resultsMatricula);
                        break;
                }

            }
            else
                return Utils.NOT_FOUND_ERROR;

            activeUser = newUser;
            statement.close();
            return Utils.REQUEST_OK;
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return Utils.FORBIDDEN_ERROR;
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
                    ") ON CONFLICT (CPF) DO UPDATE SET " +
                        "name = EXCLUDED.name," +
                        "password = EXCLUDED.password," +
                        "email = EXCLUDED.email," +
                        "matricula = EXCLUDED.matricula";
            stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }
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
                    ") ON CONFLICT (CPF) DO UPDATE SET " +
                        "name = EXCLUDED.name," +
                        "password = EXCLUDED.password," +
                        "email = EXCLUDED.email";
            stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

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

        try {
            statement = databaseConnection.createStatement();
            String sql =    "INSERT INTO PERSON " +
                    "(CPF, NAME, PASSWORD, EMAIL, MATRICULA, FUNCAO) " +
                    "VALUES (" +
                        CPF + "," +
                        "'"+ name + "'" + "," +
                        "'"+ password + "'" + "," +
                        "'"+ email + "'" + "," +
                        null + "," +
                        Utils.DIRECTOR +
                    ") ON CONFLICT (CPF) DO UPDATE SET " +
                    "name = EXCLUDED.name," +
                    "password = EXCLUDED.password," +
                    "email = EXCLUDED.email";
            statement.executeUpdate(sql);

            //Add Director's CPF to MUSEUM
            sql = "UPDATE MUSEUM " +
                    "SET cpfdirector = '" + CPF + "' " +
                    "WHERE UPPER(codmuseum) = UPPER('" + IDMuseum + "')";
            statement.executeUpdate(sql);

            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

        return Utils.REQUEST_OK;
    }

    //Collections
    public static int addCollection(String name){
        //Testa permissão
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;


        try {
            statement = databaseConnection.createStatement();
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
            statement.executeUpdate(sql);
            statement.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

        return Utils.REQUEST_OK;
    }

    public static int addItem(String museumCode, String collectionName, String itemID, String name, int year, String origin, String destination,
                              float weight, float lenght, float width, float height, Timestamp aquisitionDate){

        //Testa permissão
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
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
                    ") ON CONFLICT (ITEMID) DO UPDATE SET " +
                        "itemid = EXCLUDED.itemid," +
                        "collectionid = EXCLUDED.collectionid," +
                        "name = EXCLUDED.name," +
                        "year = EXCLUDED.year," +
                        "lenght = EXCLUDED.lenght," +
                        //Parametros que faltam
                        "weight = EXCLUDED.weight";
                        //Mais parâmetros que faltam
            //Execute Statement
            statement.executeUpdate(sql);
            statement.close();

            //Verify if this itemID is already in the movimentation table, if it is, it already has an admission movimentation
            statement = databaseConnection.createStatement();
            sql = "SELECT * FROM movimentation WHERE itemid = '" + itemID + "'";
            resultSet = statement.executeQuery(sql);
            if(!resultSet.next()) {

                //Inserts admission in MOVIMENTATION
                sql = "INSERT INTO MOVIMENTATION " +
                        "(timestamp, itemid, cpfauthor, type, origin, destination) " +
                        " VALUES(" +
                        " '" + new Timestamp(System.currentTimeMillis()) + "'," +
                        " '" + itemID + "'," +
                        " '" + activeUser.getCpf() + "'," +
                        " '" + Utils.ADMISSION + "'," +
                        " '" + origin + "'," +
                        " '" + destination + "'" +
                        ") ON CONFLICT (timestamp) DO NOTHING ";
                statement.executeUpdate(sql);
                statement.closeOnCompletion();
            }

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

        return Utils.REQUEST_OK;

    }



    public static int addItem(String itemID, String collectionName, String name, String year,  String lenght, String ItemHeight, String ItemWidth, String thickness, String itemOutnerCircumference,
                              String itemInnerCircumference, String weight, String author, String itemConservationState, String itemBiography, String itemDescription,
                              String  ItemHistoricalContext, String itemAquisitionDate, String origin, String destination){

        //Testa permissão
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
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
                    "(ITEMID, COLLECTIONID, NAME, YEAR, STATUS, LENGHT, HEIGHT, WIDTH, THICKNESS," +
                    " OUTERCIRCUMFERENCE, INNERCIRCUMFERENCE, WEIGHT," +
                    " AUTHOR, CONSERVATIONSTATE, BIOGRAPHY, DESCRIPTION, HISTORICALCONTEXT, AQUISITIONDATE)" +
                    "VALUES (" +
                        "'" + itemID + "'," +
                        "'" + collectionID + "'," +
                        "'" + name + "'," +
                        year + "," +
                        "'" + Utils.AT_STORAGE + "'," +
                        lenght + "," +
                        ItemHeight + "," +
                        ItemWidth + "," +
                        thickness + "," +
                        itemOutnerCircumference + "," +
                        itemInnerCircumference + "," +
                        weight + "," +
                        "'" + author + "'," +
                        "'" + itemConservationState + "'," +
                        "'" + itemBiography + "'," +
                        "'" + itemDescription + "'," +
                        "'" + ItemHistoricalContext + "'," +
                        "'" + itemAquisitionDate + "'" +
                    ") ON CONFLICT (ITEMID) DO UPDATE SET " +
                    "collectionid = EXCLUDED.collectionid," +
                    "name = EXCLUDED.name," +
                    "year = EXCLUDED.year," +
                    "lenght = EXCLUDED.lenght," +
                    "width = EXCLUDED.width," +
                    "thickness = EXCLUDED.thickness," +
                    "outercircumference = EXCLUDED.outercircumference," +
                    "innercircumference = EXCLUDED.innercircumference," +
                    "weight = EXCLUDED.weight," +
                    "author = EXCLUDED.author," +
                    "conservationstate = EXCLUDED.conservationstate," +
                    "biography = EXCLUDED.biography," +
                    "description = EXCLUDED.description," +
                    "historicalcontext = EXCLUDED.historicalcontext";

            //Execute Statement
            statement.executeUpdate(sql);
            statement.close();

            //Verify if this itemID is already in the movimentation table, if it is, it already has an admission movimentation
            statement = databaseConnection.createStatement();
            sql = "SELECT * FROM movimentation WHERE itemid = '" + itemID + "'";
            resultSet = statement.executeQuery(sql);
            if(!resultSet.next()) {

                //Inserts admission in MOVIMENTATION
                sql = "INSERT INTO MOVIMENTATION " +
                        "(timestamp, itemid, cpfauthor, type, origin, destination) " +
                        " VALUES(" +
                        " '" + new Timestamp(System.currentTimeMillis()) + "'," +
                        " '" + itemID + "'," +
                        " '" + activeUser.getCpf() + "'," +
                        " '" + Utils.ADMISSION + "'," +
                        " '" + origin + "'," +
                        " '" + destination + "'" +
                        ") ON CONFLICT (timestamp) DO NOTHING ";
                statement.executeUpdate(sql);
                statement.closeOnCompletion();
            }

        } catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

        return Utils.REQUEST_OK;

    }

    //Movimentation

    /**
     * Função para dar baixa em um item
     * @param itemID - ID do item
     * @param timestamp - Timestamp da Movimentação de Baixa
     * @return - inteiro representando status (definidos em Utils)
     */
    public static int dischargeItem(String itemID, Timestamp timestamp){
        //Testa permissão
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;

        try {

            //Get last destination of that item
            String origin = "";
            statement = databaseConnection.createStatement();
            String sql = "SELECT * FROM movimentation WHERE itemid = '" + itemID + "' ORDER BY timestamp DESC LIMIT 1";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                origin = resultSet.getString("destination");
            }
            statement.close();

            statement = databaseConnection.createStatement();
            sql =
                    "INSERT INTO MOVIMENTATION (TIMESTAMP, ITEMID, CPFAUTHOR, ORIGIN, DESTINATION, TYPE) " +
                    " VALUES (" +
                            "'" + timestamp + "', " +
                            "'" + itemID + "', " +
                            "'" + activeUser.getCpf() + "', " +
                            "'" + origin + "', " +
                            null + ", " +   //discharge movimentation has no destination
                            Utils.DISCHARGE +
                    ") ON CONFLICT (timestamp) DO NOTHING";
            statement.executeUpdate(sql);
            statement.close();

        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return Utils.FORBIDDEN_ERROR;
        }

        return Utils.REQUEST_OK;

    }

    /**
     * Função para realizar empréstimo de item
     * @param itemID - ID do item
     * @param timestamp - Timestamp da Movimentação de Empréstimo
     * @param dateOfReturn - Data esperada de retorno
     * @param destination - Destino do Empréstimo
     * @return - inteiro representando status (definidos em Utils)
     */
    public static int loanItem(String itemID, Timestamp timestamp, String dateOfReturn, String destination){
        //Testa permissão
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;

        try {

            //Get last destination of that item
            String origin = "";
            statement = databaseConnection.createStatement();
            String sql = "SELECT * FROM movimentation WHERE itemid = '" + itemID + "' ORDER BY timestamp DESC LIMIT 1";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                origin = resultSet.getString("destination");
            }
            statement.close();

            statement = databaseConnection.createStatement();
            sql =
                    "INSERT INTO MOVIMENTATION (TIMESTAMP, ITEMID, CPFAUTHOR, ORIGIN, DESTINATION, TYPE) " +
                            " VALUES (" +
                            "'" + timestamp + "', " +
                            "'" + itemID + "', " +
                            "'" + activeUser.getCpf() + "', " +
                            "'" + origin + "', " +
                            "'" + destination + "', " +
                            Utils.SEND_TO_LOAN +
                            ") ON CONFLICT (timestamp) DO NOTHING";
            statement.executeUpdate(sql);
            statement.close();

            statement = databaseConnection.createStatement();
            sql = "INSERT INTO LOAN(TIMESTAMP, ITEMID, DATEOFRETURN) " +
                    " VALUES(" +
                    " '" + timestamp + "'," +
                    " '" + itemID + "'," +
                    " '" + dateOfReturn + "'" +
                    ") ON CONFLICT (TIMESTAMP) DO NOTHING";
            statement.executeUpdate(sql);
            statement.closeOnCompletion();

        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return Utils.FORBIDDEN_ERROR;
        }

        return Utils.REQUEST_OK;
    }

    /**
     * Função para realizar envio de item à restauração
     * @param itemID - ID do item
     * @param timestamp - Timestamp da Movimentação de Empréstimo
     * @param destination - Destino do Empréstimo
     * @return - inteiro representando status (definidos em Utils)
     */
    public static int restoreItem(String itemID, Timestamp timestamp, String destination, String dateOfReturn, String damage, String restorer, String repair){
        //Testa permissão
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;

        try {

            //Get last destination of that item
            String origin = "";
            statement = databaseConnection.createStatement();
            String sql = "SELECT * FROM movimentation WHERE itemid = '" + itemID + "' ORDER BY timestamp DESC LIMIT 1";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                origin = resultSet.getString("destination");
            }
            statement.close();

            statement = databaseConnection.createStatement();
            sql =
                    "INSERT INTO MOVIMENTATION (TIMESTAMP, ITEMID, CPFAUTHOR, ORIGIN, DESTINATION, TYPE) " +
                            " VALUES (" +
                            "'" + timestamp + "', " +
                            "'" + itemID + "', " +
                            "'" + activeUser.getCpf() + "', " +
                            "'" + origin + "', " +
                            "'" + destination + "', " +
                            Utils.SEND_TO_RESTORATION +
                            ") ON CONFLICT (timestamp) DO NOTHING";
            statement.executeUpdate(sql);
            statement.close();

            statement = databaseConnection.createStatement();
            sql =
                    "INSERT INTO restoration (timestamp, itemid, dateofreturn, damage, restorer, repair) " +
                            "VALUES (" +
                            "'" + timestamp + "'," +
                            "'" + itemID + "'," +
                            "'" + dateOfReturn + "'," +
                            "'" + damage + "'," +
                            "'" + restorer + "'," +
                            "'" + repair + "'" +
                            ") ON CONFLICT (timestamp) DO NOTHING ";
            statement.executeUpdate(sql);
            statement.close();

        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return Utils.FORBIDDEN_ERROR;
        }

        return Utils.REQUEST_OK;
    }

    public static int storeItem(String itemID, Timestamp timestamp, String destination){
        //Testa permissão
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;

        try {
            //Get last destination of that item
            String origin = "";
            statement = databaseConnection.createStatement();
            String sql = "SELECT * FROM movimentation WHERE itemid = '" + itemID + "' ORDER BY timestamp DESC LIMIT 1";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                origin = resultSet.getString("destination");
            }
            statement.close();

            statement = databaseConnection.createStatement();
            sql =
                    "INSERT INTO MOVIMENTATION (TIMESTAMP, ITEMID, CPFAUTHOR, ORIGIN, DESTINATION, TYPE) " +
                            " VALUES (" +
                            "'" + timestamp + "', " +
                            "'" + itemID + "', " +
                            "'" + activeUser.getCpf() + "', " +
                            "'" + origin + "', " +
                            "'" + destination + "', " +
                            Utils.PUT_TO_STORAGE +
                            ") ON CONFLICT (timestamp) DO NOTHING";
            statement.executeUpdate(sql);
            statement.close();

        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return Utils.FORBIDDEN_ERROR;
        }

        return Utils.REQUEST_OK;
    }

    public static int exposeItem(String itemID, Timestamp timestamp, String destination) {
        //Testa permissão
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;

        try {
            //Get last destination of that item
            String origin = "";
            statement = databaseConnection.createStatement();
            String sql = "SELECT * FROM movimentation WHERE itemid = '" + itemID + "' ORDER BY timestamp DESC LIMIT 1";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                origin = resultSet.getString("destination");
            }
            statement.close();

            statement = databaseConnection.createStatement();
            sql =
                    "INSERT INTO MOVIMENTATION (TIMESTAMP, ITEMID, CPFAUTHOR, ORIGIN, DESTINATION, TYPE) " +
                            " VALUES (" +
                            "'" + timestamp + "', " +
                            "'" + itemID + "', " +
                            "'" + activeUser.getCpf() + "', " +
                            "'" + origin + "', " +
                            "'" + destination + "', " +
                            Utils.PUT_TO_EXPOSITION +
                            ") ON CONFLICT (timestamp) DO NOTHING";
            statement.executeUpdate(sql);
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return Utils.FORBIDDEN_ERROR;
        }

        return Utils.REQUEST_OK;
    }

    public static int returnFromLoan(String itemID, Timestamp timestamp, String destination){
        //Testa permissão
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;

        try {
            //Get last destination of that item
            String origin = "";
            statement = databaseConnection.createStatement();
            String sql = "SELECT * FROM movimentation WHERE itemid = '" + itemID + "' ORDER BY timestamp DESC LIMIT 1";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                origin = resultSet.getString("destination");
            }
            statement.close();

            statement = databaseConnection.createStatement();
            sql =
                    "INSERT INTO MOVIMENTATION (TIMESTAMP, ITEMID, CPFAUTHOR, ORIGIN, DESTINATION, TYPE) " +
                            " VALUES (" +
                            "'" + timestamp + "', " +
                            "'" + itemID + "', " +
                            "'" + activeUser.getCpf() + "', " +
                            "'" + origin + "', " +
                            "'" + destination + "', " +
                            Utils.RETURN_FROM_LOAN +
                            ") ON CONFLICT (timestamp) DO NOTHING";
            statement.executeUpdate(sql);
            statement.close();

        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return Utils.FORBIDDEN_ERROR;
        }

        return Utils.REQUEST_OK;
    }

    public static int returnFromRestoration(String itemID, Timestamp timestamp, String destination){
        //Testa permissão
        if (!(DatabaseHelper.getActiveUser() instanceof Technician || DatabaseHelper.getActiveUser() instanceof Director || DatabaseHelper.getActiveUser() instanceof Coordinator))
            return Utils.PERMISSION_ERROR;

        try {
            //Get last destination of that item
            String origin = "";
            statement = databaseConnection.createStatement();
            String sql = "SELECT * FROM movimentation WHERE itemid = '" + itemID + "' ORDER BY timestamp DESC LIMIT 1";
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                origin = resultSet.getString("destination");
            }
            statement.close();

            statement = databaseConnection.createStatement();
            sql =
                    "INSERT INTO MOVIMENTATION (TIMESTAMP, ITEMID, CPFAUTHOR, ORIGIN, DESTINATION, TYPE) " +
                            " VALUES (" +
                            "'" + timestamp + "', " +
                            "'" + itemID + "', " +
                            "'" + activeUser.getCpf() + "', " +
                            "'" + origin + "', " +
                            "'" + destination + "', " +
                            Utils.RETURN_FROM_RESTORATION +
                            ") ON CONFLICT (timestamp) DO NOTHING";
            statement.executeUpdate(sql);
            statement.close();

        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
            return Utils.FORBIDDEN_ERROR;
        }

        return Utils.REQUEST_OK;
    }

    /* -- Funções de Pesquisa -- */

    //Items
    /**
     * Função para pesquisa de Items por seu ID
     * @param ID - ID desejado
     * @return - ArrayList com itens com ID desejado
     */
    public static ArrayList<Item> searchItemByID(String ID){

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

    /**
     * Pesquisa item que contenham a substring no nome
     * @param searchString - string desejada
     * @return - retorna ArrayList com itens que contenham searchstring no nome
     */
    public static ArrayList<Item> searchItemByCollection(String searchString){

        ArrayList<Item> objectsArray = new ArrayList<>();

        try {

            //Make query
            statement = databaseConnection.createStatement();

            String collectionID;
            String sql =
                    "SELECT collectionid FROM collection WHERE UPPER(NAME) = UPPER('" + searchString + "')";
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                collectionID = resultSet.getString("COLLECTIONID");
            }
            else
                return null;

            //Get Items
            sql = "SELECT * FROM ITEM WHERE UPPER(collectionid) LIKE UPPER('%" + collectionID + "%')";
            resultSet = statement.executeQuery(sql);

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
                float resultsHeight = resultSet.getFloat("height");
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
                String resultsAquisitionDate = resultSet.getString(("aquisitiondate"));

                //Get last destination of that item
                String origin = "";
                String destination = "";
                statement = databaseConnection.createStatement();
                String sql = "SELECT * FROM movimentation WHERE itemid = '" + resultSet.getString(("itemid")) + "' ORDER BY timestamp DESC LIMIT 1";
                ResultSet resultSet2 = statement.executeQuery(sql);
                while (resultSet2.next()) {
                    origin = resultSet2.getString("origin");
                    destination = resultSet2.getString("destination");
                }
                statement.close();
                String resultsOrigin = origin;
                String resultsDestination = destination;

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
                        resultsAquisitionDate,
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


    private static ArrayList<Collection> collectionResultSetToArray(ResultSet resultSet){

        ArrayList<Collection> objectsArray = new ArrayList<>();
        try {
            //Puts results in array list
            while (resultSet.next()) {
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
        catch (SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }
        return objectsArray;
    }

    /**
     * Pesquisa coleção por substring no nome
     * @param searchString - substring de pesquisa
     * @return - ArrayList de coleções correspondentes
     */
    public static ArrayList<Collection> searchCollectionByName(String searchString){

        System.out.println("Pesquisando por " + searchString);

        ArrayList<Collection> objectsArray = new ArrayList<>();

        try {

            //Make query
            statement = databaseConnection.createStatement();
            String sql = "SELECT * FROM collection WHERE UPPER(NAME) LIKE UPPER('%" + searchString + "%')";
            ResultSet resultSet = statement.executeQuery(sql);

            objectsArray = collectionResultSetToArray(resultSet);

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
     * Gets all collections
     * @return - ArrayList de coleções correspondentes
     */
    public static ArrayList<Collection> getAllCollections(){

        ArrayList<Collection> objectsArray = new ArrayList<>();

        try {
            //Crates statement
            statement = databaseConnection.createStatement();

            //Querys for CollectionID
            String sql = "SELECT * FROM collection";
            ResultSet resultSet = statement.executeQuery(sql);

            objectsArray = collectionResultSetToArray(resultSet);

        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

        return objectsArray;
    }


    /**
     * Busca nome das coleções
     * @return - ArrayList com nomes das coleções
     */
    public static ArrayList<String> getCollectionNames(){

        ArrayList<String> objectsArray = new ArrayList<>();

        try {
            //Crates statement
            statement = databaseConnection.createStatement();

            //Querys for CollectionID
            String sql = "SELECT NAME FROM collection ";
            ResultSet resultSet = statement.executeQuery(sql);


            //Puts results in array list
            while (resultSet.next()) {

                String resultsName = resultSet.getString(("name"));
                //Add object to array
                objectsArray.add(resultsName);
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
        if (!(activeUser instanceof Technician
                || activeUser instanceof Director
                || activeUser instanceof Coordinator))
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

    public static ArrayList<Movimentation> getItemMovimentations(String itemID){

        ArrayList<Movimentation> objectsArray = new ArrayList<>();

        try {
            //Crates statement
            statement = databaseConnection.createStatement();

            //Querys for movimentations
            String sql = "SELECT * FROM movimentation WHERE UPPER(itemid) = UPPER('" + itemID + "')";
            ResultSet resultSet = statement.executeQuery(sql);

            //Variables for loan and restoration querys
            Statement statement2;
            String sql2;
            ResultSet resultSet2;
            Timestamp resultDateOfReturn;

            //Puts results in array list
            while (resultSet.next()) {

                Movimentation movimentation = null;

                Timestamp resultTimestamp = resultSet.getTimestamp("timestamp");
                int resultType = resultSet.getInt("type");
                String origin = resultSet.getString("origin");
                String destination = resultSet.getString("destination");
                String cpfAutor = resultSet.getString("cpfauthor");

                switch (resultType) {
                    case Utils.ADMISSION:
                        movimentation = new AdmissionMovimentation(resultTimestamp, origin, destination, cpfAutor);
                        break;
                    case Utils.PUT_TO_STORAGE:
                        movimentation = new PutToStorageMovimentation(resultTimestamp, origin, destination, cpfAutor);
                        break;
                    case Utils.PUT_TO_EXPOSITION:
                        movimentation = new PutToExpositionMovimentation(resultTimestamp, origin, destination, cpfAutor);
                        break;
                    case Utils.SEND_TO_LOAN:
                        sql2 = "SELECT * FROM loan WHERE timestamp = '" + resultTimestamp + "'";
                        statement2 = databaseConnection.createStatement();
                        resultSet2 = statement2.executeQuery(sql2);
                        if(resultSet2.next()) {
                            resultDateOfReturn = resultSet2.getTimestamp("dateofreturn");

                            movimentation = new SendToLoanMovimentation(
                                    resultTimestamp, resultDateOfReturn, origin, destination, cpfAutor
                            );
                        }
                        break;
                    case Utils.SEND_TO_RESTORATION:
                        sql2 = "SELECT * FROM restoration WHERE timestamp = '" + resultTimestamp + "'";
                        statement2 = databaseConnection.createStatement();
                        resultSet2 = statement2.executeQuery(sql2);
                        if(resultSet2.next()) {
                            resultDateOfReturn = resultSet2.getTimestamp("dateOfReturn");
                            movimentation = new SendToRestorationMovimentation(
                                    resultTimestamp, resultDateOfReturn, origin, destination, cpfAutor, resultSet2.getString("damage"), resultSet2.getString("restorer"), resultSet2.getString("repair")
                            );
                        }
                        break;
                    case Utils.RETURN_FROM_LOAN:
                        movimentation = new ReturnFromLoan(resultTimestamp, origin, destination, cpfAutor);
                        break;
                    case Utils.RETURN_FROM_RESTORATION:
                        movimentation = new ReturnFromRestauration(resultTimestamp, origin, destination, cpfAutor);
                        break;
                    default:
                        movimentation = new PutToStorageMovimentation(resultTimestamp, origin, destination, cpfAutor);
                        break;
                }

                //Add object to array
                objectsArray.add(movimentation);
            }


        }
        catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getSQLState());
        }

        return objectsArray;
    }

}