package modelo;
public class Cliente extends Personal{
  private String representante;
  public Cliente(int cedula, String nombre, String apellido,int telefono, String correo, String representante){
    super(cedula,nombre,apellido,telefono,correo);
    this.representante=representante;
  }
  public void agregarCliente(int cedula, String nombre, String apellido, int telefono, String correo,String representante){
    
  }
  public void editarCliente(int cedula, String nombre, String apellido, int telefono, String correo, String representante){
    
  }
}