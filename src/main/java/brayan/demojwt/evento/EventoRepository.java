package brayan.demojwt.evento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface EventoRepository extends CrudRepository<Evento, Integer> {

}
