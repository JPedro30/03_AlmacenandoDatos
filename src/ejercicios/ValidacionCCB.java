package ejercicios;

import excepciones.InvalidCuentaBancariaException;

public class ValidacionCCB {

    public ValidacionCCB() {

        String cuenta = "1234 2222 7801 2345 6558  ";

        try {
            compruebaCuentaBancaria(cuenta);
            System.out.println("Cuenta Corriente Valida");
        } catch (InvalidCuentaBancariaException e) {
            System.out.println(e.getMessage());
        }
        

    }

    @SuppressWarnings("unused")
    private void compruebaCuentaBancaria(String cuenta) throws InvalidCuentaBancariaException {

        cuenta = cuenta.trim();
        cuenta = cuenta.replace(" ","");

        String espacios = "0";

        if (cuenta.length()!=20) {
            throw new InvalidCuentaBancariaException();
        }

        while (cuenta.length()%22!=0) {
            cuenta=espacios+cuenta;
        }

        int[] arrayValidacion = {1,2,4,8,5,10,9,7,3,6};

        String parteIzqCuenta = cuenta.substring(0,10);
        String parteDerCuenta = cuenta.substring(12,22);
        String d = cuenta.substring(10,11);
        String c = cuenta.substring(11,12);

        //System.out.println(parteIzqCuenta+" "+d+" "+c+" "+parteDerCuenta);

        long parteIzqCuentaInt; 
        long parteDerCuentaInt; 
        int dInt; 
        int cInt;

        try {
            parteIzqCuentaInt = Long.parseLong(parteIzqCuenta);
            parteDerCuentaInt = Long.parseLong(parteDerCuenta);
            dInt = Integer.parseInt(d);
            cInt = Integer.parseInt(c);
        } catch (NumberFormatException e) {
            throw new InvalidCuentaBancariaException();
        }

        int acumIzq = 0;
        int acumDer = 0;

        for (int x = 0; x < parteIzqCuenta.length(); x++) {
            acumIzq+=Integer.parseInt(String.valueOf(parteIzqCuenta.charAt(x)))*arrayValidacion[x];
            //System.out.println(acumIzq);
            acumDer+=Integer.parseInt(String.valueOf(parteDerCuenta.charAt(x)))*arrayValidacion[x];
            //System.out.println(acumDer);
        }

        int digIzq = 11-acumIzq%11;
        int digDer = 11-acumDer%11;

        if (digIzq==10) digIzq=1;
        if (digIzq==11) digIzq=0;
        if (digDer==10) digDer=1;
        if (digDer==11) digDer=0;

        //System.out.println(digIzq+" "+dInt);
        //System.out.println(digDer+" "+cInt);

        if (digIzq!=dInt) throw new InvalidCuentaBancariaException();
        if (digDer!=cInt) throw new InvalidCuentaBancariaException();

    }

}
