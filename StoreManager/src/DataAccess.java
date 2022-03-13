public interface DataAccess {
    void connect();

    void saveProduct(ProductModel product);

    ProductModel loadProduct(int productID);

    void saveNote(NoteModel note);

    NoteModel loadNote(int noteID);

    ResultSet searchNotes(String keywords);
}
