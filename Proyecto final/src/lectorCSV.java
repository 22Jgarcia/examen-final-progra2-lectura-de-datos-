import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class lectorCSV {
    private BufferedReader lector;
    private String linea;
    private String list[]= null;
    public void archivoleer(String nombreArchivo){

        try {

            lector =new BufferedReader(new FileReader(nombreArchivo));
            while ((linea= lector.readLine()) != null){
                list=linea.split(",");
                mostrarlinea();
                System.out.println();
            }
            lector.close();
            linea=null;
            list=null;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e);
        }

    }
    public void mostrarlinea(){
        for(int i=0; i< list.length; i++){
            System.out.print(list[i]+"   |   ");
        }

    }
}
