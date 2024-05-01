package Clases;

import java.util.List;

/**
 * Clase que representa un departamento de una empresa.
 * @author Valeria Quiroga
 * @author Amtonio Benavides
 */
public class Departamento implements Invitable{

    private String nombre;
    private List<Empleado> empleados;

    /**
     * Constructor que establece el nombre del Departamento.
     * @param nombre Nombre del departamento.
     */
    public Departamento(String nombre){
        this.nombre = nombre;
    }

    /**
     * Funcion que retorna el nombre del departamento.
     * @return Nombre del departamento.
     */
    public String getNombre(){
        return nombre;
    }
    
    /**
     * Funcion que retorna la cantidad de empleados en el departamento.
     * @return Cantidad de empleados en el departamento.
     */
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    /**
     * Funcion que agrega un empleado al departamento.
     * @param empleado Empleado a agregar.
     */
    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    /**
     * Funcion que quita un empleado del departamento.
     * @param empleado Empleado a quitar.
     */
    public void quitarEmpleado(Empleado empleado){
        empleados.remove(empleado);
    }

    /**
     * Funcion que invita a todos los empleados del departamento.
     */
    public void invitar(){
        for(Empleado empleado : empleados){
            empleado.invitar();
        }
    }
}
