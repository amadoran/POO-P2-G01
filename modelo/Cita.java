package modelo;
import java.util.*;
//Se crea la clase cita con sus respectivos atributos
public class Cita{
  private String fechacita;
  private Servicio servicio;
  private Cliente cliente;
  private Empleado empleado;
  //Constructor
  public Cita(String fechacita,Servicio servicio, Cliente cliente,Empleado empleado){
    this.fechacita=fechacita;
    this.servicio=servicio;
    this.cliente=cliente;
    this.empleado=empleado;
  }
  //crea cita una nueva cita con los parametros indicados
  public static String crearCita(String fechacita,Servicio servicio,Cliente cliente, Empleado empleado){
    new Cita(fechacita,servicio,cliente,empleado);
    return "Cita creada";
  }
  //Consulta una cita de acuerdo a la fecha ingresada
   public static void consultarCita(ArrayList<Cita> citas){
    Scanner sc =new Scanner(System.in);
      String fechaAConsultar;
      System.out.println("Ingrese la fecha a consultar");
      fechaAConsultar=sc.nextLine();
      for(Cita c : citas){
        if (c.getFechaCita().equals(fechaAConsultar)){
          System.out.println(c);
        }
      }
    }
  //Elimina una cita de acuerdo a la cedula y la fecha de la cita que se desea eliminar
  public static void eliminarCita(ArrayList<Cita> citas){
    Scanner usuario=new Scanner(System.in);
    System.out.println("Ingrese la cedula del usuario");
    int Cedulaeliminar=usuario.nextInt();
    System.out.println("Escriba la fecha de la cita que desea eliminar");
    Scanner usuario2=new Scanner(System.in);
    String fecha=usuario2.nextLine();
    for(int i=0;i<citas.size();i++)
    {
      if(fecha.equals(citas.get(i).getFechaCita())&&(Cedulaeliminar == (citas.get(i).getCliente().getCedula()))){
        citas.remove(i);
      }
    }    
    
  }
  //getters
  public String getFechaCita(){
    return fechacita;
  } 
  public Cliente getCliente(){
    return cliente;
  }
  public Servicio getServicio(){
    return servicio;
  }
  //Metodo toString de la clase cita 
  public String toString(){
    return "Cita {FechaCita: " + fechacita + ", Servicio: " + servicio + ", Cliente: " + cliente + ", Empleado: " + empleado + "}";
  }
}