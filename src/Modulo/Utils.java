package Modulo;

import java.util.Scanner;

public class Utils {

    String b = "\u001B[0m"; //borrar
    String negro = "\033[30m";
    String rojo = "\033[31m";
    String verde = "\033[32m";
    String amarillo = "\033[33m";
    String azul = "\033[34m";
    String magenta = "\033[35m";
    String celeste = "\033[36m";
    String blanco = "\033[37m";

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
            System.out.println("Escribe una opcion valida");
        }
        return confirm;
    }

    //___________________________________________LEE__________________________________________
    public static String leeNombre(String msn){
        Scanner sc=new Scanner(System.in);
        String nombre="";
        try{
            System.out.println(msn);
            nombre=sc.nextLine();

        }catch (Exception e){
            System.out.println("Introduce una cadena de caracteres");
        }
        return nombre;
    }
    public String leeComando(String msn){
        Scanner sc=new Scanner(System.in);
        String evento="";
        try{
            System.out.println(msn);
            evento=sc.nextLine();
            evento=evento.toUpperCase();

        }catch (Exception e){
            System.out.println("Introduce un evento");
        }
        return evento;
    }
    public String leeDNI(String msn){
        Scanner sc=new Scanner(System.in);
        String dni="";
        System.out.println(msn);
        for(int i=0;i==0;){
            dni=sc.nextLine();
            if (dni.length()==9){
                i=1;
            }else if(dni.length()!=9){
                System.out.println("Introduce DNI valido ");
            }else{
                System.out.println("Introduce un dni que no este registrado");
            }
        }
        return dni;
    }
    public String leeNacimiento(String msn){
        Scanner sc=new Scanner(System.in);
        String nacimiento="";
        for(boolean isCorrect=false;isCorrect==false;){
            System.out.println(msn);
            nacimiento=sc.nextLine();
            if(nacimiento.length()<10){
                System.out.println("introduce una longitud correcta");
            }else if(nacimiento.charAt(0)<'3' && nacimiento.charAt(0)>'0' && nacimiento.charAt(4)=='-' && nacimiento.charAt(7)=='-'){
                 isCorrect=true;
            }else{
                System.out.println("introduce una fecha correcta");
            }
        }
        return nacimiento;
    }

    public int leeEntero(String msn){
        Scanner sc=new Scanner(System.in);
        int numero=0;
        try{
            System.out.println(msn);
            numero=sc.nextInt();
        }catch (Exception e){
            System.out.println("Introduce un numero valido");
        }
        return numero;
    }
//____________________________________OTROS____________________________________

    public void pausaEscribir(){
        try{ Thread.sleep(5);
        }catch(InterruptedException e ){}
    }
    public void escribir(String msn){
        for(int i=0;i<msn.length();i++ ){
            System.out.print(msn.charAt(i));pausaEscribir();
        }
    }


    public String getB() {
        return b;
    }

    public String getNegro() {
        return negro;
    }

    public String getRojo() {
        return rojo;
    }

    public String getVerde() {
        return verde;
    }

    public String getAmarillo() {
        return amarillo;
    }

    public String getAzul() {
        return azul;
    }

    public String getMagenta() {
        return magenta;
    }

    public String getCeleste() {
        return celeste;
    }

    public String getBlanco() {
        return blanco;
    }
}
