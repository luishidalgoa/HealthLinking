package Modulo;

import javax.print.Doc;
import java.util.Scanner;

public class Menus {
    public Utils utils=new Utils();
    Consulta pacientes[]=new Consulta[9999];
    public boolean Index(){
utils.fechaActual();
        for(int i=0;i<6;i++){//generar pacientes de consulta aleatorios
            pacientes[i]=new Consulta();
        }
        boolean End=false;
        while(!End){
            System.out.println(utils.amarillo+"Elije una opcion");
            System.out.println("Consulta- Historial de Pacientes de consulta");
            System.out.println("Hospitalizados- Historial Hospitalizados");
            System.out.println("Salir- Salir del programa"+utils.b);
            String opcion=utils.leeComando(utils.magenta+"Introduce opcion"+utils.b);
            if(opcion.equals("CONSULTA")){
                Consulta();
            }else if(opcion.equals("HOSPITALIZADOS")){
                Hospital hospital=new Hospital();
                for (boolean atras=false;!false;){
                    atras=hospital.main(atras);
                }
            }else if(opcion.equals("SALIR")){
                End=true;
            }
        }
        return End;
    }
    public void Consulta(){
        for(boolean Atras=false;!Atras;) {
            System.out.println(utils.amarillo+"Menu Consulta: Elije una opcion");
            System.out.println("Crear- Crearas un nuevo de paciente o grupo de pacientes");
            System.out.println("Eliminar- Eliminaras un paciente o grupo de Pacientes");
            System.out.println("Modificar- Modificaras un paciente o grupo de pacientes");
            System.out.println("Buscar- Bucaras en la base de datos un paciente o grupo de pacientes");
            System.out.println("All- Mostrara todos los pacientes registrados");
            System.out.println("Atras- Volveras al menu anterior"+utils.b);
            String opcion=utils.leeComando(utils.magenta+"Introduce opcion"+utils.b);
            if (opcion.equals("CREAR")) {
                CPC();
            } else if (opcion.equals("ELIMINAR")) {

                String dni=utils.leeDNI("Introduce el DNI del paciente a"+utils.rojo+ " eliminar");
                boolean Encontrado=false;
                boolean confirmar=false;
                for(int i=0;i<pacientes.length && !confirmar;i++){
                    if(pacientes[i]!=null){
                        Encontrado=pacientes[i].BuscarDNI(dni,Encontrado);
                        if(Encontrado){
                            confirmar=utils.confirmar("Desea realmente eliminar el paciente con el dni "+dni);
                            if(confirmar){
                                pacientes[i]=null;
                            }else{
                                confirmar=true;
                            }
                        }
                    }
                }

            } else if (opcion.equals("MODIFICAR")) {
/**
 * Comprobara si existe el Paciente con el dni introducido. Si existe se podra modificar. Si no no sera posible modificarlo.
 * Este metodo enviara al metodo buscar del objeto Consulta el dni que se desea buscar. si se encuentra se enviara al metodo
 * Modificar de Consulta el dni del paciente a modificar y se volveran a reescribir los datos
 */
                String dni=utils.leeDNI("Introduce DNI a buscar para modificar Paciente");
                boolean Encontrado=false;
                int i=0;
                for(;i<pacientes.length && !Encontrado;i++){
                    if(pacientes[i]!=null){
                        Encontrado=pacientes[i].BuscarDNI(dni,Encontrado);
                        if(Encontrado){
                            pacientes[i].Modificar();
                            System.out.println(utils.getVerde()+"Se modificaron los datos del paciente "+pacientes[i].getNombre()+" correctamente"+utils.b);
                        }
                    }
                }
                if (!Encontrado){
                    System.out.println(utils.rojo+"No se encontro el paciente con el DNI: "+dni+utils.b);
                }

            } else if (opcion.equals("BUSCAR")) {

                String dni=utils.leeDNI("Introduce DNI a buscar");
                boolean Encontrado=false;
                for(int i=0;i<pacientes.length && !Encontrado;i++){
                    if(pacientes[i]!=null){
                        Encontrado=pacientes[i].BuscarDNI(dni,Encontrado);
                        if(Encontrado){
                            pacientes[i].toString(i);
                        }
                    }
                }
                if (!Encontrado){
                    System.out.println(utils.rojo+"No se encontro. Consulte un DNI de paciente registrado"+utils.b);
                }

            } else if (opcion.equals("ALL")) {
                boolean Encontrado=false;
                for(int i=0;i<pacientes.length;i++){
                    if(pacientes[i]!=null){
                        pacientes[i].toString(i);
                        if(!Encontrado){
                            Encontrado=true;
                        }
                    }
                }
                if(!Encontrado){
                    System.out.println(utils.rojo+"No existe registro de pacientes"+utils.b);
                }

            } else if(opcion.equals("ATRAS")){
                Atras=true;
            }else if(opcion.equals("NUEVOS")){  //Comando oculto genera 10 pacientes nuevos
                int[]result=new int[10];
                int reiterar=0;
                for(int i=0;i<10;i++){
                    boolean Encontrado=false;
                    for(int e=0;e<this.pacientes.length && Encontrado==false;e++){
                        if(this.pacientes[e]==null){
                            result[i]=e+reiterar;
                            Encontrado=true;
                            reiterar++;
                        }
                    }
                    if(i==9){
                        for(int c=0;c<10;c++){//generar pacientes de consulta aleatorios
                            this.pacientes[result[c]]= new Consulta();
                        }
                    }
                }
            }
        }
    }

    public void CPC(){ //Menu creacion paciente de consulta
        Scanner sc=new Scanner(System.in);
        for(boolean Atras=false;!Atras;){
            System.out.println(utils.amarillo+"Menu Crear Paciente");
            System.out.println("Nuevo paciente- Creara un solo paciente");
            System.out.println("Resetear- Reseteara la base de datos de pacientes para introducir nuevos");
            System.out.println("Atras- Volveras al menu anterior"+utils.b);
            String opcion=utils.leeComando(utils.magenta+"Introduce opcion"+utils.b);
            if (opcion.equals("NUEVO PACIENTE")) {

                    String Dni = utils.leeDNI("Introduce DNI");
                    String Nombre = utils.leeNombre("Introduce nombre del paciente");
                    String Apellidos=utils.leeApellidos("Introduce Apellidos del paciente");
                    String Nacimiento = utils.leeFecha("Introduce la fecha de Nacimiento YYYY/MM/DD");
                    String Descripcion= utils.leeNombre("Introduce Descripcion del paciente");
                    int Consulta= utils.leeConsulta("Introduce el numero de la consulta asignada a la cita medica");
                    String InformeMedico= utils.leeNombre("Introduce informe del medico (OPCIONAL)");
                    boolean Encontrado=false;
                    for(int i=0;i<pacientes.length && !Encontrado;i++){ //buscara un espacio vacio en memoria donde almacenar el nuevo paciente
                        if(pacientes[i]==null){
                            pacientes[i]=new Consulta(Dni,Nombre,Apellidos,Nacimiento,Descripcion,Consulta,InformeMedico,i);
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
                    String Nacimiento = utils.leeFecha("Introduce la fecha de Nacimiento YYYY/MM/DD");
                    //paciente[i]=new Consulta(Dni,Nombre,Nacimiento);

                }

            } else if (opcion.equals("ATRAS")) {

                Atras=true;

            }
        }
    }
}
//Terminar grupo de pacientes
//Terminar la generacion automatica de datos
