package Clases;

import java.util.List;

public class Departamento implements Invitable{

    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
    
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    public void agregarEmpleado(Empleado empleado){
        empleados.add(empleado);
    }

    public void invitar(){
        for(Empleado empleado : empleados){
            empleado.invitar();
        }
    }
}
