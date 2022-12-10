package utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Utils {

    public static String b = "\u001B[0m"; //borrar
    public static String negro = "\033[30m";
    public static String rojo = "\033[31m";
    public static String verde = "\033[32m";
    public static String amarillo = "\033[33m";
    public static String azul = "\033[34m";
    public static String magenta = "\033[35m";
    public static String celeste = "\033[36m";
    public static String blanco = "\033[37m";

    public static boolean confirmar(String msn){
        boolean confirm=false;
        Scanner sc=new Scanner(System.in);
        String respuesta;
        int i=0;
        try{
            do{
                System.out.println("\033[32m");
                System.out.println(msn);
                System.out.println("¿Estas seguro?");
                System.out.println("1. Si: Aceptaras");
                System.out.println("2. No: declinaras");
                System.out.println("\u001B[0m");
                respuesta=sc.nextLine();
                respuesta=respuesta.toUpperCase();
                if(respuesta.equals("SI")){
                    confirm=true;
                    i++;
                }else if(respuesta.equals("NO")){
                    confirm=false;
                    i++;
                }else{
                    System.out.println("\033[32m");
                    System.out.println("Escribe una opcion valida");
                    System.out.println("\u001B[0m");
                }
            }while(i==0);
        }catch (ExceptionInInitializerError e){
            System.out.println(rojo+"Escribe una opcion valida"+b);
        }
        return confirm;
    }


    public static String fechaActual(){
        Date fecha=new Date();
        SimpleDateFormat formatoFecha=new SimpleDateFormat("YYYY/MM/dd");
        return formatoFecha.format(fecha);
    }

    /**
     * convertira de string a int y devolvera el numero de la posicion indicada
     * @param cadena recivira el string para analizar
     * @param pos sera la posicion que usemos para devolver el numero en la posicion buscada
     * @return
     */
    public static int ExtractorNumeros(String cadena,int pos){
        char caracter=cadena.charAt(pos);
        int numero=Character.getNumericValue(caracter);
        return caracter;
    }

    /**
     * Metodo que recive la fecha nacimiento del paciente y la resta con la fecha actual para calcular la edad
     * @param nacimiento
     * @return
     */
    public static int ExtractorEdad(String nacimiento){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate fechaNac=LocalDate.parse(nacimiento, formatoFecha);
        LocalDate fechaAct=LocalDate.now();
        Period periodo =Period.between(fechaNac, fechaAct);
        return periodo.getYears();
    }
}