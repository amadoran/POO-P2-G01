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
  public String crearCita(String fechacita,Servicio servicio,Cliente cliente, Empleado empleado){
    new Cita(fechacita,servicio,cliente,empleado);
    return "Cita creada";
    
  }
   public String consultarCita(String fechacita,String tipoCita){
    Scanner usuario2=new Scanner(System.in);
     if(fechacita.isEmpty()){
       System.out.println("No hay citas pendientes");
      
     }
     else{
       System.out.println("Escriba la fecha de la cita que desea eliminar");
            System.out.println("Ingrese la fecha de la cita:");
     String fechausuario=usuario2.nextLine();
       for (int i=0;i<Cita.size();i++){
         if(fechausuario.euals(Cita.get(i).getFechaCita()&&
         
      }
     }
  }
  public void eliminarCita(){
    Scanner usuario=new Scanner(System.in);
    System.out.println("Ingrese la cedula del usuario");
    int Cedulaeliminar=usuario.nextInt();
    
    
    
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