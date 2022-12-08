package Modulo;

import javax.print.Doc;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Esta clase almacenara las 10 citas medicas fijadas en el calendario de cada consulta y las consultas del centro medico
 */
public class CitasMedicas {
    private String Doctor;
    private String[]Citas=new String[9999]; // CITAS Y HORA ESTAN ASOCIADOS POR EL MISMO identificador
    private String[]Hora=new String[9999];
    public CitasMedicas(int Consulta,int identificador){
        this.Doctor=esDoctor(Consulta);
        leeCita("Introduce fecha de la cita YYYY/MM/dd",Consulta,identificador); //este metodo concretara la fecha y hora de la cita
    }
    public String esDoctor(int Consulta){
        String[]Doctor={"Jose Hidalgo Pedraza","Dora Pintor Requena","José Ángel del Gordillo","Maxi Pedrosa-Murillo","Edmundo Llorente Cisneros","Teodoro Mayoral Cañizares","Jerónimo Crespi","Ariel Rojas Llopis","Alba Pintor Sanmartín","Gilberto Ribera Anguita","Bautista del Cerdá"};
        this.Doctor=Doctor[Consulta];
        return this.Doctor;
    }

    /**
     * Metodo que revisara que la fecha seleccionada y hora no este registrada en la base de datos
     * @param Consulta
     * @return
     */
    public void leeCita(String msn,int Consulta,int identificador){
        Scanner sc=new Scanner(System.in);
        Utils utils=new Utils();
        System.out.println("Fechas ya programadas de la consulta "+ Consulta);
        String Fmayor=""; //guardara la fecha mayor
        String Hmayor=""; //guardara la hora mayor
        int Mayor=0;

        for(int i=0;i<this.Citas.length;i++){
            if(this.Hora[i]!=null){
                if(this.Citas[i].compareTo(Fmayor)>0 && this.Hora[i].compareTo(Hmayor)>0){
                    Fmayor=this.Citas[i];
                    Hmayor=this.Hora[i];
                    Mayor=i;
                }
                System.out.println(this.Citas[i]+" Hora: "+Hora[i]);
            }
        }
        String Fecha="2004-12-12";String hora="";
        for(boolean isCorrect=false;isCorrect==false;){
            if(this.Citas[Mayor]==null || this.Hora[Mayor]==null){
                System.out.println("No hay fechas concretadas en la consulta " + Consulta + " recomendamos la cita en la fecha "+ utils.fechaActual());
                Fecha=utils.leeFecha("Introduce Fecha de la cita YYYY/MM/dd");
                hora=utils.leeHora("Introduce la Hora de la consulta HH:MM    (nota: debe tener un intervalo de 30 min)");
                if(Fecha.compareTo(utils.fechaActual())>0 && hora.compareTo(Hmayor)>2.9){
                    this.Citas[identificador]=Fecha;
                    this.Hora[identificador]=hora;
                    isCorrect=true;
                }else{
                    System.out.println("Introduce fecha u hora minima a la actual.");
                }
            }else{
                System.out.println("La ultima cita registrada es a las "+this.Citas[Mayor]+" - "+ this.Hora[Mayor]+ " Horas");
                Fecha=utils.leeFecha("Introduce Fecha de la cita YYYY/MM/dd");
                hora=utils.leeHora("Introduce la Hora de la consulta HH:MM    (nota: debe tener un intervalo de 30 min)");
                //necesitamos realizar un filtro de la fecha para luego buscar en un bucle que no haya ninguna fecha con X hora+ intervalo 30 min registrado en la base de datos
                if(Fecha.compareTo(Fmayor)>0 && hora.compareTo(Hmayor)>2.9){
                    this.Citas[identificador]=Fecha;
                    this.Hora[identificador]=hora;
                    isCorrect=true;
                }
            }
        }
    }
    public String fecha(String fecha){
        SimpleDateFormat formatoFecha=new SimpleDateFormat("YYYY/MM/dd");
        System.out.println(fecha);
        return formatoFecha.format(fecha);
    }

    public String getCita(int i){return this.Citas[i];}
    public String getHora(int i){return this.Hora[i];}
    public String getDoctor(){return this.Doctor;}
}
// RESTRINGIR QUE LA FECHA INTRODUCIDA SEA MINIMO 1 DIA DESPUES a la actual