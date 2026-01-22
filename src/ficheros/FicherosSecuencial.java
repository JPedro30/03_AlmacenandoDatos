package ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FicherosSecuencial {

    public FicherosSecuencial() throws IOException{

        File fichero; // declaramos la clase fichero
        fichero = new File("alumnos.txt"); // instanciamos y ponemos el nombre del fichero en argumentos

        if (!fichero.exists()) { // si no existe el archivo se crea
            fichero.createNewFile(); // aqui creamos el archivo
        }

        FileReader fr = null; // declaramos la clase para leer ficheros y lo inicializamos a null
        BufferedReader br = null; // declaramos la clase para almacenar lo que leamos en el fichero y lo inicializamos en null
        fr = new FileReader(fichero); // instanciamos el file reader y le mandamos el archivo
        br = new BufferedReader(fr); // instanciamos el buffered con lo que ha leido el file reader

        /* String nombre = br.readLine(); // a la cadena nombre, le damos la linea que ha leido el buffered
        System.out.println(nombre);

        nombre = br.readLine(); // aqui lee la segunda linea
        System.out.println(nombre);

        nombre = br.readLine(); // y aqui la tercera linea
        System.out.println(nombre);

        nombre = br.readLine(); // y aqui la cuarta linea, pero como no existe, devuelve null
        System.out.println(nombre); */

        String nombre;

        while ((nombre = br.readLine())!=null) { // aqui lee hasta que sea distinto de null
            System.out.println(nombre);
        }

        fr.close(); // cerramos el file reader
        br.close(); // cerramos el buffered

        fr = null; // desinstanciamos fr
        br = null; // desinstanciamos br

        //#########################

        fichero = new File("daw.txt"); // instanciamos y ponemos el nombre del fichero en argumentos

        if (!fichero.exists()) { // si no existe el archivo se crea
            fichero.createNewFile(); // aqui creamos el archivo
        }

        fr = new FileReader(fichero);
        br = new BufferedReader(fr);

        String datos;

        while ((datos = br.readLine())!=null) {
            String[] nombreSplit = datos.split(","); // nos crea un array de cadenas del numero de palabras que haya
            System.out.println(Arrays.toString(nombreSplit)); // mostramos el array
            for (int i = 0; i < nombreSplit.length; i++) {
                System.out.println(nombreSplit[i]); // mostramos cada palabra del array por separado
            }
        }

        fr.close();
        br.close();

        fr = null;
        br = null;

        //#########################

        fichero = new File("notas.txt"); // instanciamos y ponemos el nombre del fichero en argumentos

        if (!fichero.exists()) { // si no existe el archivo se crea
            fichero.createNewFile(); // aqui creamos el archivo
        }

        fr = new FileReader(fichero);
        br = new BufferedReader(fr);

        String alumnos;
        alumnos = br.readLine();
        String[] alumnosArray = alumnos.split(",");
        // podria simplificarlo haciendo String[] alumnosArray = br.readLine().split(","); haria ambas cosas en la misma linea

        String asignaturas;
        asignaturas = br.readLine();
        String[] asignaturasArray = asignaturas.split(",");

        int[][] notasArray = new int[alumnosArray.length][asignaturasArray.length];
        for (int y = 0; y < notasArray.length; y++) {
            String[] notasCad = br.readLine().split(",");
            for (int x = 0; x < asignaturasArray.length; x++) {
                notasArray[y][x] = Integer.parseInt(notasCad[x]);
            }
        }

        String espacios = " ";

        System.out.printf("%10s",espacios);
        for (int i = 0; i < asignaturasArray.length; i++) {
            System.out.printf("%-15s",asignaturasArray[i]);
        }

        System.out.println();

        for (int i = 0; i < alumnosArray.length; i++) {
            System.out.printf("%-10s",alumnosArray[i]);
            for (int j = 0; j < asignaturasArray.length; j++) {
                System.out.printf(" %-14d",notasArray[i][j]);
            }
            System.out.println();
            
        }

        fr.close();
        br.close();

        fr = null;
        br = null;

        //#########################

        // ESCRIBIR EN UN FICHERO , MODIFICAR FICHERO

        alumnosArray[0] = "Arturo";
        asignaturasArray[0] = "Dormir";
        notasArray[0][0] = 10;

        FileWriter fw = null;
        BufferedWriter bw = null;

        fw = new FileWriter(fichero);
        bw = new BufferedWriter(fw);

        datos = String.join(",", alumnosArray);
        //System.out.println(datos);
        bw.write(datos); //esto escribe en el archivo
        bw.newLine(); //aqui salto a la siguiente linea

        datos = String.join(",", asignaturasArray);
        //System.out.println(datos);
        bw.write(datos); //esto escribe en el archivo
        bw.newLine(); //aqui salto a la siguiente linea
            
        for (int i = 0; i < notasArray.length; i++) {
            int[]nota = notasArray[i];
            datos = convierteCad(nota);
            //System.out.println(datos);
            bw.write(datos); //esto escribe en el archivo
            bw.newLine(); //aqui salto a la siguiente linea
        }

        bw.flush(); // vaciamos el buffer y lo pasamos al fichero
        fw.close(); // aqui cerramos el fw
        bw.close();
              

    }

    private String convierteCad(int[] nota) {
        String resultado = "";
        for (int i = 0; i < nota.length; i++) {
            resultado+=nota[i];
            if (i<nota.length-1) { // esto puedo hacerlo con un substring
                resultado+=",";
            }
        }
        return resultado;
    }

}
