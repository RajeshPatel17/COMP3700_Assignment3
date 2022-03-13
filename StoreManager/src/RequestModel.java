public class RequestModel {

    static public int EXIT_REQUEST = 0;
    static public int CUSTOMER_REQUEST = 1;
    static public int ORDER_REQUEST = 2;
    static public int LOAD_PRODUCT_REQUEST = 3;
    static public int SAVE_PRODUCT_REQUEST = 33;
    static public int USER_REQUEST = 4;
    static public int LOAD_NOTE_REQUEST = 5;
    static public int SAVE_NOTE_REQUEST = 55;
    static public int SEARCH_NOTE_REQUEST = 555;

    public int code;
    public String body;
}
