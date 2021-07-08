package bo.edu.ucb.ingsoft.ProyectoBackend.bl;

import bo.edu.ucb.ingsoft.ProyectoBackend.dao.ConsultaDao;
import bo.edu.ucb.ingsoft.ProyectoBackend.dto.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionConsultaBl {

    @Autowired
    ConsultaDao consultaDao;

    public Consulta registrarConsulta(Consulta consulta){
        return consultaDao.registrar(consulta);
    }
}
