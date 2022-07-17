//Clase menú
import java.util.ArrayList;
import modelo.*;
public class Main{
  public static ArrayList<Servicio> servicios;
  public static ArrayList<Cita> citas;
  public static ArrayList<Cliente> clientes;
  public static ArrayList<Empleado> empleados;
  public static ArrayList<Atencion> atenciones;
  
  public static void inicializarSistema(){
    servicios = new ArrayList<>();
    servicios.add(new Servicio("Terapia de Lenguaje", 45, 60.0f, Estado.ACTIVO));
  }
  public static void main(String[] args){
    System.out.println("Hello World");
  }  
}