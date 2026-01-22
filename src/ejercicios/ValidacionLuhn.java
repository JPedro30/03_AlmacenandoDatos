package ejercicios;

import java.util.Arrays;

import excepciones.InvalidTarjetaCreditoException;

@SuppressWarnings("unused")
public class ValidacionLuhn {

    public ValidacionLuhn(){

        String numeroTarjeta = "   4620058441887023     ";

        try {
            compruebaTarjeta(numeroTarjeta);
            System.out.println("Tarjeta de Credito Valida");
        } catch (InvalidTarjetaCreditoException e) {
            System.out.println(e.getMessage());
        }


    }

    
    private void compruebaTarjeta(String numeroTarjeta) throws InvalidTarjetaCreditoException {

        numeroTarjeta=numeroTarjeta.trim();
        numeroTarjeta=numeroTarjeta.replace(" ", "");

        if (numeroTarjeta.length()!=16) throw new InvalidTarjetaCreditoException();

        try {
            double numeroTarjetaNumerico = Double.parseDouble(numeroTarjeta);
        } catch (NumberFormatException e) {
            throw new InvalidTarjetaCreditoException();
        }

        int[] posicion = {16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};
        int[][] matrizValidacion = new int[5][posicion.length];

        for (int x = 0; x < 16; x++) {
            matrizValidacion[0][x]=posicion[x];
            matrizValidacion[1][x]=Character.getNumericValue(numeroTarjeta.charAt(x));
        }

        añadeDoblados(matrizValidacion);

        añadeSumaDig(matrizValidacion);

        añadeTotal(matrizValidacion);

        /* for (int y = 0; y < matrizValidacion.length; y++) {
            for (int x = 0; x < matrizValidacion[y].length; x++) {
                System.out.print(String.format("%4s",matrizValidacion[y][x]));
            }
            System.out.println();
        } */
        

        int sum=0;

        for (int x = 0; x < matrizValidacion[0].length; x++) {
            sum+=matrizValidacion[4][x];
        }

        //System.out.println(sum);

        if (sum%10!=0) throw new InvalidTarjetaCreditoException();    

    }

    private void añadeTotal(int[][] matrizValidacion) {
        for (int x = 0; x < matrizValidacion[0].length; x++) {
            if (matrizValidacion[3][x]==0) {
                matrizValidacion[4][x]=matrizValidacion[2][x];
            } else if (matrizValidacion[3][x]!=0) {
                matrizValidacion[4][x]=matrizValidacion[3][x];
            }
        }
    }

    private void añadeSumaDig(int[][] matrizValidacion) {
        for (int x = 0; x < matrizValidacion[0].length; x++) {
            if (matrizValidacion[2][x]>9) {
                int numIzq = matrizValidacion[2][x]/10;
                int numDer = matrizValidacion[2][x]%10;
                matrizValidacion[3][x]=numIzq+numDer;
            }
        }
        
    }

    private void añadeDoblados(int[][] matrizValidacion) {
        for (int x = 0; x < matrizValidacion[0].length; x++) {
            if (matrizValidacion[0][x]%2==0) {
                matrizValidacion[2][x]=matrizValidacion[1][x]*2;
            }else if (matrizValidacion[0][x]%2!=0) {
                matrizValidacion[2][x]=matrizValidacion[1][x];
            } 
        }
    }

}
