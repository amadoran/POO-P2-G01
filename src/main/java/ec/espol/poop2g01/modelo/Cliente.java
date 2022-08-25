package ec.espol.poop2g01.modelo;

import ec.espol.poop2g01.Aplicacion;

import java.io.*;
import java.util.ArrayList;

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
    super.setNombre(nombre);
    super.setApellido(apellido);
    super.setTelefono(telefono);
    super.setCorreo(correo);
    this.representante = representante;
  }
  //metodo para obtener el representante
  public Representante getRepresentante() {
    return representante;
  }
  //metodo para cargar los clientes
  public static ArrayList<Cliente> cargarClientes(){
    ArrayList<Cliente> clientes = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(Aplicacion.class.getResource("archivos/servicios.csv").getPath()))){
      String linea;
      while ((linea = br.readLine())!=null){
        String[] datos = linea.split(",");
        clientes.add(new Cliente(Integer.parseInt(datos[0]),datos[1],datos[2],Integer.parseInt(datos[3]),datos[4],new Representante(29, "", "", 9, "")));
      }
    }catch (IOException e){
      e.printStackTrace();
    }
    return clientes;
  }
  //metodo para sobreescribir el archivo de clientes al momento de editar o eliminar clientes
  public static void sobreescribirArchivo(ArrayList<Cliente> clientes){
    try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/ec/espol/poop2g01/archivos/clientes.csv"));){
      bw.write("Cédula,nombre,telefono,email,representante");
      for(Cliente c:clientes){
        bw.newLine();
        bw.write(c.getCedula()+","+c.getNombre()+","+c.getTelefono()+","+c.getCorreo()+","+c.representante);
      }
    }catch (IOException e){
      System.out.println("error");
    }}

  @Override
  public String toString(){
    return "Cliente{"+ super.toString() + ", " + representante + "}";
  }
}
