

import Clases.*;

import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {


        Date fecha = new Date();
        Instant horaPrevista = Instant.now();
        Duration duracionPrevista = Duration.ofHours(1);

        Nota n1 = new Nota() ;
        Nota n2 = new Nota() ;
        n1.setContenido("nota1");
        n2.setContenido("nota2");

        List<Nota> notas = new ArrayList<Nota>();
        notas.add(n1);
        notas.add(n2);


        Empleado vq = new Empleado("1", "quiroga" , "valeria", "vquiroga");
        Empleado ab = new Empleado("2", "benavides" , "antonio", "abenavides");
        Invitacion i1 = new Invitacion(vq);
        Invitacion i2 = new Invitacion(ab);

        List<Invitacion> invitados = new ArrayList<Invitacion>();
        invitados.add(i1);
        invitados.add(i2);


        //Empleado organizador,tipoReunion tipo,Date fecha, Instant horaPrevista, Duration duracionPrevista, Nota nota, List<Invitacion> invitacion, String sala
        Reunion reunion = new ReunionPresencial(vq, tipoReunion.MARKETING, fecha,horaPrevista, duracionPrevista, n1, invitados, "sala1" );

        Asistencia a1 = new Asistencia(vq);
        List<Asistencia> asistentes = new ArrayList<Asistencia>();
        asistentes.add(a1);

        reunion.iniciar(asistentes);
        // Thread.sleep(2000);
        reunion.finalizar();

        Informe informe = new Informe(reunion);
        informe.exportarInformeTXT("informe.txt");
    }   
}
