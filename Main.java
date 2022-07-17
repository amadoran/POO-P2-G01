//Clase menú
import java.util.ArrayList;
import modelo.*;
import java.util.Scanner;

public class Main{
  public static ArrayList<Servicio> servicios;
  public static ArrayList<Cita> citas;
  public static ArrayList<Cliente> clientes;
  public static ArrayList<Empleado> empleados;
  public static ArrayList<Atencion> atenciones;
  
  public static void inicializarSistema(){
    servicios = new ArrayList<>();
    servicios.add(new Servicio("Terapia de Lenguaje", 45, 60.0f, Estado.ACTIVO));
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