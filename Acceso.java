
/**
 * Write a description of class Acceso here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Acceso
{
    private int hora;

    /**
     * Constructor for objects of class Acceso
     */
    public Acceso(int anyo, int mes, int dia, int hora, int minuto)
    {
        this.hora = hora;
    }

    /**
     * Informa de la hora de acceso.
     */
    public int getHoraDeAcceso()
    {
        return hora;
    }
}
