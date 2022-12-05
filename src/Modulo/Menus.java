package Modulo;

import java.util.Scanner;

public class Menus {
    public Consulta consulta;
    public Utils utils=new Utils();
    static int numero=9999;

    Consulta pacientes[]=new Consulta[numero];
    public boolean Index(){
        boolean End=false;
        for(;End==false;){
            System.out.println("Elije una opcion");
            System.out.println("Consulta- Historial de Pacientes de consulta");
            System.out.println("Hospitalizados- Historial Hospitalizados");
            System.out.println("Salir- Salir del programa");
            String opcion=utils.leeComando("Introduce opcion");
            if(opcion.equals("CONSULTA")){
                Consulta();
            }else if(opcion.equals("HOSPITALIZADOS")){

            }else if(opcion.equals("SALIR")){
                End=true;
            }
        }
        return End;
    }
    public void Consulta(){
        for(boolean Atras=false;Atras==false;) {
            System.out.println("Menu Consulta: Elije una opcion");
            System.out.println("Crear- Crearas un nuevo de paciente o grupo de pacientes");
            System.out.println("Eliminar- Eliminaras un paciente o grupo de Pacientes");
            System.out.println("Modificar- Modificaras un paciente o grupo de pacientes");
            System.out.println("Buscar- Bucaras en la base de datos un paciente o grupo de pacientes");
            System.out.println("Atras- Volveras al menu anterior");
            String opcion=utils.leeComando("Introduce opcion");
            if (opcion.equals("CREAR")) {
                CPC();
            } else if (opcion.equals("ELIMINAR")) {

            } else if (opcion.equals("MODIFICAR")) {

            } else if (opcion.equals("BUSCAR")) {
                String dni=utils.leeDNI("Introduce DNI a buscar");

            } else if(opcion.equals("ATRAS")){
                Atras=true;
            }
        }
    }

    public void CPC(){ //Menu creacion paciente de consulta
        Scanner sc=new Scanner(System.in);
        for(boolean Atras=false;Atras==false;){
            System.out.println("Menu Crear Paciente");
            System.out.println("Nuevo paciente- Creara un solo paciente");
            System.out.println("Resetear- Reseteara la base de datos de pacientes para introducir nuevos");
            System.out.println("Atras- Volveras al menu anterior");
            String opcion=utils.leeComando("Introduce opcion");
            if (opcion.equals("NUEVO PACIENTE")) {

                    String Dni = utils.leeDNI("Introduce DNI");
                    System.out.println("Introduce Nombre del paciente");
                    String Nombre = sc.nextLine();
                    String Nacimiento = utils.leeNacimiento();
                    boolean Encontrado=false;
                    for(int i=0;i<pacientes.length && Encontrado==false;i++){ //buscara un espacio vacio en memoria donde almacenar el nuevo paciente
                        if(pacientes[i]==null){
                            pacientes[i]=new Consulta(Dni,Nombre,Nacimiento);
                            Encontrado=true;
                        }
                    }

            } else if (opcion.equals("NUEVO GRUPO")) {

                int n=utils.leeEntero("Introduce total de Pacientes");
                Consulta paciente[]=new Consulta[n];// el usuario asignara el tamaño
                for(int i=0;i<paciente.length;i++) { //repetira tantas veces como tamaño tenga el array de objeto. De este modo recojeremos los datos de todos los pacientes que desee el usuario agregar
                    String Dni = utils.leeDNI("Introduce DNI");
                    System.out.println("Introduce Nombre del paciente");
                    String Nombre = sc.nextLine();
                    String Nacimiento = utils.leeNacimiento();
                    paciente[i]=new Consulta(Dni,Nombre,Nacimiento);

                }

            } else if (opcion.equals("ATRAS")) {

                Atras=true;

            }
        }
    }
}
