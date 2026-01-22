import ejercicios.EjecricioFicheroTarjetaClave;
import ejercicios.EjercicioFicheroAlumnos;
import ejercicios.ValidacionCCB;
import ejercicios.ValidacionLuhn;
import estudio.EstudioFlujoDatos;
import ficheros.FicherosSecuencial;

@SuppressWarnings("unused")
public class Main {

    public static void main(String[] args) {
        
        //EstudioFlujoDatos estudioFlujoDatos = new EstudioFlujoDatos();

        //ValidacionCCB validacionCCB = new ValidacionCCB();

        //ValidacionLuhn validacionLuhn = new ValidacionLuhn();


        // EXCEPCIONES

        try {
            //FicherosSecuencial ficherosSecuencial = new FicherosSecuencial();
            //EjercicioFicheroAlumnos ejercicioFicheroAlumnos = new EjercicioFicheroAlumnos();
            EjecricioFicheroTarjetaClave ejecricioFicheroTarjetaClave = new EjecricioFicheroTarjetaClave();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }



    }
}
