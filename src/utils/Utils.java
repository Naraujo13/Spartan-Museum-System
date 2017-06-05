package utils;

/**
 * Created by naraujo on 29/05/17.
 */
public abstract class Utils {

    //Status Items
    public static String AT_EXPOSITION = "Em Exposição";
    public static String AT_STORAGE = "Em Armazenamento";
    public static String AT_RESTAURATION = "Em Restauração";
    public static String DISCHARGED = "Baixa";
    public static String AT_LOAN = "Emprestada";

    //Return Codes
    public static int REQUEST_OK = 200; // Operação realizada com sucesso
    public static int ALREADY_EXISTS_ERROR = 402; // Erro de inserção, já existe valor
    public static int FORBIDDEN_ERROR = 403; // Erro, operação proibida
    public static int NOT_FOUND_ERROR = 404; // Erro, informação não encontrada
    public static int PERMISSION_ERROR = 550; //Erro, usuário não autorizado a realizar operação


}
