package Modulo;

public class Hospital {
Utils utils=new Utils();

    private String DNI;
    private String Nombre;
    private String Nacimiento;
    private String FechaEntrada;
    private String FechaSalida;
    private String InformeMedico;
    private int Habitacion;
    public boolean main(boolean atras){
        while(!atras){
            System.out.println(utils.amarillo+"Menu Hospitalizados: Elije una opcion");
            System.out.println("Consulta- Historial de Pacientes hospitalizados");
            System.out.println("Hospitalizados- Historial Hospitalizados");
            System.out.println("Habitacion- busca la planta en la que se ubica una habitacion");
            System.out.println("Salir- Salir del programa"+utils.b);
            String opcion=utils.leeComando(utils.magenta+"Introduce opcion"+utils.b);
        }

        return atras;
    }

}
