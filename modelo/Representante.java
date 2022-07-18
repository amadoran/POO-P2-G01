package modelo;

public class Representante extends Personal{
  public Representante(int cedula, String nombre, String apellido, int telefono, String correo){
super(cedula,nombre,apellido,telefono,correo);
  }
  @Override
  public String toString(){
    return "Representante{"+ super.toString() + "}";
  }
}