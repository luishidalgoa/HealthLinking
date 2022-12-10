package Objects;

import java.net.StandardSocketOptions;
import java.util.Random;
import utils.*;
public class Paciente {
    private String DNI;
    private String Nombre;
    private String Apellidos;
    private String Nacimiento;
    private String Descripcion;
    private String Cita;
    private String Hora;
    private int Sala; //En realidad deberia llamarse Consulta ya que almacena la consulta de la cita medica
    private String InformeMedico;
    private int Edad;
    private String Doctor;
    //Este atributo actua como id del paciente. y lo utilizamos para asociarlo con el array de citas del objeto Consultas
    private int Identificador;

    /**
     *
     * @param DNI
     * @param Nombre
     * @param Apellidos
     * @param Nacimiento
     * @param Descripcion
     * @param Consulta
     * @param InformeMedico
     * @param Doctor
     * @param FechaCita
     * @param HoraCita
     */
    public Paciente(String DNI, String Nombre, String Apellidos, String Nacimiento, String Descripcion, int Consulta, String InformeMedico, String Doctor, String FechaCita, String HoraCita,int identificador  ){//constructor que recibira los valores del nuevo Paciente
        this.DNI=DNI;
        this.Nombre=Nombre;
        this.Apellidos=Apellidos;
        this.Nacimiento=Nacimiento;
        this.Descripcion=Descripcion;
        this.InformeMedico=InformeMedico;
        this.Edad=Utils.ExtractorEdad(Nacimiento);
        this.Cita=FechaCita;
        this.Hora=HoraCita;
        this.Doctor=Doctor;
        this.Sala=Consulta;
        this.Identificador=identificador;
        System.out.println(Utils.verde+"Se creo correctamente el paciente"+Utils.b);
    }
//metodo que recoje todos los atributos o vaores del paciente y los imrpime en pantalla
    public void toString(int i){
        System.out.println(Utils.amarillo+"                           Datos personales"+Utils.b);
        System.out.println(Utils.verde+" Paciente nº "+i+" DNI: "+this.DNI+" Nombre: "+this.Nombre+" Apellidos: "+this.Apellidos+" Nacimiento: "+this.Nacimiento+" Edad: "+this.Edad);
        System.out.println(" Descripcion de la cita: "+this.Descripcion);
        System.out.println(Utils.amarillo+"                           Datos medicos"+Utils.b);
        System.out.println(Utils.verde+" FechaCita: "+this.Cita+" - "+this.Hora+" Consulta: "+this.Sala+" Profesional Medico: "+this.Doctor);
        System.out.println(" Informe medico: "+this.InformeMedico+Utils.b);
    }
    //Metodo que recoje el dni introducido por
    public boolean BuscarDNI(String dni,boolean Encontrado){

        if(getDNI().equals(dni)){
            Encontrado=true;
        }
        return Encontrado;

    }
    //Metodo que cuando es invocado. Actualizara los datos del paciente
    public void Modificar(Consulta[] Consulta){
        this.DNI=Read.leeDNI("Introduce nuevo DNI del paciente");
        System.out.println("Introduce nuevo nombre del paciente");
        this.Nombre=Read.leeNombre("Introduce el nombre del paciente");
        this.Apellidos=Read.leeApellidos("Inroduce nuevos apellidos");
        this.Nacimiento= Read.leeFecha("Introduce la fecha de Nacimiento YYYY/MM/DD");
        this.Descripcion=Read.leeNombre("Introduce nueva descripcion del paciente");
        this.Sala=Read.leeConsulta("Introduce numero de la consulta asignada a la cita medica");
        this.Doctor=Consulta[this.Sala].getDoctor(this.Sala);
        this.Cita=Consulta[Sala].getCita(this.Sala,Identificador);
        this.Hora=Consulta[Sala].getHora(Identificador);
    }

    /**
     * metodo que generara una base de datos automatica nada mas iniciar el programa. genera cadenas de caracteres aleatorios (investigar)
     * @return
     */
    public Paciente(Consulta[] obj){ //Constructor generador random de Pacientes automaticos
        this.DNI="";
        this.Nombre="";
        this.Nacimiento="";
        String abc="ABCDEFGHYJKLMNOPQRSTUVWXYZ";
        String numeros="0123456789";
        Random random=new Random();
        String[]nombres={"Carlos","Raul","Manuel","Laura","Samuel","Jose","Sebastian","Fidel","Ferran","Fernando","Carmen","Maria","Julia"};
        String[]apellidos={"Hidalgo","Carmona","Lopez","Jimenez","Gonzalez","Crespo","Benitez","Trastamara","Galan","Salazar","Gutierrez","Chasdan","Aguilar","Pedraza","Bornoz","Polonio"};
        String[]descripcion={"Dolor espalda","no vee de lejos","Rotura de pierna","Desmayo","Fuerte tos y mocos","Dolor garganta"};
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
        this.Nombre=nombres[((int)(Math.random()*12))];
        this.Apellidos=apellidos[((int)(Math.random()*15))];
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
                        int result=Utils.ExtractorNumeros(this.Nacimiento,0);
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
                        int result=Utils.ExtractorNumeros(this.Nacimiento,0);
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
                        int result=Utils.ExtractorNumeros(this.Nacimiento,0);
                        if(result==50 && ((result=Utils.ExtractorNumeros(this.Nacimiento,2))==2)){
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
                        int result=Utils.ExtractorNumeros(this.Nacimiento,5);
                        if(result==49){
                            caracter=numeros.charAt((int)(Math.random()*(3-1)+1));
                            this.Nacimiento+=caracter;
                        }else{
                            posicion=(int)(Math.random()*(9-1)+1);
                            caracter=numeros.charAt(posicion);
                            this.Nacimiento+=caracter;
                        }
                    }
                } else if (e>7 && e<10) {
                    if(e==8){
                        caracter=numeros.charAt((int)(Math.random()*3));
                        this.Nacimiento+=caracter;
                    }else if(e==9){
                        int result=Utils.ExtractorNumeros(this.Nacimiento,8);
                        if(result==3){
                            caracter=numeros.charAt(0);
                            this.Nacimiento+=caracter;
                        } else {
                            posicion=(int)(Math.random()*(9-1)+1);
                            caracter=numeros.charAt(posicion);
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
        this.Descripcion=descripcion[((int)(Math.random()*5))];
        this.Sala=((int)(Math.random()*4));
        this.Doctor=obj[0].getDoctor(this.Sala);
        this.Edad=Utils.ExtractorEdad(this.Nacimiento);
    }


    public String getDNI(){ return this.DNI; }

    public String getNombre() {
        return this.Nombre;
    }

}
