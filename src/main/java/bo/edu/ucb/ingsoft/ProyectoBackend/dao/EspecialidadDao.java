package bo.edu.ucb.ingsoft.ProyectoBackend.dao;

import bo.edu.ucb.ingsoft.ProyectoBackend.dto.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class EspecialidadDao {


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

    /**
     * La siguiente función se encargará  de seleccionar todas las direcciones de la tabla "especialidad",
     * el cual no tiene parámetros  y una vez realizada la busqueda, retornará un array de objetos "Especialidad".
     **/

    public List<Especialidad> SelectAllSpecialties() throws SQLException {
        List<Especialidad> array=new ArrayList<>();
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            ResultSet res= stat.executeQuery("select e.especialidad,e.especialidad_id from especialidad e");
            while(res.next()){
                Especialidad ob = new Especialidad();
                ob.setEspecialidad(res.getString("especialidad"));
                ob.setIdEspecialidad(res.getInt("especialidad_id"));
                array.add(ob);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException sqex) {}
            }
        }
        return array;
    }

}

