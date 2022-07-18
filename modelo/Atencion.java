package modelo;
import java.util.ArrayList;

public class Atencion{
  private Servicio servicio;
  private Cita cita;
  private Empleado atendio;
  private int duracionReal;

  public Atencion(Cita cita, Empleado atendio, int minutos){
    servicio = cita.getServicio();
    this.cita = cita;
    this.atendio = atendio;
    duracionReal = minutos;
  }
  //Metodo para registarAtencion
  public static void registrarAtencion(ArrayList<Cita> citas, int cedula, Empleado atendio, int minutos){
    Cita citaEncontada = null;
    for (Cita cita: citas){
      if (cita.getCliente().getCedula() == cedula){
        citaEncontada = cita;
      }
    }
    if (citaEncontada != null) {
      new Atencion(citaEncontada, atendio, minutos);
    } else{
      System.out.println("No se encontró una cita con esa cédula");
    }
  }
  //Se sobrecarga este metodo para buscar por cedula o por fecha
  public static Atencion[] consultarAtenciones(int cedula, ArrayList<Personal> personas, ArrayList<Atencion> atenciones){
    ArrayList<Atencion> atencionesEncontradas = new ArrayList<>();
    Personal personaEncontrada = null;
    for (Personal persona: personas){
      if (persona.getCedula() == cedula){
        personaEncontrada = persona;
      }
    }
    if (personaEncontrada instanceof Empleado){
      for (Atencion atencion: atenciones){
        if (atencion.getAtendio().equals(personaEncontrada)){
          atencionesEncontradas.add(atencion);
        }
      }
    } else if(personaEncontrada instanceof Cliente){
      for (Atencion atencion: atenciones){
        if (atencion.getCita().getCliente().equals(personaEncontrada)){
          atencionesEncontradas.add(atencion);
        }
      }
    } else {
      System.out.println("No se encontró usuario con cédula: " + cedula);
      Atencion[] arr = new Atencion[1];
      return arr;
    }
    Atencion[] arr = new Atencion[atencionesEncontradas.size()];
    for (int i = 0; i<atencionesEncontradas.size(); i++){
      arr[i] = atencionesEncontradas.get(i);
    }
    return arr;
  }
  //Busqueda por fecha
  public static Atencion[] consultarAtenciones(String fecha, ArrayList<Atencion> atenciones){
    ArrayList<Atencion> atencionesEncontradas = new ArrayList<>();
    for (Atencion atencion: atenciones){
      if (atencion.getCita().getFechaCita().equals(fecha)){
        atencionesEncontradas.add(atencion);
      }
    }
    Atencion[] arr = new Atencion[atencionesEncontradas.size()];
    for (int i = 0; i<atencionesEncontradas.size(); i++){
      arr[i] = atencionesEncontradas.get(i);
    }
    return arr;
  }
  public Empleado getAtendio(){
    return atendio;
  }
  public Cita getCita(){
    return cita;
  }
  public Servicio getServicio(){
    return servicio;
  }
  public int getDuracion(){
    return duracionReal;
  }
}