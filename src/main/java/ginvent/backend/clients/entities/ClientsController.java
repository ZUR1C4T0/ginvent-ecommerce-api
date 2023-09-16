package ginvent.backend.clients.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ginvent.backend.clients.ClientsService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("clients")
@RequiredArgsConstructor
public class ClientsController {

    @Autowired
    private ClientsService clientsService;

    @PostMapping
    public Client create(@RequestBody Client body) {
        Client client = clientsService.create(body);
        if (client == null) {
            return null;
        }
        return client;
    }

    @GetMapping
    public Iterable<Client> getAll() {
        return clientsService.getAll();
    }

    @GetMapping("{id}")
    public Client getById(@PathParam("id") String id) {
        return clientsService.getById(id);
    }

    @PatchMapping("{id}")
    public Client update(@PathParam("id") String id, @RequestBody Client body) {
        Client client = clientsService.update(id, body);
        if (client == null) {
            return null;
        }
        return client;
    }

    @DeleteMapping("{id}")
    public Client delete(@PathParam("id") String id) {
        Client client = clientsService.delete(id);
        if (client == null) {
            return null;
        }
        return client;
    }

}
