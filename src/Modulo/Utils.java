package Modulo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

    public boolean confirmar(String msn){
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

    //___________________________________________LEE__________________________________________
    public String leeNombre(String msn){
        Scanner sc=new Scanner(System.in);
        String nombre="";
        try{
            System.out.println(msn);
            nombre=sc.nextLine();

        }catch (Exception e){
            System.out.println(rojo+"Introduce una cadena de caracteres"+b);
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
            System.out.println(rojo+"Introduce una opcion correcta"+b);
        }
        return evento;
    }
    public String leeDNI(String msn){
        Scanner sc=new Scanner(System.in);
        String dni="";
        System.out.println(msn);
        boolean isCorrect=true;
        do{
            dni=sc.nextLine();
            dni.toUpperCase();
            if (dni.length()==9){ //buscara que todos los numeros sean numeros
                String numerosDNI="";
                for(int c=0;c<dni.length()-1 && isCorrect==true;c++){
                    isCorrect=esNumero(dni.charAt(c));
                    numerosDNI+=dni.charAt(c);
                }
                if(isCorrect==true){ //si los 8 primeros digitos son numeros entonces se comprueba que la letra sea correcta
                    if(dni.charAt(9)==calculaLetraDNI(numerosDNI)){
                        isCorrect=true;
                    }else{
                        isCorrect=false;
                    }
                }
            }else if(dni.length()==8){
                boolean isTrue=confirmar("La letra es "+calculaLetraDNI(dni)+" ?");
                if(isTrue==true){
                    dni+=calculaLetraDNI(dni);
                }else{
                    isCorrect=false;
                    System.out.println("Pulsa intro de nuevo");
                }
            } else if (dni.length()!=8 && dni.length()!=9 || isCorrect==false) {
                System.out.println(rojo+"Introduzca de nuevo el DNI"+b);
            } else{
                System.out.println(rojo+"Introduce un dni que no este registrado"+b);
            }
        }while(isCorrect==false);

        return dni;
    }
    public String leeFecha(String msn){
        Scanner sc=new Scanner(System.in);
        String nacimiento="";
        for(boolean isCorrect=false;isCorrect==false;){
            System.out.println(msn);
            nacimiento=sc.nextLine();
            if(nacimiento.length()<10){
                System.out.println(rojo+"introduce una longitud correcta"+b);
            }else if(nacimiento.charAt(0)<'3' && nacimiento.charAt(0)>'0' && nacimiento.charAt(4)=='/' && nacimiento.charAt(7)=='/'){
                isCorrect=true;
            }else{
                System.out.println(rojo+"introduce una fecha correcta"+b);
            }
        }
        return nacimiento;
    }
    public String leeHora(String msn){
        Scanner sc=new Scanner(System.in);
        String hora="";
        for(boolean isCorrect=false;isCorrect==false;){
            System.out.println(msn);
            hora=sc.nextLine();
            int caracter=ExtractorNumeros(hora,0);
            if(hora.length()!=5){
                System.out.println(rojo+"introduce una longitud correcta"+b);
            }else if(caracter<51 && caracter>=48){
                caracter=ExtractorNumeros(hora,0);
                int caracter1=ExtractorNumeros(hora,1);
                if((caracter==50 && caracter1<53) || (caracter1>=48 && caracter1<=57)){
                    caracter=ExtractorNumeros(hora,2);
                    if(caracter==58){
                        caracter=ExtractorNumeros(hora,3);
                        if(caracter<55 && caracter>=48){
                            caracter=ExtractorNumeros(hora,3);
                            caracter1=ExtractorNumeros(hora,4);
                            if((caracter==54 && caracter1==48) || (caracter1>=48 && caracter1<=57)){
                                isCorrect=true;
                            }
                        }
                    }
                }
            }else{
                System.out.println(rojo+"Introduce una hora valida"+b);
            }
        }
        return hora;
    }

    public int leeEntero(String msn){
        Scanner sc=new Scanner(System.in);
        int numero=0;
        try{
            System.out.println(msn);
            numero=sc.nextInt();
        }catch (Exception e){
            System.out.println(rojo+"Introduce un numero valido"+b);
        }
        return numero;
    }
    public int leeConsulta(String msn){
        Scanner sc=new Scanner(System.in);
        int numero=0;
        boolean isCorrect=false;
        do{
            numero=0;
            try {
                    System.out.println(msn);
                    numero = sc.nextInt();
                    if (numero >= 0 && numero < 6) {
                        isCorrect = true;
                    } else {
                        System.out.println(rojo+"Esa no es una consulta correcta. Existen hasta 5 consultas"+b);
                    }
            } catch (Exception e) {
                System.out.println(rojo+"Introduce un numero valido"+b);
                sc.nextLine();
            }
        }while(isCorrect==false);
        return numero;
    }

    public String leeApellidos(String msn){
        String Apellidos="";
        Scanner sc=new Scanner(System.in);
        for(boolean isCorrect=false;!isCorrect;){
            System.out.println(msn);
            Apellidos=sc.nextLine();
            for(int i=0;i<Apellidos.length();i++){
                char caracter=Apellidos.charAt(i);
                if(caracter==' '){
                    isCorrect=true;
                }

            }
            if(isCorrect==false){
                System.out.println(rojo+"Debes introducir los dos apellidos"+b);
            }
        }

        return Apellidos;
    }
    //_______________________________DNI________________________
    public boolean esNumero(char c){ //funcion que calcula q los valores introducidos en dni sean todos numeros
        System.out.println(c);
        boolean result=false;
        if(c>='0' && c<='9'){
            result=true;
        }
        return result;
    }
    public char calculaLetraDNI(String numeroDNI){ //
        char[] letras={'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
        char letra= letras [Integer.valueOf(numeroDNI) % 23]; //Integer.valueOF(numeroDNI)  coge la cadena string NumeroDNI lo convertira a numerico (como si fuese un int)
        return letra;
    }
    //_________________________________________________________________
//____________________________________OTROS____________________________________

    public String fechaActual(){
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
    public int ExtractorNumeros(String cadena,int pos){
        char caracter=cadena.charAt(pos);
        int numero=Character.getNumericValue(caracter);
        return caracter;
    }

    /**
     * Metodo que recive la fecha nacimiento del paciente y la resta con la fecha actual para calcular la edad
     * @param nacimiento
     * @return
     */
    public int ExtractorEdad(String nacimiento){
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate fechaNac=LocalDate.parse(nacimiento, formatoFecha);
        LocalDate fechaAct=LocalDate.now();
        Period periodo =Period.between(fechaNac, fechaAct);
        return periodo.getYears();
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
//prohibir que en fecha se puedan meter caracteres no numericos

//bug en leeDni. Scanner nos pide 2 veces introducir valor