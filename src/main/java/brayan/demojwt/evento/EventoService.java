package brayan.demojwt.evento;

import brayan.demojwt.User.User;
import brayan.demojwt.User.UserDTO;

import java.util.List;

public interface EventoService {
    public List<Evento> listaEventos();

    public void guardar(Evento evento);

    public void eliminar(Evento evento);

    public void eliminarById(int id);

    public Evento encontrarEvento(Evento evento);

    public Evento eventoById(int id);

    void agregarUsuarioAEvento(int eventoId, int usuarioId);

    List<UserDTO> verUsuariosEnEvento(int eventoId);



}
