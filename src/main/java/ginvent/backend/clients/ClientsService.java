package ginvent.backend.clients;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ginvent.backend.clients.entities.Client;
import ginvent.backend.clients.entities.ClientsRepository;
import ginvent.backend.users.entities.User;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientsService {

    @Autowired
    private final ClientsRepository clientsRepository;

    public Client create(Client client) {
        boolean exists = clientsRepository.existsByEmail(client.getEmail());
        if (exists) {
            return null;
        }
        return clientsRepository.save(client);
    }

    public Iterable<Client> getAll() {
        return clientsRepository.findAll();
    }

    public Client getById(String id) {
        return clientsRepository.findById(id).orElse(null);
    }

    public Client getByEmail(String email) {
        return clientsRepository.findByEmail(email).orElse(null);
    }

    public Client getByUser(User user) {
        return clientsRepository.findByUser(user).orElse(null);
    }

    public Client update(String id, Client client) {
        Client clientToUpdate = clientsRepository.findById(id).orElse(null);
        if (clientToUpdate == null) {
            return null;
        }
        if (client.getEmail() != null) {
            clientToUpdate.setEmail(client.getEmail());
        }
        if (client.getName() != null) {
            clientToUpdate.setName(client.getName());
        }
        if (client.getLastname() != null) {
            clientToUpdate.setLastname(client.getLastname());
        }
        if (client.getPhone() != null) {
            clientToUpdate.setPhone(client.getPhone());
        }
        if (client.getAddress() != null) {
            clientToUpdate.setAddress(client.getAddress());
        }
        if (client.getCity() != null) {
            clientToUpdate.setCity(client.getCity());
        }
        if (client.getState() != null) {
            clientToUpdate.setState(client.getState());
        }
        return clientsRepository.save(clientToUpdate);
    }

    public Client delete(String id) {
        Client client = clientsRepository.findById(id).orElse(null);
        if (client == null) {
            return null;
        }
        clientsRepository.deleteById(id);
        return client;
    }
}
