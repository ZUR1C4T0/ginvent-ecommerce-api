package ginvent.backend.clients.entities;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface ClientsRepository extends CrudRepository<Client, String> {

    Optional<Client> findByEmail(String email);

    boolean existsByEmail(String email);

}
