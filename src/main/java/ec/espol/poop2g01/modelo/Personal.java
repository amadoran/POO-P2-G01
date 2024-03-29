package ec.espol.poop2g01.modelo;
import java.io.Serializable;

//Clase abstracta "Personal"
public abstract class Personal implements Serializable{

  //Atributos de cada miembro del Personal
  private int cedula;
  private String nombre;
  private String apellido;
  private int telefono;
  private String correo;

  //constructor Personal
  public Personal(int cedula, String nombre, String apellido, int telefono, String correo){
    this.cedula = cedula;
    this.nombre= nombre;
    this.apellido = apellido;
    this.telefono = telefono;
    this.correo= correo;
  }
  public Personal(String nombre, String apellido){
    this.nombre = nombre;
    this.apellido = apellido;
  }
  //setters

  public void setCedula(int cedula){
    this.cedula = cedula;
  }

  public void setNombre(String nombre){
    this.nombre = nombre;
  }

  public void setApellido(String apellido){
    this.apellido = apellido;
  }

  public void setTelefono(int telefono){
    this.telefono = telefono;
  }

  public void setCorreo(String correo){
    this.correo = correo;
  }

  //getters
  public int getCedula(){
    return cedula;
  }

  public String getNombre(){
    return nombre;
  }

  public String getApellido(){
    return apellido;
  }

  public int getTelefono(){
    return telefono;
  }

  public String getCorreo(){
  return correo;
  }
  public String toString(){
    return "Cedula: " + cedula + ", Nombre:" + nombre + ", Apellido:" + apellido + ", Telefono: " + telefono + ", Correo: " + correo;
  }
}