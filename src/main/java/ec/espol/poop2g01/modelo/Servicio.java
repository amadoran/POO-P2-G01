package ec.espol.poop2g01.modelo;

import ec.espol.poop2g01.Aplicacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Servicio implements Serializable {
  private String nombreServicio;
  private int duracionServicio;
  private float precio;
  private Estado estado;
  private Empleado empleado;

  public Servicio(String nombreServicio, int minutos, float precio, Estado estado, Empleado empleado){
    this.nombreServicio = nombreServicio;
    duracionServicio = minutos;
    this.precio = precio;
    this.estado = estado;
    this.empleado = empleado;
  }
  //El metodo es estatico porque no debe hacer referencia a ninguna instancia de servicio
  public static void agregarServicio(String nombre, int minutos, float precio, Empleado empleado){
    new Servicio(nombre, minutos, precio, Estado.INACTIVO, empleado);
  }

  public static List<Servicio> cargarServicios(){
      List<Servicio> servicios = new ArrayList<>();
      try (ObjectInputStream ois = new ObjectInputStream(Aplicacion.class.getResourceAsStream("archivos/servicios.dat"))){
          servicios = (ArrayList<Servicio>) ois.readObject();
      } catch (IOException e){
          e.printStackTrace();
      } catch (ClassNotFoundException e){
        e.printStackTrace();
      }
      return servicios;
  }
  //Sobrecarga para editar los atributos de un servicio
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
  public Empleado getEmpleado(){
    return empleado;
  }
  @Override
  public String toString(){
    return "Servicio {Nombre: " + nombreServicio + ", Duración (minutos): " + duracionServicio + ", Precio: $" + precio + ", Estado:" + estado + "}";
  }

}