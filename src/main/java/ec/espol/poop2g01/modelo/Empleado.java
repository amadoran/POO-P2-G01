package ec.espol.poop2g01.modelo;

import ec.espol.poop2g01.Aplicacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
  public static List<Empleado> cargarEmpleados(){
    List<Empleado> empleados= new ArrayList<>();
    System.out.println(Aplicacion.class.getResource("archivos/empleados.csv"));
    System.out.println(Aplicacion.class.getResource("archivos/empleados.csv").getPath());
    try (BufferedReader br = new BufferedReader(new FileReader(Aplicacion.class.getResource("archivos/empleados.csv").getPath()))){
      String line;
      while ((line = br.readLine()) != null){
        String[] datos = line.split(",");
        Empleado empleado = new Empleado(Integer.parseInt(datos[0]), datos[1], datos[2], Integer.parseInt(datos[3]), datos[4], Estado.valueOf(datos[5]));
        empleados.add(empleado);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return empleados;

  }

  //metodo para cambiar el estado a inactivo del empleado
  
  public void eliminarEmpleado(){
    estado = Estado.INACTIVO;
  }

  public Estado getEstado() {
    return estado;
  }

  public void setEstado(Estado estado) {
    this.estado = estado;
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

