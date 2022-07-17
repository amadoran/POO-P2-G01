package modelo;
public class Cliente extends Personal{
  private String representante;
  public Cliente( int cedula,String nombre, String apellido,int telefono, String correo, String representante){
    super(cedula,nombre,apellido,telefono,correo);
    this.representante=representante;
  } 
  public static void agregarCliente( int cedula,String nombre, String apellido, int telefono, String correo,String representante){
    new Cliente(cedula,nombre,apellido,telefono,correo,representante);
    System.out.println("Cliente agregado");
  }
  public void editarCliente( String nombre, String apellido, int telefono, String correo, String representante){
    setNombre(nombre);
    setApellido(apellido);
    setTelefono(telefono);
    setCorreo(correo);
    this.representante = representante;
    }
  }
