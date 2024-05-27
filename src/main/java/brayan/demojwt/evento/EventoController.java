package brayan.demojwt.evento;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
