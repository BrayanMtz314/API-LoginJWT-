package brayan.demojwt.evento;

import brayan.demojwt.User.User;
import brayan.demojwt.User.UserDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/api/v1/evento")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EventoController {
    @Autowired
    private EventoService eventoService;

    @PostMapping(value = "/save")
    public ResponseEntity<Evento> guardar(@RequestBody Evento evento){
        eventoService.guardar(evento);
        return ResponseEntity.ok(evento);
    }

    // Nuevo método para agregar usuarios a un evento
    @GetMapping(value = "/{eventoId}/usuarios/{usuarioId}")
    public ResponseEntity<?> agregarUsuarioAEvento(@PathVariable int eventoId, @PathVariable int usuarioId) {
        try {
            eventoService.agregarUsuarioAEvento(eventoId, usuarioId);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    // Nuevo método para ver los usuarios en un evento
    @GetMapping(value = "/{eventoId}/usuarios")
    public ResponseEntity<List<UserDTO>> verUsuariosEnEvento(@PathVariable int eventoId) {
        try {
            List<UserDTO> usuarios = eventoService.verUsuariosEnEvento(eventoId);
            return ResponseEntity.ok(usuarios);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null);
        }
    }


    @GetMapping(value = "/delete/{id}")
    public void deleteById(@PathVariable int id){
        eventoService.eliminarById(id);
    }

    @GetMapping(value = "/eventos")
    public List<Evento> getEventos(){
        return eventoService.listaEventos();
    }

    @GetMapping(value = "/{id}")
    public Evento eventoById(@PathVariable int id ){
        return eventoService.eventoById(id);
    }




}
