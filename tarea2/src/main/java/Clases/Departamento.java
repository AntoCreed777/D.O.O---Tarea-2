package Clases;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un departamento de una empresa.
 * @author Valeria Quiroga
 * @author Antonio Benavides
 */
public class Departamento implements Invitable{

    private final String nombre;
    private List<Empleado> empleados;

    /**
     * Constructor que establece el nombre del Departamento y crea la lista de empleados vacia.
     * @param nombre Nombre del departamento.
     */
    public Departamento(String nombre){
        this.nombre = nombre;
        empleados = new ArrayList<Empleado>();
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
     * Funcion que invita al Departamento.
     * @param reunion Reunion a la que se invita al 'Departamento'
     */
    public void invitar(Reunion reunion){
        reunion.agregarInvitado(new Invitacion(reunion,this));
    }

    /**
     * Funcion que retorna la lista de empleados del departamento.
     * @return Lista de empleados del departamento.
     */
    public List<Empleado> getEmpleados(){
        return empleados;
    }

    /**
     * Funcion que devuelve una descripcion de la clase
     * @return Descripcion de la clase
     */
    @Override
    public String toString() {
        return "Representa a un departamento de una Empresa";
    }
}
