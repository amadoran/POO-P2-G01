package modelo;
import java.util.*;

//Clase Empleado heredada de su clase padre Personal
public class Empleado extends Personal{
  
  //estado del empleado(activo o inactivo)
  private Estado estado;


  //constructor Empleado
  public Empleado(int cedula,String nombre, String apellido, int telefono, String correo, Estado estado){
    super(cedula, nombre, apellido, telefono,correo);
    this.estado = estado;
  }

  public Empleado(String nombre, String apellido){
    super(nombre, apellido);
    estado = Estado.INACTIVO;
  }

  //metodo para agregar a los empleados
  public void agregarEmpleado(int cedula, String nombre, String apellido, int telefono, String correo, Estado estado){
    new Empleado(cedula,nombre,apellido,telefono,correo,estado);
    System.out.println("Un nuevo empleado se ha unido");
  }

  //metodo para editar el perfil del empleado
  public void editarEmpleado(String nombre, String apellido, int telefono, String correo, Estado estado){
    setNombre(nombre);
    setApellido(apellido);
    setTelefono(telefono);
    setCorreo(correo);
    this.estado = estado;
  }

  //metodo para cambiar el estado a inactivo del empleado
  
  public void eliminarEmpleado(){
    estado = Estado.INACTIVO;
  }

  //metodo toString
  @Override
  public String toString(){
    return "Empleado[\n" +
      "Nombre: "+getNombre() + "\n" +
      "Apellido: "+getApellido() + "\n"+
      "Telefono: "+getTelefono() + "\n"+
      "Correo: "+getCorreo() + "\n"+
      "Estado: "+estado +"]";
  }
  }

