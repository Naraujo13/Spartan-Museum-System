package utils;

import model.Item;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Created by naraujo on 29/05/17.
 */
public abstract class Utils {

    //Status Items
    public static String AT_EXPOSITION = "Em Exposição";
    public static String AT_STORAGE = "Em Armazenamento";
    public static String AT_RESTAURATION = "Em Restauração";
    public static String AT_LOAN = "Emprestada";
    public static String DISCHARGED = "Baixa";

    //User functions
    public static int RESEARCHER = 1;
    public static int TECHNICIAN = 2;
    public static int DIRECTOR = 3;
    public static int COORDINATOR = 4;

    //Return Codes
    public static int REQUEST_OK = 200; // Operação realizada com sucesso
    public static int ALREADY_EXISTS_ERROR = 402; // Erro de inserção, já existe valor
    public static int FORBIDDEN_ERROR = 403; // Erro, operação proibida
    public static int NOT_FOUND_ERROR = 404; // Erro, informação não encontrada
    public static int PERMISSION_ERROR = 550; //Erro, usuário não autorizado a realizar operação

    public static SortedMap<String, String> searchByPrefix(SortedMap<String, String> baseMap, String prefix) {
        if(prefix.length() > 0) {
            char nextLetter = (char) (prefix.charAt(prefix.length() -1) + 1);
            String end = prefix.substring(0, prefix.length()-1) + nextLetter;
            return baseMap.subMap(prefix, end);
        }
        return baseMap;
    }


}
