package lk.ijse.possystemapispring.util;

import java.util.UUID;

public class AppUtil {
    public static String generateNoteId(){
        return "CUSTOMER-"+ UUID.randomUUID();
    }
}
