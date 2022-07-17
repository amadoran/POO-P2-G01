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
    servicios = new ArrayList<>();
    personas = new ArrayList<>();
    citas = new ArrayList<>();
    atenciones = new ArrayList<>();
    servicios.add(new Servicio("Terapia de Lenguaje", 45, 60.0f, Estado.ACTIVO));
    servicios.add(new Servicio("Terapia Psicopedagógica", 45, 60.0f, Estado.ACTIVO));
    servicios.add(new Servicio("Terapia Cognitiva", 45, 60.0f, Estado.ACTIVO));
    personas.add(new Empleado(958024996, "Pedro", "Flores", 991056746, "pedroflores@gmail.com", Estado.ACTIVO));
    personas.add(new Cliente(932764534, "Jaime", "Gaibor", 974874878, "jaimegaibor@gmail.com",rep1));
    personas.add(new Cliente(958625741, "Antonio", "Amador", 997353370, "antonioamador@gmail.com",rep2));
    citas.add(new Cita("20/10/2022", servicios.get(0), new Cliente(932764534, "Jaime", "Gaibor", 974874878, "jaimegaibor@gmail.com",rep1), new Empleado(958024996, "Pedro", "Flores", 991056746, "pedroflores@gmail.com", Estado.ACTIVO)));
    citas.add(new Cita("25/10/2022", servicios.get(1), new Cliente(958625741, "Antonio", "Amador", 997353370, "antonioamador@gmail.com",rep2), new Empleado(958024996, "Pedro", "Flores", 991056746, "pedroflores@gmail.com", Estado.ACTIVO)));
    atenciones.add(new Atencion(new Cita("17/10/2022", servicios.get(2), new Cliente(932764534, "Jaime", "Gaibor", 974874878, "jaimegaibor@gmail.com",rep1), new Empleado(958024996, "Pedro", "Flores", 991056746, "pedroflores@gmail.com", Estado.ACTIVO)), new Empleado(958024996, "Pedro", "Flores", 991056746, "pedroflores@gmail.com", Estado.ACTIVO), 30));
  } 
    

  Scanner input = new Scanner(System.in;
  System.out.println("---MENU---");
  System.out.println("1.Servicios\n2.Empleados\n3.Clientes\n4.Citas\n5.Atencion\n6.Salir\nElija la opcion que desee:");

int opcion= input.nextInt();
switch(opcion){
  case 1:
    System.out.println(servicios);
    break;
  case 2:
    Empleado.cuerpo();
    break;
  case 3:
    Cliente.cuerpo();
    break;
  case 4:
    break;
  case 5:
    Atencion.cuerpo();
  case 6:
    break;
}


  
  public static void main(String[] args){
    System.out.println("Hello World");
    inicializarSistema();
  }  
}