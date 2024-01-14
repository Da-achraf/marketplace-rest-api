package ma.fstt.market_place_api.services;

import ma.fstt.market_place_api.entites.Client;
import ma.fstt.market_place_api.repositories.ClientRepo;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private final ClientRepo clientRepo;

    public ClientService(ClientRepo clientRepo) {
        this.clientRepo = clientRepo;
    }

    Client findClientById(Long id){
        return clientRepo.findById(id).orElse(null);
    }


    public void deleteClientById(Long id){
        clientRepo.deleteById(id);
    }

}
