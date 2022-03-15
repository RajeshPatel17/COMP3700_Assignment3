import javax.swing.*;

public class MainApp {
    public static void main(String[] args) {
        StoreManager.getInstance().getNoteView().setVisible(true);
        StoreManager.getInstance().getSearchView().setVisible(true);
    }
}
