import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
        InterfazInventario v1 = new InterfazInventario();
        v1.setVisible(true);
        lectorCSV archivo= new lectorCSV();
        archivo.archivoleer("C://Users/Georg/Desktop/uni/PROGRA 2/proyecto final/tabla Mysql/inventario.csv");
    }
}
