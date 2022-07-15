package modelo;
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
  
  public void editarServicio(String nombre, int minutos, float precio, Estado estado){
    if (!(new Servicio(nombre, minutos, precio, estado).equals(this))){
      nombreServicio = nombre;
      duracionServicio = minutos;
      this.precio = precio;
      this.estado = estado;
    }
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
}