package Objects;

import utils.Read;
import utils.Utils;

/**
 * Esta clase almacenara las 10 citas medicas fijadas en el calendario de cada consulta y las consultas del centro medico
 */
public class Consulta {
    private String Doctor;
    private String[]Citas=new String[9999]; // CITAS Y HORA ESTAN ASOCIADOS POR EL MISMO identificador o dicho de otro modo cada identificador es un paciente
    private String[]Hora=new String[9999];
    private String Fmayor=""; //guardara la fecha mayor
    private String Hmayor=""; //guardara la hora mayor

    /**
     * Constructor que generara las 3 consultas que se requieren en el programa
     * @param Consulta recive la consulta que se creara
     * @param Fecha recive la fecha preestablecida para crear el objeto
     * @param Hora
     */
    public Consulta(int Consulta, String Fecha, String Hora) {
        this.Doctor=esDoctor(Consulta);
        this.Citas[0]=Fecha;
        this.Hora[0]=Hora;
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
    public void leeCita(int Consulta,int identificador){
        System.out.println("Fechas ya programadas de la consulta "+ Consulta);
        int Mayor=0;

        for(int i=0;i<this.Citas.length;i++){
            if(this.Hora[i]!=null || this.Citas[i]!=null){
                if(this.Citas[i].compareTo(Fmayor)>=0 && this.Hora[i].compareTo(Hmayor)>0){
                    Fmayor=this.Citas[i];
                    Hmayor=this.Hora[i];
                    Mayor=i;
                }
                System.out.println(Utils.verde+"Cita dia: "+this.Citas[i]+" Hora: "+Hora[i]+Utils.b);
            }
        }
        String Fecha=null;String hora=null;
        for(boolean isCorrect=false;!isCorrect;){
            if(this.Citas[Mayor]==null || this.Hora[Mayor]==null){
                System.out.println("No hay fechas concretadas en la consulta " + Consulta + " recomendamos la cita en la fecha "+ Utils.fechaActual());
                Fecha= Read.leeFecha("Introduce Fecha de la cita YYYY/MM/dd");
                hora=Read.leeHora("Introduce la Hora de la consulta HH:MM    (nota: debe tener un intervalo de 30 min)");
                if(Fecha.compareTo(Utils.fechaActual())>=0 && hora.compareTo(Hmayor)>2.9){
                    this.Citas[identificador]=Fecha;
                    this.Hora[identificador]=hora;
                    isCorrect=true;
                }else{
                    System.out.println("Introduce fecha u hora minima a la actual.");
                }
            }else{
                System.out.println("La ultima cita registrada es a las "+this.Citas[Mayor]+" - "+ this.Hora[Mayor]+ " Horas");
                Fecha=Read.leeFecha(Utils.amarillo+"Introduce Fecha de la cita YYYY/MM/dd"+Utils.b);
                hora=Read.leeHora(Utils.amarillo+"Introduce la Hora de la consulta HH:MM    (nota: debe tener un intervalo de 30 min respecto la anterior)"+Utils.b);
                //necesitamos realizar un filtro de la fecha para luego buscar en un bucle que no haya ninguna fecha con X hora+ intervalo 30 min registrado en la base de datos
                if(!Fecha.equals(Fmayor) && Fecha.compareTo(Fmayor)>0){
                    this.Citas[identificador]=Fecha;
                    this.Hora[identificador]=hora;
                    isCorrect=true;
                }else if(Fecha.compareTo(Fmayor)>=0 && hora.compareTo(Hmayor)>2.9){
                    this.Citas[identificador]=Fecha;
                    this.Hora[identificador]=hora;
                    isCorrect=true;
                }
            }
        }
    }

    public String getCita(int Consulta,int identificador){
        leeCita(Consulta,identificador);
        return this.Citas[identificador];
    }
    public String getHora(int i){return this.Hora[i];}
    public String getDoctor(int Consulta){return esDoctor(Consulta);}
}