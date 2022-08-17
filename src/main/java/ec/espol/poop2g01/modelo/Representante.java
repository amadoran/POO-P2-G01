package ec.espol.poop2g01.modelo;

//clase Representante
public class Representante extends Personal{

  //constructor Representante
  public Representante(int cedula, String nombre, String apellido, int telefono, String correo){
    super(cedula,nombre,apellido,telefono,correo);
  }


//Metodo toString
  @Override
  public String toString(){
    return "Representante{"+ super.toString() + "}";
  }
}