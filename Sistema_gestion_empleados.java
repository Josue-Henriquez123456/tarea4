/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistema_gestion_empleados;

/**
 *
 * 
 */
import java.util.List;
import java.util.Scanner;


public class Sistema_gestion_empleados {
private static final Scanner scanner = new Scanner(System.in);
    private static final GestorEmpleados gestor = new GestorEmpleados();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          while (true) {
            mostrarMenu();
            try {
                int opcion = Integer.parseInt(scanner.nextLine());
                procesarOpcion(opcion);
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un numero valido");
            }
        }
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=== Sistema de Gestion de Empleados ===");
        System.out.println("1. Agregar empleado");
        System.out.println("2. Mostrar empleados");
        System.out.println("3. Buscar empleado por nombre exacto");
        System.out.println("4. Buscar empleados por nombre parcial");
        System.out.println("5. Eliminar empleado");
        System.out.println("6. Salir");
        System.out.print("Seleccione una opcion: ");
    }
    
    private static void procesarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                agregarEmpleado();
                break;
            case 2:
                gestor.mostrarEmpleados();
                break;
            case 3:
                buscarEmpleadoExacto();
                break;
            case 4:
                buscarEmpleadosParcial();
                break;
            case 5:
                eliminarEmpleado();
                break;
            case 6:
                System.out.println("¡Gracias por usar el sistema!");
                scanner.close();
                System.exit(0);
            default:
                System.out.println("Opcion no valida");
        }
    }
    
    private static void agregarEmpleado() {
        try {
            System.out.print("Ingrese el nombre del empleado: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Ingrese la edad del empleado: ");
            int edad = Integer.parseInt(scanner.nextLine());
            
            System.out.print("Ingrese el salario del empleado: ");
            double salario = Double.parseDouble(scanner.nextLine());
            
            Empleado nuevoEmpleado = new Empleado(nombre, edad, salario);
            gestor.agregarEmpleado(nuevoEmpleado);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    private static void buscarEmpleadoExacto() {
        System.out.print("Ingrese el nombre exacto del empleado a buscar: ");
        String nombre = scanner.nextLine();
        Empleado empleado = gestor.buscarEmpleado(nombre);
        
        if (empleado != null) {
            System.out.println("Empleado encontrado: " + empleado);
        } else {
            System.out.println("No se encontro ningun empleado con ese nombre exacto");
        }
    }
    
    private static void buscarEmpleadosParcial() {
        System.out.print("Ingrese parte del nombre a buscar: ");
        String nombre = scanner.nextLine();
        List<Empleado> encontrados = gestor.buscarEmpleadosPorNombre(nombre);
        
        if (encontrados.isEmpty()) {
            System.out.println("No se encontraron empleados con ese nombre");
        } else {
            System.out.println("Empleados encontrados:");
            for (Empleado emp : encontrados) {
                System.out.println(emp);
            }
        }
    }
    
    private static void eliminarEmpleado() {
        System.out.print("Ingrese el nombre del empleado a eliminar: ");
        String nombre = scanner.nextLine();
        
        if (gestor.eliminarEmpleado(nombre)) {
            System.out.println("Empleado eliminado exitosamente");
        } else {
            System.out.println("No se encontro el empleado para eliminar");
        }
    }
    }

    
    

