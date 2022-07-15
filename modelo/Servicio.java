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
  
  public void editarServicio(){
    Scanner sc = new Scanner(System.in);
    System.out.println("Ingrese el número del cambio que desea hacer");
    char respuesta = 'Y';
    while(respuesta != 'N'){
      System.out.println("1.- Cambiar Nombre");
      System.out.println("2.- Cambiar Duracion");
      System.out.println("3.- Cambiar Precio");
      System.out.println("4.- Activar Servicio");
      System.out.print("Opcion: ");
      int opcion = sc.nextInt();
      sc.nextLine();
      switch (opcion){
        case 1:
          System.out.print("Ingrese el nuevo nombre: ");
          this.nombreServicio = sc.nextLine();
          System.out.println("Se ha actualizado el nombre");
          break;
        case 2:
          System.out.print("Ingrese la nueva duración (minutos): ");
          this.duracionServicio = sc.nextInt();
          System.out.println("Se ha actualizado la duración");
          break;
        case 3:
          System.out.print("Ingrese el nuevo precio: ");
          this.precio = sc.nextFloat();
          System.out.println("Se ha actualizado el precio");
          break;
        case 4:
          this.estado = Estado.ACTIVO;
          System.out.println("Se ha activado el servicio");
          break;
        default:
          System.out.println("No ingreso un número correcto");
      }
      System.out.println();
      System.out.println("Desea continuar (Y/N): ");
      respuesta = sc.nextLine().toUpperCase().charAt(0);
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

  public String toString(){
    return "Servicio {Nombre: " + nombreServicio + ", Duración (minutos): " + duracionServicio + ", Precio: $" + precio + ", Estado:" + estado + "}";
  }
}