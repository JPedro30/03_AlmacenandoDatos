package ejercicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import estudio.Leer;

public class EjecricioFicheroTarjetaClave {

    public EjecricioFicheroTarjetaClave() throws IOException{

        File fichero = new File("usuarios.txt");

        if (!fichero.exists()) {
            fichero.createNewFile();
        }

        FileReader fr = new FileReader(fichero);
        BufferedReader br = new BufferedReader(fr);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 2; j++) {
                String[] nombresUsuarios = new String[10];
                String usuario = br.readLine();
                nombresUsuarios[i] = usuario;
                //System.out.println(usuario);

                String[] contraseñaUsuarios = new String[10];
                String contraseña = br.readLine();
                contraseñaUsuarios[i] = contraseña;
                //System.out.println(contraseña);

                String[] tarjetaClave = br.readLine().replace(" ","").split(",");
                //System.out.println(Arrays.toString(tarjetaClave));

                System.out.print("Introduzca el nombre de usuario : ");
                String nombre = Leer.dato();
                if (usuario.equals(nombre)) {
                    System.out.print("Introduzca la contraseña de "+nombre+" : ");
                    String contra = Leer.dato();
                    if (contraseña.equals(contra)) {
                        System.out.println(Arrays.toString(tarjetaClave));
                    }
                    break;
                }
            }
            
            
        }

        
    

    }

}
