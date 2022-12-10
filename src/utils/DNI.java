package utils;

public class DNI {
    public static boolean esNumero(char c){ //funcion que calcula q los valores introducidos en dni sean todos numeros
        boolean result=false;
        if(c>='0' && c<='9'){
            result=true;
        }
        return result;
    }
    public static char calculaLetraDNI(String numeroDNI){ //
        char[] letras={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        char letra= letras [Integer.valueOf(numeroDNI) % 23]; //Integer.valueOF(numeroDNI)  coge la cadena string NumeroDNI lo convertira a numerico (como si fuese un int)
        return letra;
    }
}
