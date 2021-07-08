package bo.edu.ucb.ingsoft.ProyectoBackend.dao;


import bo.edu.ucb.ingsoft.ProyectoBackend.dto.Ciudad;
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
public class CiudadDao {

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


    public List<Ciudad> SelectAllCities() throws SQLException {
        List<Ciudad> array=new ArrayList<>();
        Connection con=null;
        try{
            con=dataSource.getConnection();
            Statement stat =con.createStatement();
            ResultSet res= stat.executeQuery("select c.ciudad_id,c.nombre from ciudad c");
            while(res.next()){
                Ciudad ob = new Ciudad();
                ob.setCiudad(res.getString("nombre"));
                ob.setIdCiudad(res.getInt("ciudad_id"));
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