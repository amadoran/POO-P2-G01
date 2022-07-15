package modelo;
import java.util.Scanner;
public class Servicio{
  private String nombreServicio;
  private int duracionServicio;
  private float precio;
  private Estado estado;

  public Servicio(String nombreServicio, int minutos, float precio, Estado estado){
    this.nombreServicio = nombreServicio;
    duracionServicio = minutos;
    this.precio = precio;
    this.estado = estado;
  }
  //El metodo es estatico porque no debe hacer referencia a ninguna instancia de servicio
  public static void agregarServicio(String nombre, int minutos, float precio){
    new Servicio(nombre, minutos, precio, Estado.INACTIVO);
  }
  
  public void editarServicio(String nombre){
    nombreServicio = nombre;
  }
  public void editarServicio(int duracionServicio){
    this.duracionServicio = duracionServicio;
  }
  public void editarServicio(float precio){
    this.precio = precio;
  }
  public void editarServicio(Estado estado){
    this.estado = estado;
  }

  public void eliminarServicio(){
    estado = Estado.INACTIVO;
  }

  public String getNombreServicio(){
    return nombreServicio;
  }
  public int getDuracionServicio(){
    return duracionServicio;
  }
  public float getPrecio(){
    return precio;
  }
  public Estado getEstado(){
    return estado;
  }

  public String toString(){
    return "Servicio {Nombre: " + nombreServicio + ", Duración (minutos): " + duracionServicio + ", Precio: $" + precio + ", Estado:" + estado + "}";
  }
}