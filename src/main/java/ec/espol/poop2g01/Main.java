//Clase menú
package ec.espol.poop2g01;

import ec.espol.poop2g01.modelo.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
  public static ArrayList<Servicio> servicios;
  public static ArrayList<Cita> citas;
  public static ArrayList<Atencion> atenciones;
  public static ArrayList<Personal> personas;
  //Creacion de los arrays
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
//    try (BufferedWriter bw = new BufferedWriter(new FileWriter("src/main/resources/ec/espol/poop2g01/archivos/empleados.csv"))){
//      Empleado empleado = (Empleado) personas.get(0);
//      bw.write(empleado.getCedula()+ ","+empleado.getNombre()+","+empleado.getApellido()+","+empleado.getTelefono()+","+empleado.getCorreo()+","+empleado.getEstado());
//    } catch (IOException e){
//      e.printStackTrace();
//    }

//    try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("src/main/resources/ec/espol/poop2g01/archivos/servicios.dat"))){
//      os.writeObject(servicios);
//    } catch (IOException e){
//      e.printStackTrace();
//    }

    Scanner input = new Scanner(System.in);
    System.out.println("---MENU---");
    //Un switch para las opciones del menú
    System.out.print("1.Servicios\n2.Empleados\n3.Clientes\n4.Citas\n5.Atencion\n6.Salir\nElija la opcion que desee:");
    int opcion= input.nextInt();
    switch(opcion){
      case 1:
        System.out.println(servicios);
        break;
      case 2:
        //Busca en la lista de persona el empleado
        ArrayList<Empleado> empleados = new ArrayList<>();
        for (Personal persona: personas){
          if (persona instanceof Empleado){
            empleados.add((Empleado) persona);
          }
        }
        System.out.println(empleados);
        break;
      case 3:
        //Busca en la lista de personas el cliente
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
        input.nextLine();
        //Un switch para las opciones del submenú cita
        switch (opcionCita){
          case 1:
            System.out.print("Ingrese una la fecha para la cita: ");
            String fecha = input.nextLine();
            System.out.println(servicios);
            System.out.print("Ingrese el indice del servicio que desea: ");
            int indice = input.nextInt();
            input.nextLine();
            System.out.print("Ingrese la cedula del cliente: ");
            int cedula = input.nextInt();
            Cliente cl = null;
            for (Personal persona: personas){
              if (persona.getCedula() == cedula){
                cl = (Cliente) persona;
              }
            }
            Cita.crearCita(fecha, servicios.get(indice), cl, servicios.get(indice).getEmpleado());
            break;
          case 2:
            Cita.eliminarCita(citas);
            break;
          case 3:            
            Cita.consultarCita(citas);
            break;
          default:
            System.out.println("El número ingresado es incorrecto");
        }
        break;
      case 5:
        System.out.println("Submenú atención");
        System.out.print("1.Registrar atencion\n2.Consultar atencion\nElija la opcion que desee:");
        int opcionAtencion = input.nextInt();
        input.nextLine();
        //Switch anidado para las opciones del submenú atencion
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
            System.out.print("Desea buscar por fecha o cedula (F/C): ");
            char busqueda = input.nextLine().toUpperCase().charAt(0);
            //Switch para las 2 formas de busqueda
            switch (busqueda){
              case 'F':
                System.out.print("Ingrese la fecha: ");
                String fecha = input.nextLine();
                System.out.println(Atencion.consultarAtenciones(fecha, atenciones));
                break;
              case 'C':
                System.out.print("Ingrese la cedula: ");
                int cedula2 = input.nextInt();
                System.out.println(Atencion.consultarAtenciones(cedula2, personas, atenciones));
                break;
              default:
                System.out.println("Caracter incorrecto");
            }
              break;
          default:
            System.out.println("Valor incorrecto");
        }
        break;
      case 6:
        //Termina el programa
        break;
      default:
        System.out.println("El número ingresado es incorrecto");
    }
  input.close();
  }
}