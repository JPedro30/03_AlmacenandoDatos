package estudio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Leer {

    public static String dato() throws IOException{
        String dato = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader brt = new BufferedReader(isr);
        dato = brt.readLine();
        return dato;
    }

    public static int datoInt() throws NumberFormatException, IOException {
        int datoInt = 0;
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader brt = new BufferedReader(isr);
        datoInt = Integer.parseInt(brt.readLine());
        return datoInt;
    }

}
