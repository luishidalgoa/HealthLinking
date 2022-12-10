package utils;

import java.util.Scanner;

public class Read {
    static Scanner sc=new Scanner(System.in);
    public static String leeNombre(String msn){
        String nombre=null;
        try{
            System.out.println(msn);
            nombre=sc.nextLine();

        }catch (Exception e){
            System.out.println(utils.Utils.rojo+"Introduce una cadena de caracteres"+Utils.b);
        }
        return nombre;
    }
    public static String leeDNI(String msn){
        String dni;
        boolean isCorrect=true;
        do{
            isCorrect=true;
            System.out.println(msn);
            dni=sc.nextLine();
            dni=dni.toUpperCase();
            if (dni.length()==9){ //buscara que todos los numeros sean numeros
                String numerosDNI="";
                for(int c=0;c<dni.length()-1 && isCorrect;c++){
                    isCorrect=DNI.esNumero(dni.charAt(c));
                    numerosDNI+=dni.charAt(c);//esto los almacena correctamente
                }
                if(isCorrect){ //si los 8 primeros digitos so5n numeros entonces se comprueba que la letra sea correcta
                    if(dni.charAt(8)==DNI.calculaLetraDNI(numerosDNI)){
                        isCorrect=true;
                    }else{
                        isCorrect=false;
                    }
                }
            }else if(dni.length()==8){
                boolean isTrue=Utils.confirmar("La letra es "+DNI.calculaLetraDNI(dni)+" ?");
                if(isTrue){
                    dni+=DNI.calculaLetraDNI(dni);
                }else{
                    isCorrect=false;
                }
            } else if (dni.length()==8 || dni.length()==9){
                System.out.println(Utils.rojo+"Introduce un dni que no este registrado"+Utils.b);
                isCorrect=false;
            }else{
                isCorrect=false;
            }
            if (dni.length()!=8 && dni.length()!=9 || !isCorrect) {
                System.out.println(Utils.rojo+"Introduzca correctamente el DNI"+Utils.b);
            }
        }while(!isCorrect);

        return dni;
    }
    public static String leeFecha(String msn){
        String fecha = null;
        for(boolean isCorrect=false;!isCorrect;){
            System.out.println(msn);
            fecha=sc.nextLine();
            if(fecha.length()<10){
                System.out.println(Utils.rojo+"introduce una longitud correcta"+Utils.b);
            }else if(fecha.charAt(0)<'3' && fecha.charAt(0)>'0' && fecha.charAt(4)=='/' && fecha.charAt(7)=='/'){
                isCorrect=true;
            }else{
                System.out.println(Utils.rojo+"introduce una fecha correcta"+Utils.b);
            }
        }
        return fecha;
    }
    public static String leeHora(String msn){
        String hora="";
        for(boolean isCorrect=false;!isCorrect;){
            System.out.println(msn);
            hora=sc.nextLine();
            int caracter=Utils.ExtractorNumeros(hora,0);
            if(hora.length()!=5){
                System.out.println(Utils.rojo+"introduce una longitud correcta"+Utils.b);
            }else if(caracter<51 && caracter>=48){
                caracter=Utils.ExtractorNumeros(hora,0);
                int caracter1=Utils.ExtractorNumeros(hora,1);
                if((caracter==50 && caracter1<53) || (caracter1>=48 && caracter1<=57)){
                    caracter=Utils.ExtractorNumeros(hora,2);
                    if(caracter==58){
                        caracter=Utils.ExtractorNumeros(hora,3);
                        if(caracter<55 && caracter>=48){
                            caracter=Utils.ExtractorNumeros(hora,3);
                            caracter1=Utils.ExtractorNumeros(hora,4);
                            if((caracter==54 && caracter1==48) || (caracter1>=48 && caracter1<=57)){
                                isCorrect=true;
                            }
                        }
                    }
                }
            }else{
                System.out.println(Utils.rojo+"Introduce una hora valida"+Utils.b);
            }
        }
        return hora;
    }

    public static int leeEntero(String msn){
        int numero=0;
        try{
            System.out.println(msn);
            numero=sc.nextInt();
        }catch (Exception e){
            System.out.println(Utils.rojo+"Introduce un numero valido"+Utils.b);
        }
        sc.nextLine();
        return numero;
    }
    public static int leeConsulta(String msn){
        int numero=0;
        boolean isCorrect=false;
        do{
            numero=0;
            try {
                System.out.println(msn);
                numero = sc.nextInt();
                if (numero >= 0 && numero < 3) {
                    isCorrect = true;
                } else {
                    System.out.println(Utils.rojo+"Esa no es una consulta correcta. Existen hasta 5 consultas"+Utils.b);
                }
            } catch (Exception e) {
                System.out.println(Utils.rojo+"Introduce un numero valido"+Utils.b);
                sc.nextLine();
            }
        }while(!isCorrect);
        sc.nextLine();
        return numero;
    }

    public static String leeApellidos(String msn){
        String Apellidos="";
        for(boolean isCorrect=false;!isCorrect;){
            System.out.println(msn);
            Apellidos=sc.nextLine();
            for(int i=0;i<Apellidos.length() && !isCorrect;i++){
                char caracter=Apellidos.charAt(i);
                if(caracter==' '){
                    isCorrect=true;
                }

            }
            if(!isCorrect){
                System.out.println(Utils.rojo+"Debes introducir los dos apellidos"+Utils.b);
            }
        }

        return Apellidos;
    }
}
