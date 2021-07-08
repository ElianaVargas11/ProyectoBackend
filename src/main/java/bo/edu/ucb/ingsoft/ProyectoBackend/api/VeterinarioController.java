package bo.edu.ucb.ingsoft.ProyectoBackend.api;

import bo.edu.ucb.ingsoft.ProyectoBackend.bl.GestionVeterinarioBl;
import bo.edu.ucb.ingsoft.ProyectoBackend.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class VeterinarioController {

    @Autowired
    GestionVeterinarioBl gestionVeterinarioBl;


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path= "/veterinario")
    public ResponseDto Seldo(
            @RequestParam(defaultValue = "8") int limit ,
            @RequestParam(defaultValue = "0") int offset,
            @RequestParam(defaultValue = "") String ciudad,
            @RequestParam(defaultValue = "") String especialidad
    ) {
        System.out.println("ciudad : "+ciudad+"especialidad : "+especialidad);

        return new ResponseDto(true,gestionVeterinarioBl.SelectAllVeterinarians(limit,offset,ciudad,especialidad), "Lista de veterinarios");
    }
}
