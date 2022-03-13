public class StoreManager {

    private static StoreManager instance = null;

    private RemoteDataAdapter dao;

    private ProductView productView = null;

    private NoteView noteView = null;

    public ProductView getProductView() {
        return productView;
    }

    public NoteView getNoteView() {
        return noteView;
    }

    private ProductController productController = null;

    private NoteController noteController = null;

    public static StoreManager getInstance() {
        if (instance == null)
            instance = new StoreManager("SQLite");
        return instance;
    }

    public RemoteDataAdapter getDataAccess() {
        return dao;
    }

    private StoreManager(String db) {
        // do some initialization here!!!
        dao = new RemoteDataAdapter();
        dao.connect();
        productView = new ProductView();
        productController = new ProductController(productView, dao);
        noteView = new NoteView();
        noteController = new NoteController(noteView, dao);
    }






}
