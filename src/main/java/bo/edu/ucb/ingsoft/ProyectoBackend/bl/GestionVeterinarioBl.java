package bo.edu.ucb.ingsoft.ProyectoBackend.bl;

import bo.edu.ucb.ingsoft.ProyectoBackend.dao.VeterinarioDao;
import bo.edu.ucb.ingsoft.ProyectoBackend.dto.Veterinario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionVeterinarioBl {

    @Autowired
    VeterinarioDao veterinarioDao;

    public List<Veterinario> SelectAllVeterinarians(int limit, int offset, String ciudad, String especialidad) {
        return veterinarioDao.SelectAllVeterinarians(limit,offset,ciudad,especialidad);
    }

}