package Menu;

import Objects.Consulta;
import Objects.Paciente;
import controlador.Controlador;
import utils.*;

import javax.naming.ldap.Control;
import java.util.Scanner;

public class Menus {
    Scanner sc=new Scanner(System.in);
    Paciente pacientes[]=new Paciente[9999];
    Objects.Consulta Consulta[]=new Consulta[6];

    /**
     * Metodo que se ejecutara 1 vez durante toda la ejecucion del programa.
     * Este metodo genera las consultas totales del centro de salud e invoca la generacion automatica de pacientes
     * @return
     */
    public boolean Execute(){
        this.Consulta[0]=new Consulta(0,Utils.fechaActual(),"08:00");
        this.Consulta[1]=new Consulta(0,Utils.fechaActual(),"08:00");
        this.Consulta[2]=new Consulta(0,Utils.fechaActual(),"08:00");
        //generador automatico de pacientes
        Utils.fechaActual();
        for(int i=0;i<6;i++){//generar pacientes de consulta aleatorios
            pacientes[i]=new Paciente(Consulta);
        }
        //generador de consultas
        boolean End=Index();
        return End;
    }

    /**
     * 
     * @return
     */
    public boolean Index(){
        boolean End=false;
        while(!End){
            Imprimir.P(Utils.rojo+":-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=:");
            Imprimir.P("|                                                                                          |");
            Imprimir.P("|                                "+Utils.verde+"MENU PRINCIPAL "+Utils.celeste+"HealthLinking"+Utils.rojo+"                              |");
            Imprimir.P("|                                                                                          |");
            Imprimir.P("|"+Utils.amarillo+"    [1]-          Crearas un nuevo paciente o grupo de pacientes     "+Utils.rojo+"                     |");
            Imprimir.P("|                                                                                          |");
            Imprimir.P("|"+Utils.amarillo+"    [2]-          Eliminaras un paciente o grupo de Pacientes"+Utils.rojo+"                             |");
            Imprimir.P("|                                                                                          |");
            Imprimir.P("|"+Utils.amarillo+"    [3]-          Modificaras un paciente o grupo de pacientes     "+Utils.rojo+"                       |");
            Imprimir.P("|                                                                                          |");
            Imprimir.P("|"+Utils.amarillo+"    [4]-          Bucaras en la base de datos un paciente o grupo de pacientes"+Utils.rojo+"            |");
            Imprimir.P("|                                                                                          |");
            Imprimir.P("|"+Utils.amarillo+"    [5]-          Mostrara todos los pacientes registrados                  "+Utils.rojo+"              |");
            Imprimir.P("|                                                                                          |");
            Imprimir.P("|"+Utils.amarillo+"    [6]-          Finalizaras el programa                    "+Utils.rojo+"                             |");
            Imprimir.P("|                                                                                          |");
            Imprimir.P(":-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=:");
            int opcion=Read.leeEntero(Utils.magenta+"Introduce opcion"+Utils.b);
            End=Controlador.MenuPrincipal(opcion,this.pacientes,this.Consulta);
        }
        return End;
    }

    /**
     *
     * @param pacientes
     * @param Consulta
     */
    public static void CPC(Paciente[]pacientes,Consulta[]Consulta){ //Menu creacion paciente de consulta
        for(boolean Atras=false;!Atras;){
            Imprimir.P(Utils.rojo+":-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=:");
            Imprimir.P("|                                                                                          |");
            Imprimir.P("|                                  "+Utils.verde+"MENU CREAR PACIENTE "+Utils.rojo+"                                    |");
            Imprimir.P("|                                                                                          |");
            Imprimir.P("|"+Utils.amarillo+"    [1]-          Crearas un nuevo paciente                          "+Utils.rojo+"                     |");
            Imprimir.P("|                                                                                          |");
            Imprimir.P("|"+Utils.amarillo+"    [2]-          La base de datos de pacientes para introducir nuevos"+Utils.rojo+"                    |");
            Imprimir.P("|                                                                                          |");
            Imprimir.P("|"+Utils.amarillo+"    [3]-          Volveras al menu anterior     "+Utils.rojo+"                                          |");
            Imprimir.P("|                                                                                          |");
            Imprimir.P(":-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=:");
            int opcion=Read.leeEntero(Utils.magenta+"Introduce opcion"+Utils.b);
            Atras=Controlador.MenuPacientes(opcion,pacientes,Consulta);
        }
    }
}
