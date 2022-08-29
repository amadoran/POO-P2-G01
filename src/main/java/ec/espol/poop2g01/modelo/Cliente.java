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
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/ec/espol/poop2g01/archivos/clientes.dat"))) {
      ArrayList<Cliente> ser_clientes = (ArrayList<Cliente>) ois.readObject();
      clientes.addAll(ser_clientes);
    } catch (IOException | ClassNotFoundException e){
      e.printStackTrace();
    }
    return clientes;
  }
  //metodo para sobreescribir el archivo de clientes al momento de editar o eliminar clientes
  public static void sobreescribirArchivo(Cliente cliente){
    ObjectOutputStream obs = null;
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/main/resources/ec/espol/poop2g01/archivos/clientes.dat"))){
      ArrayList<Cliente> clientes = (ArrayList<Cliente>) ois.readObject();
      clientes.add(cliente);
      obs = new ObjectOutputStream(new FileOutputStream("src/main/resources/ec/espol/poop2g01/archivos/clientes.dat"));
      obs.writeObject(clientes);
    }catch (IOException e){
      System.out.println("error");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      try {
        obs.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  @Override
  public String toString(){
    return "Cliente{"+ super.toString() + ", " + representante + "}";
  }
}
