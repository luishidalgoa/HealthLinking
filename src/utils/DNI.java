package utils;

public class DNI {
    /*
     * Metodo que es usado por leeDNI. su objetivo es comprobar que todos los supuestos numeros escritos por el usuario son caracteres del 0-9
     * si no retorna un false a leeDNI haciendo que este vuelva a pedir el dni
     */
    public static boolean esNumero(char c){ //funcion que calcula q los valores introducidos en dni sean todos numeros
        boolean result=false;
        if(c>='0' && c<='9'){
            result=true;
        }
        return result;
    }
    /*
     * Metodo que sera utilizado por leeDNI con 2 objetivos . o bien comprobar que la letra del dni sea correspondiente al dni introducido
     * o si el usuario no introduce la letra del dni . el programa le sujiera la letra
     */
    public static char calculaLetraDNI(String numeroDNI){ //
        char[] letras={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        char letra= letras [Integer.valueOf(numeroDNI) % 23]; //Integer.valueOF(numeroDNI)  coge la cadena string NumeroDNI lo convertira a numerico (como si fuese un int)
        return letra;
    }
}
