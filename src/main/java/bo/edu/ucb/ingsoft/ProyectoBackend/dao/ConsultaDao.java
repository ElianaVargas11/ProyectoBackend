package bo.edu.ucb.ingsoft.ProyectoBackend.dao;

import bo.edu.ucb.ingsoft.ProyectoBackend.dto.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;

@Service
public class ConsultaDao {
    /**
     * Inicializamos sequenceDao para simular el "AUTO INCREMENT" de las llaves PRIMARIAS requeridas"
     **/

    @Autowired
    private SequenceDao sequenceDao;

    /**
     * Inicializamos datasource para la conexión a la base de datos
     **/

    @Autowired
    public DataSource dataSource;


    public Consulta registrar(Consulta ob){
        ob.setConsulta_id(sequenceDao.getLLaveprincipal("consulta"));

        Connection con=null;
        Calendar fecha = new GregorianCalendar();

        int año = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        int hora =fecha.get(Calendar.HOUR_OF_DAY);
        int minutos = fecha.get(Calendar.MINUTE);
        int segundos = fecha.get(Calendar.SECOND);
        String fecha_actual="";
        String horaA=hora + ":" + minutos + ":" + segundos;
        fecha_actual=año+"-"+mes+"-"+dia;

        ob.setFecha(fecha_actual);
        ob.setHora(horaA);
        try{
            con=dataSource.getConnection();
            PreparedStatement preesta;
            preesta = con.prepareStatement("insert into consulta(consulta_id, ciudad_id, veterinario_id, tema_consulta, descripcion, fecha, hora)  values (?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),TO_TIMESTAMP(?,'HH24: MI: SS')) ");
            preesta.setInt(1, ob.getConsulta_id());
            preesta.setInt(2, ob.getCiudad_id());
            preesta.setInt(3, ob.getVeterinario_id());
            preesta.setString(4, ob.getTema_consulta());
            preesta.setString(5, ob.getDescripcion());
            preesta.setString(6, ob.getFecha());
            preesta.setString(7, ob.getHora());



            preesta.executeUpdate();



        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqex) {}
            }
        }
        return ob;
    }

}

