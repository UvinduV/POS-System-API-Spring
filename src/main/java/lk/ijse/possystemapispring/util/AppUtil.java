package lk.ijse.possystemapispring.util;

import java.util.UUID;

public class AppUtil {
    public static String generateCustomerId(){
        return "CUSTOMER-"+ UUID.randomUUID();
    }
    public static String generateItemId(){
        return "ITEM-"+ UUID.randomUUID();
    }

    public static String generateOrderId() {
        return "ORDER-"+ UUID.randomUUID();
    }
}
