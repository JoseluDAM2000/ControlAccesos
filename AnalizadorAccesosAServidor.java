import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

/**
 * Write a description of class AnalizadorAccesosAServidor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnalizadorAccesosAServidor
{
    private ArrayList<Acceso> accesos;

    /**
     * Constructor for objects of class AnalizadorAccesosAServidor
     */
    public AnalizadorAccesosAServidor()
    {
        accesos = new ArrayList<Acceso>();
    }

    /**
     * Este método lee el archivo de log y lo analiza.
     */
    public void analizarArchivoDeLog(String nombre)
    {
        try{
            File archivo = new File(nombre);
            Scanner sc = new Scanner(archivo);
            while (sc.hasNextLine()){
                String lineaConsultada = sc.nextLine();
                System.out.println(lineaConsultada);
                String[] lineaActual = lineaConsultada.split(" ");
                Acceso acceso = new Acceso(Integer.parseInt(lineaActual[0]), Integer.parseInt(lineaActual[1]), Integer.parseInt(lineaActual[2]), Integer.parseInt(lineaActual[3]), Integer.parseInt(lineaActual[4]));
                accesos.add(acceso);
            }
        }
        catch(FileNotFoundException e){

        }
    }

    /**
     *  A partir del análisis hecho por el método anterior encuentra la hora 
     *  (solo la hora, sin tener en cuenta los minutos) a la que se producen
     *  más accesos al servidor. El método muestra por pantalla dicha hora y 
     *  la devuelve. En caso de que se invoque este método sin haberse 
     *  invocado el anterior el método informa por pantalla de que no tiene 
     *  datos y no hace nada más.
     */
    public int obtenerHoraMasAccesos()
    {
        int indexGuardado = -1;
        if(accesos.size() != 0){
            int[] horas = new int[24];
            for(Acceso acceso : accesos){
                horas[acceso.getHoraDeAcceso()]++;
            }
            int accesosMaximos = 0;
            int index = 0;
            while(index < horas.length){
                if(horas[index] > accesosMaximos){
                    accesosMaximos = horas[index];
                    indexGuardado = index;
                }
                index++;
            }
        }else{
            System.out.println("Aun no hay datos de acceso.");
        }
        return indexGuardado;
    }

}
