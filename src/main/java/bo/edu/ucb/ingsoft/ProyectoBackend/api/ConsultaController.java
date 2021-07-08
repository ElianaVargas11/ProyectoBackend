package bo.edu.ucb.ingsoft.ProyectoBackend.api;

import bo.edu.ucb.ingsoft.ProyectoBackend.bl.GestionConsultaBl;
import bo.edu.ucb.ingsoft.ProyectoBackend.dto.Consulta;
import bo.edu.ucb.ingsoft.ProyectoBackend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController

public class ConsultaController {
    @Autowired
    GestionConsultaBl gestionConsultaBl;
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path= "/consulta")
    public ResponseDto RegistrarConsulta(@RequestBody Consulta consulta) throws SQLException {
        System.out.println("ID DUEÑO : "+consulta.getCiudad_id()+" des : "+consulta.getTema_consulta());
        Consulta con= gestionConsultaBl.registrarConsulta(consulta);
        if(consulta.getTema_consulta()==null|| consulta.getTema_consulta().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(consulta.getDescripcion()==null|| consulta.getDescripcion().trim().equals("")){
            return new ResponseDto(false,null,null);
        }
        if(consulta.getVeterinario_id() <=0 ){
            return new ResponseDto(false,null,null);
        }
        if(consulta.getCiudad_id() <=0 ){
            return new ResponseDto(false,null,null);
        }


        return new ResponseDto(true,con,"Registro de consulta exitosa");
    }
}

