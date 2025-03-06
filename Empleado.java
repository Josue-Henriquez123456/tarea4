/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_gestion_empleados;

/**
 *
 * 
 * 
 */

public final class Empleado {
    private String nombre;
    private int edad;
    private double salario;
    
    // Constructor
    public Empleado(String nombre, int edad, double salario) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        if (salario < 0) {
            throw new IllegalArgumentException("El salario no puede ser negativo");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        
        this.nombre = nombre;
        this.edad = edad;
        this.salario = salario;
    }
    
    // Getters y Setters con validaciones
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombre = nombre;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
        this.edad = edad;
    }
    
    public double getSalario() {
        return salario;
    }
    
    public void setSalario(double salario) {
        if (salario < 0) {
            throw new IllegalArgumentException("El salario no puede ser negativo");
        }
        this.salario = salario;
    }
    
    @Override
    public String toString() {
        return String.format("Empleado{nombre='%s', edad=%d, salario=%.2f}", 
                           nombre, edad, salario);
    }
 
}