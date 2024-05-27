package brayan.demojwt.evento;

import brayan.demojwt.User.User;
import brayan.demojwt.User.UserDTO;
import brayan.demojwt.User.UserMapper;
import brayan.demojwt.User.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventoServiceImpl implements  EventoService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EventoRepository eventoRepository;

    @Autowired
    private UserMapper userMapper;

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

    @Override
    @Transactional
    public Evento eventoById(int id){
        return eventoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void agregarUsuarioAEvento(int eventoId, int usuarioId) {
        Evento evento = eventoRepository.findById(eventoId).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        User usuario = userRepository.findById(usuarioId).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!evento.getUsers().contains(usuario)) {
            evento.getUsers().add(usuario);
            eventoRepository.save(evento);
        }
    }

    @Override
    @Transactional
    public List<UserDTO> verUsuariosEnEvento(int eventoId) {
        Evento evento = eventoRepository.findById(eventoId).orElseThrow(() -> new RuntimeException("Evento no encontrado"));
        return evento.getUsers().stream().map(userMapper::toDTO).collect(Collectors.toList());
    }


}
