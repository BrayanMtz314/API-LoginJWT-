package brayan.demojwt.evento;

import java.util.List;

public interface EventoService {
    public List<Evento> listaEventos();

    public void guardar(Evento evento);

    public void eliminar(Evento evento);

    public void eliminarById(int id);

    public Evento encontrarEvento(Evento evento);
}
