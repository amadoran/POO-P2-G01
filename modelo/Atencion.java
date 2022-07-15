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
  public static void registrarAtencion(ArrayList<Cita> citas, int cedula, Empleado atendio, int minutos){
    Cita citaEncontada;
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
  public static Atencion consultarAtenciones()
}