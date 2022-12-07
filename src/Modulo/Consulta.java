package Modulo;

import java.util.Random;
import java.util.Scanner;

public class Consulta {
    private String DNI;
    private String Nombre;
    private String Apellidos;
    private String Nacimiento;
    private String FechaCita;
    private String Descripcion;
    private String Consulta;
    private String InformeMedico;
    private int Edad;
    Utils utils=new Utils();

    public Consulta(String DNI,String Nombre,String Apellidos,String Nacimiento,String FechaCita,String Descripcion,String Consulta,String InformeMedico){//constructor que recibira los valores del nuevo Paciente
        this.DNI=DNI;
        this.Nombre=Nombre;
        this.Apellidos=Apellidos;
        this.Nacimiento=Nacimiento;
        this.FechaCita=FechaCita;
        this.Descripcion=Descripcion;
        this.Consulta=Consulta;
        this.InformeMedico=InformeMedico;
        this.Edad=utils.ExtractorEdad(Nacimiento);
    }

    public void toString(int i){
        Utils utils=new Utils();
        System.out.println(utils.getVerde()+"Paciente nº "+i+" DNI: "+this.DNI+" Nombre: "+this.Nombre+" Nacimiento: "+this.Nacimiento+utils.getB()) ;
    }

    public boolean BuscarDNI(String dni,boolean Encontrado){

        if(getDNI().equals(dni)){
            Encontrado=true;
        }
        return Encontrado;

    }
    public void Modificar(){

        Scanner sc=new Scanner(System.in);
        this.DNI=utils.leeDNI("Introduce nuevo DNI del paciente");
        System.out.println("Introduce nuevo nombre del paciente");
        this.Nombre=sc.nextLine();
        this.Nacimiento= utils.leeNacimiento("Introduce la fecha de Nacimiento YYYY-MM-DD");

    }

    /**
     * metodo que generara una base de datos automatica nada mas iniciar el programa. genera cadenas de caracteres aleatorios (investigar)
     * @return
     */
    public Consulta(){ //Constructor generador random de Pacientes
        this.DNI="";
        this.Nombre="";
        this.Nacimiento="";
        String abc="ABCDEFGHYJKLMNOPQRSTUVWXYZ";
        String numeros="0123456789";
        Random random=new Random();
        String[]nombres={"Carlos","Raul","Manuel","Laura","Samuel","Jose","Sebastian","Fidel","Ferran","Fernando"};
        for(int e=0;e<9;e++){
            if(e<8){
                int posicion= random.nextInt(numeros.length());
                char caracter= numeros.charAt(posicion);
                this.DNI+=caracter;
            }else{
                int posicion= random.nextInt(abc.length());
                char caracter=abc.charAt(posicion);
                this.DNI+=caracter;
            }
        }
        this.Nombre=nombres[((int)(Math.random()*9))];
        for(int e=0;e<10;e++){
            char caracter='a';
            int posicion=0;
            if(e<4 || (e>4 && e<7) || e>7){
                if(e<4){
                    if(e==0){
                        posicion=((int)(Math.random()*(2)+1));
                        caracter=numeros.charAt(posicion);
                        this.Nacimiento+=caracter;
                    }else if(e==1){
                        int result=utils.ExtractorNumeros(this.Nacimiento,0);
                        if(result==50){
                            caracter=numeros.charAt(0);
                            this.Nacimiento+=caracter;
                        } else if (result==49){
                            posicion=(int)(Math.random()*(9-9)+9);
                            caracter=numeros.charAt(posicion);
                            this.Nacimiento+=caracter;
                        } else{
                            posicion= random.nextInt(numeros.length());
                            caracter=numeros.charAt(posicion);
                            this.Nacimiento+=caracter;
                        }
                    }else if(e==2){
                        int result=utils.ExtractorNumeros(this.Nacimiento,0);
                        if(result==50){
                            posicion=((int)(Math.random()*2));
                            caracter=numeros.charAt(posicion);
                            this.Nacimiento+=caracter;
                        }else{
                            posicion= random.nextInt(numeros.length());
                            caracter=numeros.charAt(posicion);
                            this.Nacimiento+=caracter;
                        }
                    }else if(e==3){
                        int result=utils.ExtractorNumeros(this.Nacimiento,0);
                        if(result==50 && ((result=utils.ExtractorNumeros(this.Nacimiento,2))==2)){
                            posicion=((int)(Math.random()*2));
                            caracter=numeros.charAt(posicion);
                            this.Nacimiento+=caracter;
                        }else{
                            posicion= random.nextInt(numeros.length());
                            caracter=numeros.charAt(posicion);
                            this.Nacimiento+=caracter;
                        }
                    }
                }else if (e>4 && e<7) {
                    if(e==5){
                        this.Nacimiento+=caracter=numeros.charAt((int)(Math.random()*2));
                    }else if(e==6){
                        int result=utils.ExtractorNumeros(this.Nacimiento,5);
                        if(result==1){
                            this.Nacimiento+=caracter=numeros.charAt((int)(Math.random()*3));
                        }else{
                            posicion= random.nextInt(numeros.length());
                            caracter= numeros.charAt(posicion);
                            this.Nacimiento+=caracter;
                        }
                    }
                } else{
                    posicion= random.nextInt(numeros.length());
                    caracter= numeros.charAt(posicion);
                    this.Nacimiento+=caracter;
                }
            }else{
                this.Nacimiento+='/';
            }
        }
    }


    public String getDNI(){ return this.DNI; }

    public String getNombre() {
        return this.Nombre;
    }

}
