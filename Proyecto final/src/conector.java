import javax.swing.*;
import java.io.*;
import java.sql.*;

public class conector {
    static BufferedReader leendo;
    static String data;
    static String ar;
    String db = "jdbc:postgresql://localhost:5432/inventario";
    public void addProduct (String nombre, String codego) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(db, "postgres", "123456");
            PreparedStatement newStatement = connection.prepareStatement("insert into inventario values (?, ?)");
            newStatement.setString(1, nombre);
            newStatement.setString(2, codego);
            newStatement.executeQuery();
            JOptionPane.showMessageDialog(null, "se digito su producto");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
    }

    public void export () {
        try {
            FileWriter file = new FileWriter("C:/Users/Georg/Desktop/uni/PROGRA 2/proyecto final/inventario.txt");

            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(db, "postgres", "123456");

            Statement createStatement = connection.createStatement();

            ResultSet results = createStatement.executeQuery ("select * from inventario");
            int i=0;
            // Se recorre el ResultSet, mostrando por pantalla los resultados.
            while (results.next())
            {
                file.write(i+1 + results.getString(1) + " " + results.getString(2) + "\n");
                i++;
            }
            file.close();// Se cierra la conexión con la base de datos.

            connection.close();
            JOptionPane.showMessageDialog(null, "Exportando en un archivo txt");
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: "+e.toString());
        }
    }

        public void leer(){
            String archi = null;
            try {
                leendo = new BufferedReader(new FileReader(archi));
                while ((data = leendo.readLine()) != null) {
                    impor();
                    System.out.println(ar);
                }
                leendo.close();
                data = null;
            }catch (Exception e){
                System.out.println(e);
            }
        }
    public void impor() {
        String db = "jdbc:postgresql://localhost:5432/inventario";

        try{
            Class.forName("org.postgresql.Driver");
            Connection conexion = DriverManager.getConnection(db, "postgres", "123456");
            Statement createStatement = conexion.createStatement();
            PreparedStatement newStatement = conexion.prepareStatement("insert into inventario values (?, ?)");//hacemos el query

            String registros [] = data.split(",");//aqui se separan por comas los registros del archivo

            newStatement.setString(1, registros[0]);
            newStatement.setString(2, registros[1]);
            newStatement.executeQuery();
        }catch (Exception e){
            System.out.println(e);
        }
    }


}




