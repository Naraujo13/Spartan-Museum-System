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
    public static final String AT_EXPOSITION = "Em Exposição";
    public static final String AT_STORAGE = "Em Armazenamento";
    public static final String AT_RESTAURATION = "Em Restauração";
    public static final String AT_LOAN = "Emprestada";
    public static final String DISCHARGED = "Baixa";

    //User functions
    public static final int RESEARCHER = 1;
    public static final int TECHNICIAN = 2;
    public static final int DIRECTOR = 3;
    public static final int COORDINATOR = 4;

    //Movimentation Functions
    public static final int ADMISSION = 1;
    public static final int PUT_TO_STORAGE = 2;
    public static final int PUT_TO_EXPOSITION = 3;
    public static final int SEND_TO_LOAN = 4;
    public static final int SEND_TO_RESTORATION = 5;
    public static final int RETURN_FROM_LOAN = 6;
    public static final int RETURN_FROM_RESTORATION = 7;
    public static final int DISCHARGE = 8;


    //Return Codes
    public static final int REQUEST_OK = 200; // Operação realizada com sucesso
    public static final int ALREADY_EXISTS_ERROR = 402; // Erro de inserção, já existe valor
    public static final int FORBIDDEN_ERROR = 403; // Erro, operação proibida
    public static final int NOT_FOUND_ERROR = 404; // Erro, informação não encontrada
    public static final int PERMISSION_ERROR = 550; //Erro, usuário não autorizado a realizar operação

    public static SortedMap<String, String> searchByPrefix(SortedMap<String, String> baseMap, String prefix) {
        if(prefix.length() > 0) {
            char nextLetter = (char) (prefix.charAt(prefix.length() -1) + 1);
            String end = prefix.substring(0, prefix.length()-1) + nextLetter;
            return baseMap.subMap(prefix, end);
        }
        return baseMap;
    }


}
