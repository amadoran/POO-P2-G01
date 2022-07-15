package modelo;
import java.util.*;

public class Empleado extends Personal{
  private Estado estado;


  //constructor
  public Empleado(int cedula,String nombre, String apellido, int telefono, String correo, Estado estado){
    super(cedula, nombre, apellido, telefono,correo);
    this.estado = estado;
    
  }

  //metodos
  public void agregarEmpleado(int cedula, String nombre, String apellido, int telefono, String correo, Estado estado){
    new Empleado(cedula,nombre,apellido,telefono,correo,estado);
    System.out.println("Un nuevo empleado se ha unido");
  }

  /*public void editarEmpleado(String nombre, String apellido, int telefono, String correo, Estado estado){
    if(!(new Empleado(nombre,apellido,telefono,correo,estado).equals())){
      
    }
  }*/

  public void eliminarEmpleado(){
    estado = Estado.INACTIVO;
  }

  public String toString(){
    return "Empleado[\n" +
      "Nombre: "+getNombre() + "\n" +
      "Apellido: "+getApellido() + "\n"+
      "Telefono: "+getTelefono() + "\n"+
      "Correo: "+getCorreo() + "\n"+
      "Estado: "+estado +"]";
  }
  }
}
