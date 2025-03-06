/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestion_empleados;

/**
 *
 * 
 */
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {
    private final List<Empleado> empleados;
    private static final String ARCHIVO_EMPLEADOS = "empleados.txt";
    
    public GestorEmpleados() {
        empleados = new ArrayList<>();
        cargarEmpleados();
    }
    
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        guardarEmpleados();
        System.out.println("Empleado agregado exitosamente");
    }
    
    public boolean eliminarEmpleado(String nombre) {
        Empleado empleado = buscarEmpleado(nombre);
        if (empleado != null) {
            empleados.remove(empleado);
            guardarEmpleados();
            return true;
        }
        return false;
    }
    
    public void mostrarEmpleados() {
        if (empleados.isEmpty()) {
            System.out.println("No hay empleados registrados");
            return;
        }
        
        System.out.println("\nLista de Empleados:");
        for (Empleado emp : empleados) {
            System.out.println(emp);
        }
    }
    
    public List<Empleado> buscarEmpleadosPorNombre(String nombre) {
        List<Empleado> encontrados = new ArrayList<>();
        for (Empleado emp : empleados) {
            if (emp.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                encontrados.add(emp);
            }
        }
        return encontrados;
    }
    
    public Empleado buscarEmpleado(String nombre) {
        for (Empleado emp : empleados) {
            if (emp.getNombre().equalsIgnoreCase(nombre)) {
                return emp;
            }
        }
        return null;
    }
    
    private void guardarEmpleados() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ARCHIVO_EMPLEADOS))) {
            for (Empleado emp : empleados) {
                writer.println(String.format("%s,%d,%.2f", 
                    emp.getNombre(), emp.getEdad(), emp.getSalario()));
            }
        } catch (IOException e) {
            System.err.println("Error al guardar empleados: " + e.getMessage());
        }
    }
    
    private void cargarEmpleados() {
        File archivo = new File(ARCHIVO_EMPLEADOS);
        if (!archivo.exists()) {
            return;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    try {
                        Empleado emp = new Empleado(
                            datos[0],
                            Integer.parseInt(datos[1]),
                            Double.parseDouble(datos[2])
                        );
                        empleados.add(emp);
                    } catch (  IllegalArgumentException e) {
                        System.err.println("Error al cargar empleado: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al cargar empleados: " + e.getMessage());
        }
    }
}
