package ma.fstt.market_place_api.services;

import ma.fstt.market_place_api.entites.Client;
import ma.fstt.market_place_api.entites.Commande;
import ma.fstt.market_place_api.entites.dto.SaveCommandeDto;
import ma.fstt.market_place_api.repositories.CommandeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepo commandeRepo;
    private final ClientService clientService;

    public CommandeService(CommandeRepo commandeRepo, ClientService clientService) {
        this.commandeRepo = commandeRepo;
        this.clientService = clientService;
    }

    public List<Commande> findAllCommandes(){
        return commandeRepo.findAll();
    }

    public List<Commande> findAllCommandesByClientId(Long id){
        return commandeRepo.findAllByClient_Id(id);
    }

    public void saveCommande(SaveCommandeDto saveCommandeDto){
        Client client = clientService.findClientById(saveCommandeDto.getIdClient());
        Commande commande = saveCommandeDto.toCommande();
        commande.setClient(client);
        commandeRepo.save(commande);
    }

    public void deleteCommandeById(Long id){
        commandeRepo.deleteById(id);
    }

    public Commande findCommandeById(Long id) {
        return commandeRepo.findById(id).orElse(null);
    }
}
