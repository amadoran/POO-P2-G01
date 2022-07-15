package modelo;
import java.util.*;
public class Cita{
  private String fechacita;
  private String tipoCita;
  public Cita(String fechacita,String tipoCita){
    this.fechacita=fechacita;
    this.tipoCita=tipoCita;
    
  }
  public String crearCita(String fechacita,String tipoCita){
    new Cita(fechacita,tipoCita);
    return "Cita creada:"+fechacita+""+tipoCita;
    
  }
   public String consultarCita(String fechacita,String tipoCita){
    Scanner usuario2=new Scanner(System.in);
     System.out.println("Ingrese la fecha de la cita:");
     String fechausuario=usuario2.next();
     if(fechausuario.equals(fechacita)){
      
     }
     return "Consulta de la cita";
  }
  public void eliminarCita(){
    Scanner usuario=new Scanner(System.in);
    System.out.println("Ingrese la cedula del usuario");
    int Cedulaeliminar=usuario.nextInt();
    if(){}
    
    
  }
    public String getFechaCita(){
    return fechacita;
  } 
  public String getTipoCita(){
    return tipoCita;
  }
 
}