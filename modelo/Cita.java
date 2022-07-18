package modelo;
import java.util.*;
public class Cita{
  private String fechacita;
  private Servicio servicio;
  private Cliente cliente;
  private Empleado empleado;
  public Cita(String fechacita,Servicio servicio, Cliente cliente,Empleado empleado){
    this.fechacita=fechacita;
    this.servicio=servicio;
    this.cliente=cliente;
    this.empleado=empleado;
  }
  public static String crearCita(String fechacita,Servicio servicio,Cliente cliente, Empleado empleado){
    new Cita(fechacita,servicio,cliente,empleado);
    return "Cita creada";
  }
   public static void consultarCita(String fechacita, ArrayList<Cita> citas){
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
  public static void eliminarCita(){
    Scanner usuario=new Scanner(System.in);
    System.out.println("Ingrese la cedula del usuario");
    int Cedulaeliminar=usuario.nextInt();
    System.out.println("Escriba la fecha de la cita que desea eliminar");
    Scanner usuario2=new Scanner(System.in);
    String fecha=usuario2.nextLine();
    for(int i=0;i<Cita.size();i++)
    {
      if(usuario2.equals(Cita.get(i).getFechaCita()&&usuario2.equals(Cita.get(i).getCliente().getCedula()))){
        Cita.remove(i);
      }
    }    
    
  }
    public String getFechaCita(){
    return fechacita;
  } 
 public Cliente getCliente(){
  return cliente;}
public Servicio getServicio(){
  return servicio;
}
}