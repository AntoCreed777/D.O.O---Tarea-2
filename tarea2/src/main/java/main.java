

import Clases.*;
import Clases.Invitacion;

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

        Nota n1 = new Nota("Winston Smith is a member of the Outer Party. He works in the Records Department in the Ministry of Truth, rewriting and distorting history.") ;
        Nota n2 = new Nota("To escape Big Brother's tyranny, at least inside his own mind, Winston begins a diary — an act punishable by death.") ;
    

        List<Nota> notas = new ArrayList<Nota>();
        notas.add(n1);
        notas.add(n2);
        
        
        Empleado vq = new Empleado("1", "quiroga" , "valeria", "vquiroga");
        
        Reunion reunion = new ReunionPresencial(vq, tipoReunion.MARKETING, fecha,horaPrevista, duracionPrevista, "Sala Informática TM" );
        
        Empleado ab = new Empleado("2", "benavides" , "antonio", "abenavides");
        Empleado ksm = new Empleado("3", "san martin" , "kote", "kote@example.com");

        Invitacion i1 = new Invitacion(reunion, vq);
        Invitacion i2 = new Invitacion(reunion,ab);
        Invitacion i3 = new Invitacion(reunion, ksm);
        
        List<Invitacion> invitados = new ArrayList<Invitacion>();
        invitados.add(i1);
        invitados.add(i2);
        invitados.add(i3);
         
        reunion.agregarNota(n1);
        reunion.agregarNota(n2);
        
        Asistencia a1 = new Asistencia(vq);
        List<Asistencia> asistentes = new ArrayList<Asistencia>();
        asistentes.add(a1);
        
        reunion.iniciar(asistentes);
        try {
            Thread.sleep(2000);
            
            reunion.agregarRetrasado(ksm);

            Thread.sleep(2000);

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        reunion.finalizar();

        for(Empleado ausente: reunion.obtenerAusencias()){
            System.out.println(ausente.getNombre());
        }

        Informe informe = new Informe(reunion);
        informe.exportarInformeTXT("informe.txt");
    }
}
