package brayan.demojwt.evento;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventoServiceImpl implements  EventoService{
    @Autowired
    private EventoRepository eventoRepository;

    @Override
    @Transactional
    public List<Evento> listaEventos(){
        return (List<Evento>) eventoRepository.findAll();
    }

    @Override
    @Transactional
    public void guardar(Evento evento){
        eventoRepository.save(evento);
    }

    @Override
    @Transactional
    public void eliminar(Evento evento){
        eventoRepository.delete(evento);
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public Evento encontrarEvento(Evento evento) {
        return eventoRepository.findById(evento.getId()).orElse(null);
    }

    @Override
    @Transactional
    public void eliminarById(int id){
        eventoRepository.deleteById(id);
    }

}
