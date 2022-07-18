//Clase menú
import java.util.ArrayList;
import modelo.*;
import java.util.Scanner;

public class Main{
  public static ArrayList<Servicio> servicios;
  public static ArrayList<Cita> citas;
  public static ArrayList<Atencion> atenciones;
  public static ArrayList<Personal> personas;
  
  public static void inicializarSistema(){
    Representante rep1 = new Representante(901555730, "Esteban", "Gaibor", 918810059, "estebangaibor@gmail.com");
    Representante rep2 = new Representante(954680245, "Maria", "Diaz", 935153129, "mariadiaz@gmail.com");
    Cliente cl1 = new Cliente(932764534, "Jaime", "Gaibor", 974874878, "jaimegaibor@gmail.com",rep1);
    Cliente cl2 = new Cliente(958625741, "Antonio", "Amador", 997353370, "antonioamador@gmail.com",rep2);
    Empleado emp1 = new Empleado(958024996, "Pedro", "Flores", 991056746, "pedroflores@gmail.com", Estado.ACTIVO);
    servicios = new ArrayList<>();
    personas = new ArrayList<>();
    citas = new ArrayList<>();
    atenciones = new ArrayList<>();
    servicios.add(new Servicio("Terapia de Lenguaje", 45, 60.0f, Estado.ACTIVO, emp1));
    servicios.add(new Servicio("Terapia Psicopedagógica", 45, 60.0f, Estado.ACTIVO, emp1));
    servicios.add(new Servicio("Terapia Cognitiva", 45, 60.0f, Estado.ACTIVO, emp1));
    personas.add(emp1);
    personas.add(cl1);
    personas.add(cl2);
    citas.add(new Cita("20/10/2022", servicios.get(0), cl1, emp1));
    citas.add(new Cita("25/10/2022", servicios.get(1), cl2, emp1));
    atenciones.add(new Atencion(new Cita("17/10/2022", servicios.get(2), cl1, emp1), emp1, 30));
  } 
    
  public static void main(String[] args){
    inicializarSistema();
    Scanner input = new Scanner(System.in);
    System.out.println("---MENU---");
    System.out.print("1.Servicios\n2.Empleados\n3.Clientes\n4.Citas\n5.Atencion\n6.Salir\nElija la opcion que desee:");
    int opcion= input.nextInt();
    switch(opcion){
      case 1:
        System.out.println(servicios);
        break;
      case 2:
        ArrayList<Empleado> empleados = new ArrayList<>();
        for (Personal persona: personas){
          if (persona instanceof Empleado){
            empleados.add((Empleado) persona);
          }
        }
        System.out.println(empleados);
        break;
      case 3:
        ArrayList<Cliente> clientes = new ArrayList<>();
        for (Personal persona: personas){
          if (persona instanceof Cliente){
            clientes.add((Cliente) persona);
          }
        }
        System.out.println(clientes);
        break;
      case 4:
        System.out.println("Submenú cita");
        System.out.print("1.Crear Cita\n2.Eliminar Cita\n3.Consultar citas por fecha\nElija la opcion que desee:");
        int opcionCita = input.nextInt();
        switch (opcionCita){
          case 1:
            
            Cita.crearCita();
            break;
          case 2:
            Cita.eliminarCita();
            break;
          case 3:
            System.out.println("Ingrese la fecha de la cita");
            String fecha = input.nextLine();            
            Cita.consultarCita(fecha, citas);
            break;
          default:
            System.out.println("El número ingresado es incorrecto");
        }
        break;
      case 5:
        System.out.println("Submenú atención");
        System.out.print("1.Registrar atencion\n2.Consultar atencion\nElija la opcion que desee:");
        int opcionAtencion = input.nextInt();
        switch (opcionAtencion){
          case 1:
            System.out.print("Ingrese la cedula del cliente: ");
            int cedula = input.nextInt();
            input.nextLine();
            System.out.print("Ingrese la cedula del empleado: ");
            int cedulaEmp = input.nextInt();
            input.nextLine();
            System.out.print("Ingrese la duración en minutos de la atencion: ");
            int duracion = input.nextInt();
            Empleado emp = null;
            for (Personal persona: personas){
              if (persona.getCedula() == cedulaEmp){
                emp = (Empleado) persona;
              }
            }
            Atencion.registrarAtencion(citas, cedula, emp, duracion);
            break;
          case 2:
            System.out.println()
        }
      case 6:
        break;
      default:
        System.out.println("El número ingresado es incorrecto");
    }
  }
}