package modelo;
import java.util.*;

public class Personal{
  private int cedula;
  private String nombre;
  private String apellido;
  private int telefono;
  private String correo;


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
}