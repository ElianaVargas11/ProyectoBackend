package bo.edu.ucb.ingsoft.ProyectoBackend.bl;

import bo.edu.ucb.ingsoft.ProyectoBackend.dao.CiudadDao;
import bo.edu.ucb.ingsoft.ProyectoBackend.dto.Ciudad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class GestionCiudadBl {
    @Autowired
    CiudadDao ciudadDao;

    public List<Ciudad> SelectAllCities() throws SQLException {
        return ciudadDao.SelectAllCities();
    }
}