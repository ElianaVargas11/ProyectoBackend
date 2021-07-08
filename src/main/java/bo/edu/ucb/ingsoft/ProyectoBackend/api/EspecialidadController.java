package bo.edu.ucb.ingsoft.ProyectoBackend.api;

import bo.edu.ucb.ingsoft.ProyectoBackend.bl.GestionEspecialidadesBl;
import bo.edu.ucb.ingsoft.ProyectoBackend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class EspecialidadController {
    @Autowired
    GestionEspecialidadesBl gestionEspecialidadesBl;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path= "/especialidad")
    public ResponseDto SelectAllSpecialties() throws SQLException {
        return new ResponseDto(true,gestionEspecialidadesBl.SelectAllSpecialties(), "Lista de especialidades");
    }

}

