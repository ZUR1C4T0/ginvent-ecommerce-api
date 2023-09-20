package ginvent.backend.clients.entities;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ginvent.backend.users.entities.User;

public interface ClientsRepository extends CrudRepository<Client, String> {

    Optional<Client> findByEmail(String email);

    Optional<Client> findByUser(User user);

    boolean existsByEmail(String email);

}
