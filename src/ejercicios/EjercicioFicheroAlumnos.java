package ejercicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.util.Arrays;

public class EjercicioFicheroAlumnos {

    public EjercicioFicheroAlumnos() throws IOException{

        //===================================================================================================
        // LEER FICHEROS
        //===================================================================================================

        File fichero;
        fichero = new File("ficheroalumnos.txt");

        if (!fichero.exists()) {
            fichero.createNewFile();
        }

        FileReader fr = new FileReader(fichero);
        BufferedReader br = new BufferedReader(fr);

        String[] alumnosArray = br.readLine().split(",");
        //System.out.println(Arrays.toString(alumnosArray));

        String[] asignaturasArray = br.readLine().split(",");
        //System.out.println(Arrays.toString(asignaturasArray));

        int[][] notasArray = new int[alumnosArray.length][asignaturasArray.length];
        for (int y = 0; y < notasArray.length; y++) { // recorro cada alumno
            String[] notasString = br.readLine().split(","); // aqui creo un array uni de cada linea
            for (int x = 0; x < asignaturasArray.length; x++) { // recorro cada asignatura
                notasArray[y][x] = Integer.parseInt(notasString[x]); // guardo en cada posicion de alumno/nota cada nota de cada asignatura pero en entero
            }
        }
        //System.out.println(Arrays.deepToString(notasArray));

        System.out.println("DATOS ORIGINALES");
        String espacios = " ";
        System.out.printf("%10s",espacios);
        for (int y = 0; y < asignaturasArray.length; y++) {
            System.out.printf("%-15s",asignaturasArray[y]);
        }
        for (int y = 0; y < notasArray.length; y++) {
            System.out.printf("%n%-10s",alumnosArray[y]);
            for (int x = 0; x < notasArray[y].length; x++) {
                System.out.printf("%-15d",notasArray[y][x]);
            }
        }
        System.out.println();

        br.close();
        fr.close();

        br = null;
        fr = null;


        //===================================================================================================
        // ESCRIBIR FICHEROS
        //===================================================================================================

        FileWriter fw = new FileWriter(fichero);
        BufferedWriter bw = new BufferedWriter(fw);

        String datos = "";

        alumnosArray[0] = "Marcos";
        asignaturasArray[0] = "Java";
        notasArray[0][0] = -1;
        
        datos = String.join(",",alumnosArray);
        //System.out.println(datos);
        bw.write(datos);
        bw.newLine();

        datos = String.join(",", asignaturasArray);
        //System.out.println(datos);
        bw.write(datos);
        bw.newLine();

        for (int y = 0; y < notasArray.length; y++) {
            int[] notas = notasArray[y];
            datos = convertirString(notas);
            //System.out.println(datos);
            bw.write(datos);
            bw.newLine();
        }

        bw.flush();
        fw.close();
        bw.close();

        fw = null;
        bw = null;  
        
        System.out.println("NUEVOS DATOS");
        espacios = " ";
        System.out.printf("%10s",espacios);
        for (int y = 0; y < asignaturasArray.length; y++) {
            System.out.printf("%-15s",asignaturasArray[y]);
        }
        for (int y = 0; y < notasArray.length; y++) {
            System.out.printf("%n%-10s",alumnosArray[y]);
            for (int x = 0; x < notasArray[y].length; x++) {
                System.out.printf("%-15d",notasArray[y][x]);
            }
        }
        System.out.println();
            
    }

    private String convertirString(int[] notas) {
        String notaString = "";
        for (int x = 0; x < notas.length; x++) {
            notaString += notas[x];
            if (x<notas.length-1) {
                notaString += ",";
            }
        }
        return notaString;
    }

}
