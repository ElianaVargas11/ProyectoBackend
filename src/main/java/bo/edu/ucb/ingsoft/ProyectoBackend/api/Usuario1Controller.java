package bo.edu.ucb.ingsoft.ProyectoBackend.api;

import bo.edu.ucb.ingsoft.ProyectoBackend.dto.RespondeMensaje;
import bo.edu.ucb.ingsoft.ProyectoBackend.dto.Usuario1;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/usuario")
@CrossOrigin

public class Usuario1Controller {
    List<Usuario1>usuario1s =
            Stream.of(new Usuario1(1,"usuario 1"),
                     new Usuario1(2,"usuario 2"),
                     new Usuario1(3,"usuario 3")).collect(Collectors.toList());

    @GetMapping("/list")
    public ResponseEntity<List<Usuario1>> list(){
        return new ResponseEntity<>(usuario1s, HttpStatus.OK);
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<Usuario1> detail(@PathVariable("id")int id){
        Usuario1 usuario = usuario1s.stream().filter(f ->f.getId()==id).findFirst().orElse(null);
        return new ResponseEntity(usuario,HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Usuario1 usuario){
        int maxIndex =usuario1s.stream().max(Comparator.comparing(m ->m.getId())).get().getId();
        usuario.setId(maxIndex + 1);
        usuario1s.add(usuario);
        return new ResponseEntity(new RespondeMensaje("creado"),HttpStatus.CREATED);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id,@RequestBody Usuario1 usuario){
        Usuario1 usuarioUpdate = usuario1s.stream().filter(f ->f.getId()== id).findFirst().orElse(null);
        usuarioUpdate.setNombre(usuario.getNombre());
        usuario1s.add(usuarioUpdate);
        return new ResponseEntity(new RespondeMensaje("actualizado"),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        Usuario1 usuario = usuario1s.stream().filter(f ->f.getId()==id).findFirst().orElse(null);
        usuario1s.remove(usuario);
        return new ResponseEntity(new RespondeMensaje("eliminado"),HttpStatus.OK);
    }

}
