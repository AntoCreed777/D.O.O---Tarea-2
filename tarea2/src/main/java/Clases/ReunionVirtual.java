package Clases;

import java.util.List;

public class ReunionVirtual extends Reunion{

    public List<Asistencia> obtenerAsistencias(){};
    public List<Asistencia> obtenerAusencias( ){};
    public List<Asistencia> obtenerRetrasos(){};
    public int obtenerTotalAsistencia(){
        return 0;
    };
    public float obtenerPorcentajeAsistencia(){
        return 0;
    };

    public float calcularTiempo(){
        return 0;
    };

    public void iniciar(){};
    public void finalizar(){};

    private String enlace;
}
