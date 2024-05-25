package brayan.demojwt.evento;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(value = "/delete/id")
    public void deleteById(@RequestBody DeleteRequest request){
        eventoService.eliminarById(request.getId());
    }

}
