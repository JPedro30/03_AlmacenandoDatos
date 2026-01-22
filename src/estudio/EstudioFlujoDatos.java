package estudio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EstudioFlujoDatos {

    @SuppressWarnings("unused")
    public EstudioFlujoDatos(){

        String dato = "";

        System.out.println("Estudio FlujoDatos funciona");

        InputStreamReader isr = new InputStreamReader(System.in); // esta clase esta atenta al origen de los datos, ya sea teclado o al fichero

        BufferedReader br = new BufferedReader(isr); // esta clase lee del origen de datos

        int num = 0;

        System.out.print("Introduce un numero : ");

        try {
            dato = br.readLine();
            num = Integer.parseInt(dato);
        } catch (IOException e) {
            e.getMessage();
            System.out.println(e);
        } catch (NumberFormatException e) {
            e.getMessage();
            System.out.println(e);
            System.out.println("Introduzca un numero entero");
        }


        
        System.out.print("Introduzca su nombre : ");
        String nombre = "";

        try {
            nombre = Leer.dato();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Hola "+nombre);



        System.out.print("Introduzca su edad : ");
        int edad = 0;

        try {
            edad = Leer.datoInt();
        } catch (NumberFormatException e) {
            e.getMessage();
            System.out.println(e);
            System.out.println("Introduzca un numero valido");
        } catch (IOException e) {
            System.out.println(" no se cuando salta este error");
        }
        

    }

}
