package bo.edu.ucb.ingsoft.ProyectoBackend.bl;

import bo.edu.ucb.ingsoft.ProyectoBackend.dao.EspecialidadDao;
import bo.edu.ucb.ingsoft.ProyectoBackend.dto.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GestionEspecialidadesBl {

    @Autowired
    EspecialidadDao especialidadDao;

    public List<Especialidad> SelectAllSpecialties() throws SQLException{
        return especialidadDao.SelectAllSpecialties();
    }

}
