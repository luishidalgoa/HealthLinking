package controlador;
import Objects.*;
import utils.Read;
import utils.Utils;
import Menu.*;

public class Controlador {
    public static boolean MenuPrincipal(int opcion,Paciente[]pacientes,Consulta[]Consulta){
        boolean End=false;
        switch (opcion) {
            case 1:
                Menus.CPC(pacientes,Consulta);
                break;
            case 2:
                String dni = Read.leeDNI("Introduce el DNI del paciente a" + Utils.rojo + " eliminar"+Utils.b);
                boolean Encontrado = false;
                boolean confirmar = false;
                for (int i = 0; i < pacientes.length && !confirmar; i++) {
                    if (pacientes[i] != null) {
                        Encontrado = pacientes[i].BuscarDNI(dni, Encontrado);
                        if (Encontrado) {
                            confirmar = Utils.confirmar("Desea realmente eliminar el paciente con el dni " + dni);
                            if (confirmar) {
                                pacientes[i] = null;
                            } else {
                                confirmar = true;
                            }
                        }
                    }
                }
                break;
            case 3:
                /**
                 * Comprobara si existe el Paciente con el dni introducido. Si existe se podra modificar. Si no no sera posible modificarlo.
                 * Este metodo enviara al metodo buscar del objeto Consulta el dni que se desea buscar. si se encuentra se enviara al metodo
                 * Modificar de Consulta el dni del paciente a modificar y se volveran a reescribir los datos
                 */
                dni = Read.leeDNI("Introduce DNI a buscar para modificar Paciente");
                Encontrado = false;
                int i = 0;
                for (; i < pacientes.length && !Encontrado; i++) {
                    if (pacientes[i] != null) {
                        Encontrado = pacientes[i].BuscarDNI(dni, Encontrado);
                        if (Encontrado) {
                            pacientes[i].Modificar();
                            System.out.println(Utils.verde + "Se modificaron los datos del paciente " + pacientes[i].getNombre() + " correctamente" + Utils.b);
                        }
                    }
                }
                if (!Encontrado) {
                    System.out.println(Utils.rojo + "No se encontro el paciente con el DNI: " + dni + Utils.b);
                }
                break;
            case 4:
                dni = Read.leeDNI("Introduce DNI a buscar");
                Encontrado = false;
                for (int b = 0; b < pacientes.length && !Encontrado; b++) {
                    if (pacientes[b] != null) {
                        Encontrado = pacientes[b].BuscarDNI(dni, Encontrado);
                        if (Encontrado) {
                            pacientes[b].toString(b);
                        }
                    }
                }
                if (!Encontrado) {
                    System.out.println(Utils.rojo + "No se encontro. Consulte un DNI de paciente registrado" + Utils.b);
                }
                break;
            case 5:
                Encontrado = false;
                for (int c = 0; c < pacientes.length; c++) {
                    if (pacientes[c] != null) {
                        pacientes[c].toString(c);
                        if (!Encontrado) {
                            Encontrado = true;
                        }
                    }
                }
                if (!Encontrado) {
                    System.out.println(Utils.rojo + "No existe registro de pacientes" + Utils.b);
                }
                break;
            case 6:
                End = true;
                break;
            case 7:
                int[] result = new int[10];
                int reiterar = 0;
                for (int d = 0; d < 10; d++) {
                    Encontrado = false;
                    for (int e = 0; e < pacientes.length && !Encontrado; e++) {
                        if (pacientes[e] == null) {
                            result[d] = e + reiterar;
                            Encontrado = true;
                            reiterar++;
                        }
                    }
                    if (d == 9) {
                        for (int c = 0; c < 10; c++) {//generar pacientes de consulta aleatorios
                            pacientes[result[c]] = new Paciente(Consulta);
                        }
                    }
                }
                break;
        }
        return End;
    }
    public static boolean MenuPacientes(int opcion,Paciente[]pacientes,Consulta[]Consulta){
        boolean Atras=false;
        switch (opcion){
            case 1:
                String Dni = Read.leeDNI("Introduce DNI");
                String Nombre = Read.leeNombre("Introduce nombre del paciente");
                String Apellidos=Read.leeApellidos("Introduce Apellidos del paciente");
                String Nacimiento = Read.leeFecha("Introduce la fecha de Nacimiento YYYY/MM/DD");
                String Descripcion= Read.leeNombre("Introduce Descripcion del paciente");
                int consulta= Read.leeConsulta("Introduce el numero de la consulta asignada a la cita medica");
                String InformeMedico= Read.leeNombre("Introduce informe del medico (OPCIONAL)");
                boolean Encontrado=false;
                for(int i=0;i<pacientes.length && !Encontrado;i++){ //buscara un espacio vacio en memoria donde almacenar el nuevo paciente
                    if(pacientes[i]==null){
                        String Doctor=Consulta[consulta].getDoctor(consulta);
                        String FechaCita=Consulta[consulta].getCita(consulta,i);
                        String HoraCita=Consulta[consulta].getHora(i);
                        pacientes[i]=new Paciente(Dni,Nombre,Apellidos,Nacimiento,Descripcion,consulta,InformeMedico,Doctor,FechaCita,HoraCita);
                        Encontrado=true;
                    }
                }
                break;
            case 2:
                int n=Read.leeEntero("Introduce total de Pacientes");
                Paciente paciente[]=new Paciente[n];// el usuario asignara el tamaño
                for(int i=0;i<paciente.length;i++) { //repetira tantas veces como tamaño tenga el array de objeto. De este modo recojeremos los datos de todos los pacientes que desee el usuario agregar
                    Dni = Read.leeDNI("Introduce DNI");
                    Nombre = Read.leeNombre("Introduce nombre del paciente");
                    Apellidos=Read.leeApellidos("Introduce Apellidos del paciente");
                    Nacimiento = Read.leeFecha("Introduce la fecha de Nacimiento YYYY/MM/DD");
                    Descripcion= Read.leeNombre("Introduce Descripcion del paciente");
                    consulta= Read.leeConsulta("Introduce el numero de la consulta asignada a la cita medica");
                    InformeMedico= Read.leeNombre("Introduce informe del medico (OPCIONAL)");
                    String Doctor=Consulta[consulta].getDoctor(consulta);
                    String FechaCita=Consulta[consulta].getCita(consulta,i);
                    String HoraCita=Consulta[consulta].getHora(i);
                    pacientes[i]=new Paciente(Dni,Nombre,Apellidos,Nacimiento,Descripcion,consulta,InformeMedico,Doctor,FechaCita,HoraCita);

                }
                break;
            case 3:
                Atras=true;
                break;
        }
        return Atras;
    }
}
