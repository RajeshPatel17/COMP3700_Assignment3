import com.google.gson.Gson;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class RemoteDataAdapter implements DataAccess {
    Gson gson = new Gson();
    Socket s = null;
    DataInputStream dis = null;
    DataOutputStream dos = null;

    @Override
    public void connect() {
        try {
            s = new Socket("localhost", 5056);
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void saveProduct(ProductModel product) {

    }

    @Override
    public ProductModel loadProduct(int productID) {
        RequestModel req = new RequestModel();
        req.code = req.LOAD_PRODUCT_REQUEST;
        req.body = String.valueOf(productID);

        String json = gson.toJson(req);
        try {
            dos.writeUTF(json);

            String received = dis.readUTF();

            System.out.println("Server response:" + received);

            ResponseModel res = gson.fromJson(received, ResponseModel.class);

            if (res.code == ResponseModel.UNKNOWN_REQUEST) {
                System.out.println("The request is not recognized by the Server");
                return null;
            }
            else         // this is a JSON string for a product information
                if (res.code == ResponseModel.DATA_NOT_FOUND) {
                    System.out.println("The Server could not find a product with that ID!");
                    return null;
                }
                else {
                    ProductModel model = gson.fromJson(res.body, ProductModel.class);
                    System.out.println("Receiving a ProductModel object");
                    System.out.println("ProductID = " + model.productID);
                    System.out.println("Product name = " + model.name);
                    return model; // found this product and return!!!
                }



        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public NoteModel loadNote(int noteID) {
        RequestModel req = new RequestModel();
        req.code = req.LOAD_NOTE_REQUEST;
        req.body = String.valueOf(noteID);

        String json = gson.toJson(req);
        try {
            dos.writeUTF(json);

            String received = dis.readUTF();

            System.out.println("Server response:" + received);

            ResponseModel res = gson.fromJson(received, ResponseModel.class);

            if (res.code == ResponseModel.UNKNOWN_REQUEST) {
                System.out.println("The request is not recognized by the Server");
                return null;
            }
            else         // this is a JSON string for a product information
                if (res.code == ResponseModel.DATA_NOT_FOUND) {
                    System.out.println("The Server could not find a note with that ID!");
                    return null;
                }
                else {
                    NoteModel model = gson.fromJson(res.body, NoteModel.class);
                    System.out.println("Receiving a NoteModel object");
                    System.out.println("NoteID = " + model.noteID);
                    System.out.println("Note title = " + model.title);
                    return model; // found this product and return!!!
                }



        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void saveNote(NoteModel note) {
        RequestModel req = new RequestModel();
        req.code = req.SAVE_NOTE_REQUEST;
        req.body = String.valueOf(noteID);

        String json = gson.toJson(req);
        try {
            dos.writeUTF(json);

            String received = dis.readUTF();

            System.out.println("Server response:" + received);

            ResponseModel res = gson.fromJson(received, ResponseModel.class);

            if (res.code == ResponseModel.UNKNOWN_REQUEST) {
                System.out.println("The request is not recognized by the Server");
                return;
            }
            else         // this is a JSON string for a product information
                if (res.code == ResponseModel.DATA_NOT_FOUND) {
                    System.out.println("The Server could not find a product with that ID!");
                    return;
                }
                else {
                    NoteModel model = gson.fromJson(res.body, NoteModel.class);
                    System.out.println("Receiving a NoteModel object");
                    System.out.println("NoteID = " + model.noteID);
                    System.out.println("Note title = " + model.title);
                    return; // found this product and return!!!
                }



        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return;
    }

    @Override
    public void searchNotes(String keywords) {
        RequestModel req = new RequestModel();
        req.code = req.SEARCH_NOTE_REQUEST;
        req.body = keywords;

        String json = gson.toJson(req);
        try {
            dos.writeUTF(json);

            String received = dis.readUTF();

            System.out.println("Server response:" + received);

            ResponseModel res = gson.fromJson(received, ResponseModel.class);

            if (res.code == ResponseModel.UNKNOWN_REQUEST) {
                System.out.println("The request is not recognized by the Server");
                return;
            }
            else         // this is a JSON string for a product information
                if (res.code == ResponseModel.DATA_NOT_FOUND) {
                    System.out.println("The Server could not find a product with that ID!");
                    return;
                }
                else {
                    NoteModel model = gson.fromJson(res.body, NoteModel.class);
                    System.out.println("Receiving a NoteModel object");
                    System.out.println("NoteID = " + model.noteID);
                    System.out.println("Note title = " + model.title);
                    return; // found this product and return!!!
                }



        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return;
    }
}
