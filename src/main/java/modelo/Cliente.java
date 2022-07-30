package modelo;
public class Cliente extends Personal{
  private Representante representante;
  public Cliente( int cedula,String nombre, String apellido,int telefono, String correo, Representante representante){
    super(cedula,nombre,apellido,telefono,correo);
    this.representante=representante;
  } 
  public static void agregarCliente( int cedula,String nombre, String apellido, int telefono, String correo,Representante representante){
    new Cliente(cedula,nombre,apellido,telefono,correo,representante);
    System.out.println("Cliente agregado");
  }
  public void editarCliente( String nombre, String apellido, int telefono, String correo, Representante representante){
    setNombre(nombre);
    setApellido(apellido);
    setTelefono(telefono);
    setCorreo(correo);
    this.representante = representante;
  }
  @Override
  public String toString(){
    return "Cliente{"+ super.toString() + ", " + representante + "}";
  }
}
